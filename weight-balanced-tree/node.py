"""Node definition."""


class Node:
    """Define the node."""

    def __init__(self, value, parent):
        """Initialize the node using a value."""
        self.value = value
        self.parent = parent
        self.left = None
        self.right = None
        self.size = 0

    def insert_left(self, value):
        """Give the node a left child."""
        self.left = Node(value, self)

    def insert_right(self, value):
        """Give the node a right child."""
        self.right = Node(value, self)

    def increment_subtree_size(self):
        """Increment the value tracking the size of the tree."""
        if self.size == 0:
            self.size = 1
        else:
            self.size += 1

    def decrement_subtree_size(self):
        """Decrement the value tracking the size of the tree."""
        if self.size == 1:
            self.size = 0
        else:
            self.size -= 1
