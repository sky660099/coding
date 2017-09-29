from LinkedList import LinkedList
from node import node

def main():
    ll = LinkedList()

    print("Initial size: ", ll.getSize())
    ll.pushFront(24)
    print("New size: ", ll.getSize())
    print("List content: ", str(ll))
    print("Pushing more")
    ll.pushFront(6)
    ll.pushFront(783)
    print("List content: ", str(ll))
    print("popping...")
    ll.popFront()
    print("List content: ", str(ll))

    print("Deleting 24")
    ll.removeValue(24)
    print("List content: ", str(ll))
    print("Pushing another onto end.")
    ll.pushBack(365)
    print("List content: ", str(ll))


if __name__ == "__main__":
    main()