"""Define the node class."""

import math


class Node:
    """Define the node object that will make up the unrolled list."""

    max_size = 6

    def __init__(self, l=[]):
        """Initialize object."""
        self.l = l
        self.nextNode = None

    def append_to_list(self, val):
        """Append a value to a list."""
        self.l.append(val)

    def assign_next_node(self, next_node):
        """Assign next node."""
        self.nextNode = next_node

    def split_list_and_return_first_half(self):
        """Split the list in half and return the first half."""
        split_index = math.ceil(len(self.l) * 0.5)
        first_half = self.l[:split_index]
        self.l = self.l[split_index:]
        return first_half

    def split_list_and_return_second_half(self):
        """Split the list in half and return the second half."""
        split_index = math.ceil(len(self.l) * 0.5)
        second_half = self.l[split_index:]
        self.l = self.l[:split_index]
        return second_half
