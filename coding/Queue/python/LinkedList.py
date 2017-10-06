import sys
from node import node

class LinkedList:
    def __init__(self):
        self.size = 0
        self.header = None

    def __str__(self):
        current = self.header
        output = ""
        while current:
            output += str(current.getData()) + " -> "
            current = current.getNext()
        return output

    def getSize(self):
        return self.size

    def isEmpty(self):
        if self.size == 0:
            return True
        else:
            return False

    def getValueAt(self, index):
        if index > self.size - 1 or index < 0:
            print "index out of bound"
            sys.exit(0)

        tmp = self.header

        for i in range(index):
            tmp = tmp.next

        return tmp.getData()

    def pushFront(self, value):
        newNode = node(value, self.header)
        self.header = newNode
        self.size += 1

    def popFront(self):
        if self.isEmpty() == True:
            print "empty list"
            sys.exit(0)

        tmpValue = self.header.getData()
        self.header = self.header.getNext()
        self.size -= 1

        return tmpValue

    def pushBack(self, value):
        newNode = node(value)
        tmp = self.header

        for i in range(self.size-1):
            tmp = tmp.next

        tmp.setNext(newNode)

        self.size += 1

    def popBack(self):
        if self.isEmpty() == True:
            print "empty list"
            sys.exit(0)

        tmp = self.header

        for i in range(self.size - 1):
            tmp = tmp.next

        tmpValue = tmp.getData()
        tmp.setNext(None)
        self.size -= 1

        if self.isEmpty() == True:
            self.header = None

        return tmpValue

    def getFront(self):
        if self.isEmpty() == True:
            print "empty list"
            sys.exit(0)

        return self.header.getData()


    def getBack(self):
        if self.isEmpty() == True:
            print "empty list"
            sys.exit(0)

        tmp = self.header
        for i in range(self.size - 1):
            tmp = tmp.next

        return tmp.getData()

    def insert(self, index, value):
        if index > self.size or index < 0:
            print "index out of bound"
            sys.exit(0)

        if index == 0:
            self.pushFront(value)
        elif index == self.size:
            self.pushBack(value)
        else:
            newNode = node(value)
            tmp = self.header

            for i in range(index - 1):
                tmp = tmp.next

            newNode.setNext(tmp.getNext())
            tmp.setNext(newNode)

            self.size += 1

    def erase(self, index):
        if index > self.size-1 or index < 0:
            print "index out of bound"
            sys.exit(0)

        if index == 0:
            self.popFront()
        elif index == self.size-1:
            self.popBack()
        else:
            tmp = self.header

            for i in range(index - 1):
                tmp = tmp.next

            tmp.setNext(tmp.getNext().getNext())

            self.size -= 1

    def valueFromEnd(self, index):
        if index > self.size-1 or index < 0:
            print "index out of bound"
            sys.exit(0)

        tmp = self.header

        for i in range(self.size-index-1):
            tmp = tmp.next

        return tmp.getData()

    def reverse(self):
        preNode = node()
        nextNode = self.header

        tmp = node()

        for i in range(self.size):
            tmp = nextNode
            nextNode = tmp.getNext()
            tmp.setNext(preNode)
            preNode = tmp

        header = tmp

    def removeValue(self, value):
        tmp = self.header
        for i in range(self.size):
            if tmp.getData() ==  value:
                self.erase(i)
                break

            tmp = tmp.getNext()
