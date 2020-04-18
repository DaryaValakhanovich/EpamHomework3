package task1.entities;

public class Salary {
    private double count;

    public Salary() {
    }

    public Salary(double count) {
        this.count = count;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "count=" + String.format("%.2f", count) +
                '}';
    }
}
