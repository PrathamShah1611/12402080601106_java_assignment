// Problem Statement:
// CRUD Operations using Collection API
import java.util.*;

public class CRUDCollection {
    public static void main(String[] args) {

        // CREATE (ArrayList)
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "Ram", "pratham", "vansh");

        // READ
        System.out.print("ArrayList (Student Names): [");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i));
            if (i != names.size() - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        // CREATE (HashMap)
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, names.get(0));
        map.put(102, names.get(1));
        map.put(103, names.get(2));

        // DISPLAY MAP
        System.out.print("HashMap (Student Records): {");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("\b\b}");

        // READ
        int id = 102;
        System.out.println("Student with ID " + id + ": " + map.get(id));

        // UPDATE
        map.put(102, map.get(102) + " shah");
        System.out.print("Updated Record: {");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("\b\b}");

        // DELETE
        map.remove(101);
        System.out.print("After Deletion: {");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("\b\b}");

        // SORTED (TreeMap)
        TreeMap<Integer, String> sorted = new TreeMap<>(map);
        System.out.print("TreeMap (Sorted Records): {");
        for (Map.Entry<Integer, String> entry : sorted.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("\b\b}");
    }
}
