/* Program: Deadwood.java
 * Class: Role.java
 * Authors: Marshal Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: Implement the Roles that make up the Rooms and Scenes
 */

package net.processing;

public class Role {

	// private data
	private int rank;
	private boolean main;
	private String title;
	private String quote;
	private boolean taken;
	
	// constructor method
	public Role(int rank, boolean main, String title, String quote) {
		this.rank = rank;
		this.main = main;
		this.title = title;
		this.quote = quote;
		this.taken = false;
		return;
	}

	// getter methods
	public int getRank() {
		return this.rank;
	}

	public boolean ifMain() {
		return this.main;
	}

	public String getTitle() {
		return this.title;
	}
	
	public String getQuote() {
		return this.quote;
	}

	public boolean ifTaken() {
		return this.taken;
	}

	// setter methods
	public void takeRole() {
		this.taken = true;
		return;
	}
	
	public void leaveRole() {
		this.taken = false;
		return;
	}
}
