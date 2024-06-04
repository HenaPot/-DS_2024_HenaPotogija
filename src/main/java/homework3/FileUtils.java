package homework3;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
    public static RedBlackTree readFile(String filePath) {
        RedBlackTree tree = new RedBlackTree();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Entry entry = new Entry(values[0], values[1], values[2], values[3], values[4], values[5]);
                tree.put(values[0], entry); // Use 'name' as the key
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }
}