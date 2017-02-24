"""Define a Markov-Chain class that can populate and traverse."""

import random


class Markov:
    """Define the Markov-Chain class."""

    def __init__(self):
        """Initialize the class by creating the chain dictionary."""
        self.chain = {}

    def add_next_word(self, word, next_word):
        """Append current next word to list of possible next words."""
        if self.chain.get(word) is None:
            self.chain[word] = [next_word]
        else:
            self.chain[word].append(next_word)

    def add_text(self, word_list):
        """Iterate through the text adding each word to the chain."""
        self.add_next_word('.', word_list[0])   # sentences begin after a '.'
        for i in range(0, len(word_list) - 1):
            self.add_next_word(word_list[i], word_list[i + 1])

    def generate_sentence(self, n):
        """
        Traverse the chain to generate and return a sentence.

        args:
        n - the desired max number of words in the sentence
        """
        # Come up with the first word by using a possible word after a period
        current_word = random.choice(self.chain['.'])
        generated_text = current_word
        word_count = 1

        # Iterate through the markov chain until you hit a period
        # or the max number of words in a sentence
        while(word_count < n):
            next_word = random.choice(self.chain[current_word])
            if next_word == '.':
                generated_text = generated_text + "."
                return generated_text
            else:
                generated_text = generated_text + " " + next_word
                current_word = next_word
                word_count += 1

        # Make sure each sentence ends with a period
        if generated_text[-1] != '.':
            generated_text = generated_text + '.'

        return generated_text
