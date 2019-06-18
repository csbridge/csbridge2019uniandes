# First argument to script should be the desired language's ISO 639-1 code
python3 translation/translate_templates.py $1 templates/en/*.html
python3 translation/translate_templates.py $1 templates/en/handouts/*.html
python3 translation/translate_templates.py $1 templates/en/projects/*.html
# After several instances of not remembering to compile afterward: compile here
python3 compile.py
# Assumes local compilation; can be re-compiled for deployment version afterward