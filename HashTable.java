package model;

import java.util.Arrays;

public class HashTable {

    private String[] symTable;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.symTable = new String[capacity];
    }

    private int hashFunction(String identifier) {
        int sum = 0;
        for(int i = 0; i < identifier.length(); i++) {
            sum += identifier.charAt(i);
        }
        return sum % this.capacity;
    }


    //Adding the identifier to the symbol table
    public boolean insert(String identifier) {
        // Checking if it is in the sym table
        for (String s : symTable) {
            if (s != null && s.equals(identifier)) {
                System.out.println("Already in sym table.");
                return false;
            }
        }
        int hashValue = hashFunction(identifier);
        if (symTable[hashValue] == null) {
            symTable[hashValue] = identifier;
            System.out.println("Insert " + identifier + " at position " + hashValue);
            return true;
        }
        // Else, we have a collision
        int nextAvailablePosition = hashValue;
        while (symTable[nextAvailablePosition] != null) {
            nextAvailablePosition++;
        }
        if (symTable[nextAvailablePosition] == null) {
            symTable[nextAvailablePosition] = identifier;
            System.out.println("Insert " + identifier + " at position " + nextAvailablePosition);
            return true;
        }
        System.out.println("Insert failed.");
        return false;
    }

    // Searching for the identifier in the symbol table

    public int find(String identifier) {
        int hashValue = hashFunction(identifier);
        while (symTable[hashValue] != null) {
            if(symTable[hashValue].equalsIgnoreCase(identifier)) {
                return hashValue;
            }
            hashValue ++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "symTable=" + Arrays.toString(symTable) +
                '}';
    }
}
