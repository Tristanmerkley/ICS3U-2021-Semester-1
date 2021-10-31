package week7;

import java.util.Scanner;

public class CrazyEights {
   private static final double CARDS_PER_SUIT = 13;

   /**
    * initializes a round of Crazy Eights. once a round has been completed, it displays everyones
    * score. runs another round as long as the game is not over. once the game is over, it displays who
    * the winner
    *
    * @param args
    */
   public static void main(String[] args) {
      int p1Points = 0, c1Points = 0, c2Points = 0;
      Scanner in = new Scanner(System.in);
      while (!gameOver(p1Points, c1Points, c2Points)) {
         System.out.println("\nStarting round .......................... \n\n");
         String result = playRound(in);
         int firstDash = result.indexOf("-");
         int secondDash = result.indexOf("-", firstDash + 1);
         p1Points += Integer.parseInt(result.substring(0, firstDash)); // decodes for the player's points
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash)); // decodes for computer one's points
         c2Points += Integer.parseInt(result.substring(secondDash + 1)); // decodes for computer two's points
         System.out.println("\n\nYour score: " + p1Points + "\n\nComputer 1's score: " + c1Points + "\n\nComputer 2's score: " + c2Points);
      }
      System.out.println(getWinner(p1Points, c1Points, c2Points));
   }

   /**
    * gets the winner of the game.
    *
    * @param p1Points
    * @param c1Points
    * @param c2Points
    * @return
    */
   private static String getWinner(int p1Points, int c1Points, int c2Points) {
      int min = Math.min(Math.min(p1Points, c1Points), c2Points);
      if (min == p1Points)
         return "You win!!";
      else if (min == c1Points)
         return "Computer 1 wins! \n\n You lost.";
      else
         return "Computer 2 wins! \n\n You lost.";
   }

   /**
    * initially giving each player/computer 5 cards. sets a topcard which is not an 8. plays a round of
    * Crazy Eights.
    *
    * @param in
    * @return
    */
   private static String playRound(Scanner in) {
      boolean uno = false;
      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      for (int i = 1; i <= 5; i++) { // adds 5 cards to everyones hand
         playerHand += getCard() + " ";
         c1Hand += getCard() + " ";
         c2Hand += getCard() + " ";
      }
      playerHand.trim();
      c1Hand.trim();
      c2Hand.trim();

      String topCard = getCard();
      while (topCard.indexOf("8") >= 0) { // gets a new topcard if it is an 8
         topCard = getCard();
      }

      while (playerHand.length() > 0 && c1Hand.length() > 0 && c2Hand.length() > 0) {// runs everyones hand as long as everyone has a card.
         String temp = processPlayer(playerHand, topCard, in);
         playerHand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || playerHand.length() <= 3; // checks if player has one card left, or computer 2
         temp = processComputer(c1Hand, topCard, uno, in);
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || c1Hand.length() <= 3; // checks if computer 1 has one card left, or player
         temp = processComputer(c2Hand, topCard, uno, in);
         c2Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         uno = uno || c2Hand.length() <= 3; // checks if computer 2 has one card left, or computer 1
      }
      return score(playerHand) + "-" + score(c1Hand) + "-" + score(c2Hand); // returns the score in format player-computer1-computer2 (23-0-98)
   }

   /**
    * returns an inputed hand's score. with 10, Jack, Queen, King being worth 10 points 2-9 otherthan 8
    * being worth face value ace being worth 1, and 8 being worth 50.
    *
    * @param hand
    * @return
    */
   private static int score(String hand) {
      int score = 0;
      hand = hand.replaceAll("10", "X");
      for (int i = 0; i < hand.length(); i += 3) {
         String face = hand.substring(i, i + 1);
         if ("XJQK".indexOf(face) >= 0)
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

   /**
    * checks if hand contains a playable card
    *
    * @param playerHand
    * @param face
    * @param suit
    * @return
    */
   private static String playable(String playerHand, String face, String suit) {
      String playable = "";
      while (playerHand.indexOf(face) >= 0 || playerHand.indexOf(suit) >= 0 || playerHand.indexOf("8") >= 0) {
         int eightIndex = playerHand.indexOf("8");
         int suitIndex = playerHand.indexOf(suit);
         int faceIndex = playerHand.indexOf(face);
         String temp = "";
         if (faceIndex >= 0) {
            temp = playerHand.substring(faceIndex, playerHand.indexOf(" ", faceIndex));
         } else if (suitIndex >= 0) {
            if (!playerHand.substring(suitIndex - 1, suitIndex).equals("0"))
               temp = playerHand.substring(suitIndex - 1, suitIndex + 1);
            else
               temp = playerHand.substring(suitIndex - 2, suitIndex + 1);
         } else if (eightIndex >= 0)
            temp = playerHand.substring(eightIndex, playerHand.indexOf(" ", eightIndex));
         playerHand = playerHand.replaceFirst(temp + " ", "");
         playable += temp.trim() + " ";
      }
      return playable;
   }

   /**
    * displays player's hand and what the top card is. if no cards can be played, it will draw a new
    * card, up to a max of 5. if a card can be played, it gets input from the player, it then checks if
    * the input is able to be placed on topcard. if the inputed card is an 8, it requests input for a
    * suit. it then removes the chosen card.
    *
    * @param playerHand
    * @param topCard
    * @param in
    * @return
    */
   private static String processPlayer(String playerHand, String topCard, Scanner in) {
      String response = "";
      boolean validInput = false;
      boolean redo = true;
      boolean valid = false;
      int drawLimit = 0;
      int cardIndex = 0;
      while (redo) { // repeats if a card is drawn
         redo = false;
         int ler = topCard.length();
         String face = topCard.substring(0, ler - 1); // gets the face of top card
         String suit = topCard.substring(ler - 1); // gets the suit of top card
         System.out.println("Your hand is: [" + playerHand.trim().replace(" ", "] [") + "]");
         System.out.println("The top card is: [" + topCard + "]");
         if (drawLimit < 5) { // checks if draw limit has been reached
            String playable = playable(playerHand, face, suit);
            if (playable.length() > 1) { // checks if you can play any cards
               while (!validInput) {
                  final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
                  System.out.println("Pick a card to play: ");
                  response = in.nextLine().toUpperCase();
                  cardIndex = playerHand.indexOf(response);
                  if (VALID_CARDS.indexOf(response) < 0 || response.equals("")) { // checks if player input is a valid card
                     System.out.println("Not a valid card: " + response);
                  } else if (playerHand.indexOf(response) < 0) { // checks if inputed card is in hand
                     System.out.println("You don't have a [" + response + "]");
                  } else if (response.substring(0, 1).equals("8")) { // checks if inputed card is an 8
                     validInput = true;
                     while (!valid) {
                        System.out.println("Please pick a suit: [Hearts-Clubs-Spades-Diamonds]");
                        String temp = in.nextLine().substring(0, 1).toUpperCase();
                        if ("HCSD".indexOf(temp) >= 0) { // checks if input is a valid suit
                           playerHand = playerHand.replaceFirst(playerHand.substring(cardIndex, cardIndex + 2) + " ", ""); // removes the selected card
                           response = response.substring(0, 1) + temp; // sets the response equal to 8 and the selected suit
                           valid = true;
                        } else
                           System.out.println(temp + "is not a valid suit!!");
                     }
                  } else if (playable.indexOf(response) >= 0) { // checks if the inputed card can be played
                     validInput = true;
                     playerHand = playerHand.replaceFirst(topCard + " ", ""); // replaces the played card
                  } else
                     System.out.println("\nYou can not play [" + response + "] onto [" + topCard + "] Valid inputs include: [" + playable.trim().replace(" ", "] [") + "]");
               }
            } else {
               String temp = getCard();
               playerHand += temp + " "; // adds a new card to players hand
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
      System.out.println("\nPlayed [" + topCard + "]");
      System.out.println("\n-----------------------------------\n");
      return playerHand + "-" + topCard; // returns hand an topcard in the format hand-topcard (5D 6D-8C)
   }

   /**
    * If computer has a matching suit in their hand to the top card, it will play. otherwise if it has
    * a matching face to the top card, it will play. if neither of above is true, it has an eight, it
    * will play it, picking the suit based on a the other suits in their hand. regardless of above, if
    * either the player or other computer has only one card left, it will attemp rule matching faces or
    * using an eight card before a matching suit. it then displays computer's hand, replacing all the
    * cards with XX.
    *
    * @param hand
    * @param topCard
    * @param uno
    * @param in
    * @return
    */
   private static String processComputer(String hand, String topCard, boolean uno, Scanner in) {
      String selection = "";
      boolean redo = true;
      int drawLimit = 0;
      int ler = topCard.length();
      String face = topCard.substring(0, ler - 1);
      String suit = topCard.substring(ler - 1);
      Boolean checkUno = (hand.indexOf(face) >= 0 || hand.indexOf("8") >= 0) && uno; // checks if computer can change the suit, if another player has one card
      while (redo) { // loops if a card has been drawn
         redo = false;
         for (int i = 0; i < hand.replace("10", "X").length() - 2; i += 3) // prints computer's hand, with the cards being XX's
            System.out.print("XX ");
         System.out.println();
         if (drawLimit < 5) { // checks if the draw limit has been reached
            int len = hand.indexOf(suit);
            int indexFace = hand.indexOf(face);
            if (len >= 0 && !hand.substring(len - 1, len).equals("8") && !checkUno) { // checks if hand includes a card with same suit as topcard
               if (!hand.substring(len - 1, len).equals("0")) // checks if the selected card is a ten
                  selection = hand.substring(len - 1, len + 1);
               else
                  selection = hand.substring(len - 2, len + 1);
            } else if (indexFace >= 0 && !hand.substring(indexFace, indexFace + 1).equals("8")) { // checks if hand has a card with the same face as topcard
               int index = hand.indexOf(face);
               selection = hand.substring(index, index + face.length() + 1);
            } else if (hand.indexOf("8") >= 0) { // checks if hand has an eight card
               int index = hand.indexOf("8");
               String temp = "";
               for (int i = 0; i < 4; i++) { // runs through the suits
                  temp = "HCSD".substring(i, i + 1);
                  if (hand.indexOf(temp) >= 0) // if suit is in hand, it adds to a string
                     selection += temp;
               }
               int random = (int) (Math.random() * selection.length());
               selection = "8" + selection.substring(random, random + 1); // chooses a random suit, from suits in hand
               hand = hand.replaceFirst(hand.substring(index, index + 2) + " ", ""); // removes the selected card
            } else { // if no cards can be played
               String temp = getCard(); // gets a new card
               hand += temp + " "; // adds the new card to hand
               drawLimit++;
               redo = true;
            }
         } else { // if draw limit has been reached, ends the turn
            redo = false;
         }
      }
      return hand.replace(selection + " ", "") + "-" + selection; // returns the hand in format hand-topcard (5D 6D-7C)
   }

   /**
    * returns a card using a random face and suit
    *
    * @return
    */
   private static String getCard() {
      String card = getFace() + getSuit();
      return card;
   }

   /**
    * returns a random suit
    *
    * @return
    */
   private static String getSuit() {
      int suit = (int) (Math.random() * 4);
      if (suit == 0)
         return "H";
      else if (suit == 1)
         return "D";
      else if (suit == 2)
         return "C";
      else
         return "S";
   }

   /**
    * returns a random face card
    *
    * @return
    */
   private static String getFace() {
      int suit = (int) (Math.random() * CARDS_PER_SUIT);
      if (suit >= 2 && suit <= 10)
         return suit + "";
      else if (suit == 1)
         return "A";
      else if (suit == 11)
         return "J";
      else if (suit == 12)
         return "Q";
      else
         return "K";

   }

   /**
    * checks if the game is over (if any player has more than 100 points).
    *
    * @param p1Points
    * @param c1Points
    * @param c2Points
    * @return
    */
   private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
      return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
   }
}
