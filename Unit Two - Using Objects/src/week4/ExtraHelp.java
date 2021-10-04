package week4;

public class ExtraHelp {
    public static void main(String[] args) {
        String str = "This is a sentence";
        System.out.println(str.substring(0, 5));
        System.out.println(str.substring(str.length()-4));

        String str2 = "abcabc";

        int mid = str2.length()/2;

        String front = str2.substring(0, mid);
        String back = str2.substring(mid);

        System.out.println(front.equals(back));
    }
}
