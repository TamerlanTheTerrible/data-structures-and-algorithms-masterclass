package hashtable;

import java.util.LinkedList;

/**
 * Created by Temurbek Ismoilov on 24/01/23.
 */

public class DirectChaining {
    private LinkedList<String>[] hashTable;
    private int maxChainSize;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    private int modASCIIHashFunction(String word, int M) {
        char[] chars = word.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }
        return sum % M;
    }

    public void insert(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].add(word);
        System.out.println(word + " inserted");
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("HashTable doesn't exist");
        } else {
            System.out.println("------------HashTable------------");
            for(int i=0; i <hashTable.length; i++) {
                System.out.printf("index: %s; key: %s\n", i, hashTable[i]);
            }
        }
    }

    public boolean search(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        return hashTable[index] != null && hashTable[index].contains(word);
    }

    public void delete(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        if (search(word)) {
            hashTable[index].remove(word);
            System.out.println(word + " removed");
        } else {
            System.out.println(word + " not found");
        }
    }
}
