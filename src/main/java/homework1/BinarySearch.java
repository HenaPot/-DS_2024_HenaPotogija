package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int[] indices = new int[2];
        int low = 0;
        int high = entries.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (searchableName.compareTo(entries[mid].getName()) < 0) {
                high = mid - 1;
            } else if (searchableName.compareTo(entries[mid].getName()) > 0) {
                low = mid + 1;
            } else {
                int beginning = mid;
                int ending = mid;
                while(beginning != 0 && entries[beginning-1].compareTo(entries[beginning])==0){
                    beginning--;
                }
                while(ending+1 < entries.length-1 && entries[ending+1].compareTo(entries[ending])==0){
                    ending++;
                }
                indices[0] = beginning;
                indices[1] = ending;
                return indices;
            }
        }
        return new int[0];
    }
    public static int search(int[] elements, int key) {
        int low = 0;
        int high = elements.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < elements[mid]) {
                high = mid - 1;
            } else if (key > elements[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}