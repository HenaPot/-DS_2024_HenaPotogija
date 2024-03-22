package week4.labTask;

import week1.Node;

import java.util.Iterator;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        int linkedListLength = ll.count();
        for (int i = 1; i < linkedListLength; i++) {
            Data key = ll.get(i);
            int insertIndex = findInsertionPoint(ll, i - 1, key);
            ll.remove(i);
            ll.add(insertIndex, key);

        }

    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            Data midValue = ll.get(mid);

            if (key.compareTo(midValue) < 0) {
                high = mid - 1;
            } else if (key.compareTo(midValue) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return  low;
    }
}
