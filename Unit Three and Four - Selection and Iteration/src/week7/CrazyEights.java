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
         String result = playRound(in);
         int firstDash = result.indexOf("-");
         int secondDash = result.indexOf("-", firstDash + 1);
         p1Points += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));
         System.out.println("\n\nYour score: " + p1Points + "\n\nComputer 1's score: " + c1Points + "\n\nComputer 2's score: " + c2Points);
      }
      System.out.println(getWinner(p1Points, c1Points, c2Points));
   }

   private static String getWinner(int p1Points, int c1Points, int c2Points) {
      int min = Math.min(Math.min(p1Points, c1Points), c2Points);
      if (min == p1Points)
         return "You win!!";
      else if (min == c1Points)
         return "Computer 1 wins! \n\n You lost.";
      else
         return "Computer 2 wins! \n\n You lost.";
   }

   private static String playRound(Scanner in) {
      boolean uno = false;
      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      for (int i = 1; i <= 5; i++) {
         playerHand += getCard() + " ";
         c1Hand += getCard() + " ";
         c2Hand += getCard() + " ";
      }

      String topCard = getCard();
      while (topCard.indexOf("8") >= 0) {
         topCard = getCard();
      }

      while (playerHand.length() > 0 && c1Hand.length() > 0 && c2Hand.length() > 0) {
         String temp = processPlayer(playerHand, topCard, in);
         playerHand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || playerHand.length() <= 3;
         temp = processComputer(c1Hand, topCard, uno, in);
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || c1Hand.length() <= 3;
         temp = processComputer(c2Hand, topCard, uno, in);
         c2Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || c2Hand.length() <= 3;
      }
      return score(playerHand, topCard) + "-" + score(c1Hand, topCard) + "-" + score(c2Hand, topCard);
   }

   private static int score(String hand, String topCard) {
      int score = 0;
      for (int i = 0; i < hand.length(); i += 3) {
         String face = hand.substring(i, i + 1);
         if ("10JQK".indexOf(face) >= 0)
            score += 10;
         else if (face.equals("A"))
            score += 1;
         else if ("2345679".indexOf(face) >= 0)
            score += Integer.parseInt(face);
         else
            score += 50;
      }
      return score;
   }

   private static String processPlayer(String playerHand, String topCard, Scanner in) {
      String response = "";
      int len = 0;
      boolean validInput = false;
      boolean redo = true;
      boolean valid = false;
      int drawLimit = 0;
      int cardIndex = 0;
      while (redo) {
         redo = false;
         int ler = topCard.length();
         String face = topCard.substring(0, ler - 1);
         String suit = topCard.substring(ler - 1);
         context(playerHand, topCard, "Your");
         if (drawLimit < 5) {
            if (playerHand.indexOf(face) >= 0 || playerHand.indexOf(suit) >= 0 || playerHand.indexOf("8") >= 0) {
               while (!validInput) {
                  final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
                  System.out.println("Pick a card to play: ");
                  response = in.nextLine().toUpperCase();
                  len = response.length();
                  cardIndex = playerHand.indexOf(response);
                  if (VALID_CARDS.indexOf(response) < 0 || response.equals("")) { // checks if player input is a valid card
                     System.out.println("Not a valid card: " + response);
                  } else if (playerHand.indexOf(response) < 0) { // checks if inputed card is in hand
                     System.out.println("You don't have a [" + response + "]");
                  } else if (response.substring(0, 1).equals("8")) {
                     validInput = true;
                     while (!valid) {
                        System.out.println("Please pick a suit: [Hearts-Clubs-Spades-Diamonds]");
                        String temp = in.nextLine().substring(0, 1).toUpperCase();
                        if ("HCSD".indexOf(temp) >= 0) {
                           playerHand = playerHand.replaceFirst(playerHand.substring(cardIndex, cardIndex + 2) + " ", "");
                           response = response.substring(0, 1) + temp;
                           len = 2;
                           valid = true;
                        } else
                           System.out.println(temp + "is not a valid suit!!");
                     }
                  } else if (topCard.substring(0, ler - 1).equals(response.substring(0, len - 1)) ||
                     topCard.substring(ler - 1).equals(response.substring(len - 1))) {
                     validInput = true;
                  } else
                     System.out.println("\nYou can not play [" + response + "] onto [" + topCard + "]");
               }
            } else {
               String temp = getCard();
               playerHand += temp + " ";
               System.out.println("\nNo playable cards: Drawing new card ... [" + temp + "]\n");
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
         playerHand = playerHand.replaceFirst(response + " ", "");
         System.out.println("\nYou played [" + response + "]");
         System.out.println("\n-----------------------------------\n");
      }
      return playerHand + "-" + topCard;
   }

   private static void context(String hand, String topCard, String name) {
      String tempHand = hand.replace(" ", "] [");
      System.out.println(name + " hand is: [" + tempHand.substring(0, tempHand.length() - 2));
      System.out.println("The top card is: [" + topCard + "]");
   }

   private static String processComputer(String hand, String topCard, boolean uno, Scanner in) {
      String selection = "";
      boolean redo = true;
      int drawLimit = 0;
      int ler = topCard.length();
      String face = topCard.substring(0, ler - 1);
      String suit = topCard.substring(ler - 1);
      String suits = "HCSD";
      Boolean checkUno = (hand.indexOf(face) >= 0 || hand.indexOf("8") >= 0) && uno;
      while (redo) {
         redo = false;
         context(hand, topCard, "Computer"); // !for debugging
         if (drawLimit < 5) {
            int len = hand.indexOf(suit);
            int indexFace = hand.indexOf(face);
            if (len >= 0 && !hand.substring(len - 1, len).equals("8") && !checkUno) {
               if (!hand.substring(len - 1, len).equals("0"))
                  selection = hand.substring(len - 1, len + 1);
               else
                  selection = hand.substring(len - 2, len + 1);
            } else if (indexFace >= 0 && !hand.substring(indexFace, indexFace + 1).equals("8")) {
               int index = hand.indexOf(face);
               selection = hand.substring(index, index + face.length() + 1);
            } else if (hand.indexOf("8") >= 0) {
               int index = hand.indexOf("8");
               String temp = "";
               for (int i = 0; i < suits.length(); i++) {
                  temp = suits.substring(i, i + 1);
                  if (hand.indexOf(temp) >= 0)
                     selection += temp;
               }
               int random = (int) (Math.random() * selection.length());
               selection = "8" + selection.substring(random, random + 1);
               hand = hand.replaceFirst(hand.substring(index, index + 2) + " ", "");
            } else {
               String temp = getCard();
               hand += temp + " ";
               System.out.println("No playable cards: Drawing new card ... [" + temp + "]"); // !for debugging
               drawLimit++;
               redo = true;
            }
         } else {
            System.out.println("Draw limit of 5 reached. Computer passed."); // !for debugging
            selection = topCard;
            redo = false;
         }
      }
      topCard = selection;
      hand = hand.replace(selection + " ", "");
      System.out.println("Computer played [" + selection + "]");
      System.out.println("\n-----------------------------------\n");
      return hand + "-" + topCard;
   }

   private static String getCard() {
      String card = getFace() + getSuit();
      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * NUM_SUITS);
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
      int suit = (int) (Math.random() * CARDS_PER_SUIT);
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
