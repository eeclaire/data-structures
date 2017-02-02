import random

class Markov:

	def __init__(self):
		self.chain = {}

	def add_next_word(self, word, next_word):
		'''Append the next word to the list of possible next words for a given word.'''
		
		if self.chain.get(word) == None:
			self.chain[word] = [next_word]
		else:
			self.chain[word].append(next_word)

	def add_text(self, word_list):
		'''Iterates through the text adding each word to the chain'''
		
		self.add_next_word('',word_list[0])

		for i in range(0, len(word_list)-1):
			self.add_next_word(word_list[i],word_list[i+1])


	def traverse(self):
		''' Traverses the chain to generate and return a sentence'''

		generated_text = ""

		current_word = ''
		while(current_word is not '.'):
			next_word = random.choice(self.chain[current_word])
			generated_text = generated_text+" "+next_word
			current_word = next_word
		return generated_text
