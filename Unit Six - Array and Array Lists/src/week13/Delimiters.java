package week13;

import java.util.ArrayList;

public class Delimiters {
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> res = new ArrayList<String>();
        for (String i : tokens) {
            if (i == openDel || i == closeDel)
                res.add(i);
        }
        return res;
    }

    public boolean isBalenced() {
        int numClose = 0;
        int numOpen = 0;
        for (String s : delimiters) {
            if (s.equals(openDel))
                numOpen++;
            else if (s.equals(closeDel))
                numClose++;
            if (numClose < numOpen)
                return false;
        }
        return numClose == numOpen;
    }
}
