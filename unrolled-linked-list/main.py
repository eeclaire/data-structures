"""Main."""

from unrolledLinkedList import UnrolledLL


def main():
    """Main."""
    ull = UnrolledLL()

    for i in range(16):
        ull.insert(i)

    ull.print_ll()


if __name__ == "__main__":
    main()
