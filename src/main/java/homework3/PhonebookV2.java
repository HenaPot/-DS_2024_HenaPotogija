package homework3;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loading entries...");
        RedBlackTree tree = FileUtils.readFile("src/main/java/homework1/raw_phonebook_data.csv");
        System.out.println("Sorting entries...");
        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println("Total Black Edges: " + edgeCounts[0]);
        System.out.println("Total Red Edges: " + edgeCounts[1]);
        System.out.println("===========================================================");
        System.out.println("System is ready. Welcome.");
        while (true) {
            System.out.println("Enter a name in the format 'Surname, Name' to search for, or -1 to exit:");
            String input = scanner.nextLine();

            if (input.equals("-1")) {
                break;
            }

            ArrayList<Entry> entries = tree.get(input);
            if (entries != null) {
                System.out.println(entries.size() + " entries found:");
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("Entry not found.");
            }

            int[] edgeCounts2 = tree.countRedAndBlackEdgesOnPath(input);
            System.out.println("Total Black Edges on path: " + edgeCounts2[0]);
            System.out.println("Total Red Edges on path: " + edgeCounts2[1]);

        }

        scanner.close();
    }
}
