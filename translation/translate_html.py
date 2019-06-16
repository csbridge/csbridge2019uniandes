import argparse
import os
import re

import bs4

from google.cloud import translate
from translate_java import translate_code
import translation_utils

UNICODE_SPACE = u"\xa0"
SPACE_SENTINEL = " NBSP "

def translate_node(node, target_language):
    """
    Recursively translates the text within an HTML tag.

    Keyword arguments:
    :param node bs4.element.Tag or bs4.element.NavigableString: the current DOM node, which can be a tag or just text
    :param target_language str: ISO 639-1 code for the natural language to which text should be translated
    """
    # If we hit a leaf node, translate the text
    if isinstance(node, bs4.element.NavigableString):
        # Make sure leading spaces are preserved during translation by marking where they were
        translated_text = translate_code(node.string, target_language).replace(UNICODE_SPACE, SPACE_SENTINEL)
        node.string.replace_with(translated_text)
        return
    # Otherwise, we assume this is a tag and translate the child tags' text
    # TODO make sure there will always be children
    for child in node.children:
        translate_node(child, target_language)


def translate_html(text, target_language):
    """
    Translates text from an HTML document, including code snippets embedded
    in that file, from English to another language.

    :param text str: some or all of the text from an HTML file
    :param target_language str: ISO 639-1 code for the natural language to which text should be translated
    :returns: text translated into target_language
    """
    soup = bs4.BeautifulSoup(text, "html.parser")
    # TODO do I have to make a var for this or can it be in the for loop?
    code_nodes = soup.find_all(re.compile("code|pre"))
    for node in code_nodes:
        translate_node(node, target_language)
    page_text = str(soup) # Can't use prettify because it will add unwanted spaces between tags
    
    page_text = translation_utils.make_known_translations(target_language, page_text)

    translated_text = translate.Client().translate(page_text, target_language)["translatedText"]

    # Put an &nbsp; in each spot where we want a leading space
    space_sentinel_regex = re.compile(r' *' + SPACE_SENTINEL.strip() + r' *')
    translated_text = space_sentinel_regex.sub("&nbsp;", translated_text)

    # Get rid of spaces erroneously added during BeautifulSoup stringification
    translated_text = re.sub(r"> (\W)", lambda match: ">{}".format(match.group(1)), translated_text)

    return translation_utils.override_translations(target_language, translated_text)


def translate_file(filename, target_language):
    """
    Translates the text in an HTML file, including code snippets embedded
    in that file, from English to another language.

    :param filename str: the local path to an HTML file
    :param target_language str: ISO 639-1 code for the natural language to which text should be translated
    """
    path_segments = filename.split("/")
    page_name = path_segments[-1]
    # Currently assumes path is to a file in a folder for English versions
    output_dir = "/".join(
        [segment if segment != "en" else target_language for segment in path_segments[:-1]]
    )
    if not os.path.isdir(output_dir):
        os.makedirs(output_dir)

    with open(filename, "r") as file:
        translated_file = translate_html(file, target_language)
        with open(os.path.join(output_dir, page_name), "w") as outfile:
            outfile.write(translated_file)


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "language", help="Two-letter (ISO 639-1) code for the target language"
    )
    parser.add_argument(
        "files",
        help="File(s) to be translated (use globbing to translate whole directories)",
        nargs="+",
    )
    args = parser.parse_args()
    for filename in args.files:
        print("Translating {}...".format(filename))
        translate_file(filename, args.language)
        print(" done.\n")


if __name__ == "__main__":
    main()
