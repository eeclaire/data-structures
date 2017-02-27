"""Define the linked list class."""

from node import Node
import math


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

            # update the current and insert the value
            self.current = self.current.nextNode
            self.current.append_to_list(val)

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

    def search(self, val):
        """Search for a value in the ll, returns a tuple of the node+index."""
        curr = self.head
        while(True):
            if curr is None:
                return (None, -1)

            # Iterate over list of elements in node in search for value
            for i, x in enumerate(curr.l):
                if x == val:
                    return (curr, i)

            # If not found, move on to next node
            curr = curr.nextNode

    def delete(self, val):
        """Delete the first instance of the given value. Calls search()."""
        n, i = self.search(val)

        if n is None:
            return

        n.l.remove(val)

        # If the threshold length of the list is reached
        if len(n.l) < math.ceil(0.5 * n.max_size) and n.nextNode is not None:
            print("Threshold reached")
            if len(n.nextNode.l) <= math.ceil(0.5 * n.max_size):
                # merge, copy next, and delete next
                n.l.extend(n.nextNode.l)
                n.nextNode = n.nextNode.nextNode
            else:
                # steal half of next list and append
                half = n.nextNode.split_list_and_return_first_half()
                n.l.extend(half)
