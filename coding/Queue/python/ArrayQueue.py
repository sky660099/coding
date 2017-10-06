class ArrayQueue:
    def __init__(self):
        self.array = []

    def isEmpty(self):
        if len(self.array) == 0:
            return True
        else:
            return False

    def enQueue(self, value):
        self.array.append(value)

    def deQueue(self):
        return self.array.pop(0)