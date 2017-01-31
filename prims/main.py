from graph import Graph

import math
import pdb

# Instantiate the graph
g = Graph()

# Create 7 nodes, name them 0 through 6
for i in range(7):
	g.add_node(str(i))

'''
# Confirm that we got the nodes by printing their names
for node in g.get_nodes():
	print(node.name)
'''

# Build edges in the graph - I'm hardcoding in because my life is a struggle
g.add_weighted_bidirectional_connection(g.get_nodes()[0], g.get_nodes()[1], 2)
g.add_weighted_bidirectional_connection(g.get_nodes()[0], g.get_nodes()[2], 3.5)
g.add_weighted_bidirectional_connection(g.get_nodes()[0], g.get_nodes()[3], 3)
g.add_weighted_bidirectional_connection(g.get_nodes()[1], g.get_nodes()[2], 4)
g.add_weighted_bidirectional_connection(g.get_nodes()[1], g.get_nodes()[4], 4.5)
g.add_weighted_bidirectional_connection(g.get_nodes()[2], g.get_nodes()[3], 5)
g.add_weighted_bidirectional_connection(g.get_nodes()[2], g.get_nodes()[4], 1)
g.add_weighted_bidirectional_connection(g.get_nodes()[2], g.get_nodes()[5], 6)
g.add_weighted_bidirectional_connection(g.get_nodes()[3], g.get_nodes()[5], 7)
g.add_weighted_bidirectional_connection(g.get_nodes()[4], g.get_nodes()[5], 8)
g.add_weighted_bidirectional_connection(g.get_nodes()[5], g.get_nodes()[6], 9)

# Make sure edges were properly added
#g.print_connections()


# Prims time!!! (TODO: build out tree at same time)
# The following section is unfinished. 
# It concerns the Prim's algorithm implementation to find the Minimum Spanning Tree (MST) of the graph created above


# Arbitrarily start at node 0
latest_node = g.get_nodes()[0]
nodes_in_mst = [latest_node]
mst_set = set()	# populate with tuples of nodes representing edges
considered_edges = []	# list of edges connected to the current MST


# While all of the nodes in the graph aren't yet in the MST 
# TODO change this, not all nodes in the graph are necessarily connected
while(len(nodes_in_mst) != len(g.get_nodes())):

	# get the nodes connected to the latest node:
	connections = latest_node.get_connections()
	
	# Pair connected nodes with the weight of their edge
	edges = [(latest_node.get_connection_weight(n), n, latest_node) for n in connections]

	# Add any edges connected to the latest node and 
	# that are not connected to a node already in the tree to the list of edges under consideration
	for edge in edges:
		if edge not in considered_edges and edge[1] not in nodes_in_mst:
			considered_edges.append(edge)

	# Remove from consideration any edges that might close a loop in the MST
	for edge in considered_edges:
		if edge[1] in nodes_in_mst and edge[2] in nodes_in_mst:
			considered_edges.remove(edge)
			considered_edges.append((15,latest_node,latest_node))

	# Find the smallest edge weight and use its index to chose the smallest edge
	min_weight = math.inf
	closest_edge = considered_edges[0]	# placeholder
	for edge in considered_edges:
		if edge[0] < min_weight:
			min_weight = edge[0]
			closest_edge = edge

	# Add it to the MST set
	mst_set.add((closest_edge[2], closest_edge[1]))

	# Remove it from the set of nodes we're considering
	considered_edges.remove(closest_edge)

	# Update the latest node (so that we can add its attached edges to the list)
	latest_node = closest_edge[1]
	nodes_in_mst.append(closest_edge[1])


# Print the node-pairs that constitute the branches of the tree
for edge in mst_set:
	print("(%s, %s)"%(edge[0].name,edge[1].name))



