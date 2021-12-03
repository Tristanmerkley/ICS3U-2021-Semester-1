package week13;

import java.util.ArrayList;

public class MasterOrder {
    private ArrayList<CookieOrder> orders;

    public MasterOrder() {
        orders = new ArrayList<CookieOrder>();
    }

    public void addOrder(CookieOrder theOrder) {
        orders.add(theOrder);
    }

    public int getTotalBoxes() {
        int sum = 0;
        for (CookieOrder i : orders) {
            sum += i.getNumBoxes
        }
        return sum;
    }

    public int removeVariety(String cookieVar) {
        int res = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getVariety().equals(cookieVar)) {
                orders.remove(i);
                res += orders.get(i).getNumBoxes();
            }
        }
        return res;
    }
}
