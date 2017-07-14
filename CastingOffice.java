/* Program: Deadwood.java
 * Class: CastingOffice.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 */

package net.processing;

import java.util.*;
import java.lang.*;

public class CastingOffice {

	private static int[][]upgradeInfo ={ 
		{2, 4, 5},
		{3, 10, 10},
		{4, 18, 15},
		{5, 28, 20},
		{6, 40, 25}
	};
      

   /* Method: checkEligibility(int, int, int, Actor)
    * Purpose: gives choices and upgrades Actor if possible
    * Return: void
    * Technique: checks upgradeInfo to see if upgrade is possible, prints out options
    *            and gets player's choice, then upgrades Actor's rank and credits/dollars
    */
	public void checkEligibility(int rank, int credits, int dollars, Actor actor) {
   
      int upgradeSize = 0;
      int[][] upgradeOptions = new int[5][3];
   
		System.out.println("Here are the ranks you can get: ");
		int accumulater = 0;
      for (int i = 0; i < upgradeInfo.length; i++) {
			if (rank < upgradeInfo[i][0]) {
 				if (credits >= upgradeInfo[i][2]) {
					System.out.println("\tRank: " + upgradeInfo[i][0] + " with " + upgradeInfo[i][2] + " credits.");
					upgradeOptions[accumulater][0] = upgradeInfo[i][0];
					upgradeOptions[accumulater][2] = upgradeInfo[i][2];
					upgradeOptions[accumulater][1] = 0;
					accumulater++;
               upgradeSize++;
				}
				if (dollars >= upgradeInfo[i][1]) {
				System.out.println("\tRank: " + upgradeInfo[i][0] + " with " + upgradeInfo[i][1] + " dollars.");
					upgradeOptions[accumulater][0] = upgradeInfo[i][0];
					upgradeOptions[accumulater][2] = 0;
					upgradeOptions[accumulater][1] = upgradeInfo[i][1];
					accumulater++;
               upgradeSize++;
				}
			}
		}

		// takes in user input and keeps looping until integer value is given
		Scanner reader = new Scanner(System.in);
	 
		int response = 99;
		boolean loop = true;
	
		while (loop) {
		try {
				System.out.println("Enter a number for the purchase you'd like to make \n (Ranging from 1 to however many purchasable rank options there are.) \n Input 0 to decline. ");
	 			response = reader.nextInt();
				loop = false;
				if ((response > upgradeSize) || (response < 0)) {
					loop = true;
					System.out.println("Invalid value! not a number");
				}
            else if (response == 0) {
               loop = false;
               System.out.println("You've chosen to cancel the upgrade.");
            }
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid value! not a number");
				reader.next(); // this consumes the invalid token
			}
		}

		if (response != 0) {
			int newRank = upgradeOptions[response - 1][0];
			int newCredits = -upgradeOptions[response - 1][2];
			int newDollars = -upgradeOptions[response - 1][1];
			actor.changeRank(newRank);
			actor.changeCredits(newCredits);
			actor.changeDollars(newDollars);
         System.out.println("You are now at rank " + newRank + ". You have " + actor.getCredits() + " credits and " + actor.getDollars() + " dollars.");
		}
		else {
			System.out.println("You chose to cancel. Your rank has not been upgraded.");
		}

	return;

	}                  
}      
