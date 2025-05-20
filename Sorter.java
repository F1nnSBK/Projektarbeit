package Projektarbeit;

import java.util.ArrayList;

    public class Sorter {
        public ArrayList<AggregatedRow> sort(ArrayList<AggregatedRow> rows) {
        if(rows == null || rows.size() <= 1) { throw new IllegalArgumentException("Empty list received"); }
            mergeSort(rows);
            return rows;
        }


    private void mergeSort(ArrayList<AggregatedRow> rows) {
        if (rows.size() <= 1) return;

        int middleIndex = rows.size() / 2;

        ArrayList<AggregatedRow> leftSide = new ArrayList<>(middleIndex);
        ArrayList<AggregatedRow> rightSide = new ArrayList<>(rows.size() - middleIndex);

        for (int i = 0; i < middleIndex; i++) {
            leftSide.add(rows.get(i));
        }
        for (int i = middleIndex; i < rows.size(); i++) {
            rightSide.add(rows.get(i));
        }

        mergeSort(leftSide);
        mergeSort(rightSide);

        merge(rows, leftSide, rightSide);
    }

    private void merge(ArrayList<AggregatedRow> rows, ArrayList<AggregatedRow> leftSide, ArrayList<AggregatedRow> rightSide) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < leftSide.size() && rightIndex < rightSide.size()) {
            if (leftSide.get(leftIndex).sortMetric >= rightSide.get(rightIndex).sortMetric) {
                rows.set(mergedIndex++, leftSide.get(leftIndex++));
            } else {
                rows.set(mergedIndex++, rightSide.get(rightIndex++));
            }
        }

        while (leftIndex < leftSide.size()) {
            rows.set(mergedIndex++, leftSide.get(leftIndex++));
        }

        while (rightIndex < rightSide.size()) {
            rows.set(mergedIndex++, rightSide.get(rightIndex++));
        }
    }



    public static void printArr(ArrayList<AggregatedRow> arr) {
          System.out.println("_____________________");
        for(AggregatedRow row : arr) {
            System.out.println(row);
        }
          System.out.println("_____________________");
    }
    
}
