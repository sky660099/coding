package com.Array;

public class LVectorTest {

    public static void main(String []args) {


        LVectorTest tester = new LVectorTest();
        tester.RunTests();
    }

    public void RunTests() {
        TestSize();
        TestIsEmpty();
        TestCapacity();
        TestGetValueAt();
        TestPop();
        TestInsert();
        TestDelete();
        TestRemove();
        TestFind();
    };

    public void TestSize() {

        LVector tester = new LVector(3);
        System.out.println(tester.GetSize());
        assert(tester.GetSize() == 0);

        int items_to_add = 5;
        for (int i = 0; i < items_to_add; ++i) {
            tester.Push(i + 1);
        }
        assert(tester.GetSize() == items_to_add);
    }

    public void TestIsEmpty() {
        LVector tester = new LVector(3);
        assert(tester.IsEmpty());
    }

    public void TestCapacity() {
        LVector tester = new LVector(4);

        // test increasing size
        assert(tester.GetCapacity() == tester.kMinCapacity);
        for (int i = 0; i < 17; ++i) {
            tester.Push(i + 1);
        }

        assert(tester.GetCapacity() == tester.kMinCapacity * 2);
        for (int j = 0; j < 16; ++j) {
            tester.Push(j + 1);
        }

        assert(tester.GetCapacity() == tester.kMinCapacity * 4);

        // test decreasing size
        for (int k = 0; k < 2; ++k) {
            tester.Pop();
        }
        assert(tester.GetCapacity() == tester.kMinCapacity * 2);

        for (int k = 0; k < 20; ++k) {
            tester.Pop();
        }
        assert(tester.GetCapacity() == tester.kMinCapacity);
    }

    public void TestGetValueAt() {
        LVector tester = new LVector(3);
        tester.Push(4);
        tester.Push(9);
        tester.Push(12);
        assert(tester.GetValueAt(0) == 4);
        assert(tester.GetValueAt(1) == 9);
        assert(tester.GetValueAt(2) == 12);
    }

    public void TestPop() {
        LVector tester = new LVector(1);
        tester.Push(3);

        int popped = tester.Pop();
        assert(popped == 3);
        tester.Push(9);
        tester.Push(8);

        assert(tester.GetSize() == 2);
        int popped2 = tester.Pop();
        assert(popped2 == 8);
        assert(tester.GetSize() == 1);
    }

    public void TestInsert() {
        LVector tester = new LVector(3);
        tester.Push(5);
        tester.Push(7);
        tester.Push(9);
        tester.Insert(0, 4);
        assert(tester.GetValueAt(0) == 4);
        assert(tester.GetValueAt(1) == 5);
        assert(tester.GetValueAt(2) == 7);
        assert(tester.GetValueAt(3) == 9);
        tester.Insert(3, 8);
        assert(tester.GetValueAt(3) == 8);
        assert(tester.GetValueAt(4) == 9);
    }

    public void TestPrepend() {
        LVector tester = new LVector(3);
        tester.Push(9);
        tester.Push(8);
        tester.Push(7);
        tester.Prepend(6);
        assert(tester.GetSize() == 4);
        assert(tester.GetValueAt(0) == 6);
        assert(tester.GetValueAt(1) == 9);
        assert(tester.GetValueAt(3) == 7);
    }

    public void TestDelete() {
        LVector tester = new LVector(1);
        tester.Push(5);
        tester.Delete(0);

        assert(tester.GetSize() == 0);

        tester.Push(9);
        tester.Push(10);
        tester.Push(11);
        tester.Delete(1);


        assert(tester.GetSize() == 2);
        assert(tester.GetValueAt(0) == 9);
        assert(tester.GetValueAt(1) == 11);
    }

    public void TestRemove() {
        LVector tester = new LVector(5);
        tester.Push(50);
        tester.Push(2);
        tester.Push(50);
        tester.Push(4);
        tester.Push(50);
        tester.Remove(50);
        assert(tester.GetSize() == 2);
        assert(tester.GetValueAt(0) == 2);
        assert(tester.GetValueAt(1) == 4);
    }

    public void TestFind() {
        LVector tester = new LVector(3);
        tester.Push(4);
        tester.Push(7);
        tester.Push(11);
        assert(tester.Find(5) == -1);
        assert(tester.Find(4) == 0);
        assert(tester.Find(7) == 1);
        assert(tester.Find(11) == 2);
    }
}
