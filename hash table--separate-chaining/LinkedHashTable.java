
//--- E/17/206

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedHashTable {

    private LinkedList<Entry> [] linkedEntryList;
    private int capacity;
	private int currentSize;

    public LinkedHashTable(int capacity) {
		
		//initialize the values
        this.capacity = capacity;
        this.linkedEntryList = new LinkedList[capacity];
		this.currentSize = 0;

        //creating indexes
        for (int i=0; i<capacity; i++) {
            linkedEntryList[i] = new LinkedList<Entry>();
        }
    }
	
	//to clear the hashtable
    public void clearAll() {
        this.linkedEntryList = new LinkedList[capacity];
        this.currentSize = 0;
    }
	
	//to get the current size of the table
    public int getCurrentSize() {
        return this.currentSize;
    }
	
	//to check the table is full
    public boolean isFull() {
        return this.capacity == this.currentSize;
    }
	
	//to check the table is empty
    public boolean isEmpty() {
        return this.currentSize == 0;
    }
	
	//to check the key is contained
    public boolean containsKey(int key) {
        return get(key) != null;
    }

    //hash function
    private int hash(int key) {
        return key % this.capacity;
    }

    //to insert an entry
    public void insert(int key, String value) {
        Entry entryToInsert = new Entry(key, value);
        int h = hash(key);

        //selecting the index
        LinkedList<Entry> column = linkedEntryList[h];

        //check whether the key is already there
        for (Entry entry: column) {
            System.out.println("Key : "+key+" is already there");
        }

        //adding the new entry to the index
        column.add(entryToInsert);
    }

    //to remove an entry
    public void remove(int key) {
        int h = hash(key);

        //selecting the index
        LinkedList<Entry> column = linkedEntryList[h];

        //check whether the key is already there
        for (Entry entry: column) {
            if (entry.getKey() == key) {
                column.remove(entry);
            }
        }
    }

    //to get a Entry
    public String get(int key) {
        int h = hash(key);

        //selecting the index
        LinkedList<Entry> column = linkedEntryList[h];

        //check whether the key is already there
        for (Entry entry: column) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }

        return null;
    }

    //to print the whole table
    public void printList() {
        Arrays.stream(this.linkedEntryList).forEach(index -> {
            if(index != null){
				//search through the index
                index.forEach(entry -> {
                    if(entry != null) {
                        System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
                    }
                });
            }
        });
    }

}
