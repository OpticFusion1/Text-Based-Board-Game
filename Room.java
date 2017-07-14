/* Program: Deadwood.java
 * Class: Room.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: Implement the Rooms that make up the Deadwood Board
 */

package net.processing;

import java.util.*;
import java.lang.*;


public class Room {
	
	// private data: requires getter methods to inform outside classes if needed (to reduce coupling)
	private Scene currentScene;
	private Role[] roles;
	private ArrayList<Actor> currentActors = new ArrayList<Actor>();
	private Room[] adjRooms;
	private Board board;
	private String name;
	private int shots;
	private int  currentShots;
	private boolean ended = false;
	
	// creates Dice object for Room objects
	private Dice dice = new Dice();


	
	// constructor method

	/* Method: Room(int, Role[], Scene) 
	 * Purpose: constructor method for Room; initializes shots and currentShots, array of Roles in Room, and currentScene of Room
	 * Return: void
	 * Technique: initializes local variables with given parameters
	 */
	public  Room(int shots, Role[] roles, Scene scene, String name, Board board){
		this.shots = shots;
		this.currentShots = shots;
		this.roles = roles;
		this.currentScene = scene;
		this.name = name;
		this.board = board;
		return;
	}



	
	// getter methods: typical getter methods for private data
	
	public Scene getScene(){
		return this.currentScene;
	}
	
	public Role[] getRoles() {
		return this.roles;
	}

	public ArrayList<Actor> getActors() {
		return this.currentActors;
	}

	public Room[] getAdjRooms() {
		return this.adjRooms;
	}
	
	public int getShots() {
		return this.currentShots;
	}

	public boolean ifEnded() {
		return this.ended;
	}
	
	public String getTitle() {
		return this.name;
	}
	

	// setter methods

	/* Method: setAdjRooms(Room[]) 
	 * Purpose: initializes Room array adjRooms; would be a part of the constructor, but all Rooms have to be
		    constructed before the arrays are created
	 * Return: void
	 * Technique: initializes adjRooms
	 */
	public void setAdjacentRooms(Room[] rooms){
		this.adjRooms = rooms;
		return;
	}




	// other methods
	
	/* Method: updateShots
	 * Purpose: "takes" shots when an Actor successfully acts; checks to see if Room is ended, then calls endRoom
	 * Return: 
	 * Technique:  
	 */
	public void  updateShots(){
		this.currentShots = currentShots-1;
		if (currentShots<1) {
         System.out.println("You took the last shot. The room " + this.name + " has ended.");
			this.endRoom();
		}
		return;
	}

	/* Method: addActor(Actor)
	 * Purpose: add an Actor to the Room 
	 * Return: void
	 * Technique: use ArrayList add method to add Actor to currentActors
	 */
	public void addActor(Actor actor) {
		this.currentActors.add(actor);
		return;
	}

	/* Method: removeActors()
	 * Purpose: remove all Actors from the Room
	 * Return: void
	 * Technique: use ArrayList clear method to remove all Actors in currentActors
	 */
	public void removeActors(){
		this.currentActors.clear();
		return;
	}

	/* Method: endRoom()
	 * Purpose: end the Room when all shots have been taken
	 * Return: void
	 * Technique: doles out bonuses if there was a main Actor, removes all Actors
    *            from their Role, removes all Actors from the currentActor array,
    *            then ends the scene and ends the room
	 */
	public void endRoom() {
		
		// determines whether there is a main actor in the Room
		ended = true;
		Role[] temp =  this.currentScene.getRoles();
      int bound = temp.length;
		boolean bonus = false;
		for ( int i=0; i<bound; i++) {
			if (temp[i].ifTaken()) {
				bonus = true;
			}
		}

		// doles out bonus if there is a main actor in the Room
		if (bonus) {

			System.out.println("There was at least one main actor in the room. Bonus money will now be given.");

			/* Finds all extra actors, gives them their bonus based on their Role's rank,
			 * removes them from their Role and removes them from currentActors in the Room
			 */
			Iterator<Actor> itr = currentActors.iterator();
			while (itr.hasNext()) {
				Actor current = itr.next();
				if (!current.getRole().ifMain()){
					int rank = current.getRole().getRank();
					System.out.println("The actor " + current.getName() + " had an extra role with rank " + rank + " so they will get " + rank + " dollars.");
					current.changeDollars(rank);
					System.out.println("They now have " + current.getDollars() + " dollars.");
					current.resetRehearsals();
					current.getRole().leaveRole();
					current.removeRole();
					itr.remove();
				}
			}

			// Sorts updated (main Role only) currentActor array by the rank of their role
			Collections.sort(currentActors, new Comparator<Actor>() {
				public int compare (Actor one, Actor two){
					int comp = one.getRole().getRank() - two.getRole().getRank();
					return comp;
				}
			});

			// Creates array of dice rolls based on the budget of the scene, sorts them
			int numDiceRolls = this.currentScene.getBudget();
			System.out.println("The scene had a budget of " + numDiceRolls + ". " + numDiceRolls + " die will now be rolled.");
			List<Integer> rolledDice = new ArrayList<>();
         for (int i=0; i<numDiceRolls; i++) {
				rolledDice.add(this.dice.roll());
			}
			System.out.println("The die rolled were " + Arrays.toString(rolledDice.toArray()));
			Collections.sort(rolledDice, Collections.reverseOrder());
			
			
			// Doles out bonus money to main actors based on rolls
			int count = 0;
         int numRoles = this.currentScene.getRoles().length;
			while (count<numDiceRolls) {
				for ( int i = 0; i<numRoles; i++ ) {
					if (count<numDiceRolls) {
                  try{
                     Actor current = currentActors.get(numRoles-(i+1));
   						System.out.println("Main actor " + current.getName() + " had a role with rank " + current.getRole().getRank() + ", so they get " + rolledDice.get(count) + " dollars.");
   						current.changeDollars(rolledDice.get(count));
   						System.out.println("They now have " + current.getDollars() + " dollars.");
   					   count++;
                  }catch(IndexOutOfBoundsException e){
                     count++;
                  }
               }
				}
			}
		}
		
		// Removes all Actors from their Role
		for (Actor current : currentActors) {
			current.removeRole();
			current.resetRehearsals();
		}
		
		// Clears all Actors from Room
		this.removeActors();

		// Actually ends Room
		this.ended = true;
		this.currentScene.endScene();
		this.board.updateNumRooms();
		return;
	}
	
	/* Method: resetRoom(Scene) 
	 * Purpose: resetRoom method for Board at the end of a day
	 * Return: void
	 * Technique: reset shots, place new Scene on Room
	 */
	public void resetRoom(Scene scene) {
      this.removeActors();
		this.currentShots = this.shots;
		this.ended = false;
		this.currentScene = scene;
      for ( Role role : this.roles ) {
         role.leaveRole();
      }
		return;
	}
}
