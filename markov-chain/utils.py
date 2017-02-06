"""Utility methods to use in main."""


def prep_text(text_raw):
    """
    Return text as a list of lowercase words and periods in the raw text.

    Replaces '.' with ' . ' so that periods will count as their own word.
    """
    sentences = text_raw.lower().replace('.', ' . ').split()

    # Remove any empty string at the end of the list
    if sentences[-1] == '':
        sentences.remove('')

    return sentences
