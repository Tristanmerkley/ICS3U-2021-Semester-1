package week13;

import java.util.ArrayList;

public class ClimbingClub {

    private ArrayList<ClimbInfo> climbList;

    public ClimbingClub() {
        climbList = new ArrayList<ClimbInfo>();
    }

    public void addClimb(String peakName, int climbTime) {
        climbList.add(new ClimbInfo(peakName, climbTime));
        for (int i = 0; i < climbList.size(); i++) {
            String t = climbList.get(i).getName();
            if (peakName.compareTo(t) < 0) {
                climbList.add(i, new ClimbInfo(peakName, climbTime));
            }
        }
    }

}
