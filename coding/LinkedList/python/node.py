class node:
    def __init__(self, data = None, next = None):
        self.data = data
        self.next = next

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def setNext(self, next):
        self.next = next

    def setData(self, data):
        self.data = data
