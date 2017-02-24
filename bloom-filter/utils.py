"""Utility functions for use in other scripts and classes."""

import hashlib


def hash_add(element, table_size):
    """
    Hash by adding the ascii values of the letters in the string.

    Return an integer.
    """
    char_val_list = list(map(lambda x: ord(x), str(element)))
    hash_val = 0
    for val in char_val_list:
        hash_val += val
    index = hash_val % table_size

    return index


def hash_multiply(element, table_size):
    """
    Hash by multiplying the ascii values of the letters in the string.

    Return an integer.
    """
    char_val_list = list(map(lambda x: ord(x), str(element)))
    hash_val = 1
    for val in char_val_list:
        hash_val *= val
    index = hash_val % table_size

    return index
