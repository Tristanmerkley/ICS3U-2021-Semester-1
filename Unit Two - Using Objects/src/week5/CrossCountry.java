package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finishTime;
        String splitTwo, splitThree;

        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = in.nextLine();
        System.out.print("Please enter mile one: ");
        mileOne = in.nextLine();
        System.out.print("Please enter mile two: ");
        mileTwo = in.nextLine();
        System.out.print("Please enter finish time: ");
        finishTime = in.nextLine();

         splitTwo = subtractTimes(mileTwo, mileOne);
         splitThree = subtractTimes(finishTime, mileTwo);

         System.out.println(lastName + " " + firstName + ":");
         System.out.println("Split two: " + splitTwo);
         System.out.println("Split three: " + splitThree);
 
    }
/**
 * Takes two times as string in the format of mm:ss.sss and returns the difference
 * @param endTime
 * @param startTime
 * @return
 */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime);
        double startInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endInSeconds - startInSeconds;

        return convertToTime(diffInSeconds);
    }

    private static String convertToTime(double seconds) {
        return getMinutes(seconds) + ":" + getSeconds(seconds);
    }


    private static int getMinutes(Double totalSeconds) {
        int minutes = (int)(totalSeconds/60);
        return minutes;
    }

    private static double getSeconds(Double totalSeconds) {
        double seconds = (totalSeconds % 60);
        return seconds;
    }

    private static double convertToSeconds(String time) {
        int colon = time.indexOf(":");
        double minutes = Double.valueOf(time.substring(0, colon));
        double seconds = Double.valueOf(time.substring(colon + 1));
        return (minutes * 60) + seconds;
    }


}
