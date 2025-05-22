package Projektarbeit;

import java.util.ArrayList;
import java.util.List;

    public class Sorter {
        public List<AggregatedRow> sort(List<AggregatedRow> rows) {
        if(rows == null || rows.size() <= 1) { throw new IllegalArgumentException("Empty list received"); }
            mergeSort(rows);
            return rows;
        }


    private void mergeSort(List<AggregatedRow> rows) {
        if (rows.size() <= 1) return;

        int middleIndex = rows.size() / 2;

        List<AggregatedRow> leftSide = new ArrayList<>(middleIndex);
        List<AggregatedRow> rightSide = new ArrayList<>(rows.size() - middleIndex);

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

    private void merge(List<AggregatedRow> rows, List<AggregatedRow> leftSide, List<AggregatedRow> rightSide) {
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


    public static void printArr(List<AggregatedRow> arr) {
        for(AggregatedRow row : arr) {
            System.out.println(row);
        }
    }
    
}
