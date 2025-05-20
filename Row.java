package Projektarbeit;

public class Row {
    public String location;
    public int age;
    public double addictionLevel;

    public Row(String location, int age, double addictionLevel) {
        this.location = location;
        this.age = age;
        this.addictionLevel = addictionLevel;
    }

    public String toString() {
        return "Row{location='" + location + "', age=" + age + ", addictionLevel=" + addictionLevel + '}';
    }

}
