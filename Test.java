package Projektarbeit;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        // Beispielhafte Daten – du kannst sie durch echte AggregatedRows ersetzen
        ArrayList<AggregatedRow> rows = new ArrayList<>();
        rows.add(new AggregatedRow("Germany", 20, 44, 3.33, 0.14));
        rows.add(new AggregatedRow("Vietnam", 37, 37, 5.00, 5.00));
        rows.add(new AggregatedRow("Japan", 38, 51, 3.33, 0.26));
        rows.add(new AggregatedRow("India", 22, 49, 2.00, 0.07));

        insertionSort(rows);

        printArr(rows);
    }

    public static void insertionSort(ArrayList<AggregatedRow> rows) {
        int n = rows.size();
        for (int i = 1; i < n; i++) {
            AggregatedRow key = rows.get(i);
            int j = i - 1;

            while (j >= 0 && key.sortMetric > rows.get(j).sortMetric) {
                rows.set(j + 1, rows.get(j));
                j--;
            }
            rows.set(j + 1, key);
        }
    }

    public static void printArr(ArrayList<AggregatedRow> rows) {
        System.out.println("_____________________");
        for (AggregatedRow row : rows) {
            System.out.println(row);
        }
        System.out.println("_____________________");
    }
}
