# Bloom Filter

Bloom filters are used to reduce expensive lookups to elements that have not been inserted in a set. Querying the Bloom filter will return whether an element is definitely not or is probably in the set. 

#### Implementation
I implemented a Bloom Filter with my own shitty little hash functions. One of them adds up the ASCII values in the inserted string, the other one multiplies them. The indeces to set are the mod of these two results by the size of the hashtable.

#### Running it
To run an example, run: `python3 main.py`

This script creates a Bloom Filter with a 12 element hashtable, inserts a couple of values, then checks whether "Pasteur" and "Curie" have been inserted into the set.