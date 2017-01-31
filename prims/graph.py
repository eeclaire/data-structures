from node import Node

class Graph:

	def __init__(self):
		self.nodes = []

	# Adds a node (or vertex) to the graph
	def add_node(self, name):
		self.nodes.append(Node(name))

	# Creates a weighted bidirectional edge between two specified nodes
	# TODO: add safeguard that prevents from connecting node to itself
	# TODO: include clause for what to do if such connection already exists 
	def add_weighted_bidirectional_connection(self, node1, node2, edge_weight):
		node1.add_connection(node2, edge_weight)
		node2.add_connection(node1, edge_weight)

	# Returns the nodes in the graph
	def get_nodes(self):
		return self.nodes

	# Prints the edges between nodes in the graph
	def print_connections(self):
		for node in self.nodes:
			for connected_node in node.get_connections():
				print("%s connected to %s with a weight of %s"%(node.name, connected_node.name, node.get_connection_weight(connected_node)))

