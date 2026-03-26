// Problem Statement:
// Word Occurrence Counter using File Handling
import java.io.*;
import java.util.*;

public class WordCountDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
            System.out.print("Enter file path: ");
            String path = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            br.close();

            System.out.println("\nWord Occurrence:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
