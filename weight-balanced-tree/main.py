"""PEP 8 needs to chill."""

from tree import Tree


def main():
    """Main."""
    t = Tree()

    for i in [4, 1, 6, 2, 5, 10, 3, 2]:
        print("Insert %s" % (i))
        t.insert(i)
        print()

        print("Traversal")
        t.traverse()

        print()


if __name__ == "__main__":
    main()
