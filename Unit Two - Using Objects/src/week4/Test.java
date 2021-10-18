package week4;

public class Test {
    public static void main(String[] args) {
      System.out.println(!( !( a && b ) || ( c || !d )));
    }
    public static boolean mystery(String str){
      String temp = "";
      for(int k = str.length();k>0;k--){
        temp = temp + str.substring(k -1, k);
      }
      return temp.equals(str);
    }
  }