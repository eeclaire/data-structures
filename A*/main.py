"""
A* implementation entry point.

Claire Durand
03/10/2017
"""

from graph import Graph

g = Graph()

# Add nodes
start = g.add_node('START', 0, 1)
a = g.add_node('A', 1, 1)
b = g.add_node('B', 2, 1)
c = g.add_node('C', 2, 0)
d = g.add_node('D', 3, 1)
f = g.add_node('F', 2, 2)
o = g.add_node('O', 4, 1)
h = g.add_node('H', 4, 2)
end = g.add_node('END', 3, 2)

# Connect some of them with edges
g.add_edge(start, a)
g.add_edge(a, b)
g.add_edge(b, c)
g.add_edge(b, d)
g.add_edge(b, f)
g.add_edge(d, o)
g.add_edge(o, h)
g.add_edge(h, end)
