package homework1;

import homework1.Entry;

import java.io.*;

public class FileUtils {
    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        System.out.println("Loading the entries...");
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath)
            );

            // each line of the csv file is turned into one String
            String[] EntryLines = (String[]) reader.lines().toArray(String[]::new);

            // watching out for IO resources
            reader.close();

            // initializing output array with size of however many csv lines there are
            Entry[] EntryArray = new Entry[EntryLines.length-1] ;

            for (int i = 0; i < EntryLines.length; i++) {
                // avoiding csv column names, they are not an employee entry
                if (i == 0){
                    continue;
                }
                // each line is split into parts of the IP Address
                String[] EntryParts = EntryLines[i].split(";");

                // new Entry object is created and assigned a memory location within output array
                Entry tempEntry = new Entry(
                        EntryParts[0] , EntryParts[1], EntryParts[2], EntryParts[3], EntryParts[4], EntryParts[5]
                );
                EntryArray[i-1] = tempEntry;

            }
            return EntryArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        System.out.println("Saving the sorted file...");
        try {
            // means of writing into the csv file
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filePath)
            );

            // creating one line that is supposed to be written into the csv file
            for (Entry entry: entries){
                String entryLine = entry.getName() + ";" +
                                   entry.getStreetAddress() + ";" +
                                   entry.getCity() + ";" +
                                   entry.getPostCode() + ";" +
                                   entry.getCountry() + ";" +
                                   entry.getPhoneNumber();
                writer.write(entryLine.concat("\n"));
            }

            // watching out for IO resources
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}