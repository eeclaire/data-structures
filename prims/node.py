class Node:

	# TODO; input type verification
	def __init__(self, name):
		self.name = name
		self.connected_nodes = []
		self.connected_nodes_weights = {}	# weights of the edges accessible by connected node name

	# Adds an weighted unidirectional edge to another existing node
	# TODO: add verification that node exists
	def add_connection(self, node, weight):
		self.connected_nodes.append(node)
		self.connected_nodes_weights[node.name] = weight

	# Returns all of the edges connected to the current node
	def get_connections(self):
		return self.connected_nodes

	# Returns the weight of the edge connected the specified node to the current node
	def get_connection_weight(self, node):
		return self.connected_nodes_weights[node.name]

