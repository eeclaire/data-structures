"""Main."""

from unrolledLinkedList import UnrolledLL


def main():
    """Main."""
    ull = UnrolledLL()

    for i in range(16):
        ull.insert(i)

    ull.print_ll()

    ull.delete(11)
    print("post deletion of 11")
    ull.print_ll()
    print()

    ull.delete(12)
    print("post deletion of 12")
    ull.print_ll()
    print()

    ull.delete(6)
    print("post deletion of 6")
    ull.print_ll()
    print()


if __name__ == "__main__":
    main()
