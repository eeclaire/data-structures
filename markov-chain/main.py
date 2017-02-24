"""Implement and run some examples for the Markov-Chain."""

from markov import Markov
from utils import prep_text


def main():
    """Entry point for the code execution."""
    f = open('sample.txt', 'r')
    text = f.read()

    clean_text_list = prep_text(text)

    m = Markov()
    m.add_text(clean_text_list)

    text = generate_paragraph(m, 5, 10)
    print(text)

    f.close()


def generate_paragraph(m, n_sentences, max_words_per_sentence):
    """
    Generate a paragraph of n number of sentences.

    args:
    m - the Markov Chain object to use to generate text
    n_sentences - the number of "sentences" to generate
    max_words_per_sentence - the max number of words generated in one sentence
    """
    text = ""
    for i in range(n_sentences):
        sentence = m.generate_sentence(max_words_per_sentence)
        text = text + " " + sentence

    return text


if __name__ == "__main__":
    main()
