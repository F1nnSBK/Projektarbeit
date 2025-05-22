package Projektarbeit;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aggregator {

    public List<AggregatedRow> aggregate(List<Row> rows) {
        
    Map<String, List<Row>> groupedRows = new HashMap<String, List<Row>>();

    for (Row row : rows) {
        if (!groupedRows.containsKey(row.location)) {
            groupedRows.put(row.location, new ArrayList<>());
        }
        groupedRows.get(row.location).add(row);
    }

    List<AggregatedRow> aggregatedRows = new ArrayList<>();

    for (Map.Entry<String, List<Row>> entry : groupedRows.entrySet()) {
        String location = entry.getKey();
        List<Row> personsInLocation = entry.getValue();

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
            new AggregatedRow(
                location, 
                minAge,
                maxAge, 
                avgAddictionLevel, 
                sortMetric
            ));
        }

        return aggregatedRows;
    }
}
