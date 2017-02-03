"""Implement a Bloom Filter class with test and add methods."""

from utils import *


class Bloom():
    """Define the Bloom Filter class."""

    def __init__(self, size):
        """Initialize."""
        self.size = size
        self.table = [0] * self.size

    def add(self, element):
        """Add an element to the Bloom Filter table."""
        index_1 = hash_add(element, self.size)
        index_2 = hash_multiply(element, self.size)
        self.table[index_1] = 1
        self.table[index_2] = 1

    def check(self, element):
        """
        Check if an element is in the set.

        Returns true is the element is probably in the set.
        Returns false is the element is definitely not in the set.
        """
        index_1 = hash_add(element, self.size)
        index_2 = hash_multiply(element, self.size)

        return(self.table[index_1] == 1 and self.table[index_2] == 1)
