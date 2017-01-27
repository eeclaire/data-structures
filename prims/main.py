from graph import Graph

# Instantiate the graph
g = Graph()

# Create 7 nodes, name them 0 through 6
for i in range(7):
	g.add_node(str(i))


# Confirm that we got the nodes by printing their names
for node in g.get_nodes():
	print(node.name)


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
g.print_connections()


# Prims time!!! (TODO: build out tree at same time)
# The following section is unfinished. 
# It concerns the Prim's algorithm implementation to find the Minimum Spanning Tree (MST) of the graph created above

'''
# Arbitrarily start at node 0
latest_node = g.get_nodes()[0]
nodes_in_mst = [latest_node]
mst_set = set()	# populate with tuples of nodes representing edges

## Everything below should be placed in a loop
# get the edges connected to this node:
connections = latest_node.get_connections()

for node in connections:
	print("connected to %s by %s"%(node.name, latest_node.get_connection_weight(node)))

# Find smallest edge
print("edge weights")
edge_weights = list(map(lambda n: latest_node.get_connection_weight(n), connections))
# alternatively:  edge_weights = [latest_node.get_connection_weight(n) for n in connections]

print(edge_weights)
closest_node_index = edge_weights.index(min(edge_weights))

# Add the tuple to the set of branches
mst_set.add((latest_node, connections[closest_node_index]))

# Update the latest node (so that we can add its attached edges to the list)
latest_node = connections[closest_node_index]
nodes_in_mst.append(connections[closest_node_index])

'''