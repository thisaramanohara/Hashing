
//----E/17/206

import java.util.Arrays;

public class HashTable {

    private Entry[] entryList;
    private int capacity;
    private int currentSize;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.entryList = new Entry[capacity];
        this.currentSize = 0;
    }

    public void clearAll() {
        this.entryList = new Entry[capacity];
        this.currentSize = 0;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public boolean isFull() {
        return this.capacity == this.currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean containsKey(int key) {
        return get(key) != null;
    }

    //hash function 1
    private int hash1(int key) {
        return key % this.capacity;
    }

    //hash function 2
    private int hash2(int key, int i) {
        return i * (key % (this.capacity-1));
    }

    public void insert(int key, String value) {

        //create an entry object
        Entry entryToInsert = new Entry(key, value);

        //apply hash function 1
        int h1 = hash1(key);

        int i=1;
        //probing
        while (this.entryList[h1] != null) {
            h1 = (h1 + hash2(key, i)) % this.capacity;
            i++;
        }

        //adding to the table
        this.entryList[h1] = entryToInsert;
        this.currentSize++;
    }

    //function to get the value
    public String get(int key) {
        int h1 = hash1(key);    //apply hash function1

        Entry readEntry = this.entryList[h1];

        int i=1;
        //if there exists and the key is not matched
        while (readEntry != null && !(readEntry.getKey() == key)) {
            h1 = (h1 + hash2(key, i)) % this.capacity;
            readEntry = this.entryList[h1];
            i++;
        }

        return this.entryList[h1].getValue();
    }

    //function to remove an entry
    public void remove(int key) {
        if(!containsKey(key)) return;

        int h1 = hash1(key);

        Entry readEntry = this.entryList[h1];

        int i=1;
        //if there exists and the key is not matched
        while (readEntry != null && !(readEntry.getKey() == key)) {
            h1 = (h1 + hash2(key, i)) % this.capacity;
            readEntry = this.entryList[h1];
            i++;
        }

        this.entryList[h1] = null;
        this.currentSize --;
    }

    //to print the whole table
    public void printList() {
        Arrays.stream(this.entryList).forEach(entry -> {
            if(entry != null) System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
        });
    }



}
