from LinkedList import LinkedList

class ListQueue:
    def __init__(self):
        self.list = LinkedList()

    def isEmpty(self):
        return self.list.isEmpty()

    def enQueue(self, value):
        self.list.pushFront(value)

    def deQueue(self):
        return self.list.popBack()

