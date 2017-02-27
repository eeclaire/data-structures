# Unrolled Linked List Implementation

#### Unrolled Linked Lists combine Linked Lists and Arrays

Unrolled Linked Lists have nodes that contain an array of several values instead of one value per node. Each node has a maximum number of allowable values. On insertion, values are added to each node's array. If the number of values in the array is exceeded, the array is split in half, and the second half of the array is passed to a new node, linked to from the original pointer. On deletion, if the number of values in the array falls beneath a threshold (of 50% in many cases) then half of the values in the neighboring node's array are added to this one's. If both arrays are beneath the threshold, they can be merged and one of the nodes can be deleted.

This implementation decreases the number of pointers needed since it reduces the total number of nodes. However, this does entail an increased memory overhead on each node since nodes now have to store the maximum allowable number of values that can be stored in the node.

To run: `python3 main.py`
