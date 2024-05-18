package homework1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) {
        try{
            Entry[] entries = FileUtils.readFile("src/main/java/homework1/raw_phonebook_data.csv");
            MergeSort.sort(entries, Entry.getComparator("name"));
            FileUtils.writeToFile(entries, "src/main/java/homework1/test.csv");

            System.out.println("===================");
            System.out.println("System is ready.");
            String inputString = "0";
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Enter the name that you wish to search for, or -1 to exit: ");
                inputString = scanner.nextLine();
                if(inputString.equals("-1")){
                    System.out.println("Thank you for using the phonebook :3");
                    break;
                }
                int[] foundEntries = BinarySearch.search(entries, inputString);
                if (foundEntries.length== 0) {
                    System.out.println("No entries with the given name exist in the phonebook.");
                    continue;
                }
                int numOfFound = foundEntries[1] - foundEntries[0] + 1;
                System.out.println("Entries found: " + numOfFound);

                for(int i = foundEntries[0]; i<= foundEntries[1];i++) {
                    System.out.println(entries[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
