package week3;

public class ExtraQuestions {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
        String str = question5("this is a Sentence");
        
    }
    private static String question5(String string) {
        int index = string.indexOf("e");
        String first = string.substring(0, index);
        String last = string.substring(index + 1);

        return first + last;
    }
    /**
     * Obtains and displays an integer between 1 and 100
     */
    public static void questionOne(){
        int num = (int)(Math.random() * 100) + 1;
        // (int)(Math.random()* numPossibilities) + start;
        System.out.println(num);
    }

    public static void questionTwo(){
        int num = (int)(Math.random() * 101) - 50;
        // (int)(Math.random()* numPossibilities) + start;
        System.out.println(num);
    }
}
