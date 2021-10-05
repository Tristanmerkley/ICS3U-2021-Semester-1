package week5;

import java.util.Scanner; // imports the java utility Scanner

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // initiates keyboard input
        processRunner(in); // runs processRunner
        processRunner(in); // runs processRunner
        processRunner(in); // runs processRunner

        in.close(); // ends keyboard input
    }
/**
 * Takes inputs from the keyboard and outputs results
 * @param in
 */
    private static void processRunner(Scanner in) {
        String firstName, lastName; // declares the Strings firstName, lastName
        String mileOne, mileTwo, finishTime; // declares the Strings mileOne, mileTwo, finishTime
        String splitTwo, splitThree; // declares the Strings splitTwo, splitThree

        System.out.print("Please enter your first name: "); // requests input for firstName
        firstName = in.nextLine(); // sets firstName equal to the user input
        System.out.print("Please enter your last name: "); // requests input for lastName
        lastName = in.nextLine(); // sets lastName equal to the user input
        System.out.print("Please enter mile one: "); // requests input for mileOne
        mileOne = in.nextLine(); // sets mileOne equal to the user input
        System.out.print("Please enter mile two: "); // requests input for mileTwo
        mileTwo = in.nextLine(); // sets mileTwo equal to the user input
        System.out.print("Please enter finish time: "); // requests input for finishTime
        finishTime = in.nextLine(); // sets finishTime equal to the user input

         splitTwo = subtractTimes(mileTwo, mileOne); // sets splitTwo equal to a call for subtractTimes
         splitThree = subtractTimes(finishTime, mileTwo); // sets splitThree equal to a call for subtractTimes

         System.out.println(lastName + " " + firstName + ":"); // prints on a new line
         System.out.println("Split one: " + mileOne); // prints on a new line
         System.out.println("Split two: " + splitTwo); // prints on a new line
         System.out.println("Split three: " + splitThree); // prints on a new line
 
    }
/**
 * Takes two times as string in the format of mm:ss.sss and returns the difference
 * @param endTime
 * @param startTime
 * @return
 */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime); // sets endInSeconds equal to a call for convertToSeconds inserting endTime
        double startInSeconds = convertToSeconds(startTime); // sets startInSeconds equal to a call for convertToSeconds inserting startTime

        double diffInSeconds = endInSeconds - startInSeconds; // inputs the difference between endTime and startTime into diffInSeconds

        return convertToTime(diffInSeconds); // returns a call for convertToTime and inserts diffInSeconds
    }
/**
 * Takes the total seconds as a double and returns it in the format mm:ss.sss
 * @param seconds
 * @return
 */
    private static String convertToTime(double seconds) {
        //return  + ":" + ; // returns getMinutes and getSeconds in the time formatting
        return String.format("%d:%06.3f", getMinutes(seconds), getSeconds(seconds));
    }

/**
 * Takes the total seconds as a double and returns it in whole minutes
 * @param totalSeconds
 * @return
 */
    private static int getMinutes(Double totalSeconds) {
        int minutes = (int)(totalSeconds/60); // turns totalSeconds into whole minutes
        return minutes; // returns minutes
    }
/**
 * Takes the total seconds as a double and returns the remainder of seconds after whole minutes are taken out
 * @param totalSeconds
 * @return
 */
    private static double getSeconds(Double totalSeconds) {
        double seconds = (totalSeconds % 60); // takes the remainder of totalSeconds after getting whole minutes
        return seconds; // returns seconds
    }
/**
 * Takes a String in the format mm:s.sss and returns it as seconds forma: sss.sss
 * @param time
 * @return
 */
    private static double convertToSeconds(String time) {
        int colon = time.indexOf(":"); // gets index number of the colon
        double minutes = Double.valueOf(time.substring(0, colon));  // creates a double called seconds and sets it equal to time starting 0 all the way to the index, colon, then it changes it from a String to a double
        double seconds = Double.valueOf(time.substring(colon + 1)); // creates a double called seconds and sets it equal to time starting at the index, colon, then it changes it from a String to a double
        return (minutes * 60) + seconds; // returns minutes in seconds and adds seconds
    }


}
