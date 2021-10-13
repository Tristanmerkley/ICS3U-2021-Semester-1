package week4;

public class Test {
    public static void main(String[] args) {
      catDog("catdog");
    }
    public static boolean catDog(String str) {
      int index = 0;
      int cats = 0;
      int dogs = 0;
      while(index < str.length()-2){
        if(str.substring(index, index+3).equals("cat")){
          cats += 1;
        }
        if(str.substring(index, index+3).equals("dog")){
          dogs += 1;
        }
      }
      return cats == dogs;
    }
    
}
