// Problem Statement:
//Sorting Book Objects using Comparable and Comparator
import java.util.*;

// Book class implements Comparable
class Book implements Comparable<Book> {
    int id;
    String name;
    double price;

    Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Comparable → sort by price
    public int compareTo(Book b) {
        return Double.compare(this.price, b.price);
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

// Comparator → sort by name
class NameComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.name.compareTo(b2.name);
    }
}

// Comparator → sort by id
class IdComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.id - b2.id;
    }
}

public class BookSortDemo {
    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book(3, "DS", 900));
        list.add(new Book(1, "JAVA", 700));
        list.add(new Book(2, "OOP", 800));

        // Comparable (by price)
        Collections.sort(list);
        System.out.println("Sorted by Price (Comparable):");
        for (Book b : list) {
            System.out.println(b);
        }

        // Comparator (by name)
        Collections.sort(list, new NameComparator());
        System.out.println("\nSorted by Name (Comparator):");
        for (Book b : list) {
            System.out.println(b);
        }

        // Comparator (by id)
        Collections.sort(list, new IdComparator());
        System.out.println("\nSorted by ID (Comparator):");
        for (Book b : list) {
            System.out.println(b);
        }
    }
}
