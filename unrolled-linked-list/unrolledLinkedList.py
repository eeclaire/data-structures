"""Define the linked list class."""

from node import Node


class UnrolledLL:
    """Define the unrolled linked list."""

    def __init__(self):
        """Initialize."""
        self.current = Node()
        self.head = self.current

    def insert(self, val):
        """Insert a new value into the unrolled linked list."""
        if len(self.current.l) < self.current.max_size:
            self.current.append_to_list(val)

        elif len(self.current.l) == self.current.max_size:
            # Split the list in half
            second_half = self.current.split_list_and_return_second_half()

            # Create a new node with the second half of the current node's list
            self.current.assign_next_node(Node(second_half))

            # update the current
            self.current = self.current.nextNode

    def print_ll(self):
        """Print out the contents of the linked list."""
        curr = self.head
        counter = 1

        while (True):
            if curr is None:
                break
            print("Node %s" % (counter))
            print(curr.l)
            counter += 1
            curr = curr.nextNode
