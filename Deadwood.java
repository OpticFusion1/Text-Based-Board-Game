/* Program: Deadwood.java
 * Class: Deadwood.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: Class in charge of starting and ending the game of Deadwood.
 */

package net.processing;

import java.util.*;
import java.lang.*;


public class Deadwood{

   // private data
   private static int day=3;
   private static int numPlayers;
   
   // instance of CastingOffice
   static CastingOffice castingOffice = new CastingOffice();
   
   // setter method
   public static void updateDay(){
      day--;
   }
   
   // other methods
   

   /* Method: endGame(Actor, Actor, Actor)
    * Purpose: scores and announces the winner
    * Return: void
    * Technique: calculates the final scores for each player, prints out all scores
    *            along with the declared winner
    */
   public static  void endGame(Actor player1, Actor player2, Actor player3){
      int player1Score;
      int player2Score;
      String winner;   
      
      int player3Score;
      
      
      player1Score = player1.getCredits() + player1.getDollars() + 5*player1.getRank();
      player2Score = player2.getCredits() + player2.getDollars() + 5*player2.getRank();
      
      //scoring for 3 players
      if (numPlayers ==3){
         player3Score = player3.getCredits() + player3.getDollars() + 5*player3.getRank();
         
         if (player3Score > player2Score){
            if(player3Score>player1Score){
               winner= player3.getName();
            }else{
               winner= player1.getName();
            }
         }else{
            if(player2Score>player1Score){
               winner= player2.getName();
            }
            else{
               winner= player1.getName();
            }
         }  
            
              
         //print out results
         printResults3(player1,player2,player3,player1Score, player2Score, player3Score, winner);
         
         
         
      //scoring for 2 players  
      }else{
         if(player1Score>player2Score){
            winner=player1.getName();
         }else{
            winner=player2.getName();
         }       
         
         //print out results
         printResults2(player1, player2,player1Score, player2Score, winner);      
      }
   }
   
   
   

   /* Method: printResults2(Actor, Actor, int, int, String)
    * Purpose: prints out results for game of 2 players
    * Return: void
    * Technique: print statementts
    */
   public static  void printResults2(Actor player1, Actor player2, int player1Score, int player2Score, String winner){
      System.out.println(player1.getName() + " had a final score of " + player1Score + "!");
      System.out.println(player2.getName() + " had a final score of " + player2Score + "!");
      System.out.println("The winner is...");
      System.out.println(winner+"!!!");
   }
   
   /* Method: printResults2(Actor, Actor, Actor, int, int, int, String)
    * Purpose: prints out results for game of 3 players
    * Return: void
    * Technique: print statementts
    */
   public static  void printResults3(Actor player1, Actor player2, Actor player3, int player1Score, int player2Score,int player3Score,String winner){
      System.out.println(player1.getName() + " had a final score of " + player1Score + "!");
      System.out.println(player2.getName() + " had a final score of " + player2Score + "!");
      System.out.println(player3.getName() + " had a final score of " + player3Score + "!");
      System.out.println("The winner is...");
      System.out.println(winner+"!!!");
      System.out.println("Game Over.");
   }   
   
   
   
   /****************************** main ***********************************/
   
   
   
   public static void main(String[] args){
      Board board = new Board();
      board.setAllAdjacentRooms();
   
      //get number of players
      System.out.println("How many players? (2 or 3)");
      Scanner scanner = new Scanner(System.in);
      boolean loop = true;
      while (loop) {
         try {
            numPlayers = scanner.nextInt();
            if ((numPlayers == 2) ^ (numPlayers == 3)) {
               loop = false;
            }
            else {
               System.out.println("Your input was not valid. Please try again.");
            }
         }
         catch (InputMismatchException e) {
            System.out.println("Your input was not a valid integer. Please try again.");
            scanner.next(); // this consumes the invalid token
         }
         
      }
      
      Actor[] actors = new Actor[numPlayers];

      //get names for players, create actors
      System.out.println("Enter name for Player 1:");
      String name = scanner.next();
      Actor player1 = new Actor(board.trailers, castingOffice,name);
      
      System.out.println("Enter name for Player 2:");
      name = scanner.next();     
      Actor player2 = new Actor(board.trailers, castingOffice, name);
      actors[0]= player1;
      actors[1]= player2;
      Actor player3 = null;
      if (numPlayers ==3){
         System.out.println("Enter name for Player 3:");
         name = scanner.next();     
         player3 = new Actor(board.trailers, castingOffice, name);
         actors[2]= player3;
      }


      //main gameplay loop
      while(day > 0){
         while(board.ifDayEnded()){
            for(int i=0; i<numPlayers; i++){
               System.out.println("It is now actor " + actors[i].getName() + "'s turn.");
               actors[i].takeAMove();                                                                                                                  
               if(!board.ifDayEnded()){
                  break;
               }
            }  
         }
         System.out.println("\nThe day has ended. All actors are returned to trailers and rooms are reset.\n");
         updateDay();
         board.resetBoard();
         for (int i = 0; i<actors.length; i++) {
            actors[i].resetRehearsals();
            actors[i].removeRole();
            actors[i].resetRoom(board.trailers);
         }
      }
      
      
      
      //end game
      if(numPlayers == 3){
         endGame(player1,player2,player3);
      }else{
         endGame(player1,player2,null);
      }
         

    
   }
   
   /***************************** main *************************************/

}
