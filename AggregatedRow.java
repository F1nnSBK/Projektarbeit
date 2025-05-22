package Projektarbeit;

public class AggregatedRow {
    public final String location;
    public final int minAge;
    public final int maxAge;
    public final double avgAddictionLevel;
    public final double sortMetric;

    public AggregatedRow(String location, int minAge, int maxAge, double avgAddictionLevel,
                         double sortMetric) {
        this.location = location;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.avgAddictionLevel = avgAddictionLevel;
        this.sortMetric = sortMetric;
    }

    public String toString() {
        return String.format(
            "%-10s | MinAge: %2d | MaxAge: %2d | AvgAddiction: %5.2f | SortMetric: %8.5f",
            location, minAge, maxAge, avgAddictionLevel, sortMetric
        );
    }
}
