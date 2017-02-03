"""Test class for the Markov Chain."""

import unittest

from markov import Markov


class TestMarkovMethods(unittest.TestCase):
    """Test the Markov-Chain."""

    def setUp(self):
        """Set up a Markov Chain instance for testing."""
        self.m = Markov()

    def test_new_word_entry(self):
        """Make sure that a new word and its next word are properly entered."""
        self.m.add_next_word('hello', 'world')
        self.assertEqual(self.m.chain, {'hello': ['world']})

    def test_additional_next_word_entry(self):
        """Test insertion of a new next word for an existing current word."""
        self.m.add_next_word('hello', 'world')
        self.m.add_next_word('hello', 'you')
        self.assertEqual(self.m.chain, {'hello': ['world', 'you']})

    def test_paragraph_entry(self):
        """
        Test insertion of a paragraph into the chains.

        Verify the logic concerning the period.
        """
        self.m.add_text(['hello', 'world', '.', 'goodnight', 'moon', '.'])
        self.assertEqual(self.m.chain, {
            '.': ['hello', 'goodnight'],
            'hello': ['world'],
            'world': ['.'],
            'goodnight': ['moon'],
            'moon': ['.']})

    def test_sentence_generation(self):
        """Test traversing through Markov-Chain dict to create sentence."""
        self.m.add_text(['hello', 'world', '.'])
        self.m.add_text(['hello', 'you', '.'])
        self.assertIn(
            self.m.generate_sentence(4), ['hello world.', 'hello you.'])


if __name__ == '__main__':
    unittest.main()
