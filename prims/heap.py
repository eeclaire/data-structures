import math

"""Implementation of min heap
Works with Python 2 or 3
Run from terminal:
 `python heap.py`
"""

class Heap(object):

	"""Create a new Heap object
	argument data: 
		first element/top of the heap
		Number
	"""
	def __init__(self,data): #,minOrMax
		self.arr = [data]
		# def minOrMax(a,b):
		# 	if minOrMax == "min":
		# 		return min(a,b)
		# 	else:
		# 		return max(a,b)

	"""Recursively look up the heap to move smaller values up
	argument pos: 
		position from which to begin sifting
		Number
	"""
	def siftUp(self,pos):
		child = self.arr[pos]
		parentpos = int(math.floor(pos/2))
		parent = self.arr[parentpos]
		if child < parent:
			self.arr[parentpos] = child
			self.arr[pos] = parent
			self.siftUp(parentpos)
			print(self.arr)

	"""Recursively look down the heap to move smaller values up
	argument pos:
		position from which to begin sifting
		Number
	"""
	def siftDown(self,pos):
		parent = self.arr[pos]
		lchild = self.arr[2*pos + 1]
		rchild = self.arr[2*pos + 2]
		if parent > min(lchild,rchild):
			if lchild < rchild:
				self.arr[pos] = lchild
				self.arr[2*pos + 1] = parent
				self.siftDown(2*pos + 1)
			else:
				self.arr[pos] = rchild
				self.arr[2*pos + 2] = parent
				self.siftDown(2*pos + 2)

	"""Insert a new element/leaf into the Heap
	argument data:
		element to add to Heap
		Number or Array
	"""
	def insert(self,data):
		if isinstance(data,list):
			for i in data:
				self.arr.append(i)
				self.siftUp(len(self.arr)-1)
		else:
			self.arr.append(data)
			self.siftUp(len(self.arr)-1)

	"""Delete the first element/top from the Heap
			and sifts down list to move smaller values up
	no arguments
	"""
	def delete(self):
		self.arr[0] = self.arr[len(self.arr)-1]
		self.arr.pop()
		self.siftDown(0)

"""Tests
"""
myHeap = Heap(3)
myHeap.insert([15, 12, 21,25])
print('initial')
print(myHeap.arr)

myHeap.insert(6)
print('insert 6')
print(myHeap.arr)

myHeap.delete()
print('delete')
print(myHeap.arr)