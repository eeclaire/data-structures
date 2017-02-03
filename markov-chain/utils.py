"""Utility methods to use in main."""


def prep_text(text_raw):
    """Return text as a list of lowercase words and periods."""
    sentences = text_raw.split('.')

    # Remove the empty string at the end that may be caused by ending period
    if sentences[-1] == '':
        sentences.remove('')

    # Artificially add a period item in the list after each sentence
    sentences_and_periods = []
    for sentence in sentences:
        sentences_and_periods.append(sentence)
        sentences_and_periods.append('.')

    # Split up the words in the sentence items
    split_words = []
    for sentence in sentences_and_periods:
        words = sentence.split()
        [split_words.append(word.lower()) for word in words]

    return split_words
