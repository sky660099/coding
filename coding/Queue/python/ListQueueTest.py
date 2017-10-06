from ArrayQueue import ArrayQueue
from ListQueue import ListQueue

def main():
    testIsEmpty()
    testEnQueue()
    testDeQueue()


def testIsEmpty():
    tester = ListQueue()
    print tester.isEmpty()
    tester.enQueue(3)
    print tester.isEmpty()


def  testEnQueue():
    tester = ListQueue()

    tester.enQueue(12)
    tester.enQueue(4)
    tester.enQueue(5)
    tester.enQueue(7)
    tester.enQueue(885314)

    print tester.list

def testDeQueue():
    tester = ListQueue()

    tester.enQueue(100)
    tester.enQueue(200)
    print tester.deQueue()
    tester.enQueue(300)
    print tester.deQueue()
    tester.enQueue(400)
    tester.enQueue(500)
    tester.enQueue(600)
    tester.enQueue(700)
    print tester.deQueue()
    print tester.deQueue()
    print tester.deQueue()
    print tester.deQueue()
    print tester.deQueue()

    print tester.isEmpty()




if __name__ == "__main__":
    main()