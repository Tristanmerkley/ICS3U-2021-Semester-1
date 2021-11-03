package week9;

public class SingleTable {
    private int height;
    private int numSeats;
    private double viewQuality;

    public SingleTable(int seats, double viewQuality, int height) {
        this.height = height;
        this.numSeats = seats;
        this.viewQuality = viewQuality;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getHeight() {
        return height;
    }

    public double getViewQuality() {
        return viewQuality;
    }

    public void setViewQuality(double viewQuality) {
        this.viewQuality = viewQuality;
    }

}
