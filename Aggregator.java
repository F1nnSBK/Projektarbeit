package Projektarbeit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aggregator {

    public ArrayList<AggregatedRow> aggregate(ArrayList<Row> rows) {
        
    Map<String, ArrayList<Row>> groupedRows = new HashMap<String, ArrayList<Row>>();

    for (Row row : rows) {
        if (!groupedRows.containsKey(row.location)) {
            groupedRows.put(row.location, new ArrayList<>());
        }
        groupedRows.get(row.location).add(row);
    }

    ArrayList<AggregatedRow> aggregatedRows = new ArrayList<>();

    for (Map.Entry<String, ArrayList<Row>> entry : groupedRows.entrySet()) {
        String location = entry.getKey();
        ArrayList<Row> personsInLocation = entry.getValue();

        if (personsInLocation.isEmpty()) {
            continue;
        }

        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;
        double totalAddictionLevel = 0;

        for (Row row : personsInLocation) {
            int currentAge = row.age;
            if (currentAge < minAge) {
                minAge = currentAge;
            }
            if (currentAge > maxAge) {
                maxAge = currentAge;
            }

            double currentAddictionLevel = row.addictionLevel;
            totalAddictionLevel += currentAddictionLevel;
        }

        double avgAddictionLevel = totalAddictionLevel / personsInLocation.size();

        double sortMetric;
        if (maxAge == minAge) {
            sortMetric = avgAddictionLevel;
        } else {
            sortMetric = avgAddictionLevel / (maxAge - minAge);
        }

        aggregatedRows.add(
            new AggregatedRow(location, minAge, maxAge, avgAddictionLevel, sortMetric));
        }

        return aggregatedRows;
    }
}
