package week5;

import java.util.Scanner; // imports the java utility Scanner

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // initiates keyboard input
        processRunner(in);
        processRunner(in);
        processRunner(in);

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


        firstName = promptUser("Please enter your first name: ", in);
        lastName = promptUser("Please enter your last name: ", in);
        mileOne = promptUser("Please enter mile one: ", in);
        mileTwo = promptUser("Please enter mile two: ", in);
        finishTime = promptUser("Please enter finish time: ", in);

         splitTwo = subtractTimes(mileTwo, mileOne);
         splitThree = subtractTimes(finishTime, mileTwo);

         System.out.println(lastName + " " + firstName + ":");
         System.out.println("Split one: " + mileOne);
         System.out.println("Split two: " + splitTwo);
         System.out.println("Split three: " + splitThree);
 
    }
    /**
     * Takes a string and scanner input and returns the user's input
     * @param prompt
     * @param in
     * @return
     */
private static String promptUser(String prompt, Scanner in) {
    System.out.print(prompt);
    return in.nextLine();
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
/**
 * Takes the total seconds as a double and returns it in the format mm:ss.sss
 * @param seconds
 * @return
 */
    private static String convertToTime(double seconds) {
        return String.format("%d:%06.3f", getMinutes(seconds), getSeconds(seconds));
    }

/**
 * Takes the total seconds as a double and returns it in whole minutes
 * @param totalSeconds
 * @return
 */
    private static int getMinutes(Double totalSeconds) {
        int minutes = (int)(totalSeconds/60);
        return minutes;
    }
/**
 * Takes the total seconds as a double and returns the remainder of seconds after whole minutes are taken out
 * @param totalSeconds
 * @return
 */
    private static double getSeconds(Double totalSeconds) {
        double seconds = (totalSeconds % 60);
        return seconds;
    }
/**
 * Takes a String in the format mm:s.sss and returns it as seconds forma: sss.sss
 * @param time
 * @return
 */
    private static double convertToSeconds(String time) {
        int colon = time.indexOf(":");
        double minutes = Double.valueOf(time.substring(0, colon));
        double seconds = Double.valueOf(time.substring(colon + 1));
        return (minutes * 60) + seconds;
    }


}
