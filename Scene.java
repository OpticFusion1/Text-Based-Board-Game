/* Program: Deadwood.java
 * Class: Scene.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 */

package net.processing;

import java.lang.*;

public class Scene {

	// private data
	private Role[] roles;
	private int budget;
	private String sceneName;
	private String description; 
	private SceneLibrary sceneLibrary;
	private int sceneNumber;


   // constructor method
	public Scene(int budget, Role[]roles, String sceneName, String description, SceneLibrary sceneLibrary, int sceneNumber) {
		this.sceneName = sceneName;
	 	this.budget = budget;
		this.roles = roles;
		this.description = description;
		this.sceneLibrary = sceneLibrary;
	}
   
   

	// getter methods
	public Role[] getRoles() {
		return roles; 
	}

	public String getTitle() {
		return sceneName;
	}
 
	public int getSceneNumber() {
		return sceneNumber;      
	}
      
	public String getDescription() {
		return description;                        
	}

	public int getBudget() {
		return budget;
	}

	/* Method: endScene()
    * Purpose: end a scene
    * Return: void
    * Technique: remove the scene from the ArrayList of scenes
    */  
	public void endScene() {
		this.sceneLibrary.removeScene(sceneNumber); 
		return;
	}
	
}
