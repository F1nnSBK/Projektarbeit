package Projektarbeit;

import java.util.ArrayList;

    public class Sorter {
        public void sort(ArrayList<AggregatedRow> rows) {
        int n = rows.size();
        if(rows == null || rows.size() <= 1) { return; }
        quickSortHelper(rows, 0, n - 1);
        printArr(rows);
    }

    private void quickSortHelper(ArrayList<AggregatedRow> rows, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(rows, low, high);
            quickSortHelper(rows, low, pivotIndex - 1);
            quickSortHelper(rows, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<AggregatedRow> rows, int low, int high) {
        AggregatedRow pivot = rows.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (rows.get(j).sortMetric >= pivot.sortMetric) {
                i++;
                swap(rows, i, j);
            }
        }
        swap(rows, i + 1, high);
        return i + 1;
    }

    private void swap(ArrayList<AggregatedRow> rows, int i, int j) {
        AggregatedRow tempRow = rows.get(i);
        rows.set(i, rows.get(j));
        rows.set(j, tempRow);
    }

    public static void printArr(ArrayList<AggregatedRow> arr) {
          System.out.println("_____________________");
        for(AggregatedRow row : arr) {
            System.out.println(row.toString());
        }
          System.out.println("_____________________");
    }
    
}
