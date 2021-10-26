package week7;

import java.util.Scanner;

public class CrazyEights {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String CLUBS = "C";
   private static final String SPADES = "S";
   private static final double CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String QUEEN = "Q";
   private static final String KING = "K";
   public static void main(String[] args) {
      int p1Points = 0, c1Points = 0, c2Points = 0;
      Scanner in = new Scanner(System.in);
      while (!gameOver(p1Points, c1Points, c2Points)) {
         String result = playRound( in );
         int firstDash = result.indexOf("-");
         int secondDash = result.indexOf("-", firstDash + 1);
         p1Points += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));

         System.out.println("Current score: " + p1Points + " " + c1Points + " " + c2Points);
      }
   }

   private static String playRound(Scanner in ) {
      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      for (int i = 1; i <= 5; i++) {
         playerHand += getCard() + " ";
         c1Hand += getCard() + " ";
         c2Hand += getCard() + " ";
      }
      playerHand.trim();
      c1Hand.trim();
      c2Hand.trim();

      String topCard = getCard();
      while (topCard.indexOf("8") >= 0) {
         topCard = getCard();
      }

      // "7H 3D AC JS-9D"
      while (playerHand.length() > 0 && c1Hand.length() > 0 && c2Hand.length() > 0) { //delete ='s when doing processComputer.
         //String temp = processPlayer(playerHand, topCard, in );
         //playerHand = temp.substring(0, temp.indexOf("-"));
         //topCard = temp.substring(temp.indexOf("-") + 1);
         String temp = processComputer(c1Hand, topCard, in );
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         temp = processComputer(c2Hand, topCard, in );
         c2Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
      }
      int playerScore = score(playerHand, topCard);
      int c1Score = score(c1Hand, topCard);
      int c2Score = score(c2Hand, topCard);
      return playerScore + "-" + c1Score + "-" + c2Score; // "32-12-2"
   }

   private static int score(String hand, String topCard) {
      int score = 0;
      for (int i = 0; i < hand.length(); i += 3) {
         String face = hand.substring(i, i + 1);
         if ("10JQK".indexOf(face) >= 0) {
            score += 10;
         } else if (face.equals("A")) {
            score += 1;
         } else if ("2345679".indexOf(face) >= 0) {
            score += Integer.parseInt(face);
         } else {
            score += 50;
         }
      }
      return score;
   }

   private static String processPlayer(String playerHand, String topCard, Scanner in ) {
      // where all the playing logic happens
      String response = "";
      boolean validInput = false;
      boolean redo = true;
      boolean valid = false;
      int drawLimit = 0;
      while (redo) {
         redo = false;
         int ler = topCard.length();
         String face = topCard.substring(0, ler - 1);
         String suit = topCard.substring(ler - 1, ler);
         System.out.println("Your hand is: " + playerHand);
         System.out.println("The top card is: " + topCard);
         if (drawLimit < 5) {
            if (playerHand.indexOf(face) >= 0 || playerHand.indexOf(suit) >= 0 || playerHand.indexOf("8") >= 0) {
               while (!validInput) {
                  final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
                  System.out.println("Pick a card to play: ");
                  response = in .nextLine().toUpperCase();
                  int len = response.length();
                  if (VALID_CARDS.indexOf(response) < 0) {
                     System.out.println("Not a valid card: " + response);
                  } else if ((playerHand.indexOf(response) < 0)) {
                     System.out.println("You don't have a " + response);
                  } else if (response.substring(0, 1).equals("8")) {
                     validInput = true;
                     while (!valid) {
                        System.out.println("Please pick a suit: [Hearts-Clubs-Spades-Diamonds]");
                        String temp = in .nextLine().substring(0, 1).toUpperCase();
                        if ("HCSD".indexOf(temp) >= 0) {
                           int res = playerHand.indexOf(response);
                           playerHand = playerHand.replace(playerHand.substring(res, res+2)+" ", "");
                           response = response.substring(0, 1) + temp;
                           valid = true;
                        } else {
                           System.out.println("That is not a valid suit!!");
                        }
                     }
                  } else if (topCard.substring(0, len - 2).equals(response.substring(0, len - 2)) || topCard.substring(len - 1, len).equals(response.substring(len - 1, len))) {
                     validInput = true;
                  } else {
                     System.out.println("You can not play [" + response + "] onto [" + topCard + "]");
                  }
               }
            } else {
               String temp = getCard();
               playerHand += temp + " ";
               System.out.println("No playable cards: Drawing new card ... [" + temp + "]");
               drawLimit++;
               redo = true;
            }
         } else {
            System.out.println("Draw limit of 5 reached. You passed.");
            response = topCard;
            redo = false;
            validInput = false;
         }
      }
      if (validInput) {
         topCard = response;
         playerHand = playerHand.replace(response + " ", "");
         System.out.println("You played [" + response + "]");
      }
      return playerHand + "-" + topCard;
   }
   // length is 2 more than highest possible selection
   // 6H7C8D7D9D
   // 0, 3, 6, 9
   // get input .substring(input, input+2)
   private static String processComputer(String hand, String topCard, Scanner in ) {
      // where all the playing logic happens
      String selection = "";
      boolean redo = true;
      int drawLimit = 0;
      int ler = topCard.length();
      String face = topCard.substring(0, ler - 1);
      String suit = topCard.substring(ler - 1, ler);
      // check if selection's suit is same as top card's suit.
      //! add functionallity for rule #4
      //if(!(hand.length() == 1)){
      while (redo) {
         redo = false;
         System.out.println("Your hand is: " + hand); // for degbugging
         System.out.println("The top card is: " + topCard); // for degbugging
         if (drawLimit < 5) {
            //! add functionallity for if face == 10.
            if (hand.indexOf(suit) >= 0) {
               int index = hand.indexOf(suit);
               selection = hand.substring(index-1, index+1);
            }else if (hand.indexOf(face) >= 0){
               int index = hand.indexOf(face);
               selection = hand.substring(index, index+2);
            }else if(hand.indexOf("8") >= 0){
               int index = hand.indexOf("8");
               int random = (int)(Math.random()*4);
               hand = hand.replace(hand.substring(index, index+2)+" ", "");
               selection = "DSHC".substring(random, random+1);
               selection = "8" + selection;
               // chose suit from options in hand.
            }else{
               String temp = getCard();
               hand += temp + " ";
               System.out.println("No playable cards: Drawing new card ... [" + temp + "]"); // for debugging
               drawLimit++;
               redo = true;
            }
         }else {
            System.out.println("Draw limit of 5 reached. You passed."); // for debugging
            selection = topCard;
            redo = false;
         }
      }
   //}
         topCard = selection;
         hand = hand.replace(selection + " ", "");
         System.out.println("You played [" + selection + "]");
         hand.trim();
      return hand + "-" + topCard;
      // return "-10D"; // for testing
   }

   private static String getCard() {
      String card = getFace() + getSuit();

      return card;
   }

   private static String getSuit() {
      int suit = (int)(Math.random() * NUM_SUITS);

      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return DIAMONDS;
      else if (suit == 2)
         return CLUBS;
      else
         return SPADES;

   }

   private static String getFace() {
      int suit = (int)(Math.random() * CARDS_PER_SUIT);
      if (suit >= 2 && suit <= 10)
         return suit + "";
      else if (suit == 1)
         return ACE;
      else if (suit == 11)
         return JACK;
      else if (suit == 12)
         return QUEEN;
      else
         return KING;

   }

   private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
      return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
   }
}