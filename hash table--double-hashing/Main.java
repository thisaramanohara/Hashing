
//----E/17/206
public class Main {

    public static void main(String[] args) {

        //creating the Hashtable
        HashTable hashTable = new HashTable(13);

        //adding entries
        hashTable.insert(17, "value is 17");
        hashTable.insert(222, "value is 222");
        hashTable.insert(0, "value is 0");
        hashTable.insert(53, "value is 53");
        hashTable.insert(54, "value is 54");
        hashTable.insert(55, "value is 55");
        hashTable.insert(50, "value is 50");
        hashTable.insert(51, "value is 51");
        hashTable.insert(52, "value is 52");
        hashTable.insert(57, "value is 57");
        hashTable.insert(58, "value is 58");
        hashTable.insert(59, "value is 59");
        hashTable.insert(67, "value is 67");

        //printing the hash table
        hashTable.printList();

    }
}
