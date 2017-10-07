package com.HashTable;

class HashObject{
    private String key;
    private String value;

    public HashObject(){
        key = "<null>";
        value = "";
    }

    public void remove(){
        key = "<null>";
        value = "";
    }

    public void set(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }
}

public class HashTable {
    private HashObject[] table;
    private int size;

    public HashTable(int size){
        table = new HashObject[size];
        this.size = size;

        for (int i = 0;i < size;i++){
            table[i] = new HashObject();
        }
    }

    public int hash(String key){
        int hash = 0;

        for (int i = 0;i < key.length();i++){
            hash = hash*31+(int)key.charAt(i);
        }

        return Math.abs(hash%size);
    }

    public void add(HashObject object){
        String key = object.getKey();
        String value = object.getValue();
        int index = hash(key);
        int originalIndex = index;

        while (table[index].getKey() != "<null>" && table[index].getKey() != key){
            index = (index+1)%size;
            if (index == originalIndex){
                return;
            }
        }

        table[index].set(key, value);
    }

    public boolean exist(String key){
        int index = hash(key);
        int originalIndex = index;

        while (table[index].getKey() != "<null>" && table[index].getKey() != key){
            index = (index+1)%size;
            if (index == originalIndex){
                return false;
            }
        }

        if (table[index].getKey() == "<null>"){
            return false;
        }else{
            return true;
        }
    }

    public String getValue(String key){
        if (exist(key) == true){
            int index = hash(key);
            while (table[index].getKey() != key){
                index = (index+1)%size;
            }
            return table[index].getValue();
        }
        else{
            System.out.println("key does not exit");
            return "";
        }
    }

    public void remove(String key){
        if (exist(key) == true){
            int index = hash(key);
            while (table[index].getKey() != key){
                index = (index+1)%size;
            }
            table[index].remove();
        }
        else{
            System.out.println("key does not exit");
        }
    }

    public void debug(){
        for (int i = 0;i < size;i++){
            System.out.print(i + " ");
            System.out.print(table[i].getKey() + " ");
            System.out.println(table[i].getValue());
        }
    }

}
