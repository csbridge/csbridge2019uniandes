import argparse
import os

from translate_templates import translate_template

def translate_dir(dir_path, target_language):
    """Translates all HTML files in the given directory and its sub-directories."""
    for entry in os.scandir(dir_path):
        if entry.is_dir():
            translate_dir(entry.path, target_language)
        elif entry.is_file(follow_symlinks=False) and entry.name[-5:] == ".html":
            print("Translating {}...".format(entry.path))
            try:
                translate_template(entry.path, target_language)
            except Exception as e:
                print("Error translating {}: {}\n".format(entry.path, e))
            else:
                print(" done.\n")

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--language", default="es", help="Two-letter (ISO 639-1) code for the target language"
    )
    args = parser.parse_args()
    translate_dir("templates/en", args.language)

if __name__ == "__main__":
    main()