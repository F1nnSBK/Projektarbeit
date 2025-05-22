package Projektarbeit;

import java.util.ArrayList;
import java.util.List;

public class Main {

     public static List<Row> createRowObjectsFromCsv() {
        String csvData =
                "UserID,Gender,Age,Income,Profession,Demographics,Platform,Location,AddictionLevel,SelfControl\n" +
                "626,Female,62,95250,Server,Urban,YouTube,Indonesia,7,3\n" +
                "293,Male,63,85677,Server,Urban,Facebook,Brazil,2,8\n" +
                "961,Female,21,84110,Manager,Rural,YouTube,Germany,5,5\n" +
                "742,Other,22,98471,Driver,Rural,TikTok,Indonesia,5,5\n" +
                "188,Male,44,87843,Server,Urban,YouTube,Germany,0,10\n" +
                "747,Male,40,40131,Cashier,Urban,TikTok,Japan,2,8\n" +
                "730,Male,39,47810,Server,Rural,Instagram,India,4,6\n" +
                "732,Other,30,30503,Driver,Rural,YouTube,India,3,7\n" +
                "344,Male,46,28259,Driver,Urban,Facebook,India,2,8\n" +
                "190,Male,54,31205,Teacher,Rural,YouTube,Mexico,0,10\n" +
                "238,Female,37,65096,Artist,Rural,Facebook,Vietnam,5,5\n" +
                "608,Female,30,35848,Driver,Rural,Instagram,US,1,9\n" +
                "996,Male,22,74254,Students,Rural,TikTok,India,0,10\n" +
                "191,Male,50,75661,Engineer,Rural,YouTube,Indonesia,2,8\n" +
                "480,Female,51,54542,Driver,Urban,YouTube,Japan,1,9\n" +
                "451,Other,46,64199,Driver,Urban,TikTok,Mexico,2,8\n" +
                "442,Male,49,88648,Worker,Rural,TikTok,India,1,9\n" +
                "663,Male,38,21207,Students,Rural,Instagram,Japan,7,3\n" +
                "276,Female,20,28179,Driver,Rural,TikTok,Germany,5,5\n" +
                "235,Female,33,45556,Driver,Urban,Instagram,Brazil,2,8";

        List<Row> rowObjects = new ArrayList<>();
        String[] lines = csvData.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] values = line.split(",");

            try {
                String location = values[7];
                int age = Integer.parseInt(values[2]);
                double addictionLevel = Double.parseDouble(values[8]);

                Row newRow = new Row(location, age, addictionLevel);
                rowObjects.add(newRow);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Fehler in Zeile: " + line + " – " + e.getMessage());
            }
        }

        return rowObjects;
    }


public static void main(String[] args) {
        List<Row> rawData = createRowObjectsFromCsv();
        System.out.println("--- Rohdaten (" + rawData.size() + " Einträge) ---");

        Aggregator aggregator = new Aggregator();
        List<AggregatedRow> aggregatedRows = aggregator.aggregate(rawData);
        System.out.println("--- Anzahl aggregierter Locations (" + aggregatedRows.size() + " Locations) ---");

        Sorter sorter = new Sorter();
        List<AggregatedRow> sortedRows = sorter.sort(aggregatedRows);

        Sorter.printArr(sortedRows);
    }
}