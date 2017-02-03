"""Implements the Bloom Filter in an example script."""

from bloom import Bloom
from utils import *


def main():
    """Main function."""
    bloom = Bloom(12)

    # Add some values to the set
    bloom.add("Curie")
    bloom.add("Laplace")

    # Now test some values
    person = "Pasteur"
    if (bloom.check(person)):
        print("%s is probably in the set." % person)
    else:
        print("%s is definitely not in the set." % person)

    # Test some more values
    person = "Curie"
    if (bloom.check(person)):
        print("%s is probably in the set." % person)
    else:
        print("%s is definitely not in the set." % person)


if __name__ == "__main__":
    main()
