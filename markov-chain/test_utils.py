"""Test class for the utility functions."""

import unittest

from utils import *


class TestUtilityFunctions(unittest.TestCase):
    """Test the functions."""

    def setUp(self):
        """Set up a text string for testing."""
        self.raw = "Hello world. Goodnight moon."

    def test_prep_text(self):
        """Check that the output looks like what we expect."""
        self.assertEqual(prep_text(self.raw), [
            'hello', 'world', '.', 'goodnight', 'moon', '.'])


if __name__ == '__main__':
    unittest.main()
