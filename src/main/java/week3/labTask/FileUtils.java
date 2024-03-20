package week3.labTask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath)
            );

            // each line of the csv file is turned into one String
            String[] IPLines = (String[]) reader.lines().toArray(String[]::new);

            //watching out for IO resources
            reader.close();

            // initializing output array with size of however many csv lines there are
            IPAddress[] IPArray = new IPAddress[IPLines.length] ;

            for (int i = 0; i < IPLines.length; i++) {
                // each line is split into parts of the IP Address
                String[] IPParts = IPLines[i].split(";");

                // new IPAddress object is created and assigned a memory location within output array
                IPAddress tempIPAddress = new IPAddress(
                        Long.parseLong(IPParts[0]) , Long.parseLong(IPParts[1]), IPParts[2], IPParts[3], IPParts[4], IPParts[5]
                );
                IPArray[i] = tempIPAddress;

            }

            return IPArray;

        } catch (FileNotFoundException e) {
            System.out.println("BAD FILEPATH");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /*public static void main(String[] args) {
        String myFilePath = "G:\\Faks 4\\Data Structures\\DS Labs\\Data_Structures_Labs\\IP2LOCATION.csv";
        readFile(myFilePath);

    }*/

}
