// Problem Statement:
// Display Files of a Directory using File Class
import java.io.File;

public class DirectoryDisplay {
    public static void main(String[] args) {

        File dir = new File("C:\\Users\\Pratham\\OneDrive\\Desktop\\CODEING");

        if (dir.exists() && dir.isDirectory()) {

            String[] files = dir.list();

            System.out.println("Files in Directory:");
            for (String f : files) {
                System.out.println(f);
            }

        } else {
            System.out.println("Invalid Directory Path");
        }
    }
}
