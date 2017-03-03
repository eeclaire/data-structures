"""Tree definition."""

from node import Node


class Tree:
    """Tree."""

    def __init__(self):
        """Initialize."""
        self.root = None

    def insert(self, value):
        """Insert new node into the tree."""
        # Check whether tree is empty
        if self.root is None:
            n = Node(value, self.root)
            self.root = n

        else:
            self.insert_node(self.root, value)

    def insert_node(self, curr, value):
        """Insert a node that is not the root."""
        while(True):
            curr.increment_subtree_size()

            # this whole block could be a try_left method
            if value < curr.value:
                print("%s should be left of %s" % (value, curr.value))
                if curr.left is None:
                    curr.insert_left(value)
                    return
                else:
                    curr = curr.left

            # this whole block could be a try_right method
            elif value > curr.value:
                print("%s should be right of %s" % (value, curr.value))
                if curr.right is None:
                    curr.insert_right(value)
                    return
                else:
                    curr = curr.right

            # don't add a value to the tree if it's already in there
            # TODO: fix the fact that this should delete up the search path
            else:
                print("%s is already in the tree!" % (value))
                curr.decrement_subtree_size()   # oops
                return

    def traverse(self):
        """Traverse and print the contents of the trees in place."""
        self.traverse_rec(self.root)

    def traverse_rec(self, curr):
        """Recursive traversal function."""
        if curr.left is not None:
            self.traverse_rec(curr.left)

        print("%s\tsubree_size=%s" % (curr.value, curr.size))

        if curr.right is not None:
            self.traverse_rec(curr.right)

        return
