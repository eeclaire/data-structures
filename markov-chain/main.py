from markov import Markov

def main():

	f = open('sample.txt', 'r')
	text = f.read()

	clean_text_list = prep_text(text)

	m = Markov()
	m.add_text(clean_text_list)

	print(m.chain)

	generated = m.traverse()
	print(generated)


# TODO: Look into bug duplicating ending periods
# also whether the remove('') is needed or not
def prep_text(text_raw):

	'''Clean up data so that it's consistent when entered into the chain'''

	sentences = text_raw.split('.')
	#sentences.remove('')

	sentences_and_periods = []
	for sentence in sentences:
		sentences_and_periods.append(sentence)
		sentences_and_periods.append('.')

	split_words = []
	for sentence in sentences_and_periods:
		words = sentence.split()
		[split_words.append(word.lower()) for word in words]
	
	return split_words



# TODO: Test for proper entry into chain
# TODO: Test for proper traversal


if __name__ == "__main__":
	main()
