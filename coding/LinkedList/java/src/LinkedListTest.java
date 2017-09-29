public class LinkedListTest {
    public static void main(String []args) {
        LinkedListTest tester = new LinkedListTest();
        tester.RunTests();
    }

    public void RunTests() {

        testSize();
        testEmpty();
        valueAtTest();
        popFrontTest();
        pushBackTest();
        popBackTest();
        getFrontTest();
        getBackTest();
        insertTest();
        eraseTest();
        valueFromEndTest();
        reverseTest();
        removeValueTest();
    };

    public void testSize(){
        LinkedList tester = new LinkedList();
        assert(tester.getSize() == 0);

        tester.pushFront(4);
        assert(tester.getSize() == 1);

        tester.pushFront(9);
        assert(tester.getSize() == 2);
    }

    public void testEmpty(){
        LinkedList tester = new LinkedList();
        assert(tester.isEmpty() == true);

        tester.pushFront(4);
        assert(tester.isEmpty() == false);
    }

    public void valueAtTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(99);
        assert(tester.getValueAt(0) == 99);

        tester.pushFront(3);
        tester.pushFront(122);
        assert(tester.getValueAt(0) == 122);
        assert(tester.getValueAt(1) == 3);
        assert(tester.getValueAt(2) == 99);
    }

    public void popFrontTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(66);
        int val = tester.popFront();

        assert(val == 66);

        tester = new LinkedList();

        tester.pushFront(12);
        tester.pushFront(11);

        assert(tester.popFront() == 11);
        assert(tester.popFront() == 12);
    }

    public void pushBackTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(4);
        assert(tester.getSize() == 1);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.pushFront(456);


        assert(tester.getSize() == 2);
        assert(tester.getValueAt(0) == 456);
        assert(tester.getValueAt(1) == 123);

    }

    public void popBackTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(4);
        int val = tester.popBack();

        assert(tester.getSize() == 0);
        assert(val == 4);

        tester = new LinkedList();

        tester.pushFront(33);
        tester.pushFront(36);



        assert(tester.popBack() == 33);
        assert(tester.popBack() == 36);
        assert(tester.getSize() == 0);

    }

    public void getFrontTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(123);
        assert(tester.getFront() == 123);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.pushFront(456);
        assert(tester.getFront() == 456);
    }

    public void getBackTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(3);
        assert(tester.getBack() == 3);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.pushFront(456);
        assert(tester.getBack() == 123);
    }

    public void insertTest(){
        LinkedList tester = new LinkedList();

        tester.insert(0,3);

        assert(tester.getFront() == 3);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.insert(0,3);

        assert(tester.getFront() == 3);
        assert(tester.getBack() == 123);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.insert(1,3);

        assert(tester.getBack() == 3);

        tester = new LinkedList();

        tester.pushFront(123);
        tester.pushFront(456);
        tester.pushFront(999);
        tester.insert(2,777);



        assert(tester.getValueAt(1) == 456);
        assert(tester.getValueAt(2) == 777);
        assert(tester.getBack() == 123);
    }

    public void eraseTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(44);
        tester.erase(0);

        assert(tester.getSize() == 0);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);
        tester.erase(0);



        assert(tester.getSize() == 1);
        assert(tester.getFront() == 44);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);
        tester.erase(1);

        assert(tester.getSize() == 1);
        assert(tester.getFront() == 55);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);
        tester.pushFront(66);
        tester.erase(1);

        assert(tester.getSize() == 2);
        assert(tester.getFront() == 66);
        assert(tester.getBack() == 44);
    }

    public void valueFromEndTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(33);

        assert(tester.getValueFromEnd(0) == 33);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);
        tester.pushFront(66);

        assert(tester.getValueFromEnd(2) == 66);
        assert(tester.getValueFromEnd(1) == 55);
        assert(tester.getValueFromEnd(0) == 44);
    }

    public void reverseTest(){
        LinkedList tester = new LinkedList();

        tester.pushFront(44);

        tester.reverse();

        assert(tester.getFront() == 44);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);

        tester.reverse();

        assert(tester.getFront() == 44);
        assert(tester.getBack() == 55);

        tester = new LinkedList();

        tester.pushFront(44);
        tester.pushFront(55);
        tester.pushFront(66);

        tester.reverse();

        assert(tester.getValueAt(0) == 44);
        assert(tester.getValueAt(1) == 55);
        assert(tester.getValueAt(2) == 66);
    }

    public void removeValueTest(){
        LinkedList tester = new LinkedList();

        tester.removeValue(5);

        assert(tester.getSize() == 0);

        tester = new LinkedList();

        tester.pushFront(5);
        tester.removeValue(5);

        assert(tester.getSize() == 0);

        tester = new LinkedList();

        tester.pushFront(5);
        tester.pushFront(22);
        tester.removeValue(5);

        assert(tester.getSize() == 1);
        assert(tester.getFront() == 22);

        tester = new LinkedList();

        tester.pushFront(10);
        tester.pushFront(20);
        tester.removeValue(20);

        assert(tester.getSize() == 1);
        assert(tester.getBack() == 10);

        tester = new LinkedList();

        tester.pushFront(10);
        tester.pushFront(25);
        tester.pushFront(45);

        tester.removeValue(25);

        assert(tester.getSize() == 2);
        assert(tester.getFront() == 45);
        assert(tester.getBack() == 10);
    }

}
