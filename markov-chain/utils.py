"""Utility methods to use in main."""

def prep_text(text_raw):
    """Return text as a list of lowercase words and periods."""
    split_words = text_raw.lower().replace('.', ' .').split()
    return split_words
