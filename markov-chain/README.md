# Markov Chain

#### Implementation Notes

This implementation of a Markov-Chain turns a body of text into a dictionary where each key is the current word and the value is a list of possible following words. For example, the text
```
"Hello world. Goodnight moon."
```
should yield the dictionary

```
{
    '.': ['hello', 'goodnight'],
    'hello': ['world'],
    'world': ['.'],
    'goodnight': ['moon'],
    'moon': ['.']
}
```

Note that the period '.' is used both as the ending punction mark, but also as a key that indicates the future beginning of a new grammatical sentence.

In order to generate text, the code traverses the dictionary by using the current word as the key, and picking a next word from the list of next possible words. Paragraphs start the traversal at the '.', even though this period is not included in the sentence. Because words following a period are the first words in a sentence they are appropriate as a first word in a paragraph. If the traversal reaches a period, such as after 'world' or 'moon' in the example above, the sentence ends and the generated text is returned. There is a maximum number of words allowable in a sentence variable. If a sentence does not reach a period before the maximum number of words is reached, a period is added to the end of the generated text and this sentence is returned.


#### Running it
To run an example, run: `python3 main.py`

This script preps the text from `sample.txt` (the first chapter from 1984), inserts the clean text into a markov chain, then generates ten sentences of ten words max each. The paragraph is printed to stdout.