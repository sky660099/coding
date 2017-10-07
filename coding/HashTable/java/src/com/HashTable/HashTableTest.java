package com.HashTable;

public class HashTableTest {
    public static void main(String []args) {
        HashTableTest tester = new HashTableTest();
        tester.RunTests();
    }

    public void RunTests() {
        testadd();
        testProbing();
        testGet();
        testRemove();
    }

    public void testadd(){
        HashTable states = new HashTable(100);

        HashObject tx = new HashObject();
        tx.set("Texas","Austin");

        states.add(tx);

        assert(states.exist("Texas"));
    }

    public void testProbing(){
        HashTable states = new HashTable(8);

        HashObject tx = new HashObject();
        tx.set("Texas","Austin");

        HashObject ca = new HashObject();
        ca.set("California","Sacramento");

        HashObject nm = new HashObject();
        nm.set("New Mexico","Santa Fe");

        HashObject fl = new HashObject();
        fl.set("Florida","Tallahassee");

        HashObject oregon = new HashObject();
        oregon.set("Oregon","Salem");

        HashObject wa = new HashObject();
        wa.set("Washington","Olympia");

        HashObject ut = new HashObject();
        ut.set("Utah","Salt Lake City");

        HashObject ny = new HashObject();
        ny.set("New York","Albany");

        HashObject mn = new HashObject();
        mn.set("Minnesota","St. Paul");

        states.add(tx);  
        states.add(ca);  
        states.add(nm);  
        states.add(fl);
        states.add(oregon);
        states.add(wa);
        states.add(ut);
        states.add(ny);
        states.add(mn);

        assert(states.exist("California"));
        assert(states.exist("New Mexico"));
        assert(states.exist("Florida"));
        assert(!states.exist("Minnesota"));  // no room
    }

    public void testGet(){
        HashTable states = new HashTable(100);

        HashObject tx = new HashObject();
        tx.set("Texas","Austin");

        states.add(tx);

        assert(states.getValue("Texas") == "Austin");
    }

    public void testRemove(){
        HashTable states = new HashTable(100);

        HashObject tx = new HashObject();
        tx.set("Texas","Austin");

        states.add(tx);

        assert(states.exist("Texas"));

        states.remove("Texas");

        assert(!states.exist("Texas"));
    }
}
