"""Implement the graph to traverse."""

from collections import Counter


class Node:
    """Node class."""

    def __init__(self, value, x, y):
        """Initialize node."""
        self.x = x
        self.y = y
        self.value = value
        self.neighbors = []

    def add_neighbor(self, n, weight):
        """Add a neighbor to this node."""
        self.neighbors.append((n, weight))


class Graph:
    """Graph of nodes."""

    def __init__(self):
        """Initialize."""
        self.nodes = []

    def add_node(self, value, x, y):
        """Add a new node to the graph."""
        new_node = Node(value, x, y)
        self.nodes.append(new_node)
        return new_node

    def add_edge(self, node1, node2, weight=1):
        """Connect two nodes with optional edge weight specification."""
        node1.add_neighbor(node2, weight)
        node2.add_neighbor(node1, weight)

    def find_path(self, start, end):
        """Use A* to find a path from start to end in the graph."""
        visited_nodes = {}
        accessible_nodes = {}
        current_distance = 0

        current = start

        # Loop as long as the end node has not been found
        # this is not finished yet!!!
        while(current.value != end.value):
            # calculate cost for each neighbor of n
            costs = []
            for n in current.neighbors:
                cost = self.g(n, current_distance) + self.h(n, end)
                costs.append((n, g))

    def g(self, n, current_distance):
        """Calculate the distance from the start node."""
        return current_distance + n[1]

    def h(self, n, end):
        """Estimate the distance to the end node using Manhattan distance."""
        return abs(n[0].x - end.x) + abs(n[0].y - end.y)
