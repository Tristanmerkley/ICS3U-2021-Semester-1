package week9;

public class StepTracker {
    private int steps;
    private int days;
    private int activeDays;
    private int activeLimit;

    public StepTracker(int limit) {
        activeLimit = limit;
        this.steps = 0;
        this.days = 0;
        this.activeDays = 0;
    }

    public void addDailySteps(int steps) {
        days++;
        if (steps >= activeLimit)
            activeDays++;
        this.steps += steps;
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        return (double) steps / days;
    }
}
