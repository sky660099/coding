package com.Queue;

public class ListQueueTest {
    public static void main(String []args) {


        ListQueueTest tester = new ListQueueTest();
        tester.RunTests();
    }

    public void RunTests() {
        testIsEmpty();
        testEnQueue();
        testDeQueue();
    };

    public void testIsEmpty() {
        ListQueue tester = new ListQueue();

        assert(tester.isEmpty());

        tester.enQueue(3);

        assert(!tester.isEmpty());
    }

    public void testEnQueue() {
        ListQueue tester = new ListQueue();

        tester.enQueue(12);
        tester.enQueue(4);
        tester.enQueue(5);
        tester.enQueue(7);
        tester.enQueue(885314);

        assert(!tester.isEmpty());
    }

    public void testDeQueue() {
        ListQueue tester = new ListQueue();

        tester.enQueue(100);
        tester.enQueue(200);
        assert(tester.deQueue() == 100);
        tester.enQueue(300);
        assert(tester.deQueue() == 200);
        tester.enQueue(400);
        tester.enQueue(500);
        tester.enQueue(600);
        tester.enQueue(700);
        assert(tester.deQueue() == 300);
        assert(tester.deQueue() == 400);
        assert(tester.deQueue() == 500);
        assert(tester.deQueue() == 600);
        assert(tester.deQueue() == 700);

        assert(tester.isEmpty());
    }

}
