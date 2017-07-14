/* Program: Deadwood.java
 * Class: Dice.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: Used by the Deadwood game that returns a random integer between 1 & 6  
 */

package net.processing;


import java.util.Random;

public class Dice{

   // random number generator function
	public static int roll(){
		Random rand = new Random();
		int n;
		n = rand.nextInt(6) + 1;
		return n;
	}

}
