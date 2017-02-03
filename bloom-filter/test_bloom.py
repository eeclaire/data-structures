"""Test suite for the Bloom Filter."""

import unittest

from bloom import Bloom


class TestBloomMethods(unittest.TestCase):
    """Test the Bloom Filter."""

    def setUp(self):
        """Set up the Bloom Filter table."""
        self.size = 10
        self.b = Bloom(self.size)

    def test_add(self):
        """Make sure that add properly activates bits in the table."""
        self.b.add('Archimedes')
        self.assertEqual(self.b.table, [1, 0, 0, 1, 0, 0, 0, 0, 0, 0])

    def test_check_element_in_table(self):
        """Ensure check method returns true if element was added."""
        self.b.add('Copernicus')
        self.assertEqual(self.b.check('Copernicus'), True)

    def test_check_element_not_in_table(self):
        """Ensure check method returns false if elmt definitely not in set."""
        self.assertEqual(self.b.check('Galileo'), False)


if __name__ == "__main__":
    unittest.main()
