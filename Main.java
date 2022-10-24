import model.HashTable;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inserting the values you decide");
        HashTable symTable = new HashTable(18);

        // Inserting some values
        symTable.insert("f");
        symTable.insert("o");
        symTable.insert("r");
        symTable.insert("m");
        symTable.insert("e");
        symTable.insert("a");

        System.out.println("\nStarting tests ...");
        // Test if all values have been inserted (all should return true)
        assert symTable.insert("f");
        assert symTable.insert("o");
        assert symTable.insert("r");
        assert symTable.insert("m");
        assert symTable.insert("e");
        assert !symTable.insert("a");

        assert 12 == symTable.find("a");
        assert 8 == symTable.find("ab");
        assert -1 == symTable.find("carmen");
        System.out.println(symTable);
    }
}
