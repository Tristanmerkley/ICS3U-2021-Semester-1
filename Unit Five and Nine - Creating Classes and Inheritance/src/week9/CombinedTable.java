package week9;

public class CombinedTable {
    private SingleTable table1;
    private SingleTable table2;

    public CombinedTable(SingleTable tableOne, SingleTable tableTwo) {
        table1 = tableOne;
        table2 = tableTwo;
    }

    public double getDesirability() {
        if (table1.getHeight() != table2.getHeight()) {
            return (table1.getViewQuality() + table2.getViewQuality()) / 2;
        } else {
            return (table1.getViewQuality() + table2.getViewQuality()) / 2 - 10;
        }
    }

    public boolean canSeat(int seats) {
        return seats <= (table1.getNumSeats() + table2.getNumSeats() - 2);
    }
}
