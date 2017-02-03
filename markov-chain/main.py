"""Implement and run some examples for the Markov-Chain."""

from markov import Markov


def main():
    """Entry point for the code execution."""
    f = open('sample.txt', 'r')
    text = f.read()

    clean_text_list = prep_text(text)

    m = Markov()
    m.add_text(clean_text_list)

    text = ""
    for i in range(10):
        sentence = m.generate_sentence(10)
        text = text + " " + sentence
    print(text)


def prep_text(text_raw):
    """Clean up data so that it's consistent when entered into the chain."""
    sentences = text_raw.split('.')

    sentences_and_periods = []
    for sentence in sentences:
        sentences_and_periods.append(sentence)
        sentences_and_periods.append('.')

    split_words = []
    for sentence in sentences_and_periods:
        words = sentence.split()
        [split_words.append(word.lower()) for word in words]

    return split_words


if __name__ == "__main__":
    main()
