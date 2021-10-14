package week4;

public class Test {
    public static void main(String[] args) {
      //catDog("catdog");
      int numRounds = 5;
      int value = 9;
      int random = (int)(Math.random()*10);
      for (int i = 0; i < numRounds; i++){
      while (random != value){
      random = (int)(Math.random()*10);
      System.out.print(random);
    }
    System.out.println();
  }
}
}