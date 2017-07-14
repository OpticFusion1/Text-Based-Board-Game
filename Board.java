/* Program: Deadwood.java
 * Class: Board.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: The game board used in the game of Deadwood. 
 */

package net.processing;

public class Board{

   // private data
   private SceneLibrary sceneLibrary = new SceneLibrary();
   private static Room[] rooms = new Room[12];
   private boolean dayNotEnded=true;
   private int numRooms=12;
   private int currentNumRooms =numRooms-2;
     
   // protected data, rooms accessible to other classes
   Room mainStreet = new Room(3, mainStRoleArray(), sceneLibrary.getRandomScene(), "Main Street",this);
   Room saloon = new Room(2, saloonRoleArray(),  sceneLibrary.getRandomScene(), "Saloon",this);
   Room ranch = new Room(3, ranchRoleArray(),  sceneLibrary.getRandomScene(), "Ranch",this);
   Room secretHideout = new Room(3, secretHideoutRoleArray(),  sceneLibrary.getRandomScene(), "Secret Hideout",this);
   Room bank = new Room(1, bankRoleArray(),  sceneLibrary.getRandomScene(), "Bank",this);
   Room hotel = new Room(3, hotelRoleArray(),  sceneLibrary.getRandomScene(), "Hotel",this);
   Room church = new Room(2, churchRoleArray(),  sceneLibrary.getRandomScene(), "Church",this);
   Room jail = new Room(1, jailRoleArray(),  sceneLibrary.getRandomScene(), "Jail",this);
   Room trainStation = new Room(3, trainStationRoleArray(),  sceneLibrary.getRandomScene(), "Train Station",this);
   Room generalStore = new Room(2, generalStoreRoleArray(),  sceneLibrary.getRandomScene(),"General Store", this);    
   Room trailers = new Room(0, null,  null, "Trailer",this);   
   Room castingOffice = new Room(0, null,  null, "Casting Office",this);   
   
     
   // constructor method
   public Board(){
      rooms[0] = mainStreet;
      rooms[1] = saloon;
      rooms[2] = ranch;
      rooms[3] = secretHideout;
      rooms[4] = bank;
      rooms[5] = hotel;
      rooms[6] = church;
      rooms[7] = jail;
      rooms[8] = trainStation;
      rooms[9] = generalStore;
      rooms[10] = trailers; 
      rooms[11] = castingOffice;    
   }


   
   // extension of constructor, to set adjacent Rooms AFTER they've been constructed
   public void setAllAdjacentRooms(){
      Room[] ms = new Room[3];
      ms[0] = saloon;
      ms[1] = trailers;
      ms[2] = jail;
      mainStreet.setAdjacentRooms(ms);
      
      Room[] sal = new Room[4];
      sal[0] = mainStreet;
      sal[1] = castingOffice;
      sal[2] = bank;
      sal[3] = generalStore;
      saloon.setAdjacentRooms(sal);
      
      Room[] tlr = new Room[3];
      tlr[0] = mainStreet;
      tlr[1] = saloon;
      tlr[2] = hotel;
      trailers.setAdjacentRooms(tlr);
      
      Room[] cof = new Room[3];
      cof[0] = secretHideout;
      cof[1] = trainStation;
      cof[2] = ranch;
      castingOffice.setAdjacentRooms(cof);

      Room[] rch = new Room[4];
      rch[0] = secretHideout;
      rch[1] = castingOffice;
      rch[2] = bank;
      rch[3] = generalStore;
      ranch.setAdjacentRooms(rch);
   
      Room[] sec = new Room[3];
      sec[0] = ranch;
      sec[1] = castingOffice;
      sec[2] = church;
      secretHideout.setAdjacentRooms(sec);

      Room[] bnk = new Room[4];
      bnk[0] = ranch;
      bnk[1] = hotel;
      bnk[2] = church;
      bnk[3] = saloon;
      bank.setAdjacentRooms(bnk);
      
      Room[] chu = new Room[3];
      chu[0] = bank;
      chu[1] = hotel;
      chu[2] = secretHideout;
      
      church.setAdjacentRooms(chu);
     
      Room[] htl = new Room[3];
      htl[0] = trailers;
      htl[1] = bank;
      htl[2] = church;
      hotel.setAdjacentRooms(htl);
      
      Room[] jai = new Room[3];
      jai[0] = trainStation;
      jai[1] = generalStore;
      jai[2] = mainStreet;
      jail.setAdjacentRooms(jai);
      
      Room[] tst = new Room[3];
      tst[0] = castingOffice;
      tst[1] = generalStore;
      tst[2] = jail;
      trainStation.setAdjacentRooms(tst);
     
      Room[] gen = new Room[4];
      gen[0] = trainStation;
      gen[1] = jail;
      gen[2] = saloon;
      gen[3] = ranch;
      generalStore.setAdjacentRooms(gen);
     
      }
   
   
   // getter methods
   public int getCurrentNumRooms(){
      return currentNumRooms;
   }
   

   public boolean ifDayEnded() {
      return dayNotEnded;
   }

   
   
   // setter methods
   public void updateNumRooms(){
      currentNumRooms--;
      if(currentNumRooms == 1){
         dayNotEnded=false;
      }
   } 




   
   

 
   /**********************************************************************/

   /* Method: RoleArray()
    * Purpose: 10 functions that create all of the Role Arrays
    * Return: Role[]
    * Technique: create Roles, put them into an array, return that array
    */
   public Role[] mainStRoleArray(){  
      Role[] roleArray = new Role[4];
      
      Role r1= new Role(1, false, "Railroad Worker", "I'm a steel-drivin' man!");
      Role r2= new Role(2, false, "Falls off Roof", "Aaaaiiiiigggghh!");
      Role r3= new Role(2, false, "Woman in Black Dress", "Well, I'll be!");
      Role r4= new Role(4, false, "Mayor McGinty", "People of Deadwood!");  
      
      roleArray[0]= r1;
      roleArray[1]= r2;
      roleArray[2]= r3;
      roleArray[3]= r4;    
      
      return roleArray;       
   }
   
   public Role[] saloonRoleArray(){  
      Role[] roleArray = new Role[2];
      
      Role r1= new Role(2, false, "Woman in Red Dress", "Come up and see me!");
      Role r2= new Role(1, false, "Reluctant Farmer", "I ain't so sure about that!");  
      
      roleArray[0]= r1;
      roleArray[1]= r2;   
      
      return roleArray;       
   }
   
  	public Role[] ranchRoleArray(){	 
   	Role[] roleArray = new Role[3];
   	
   	Role r1=	new Role(3,	false, "Man Under Horse", "A little help here!");
   	Role r2=	new Role(1,	false, "Shot in Leg",	"Ow! Me Leg!");	
   	Role r3=	new Role(2,	false, "Saucy Fred",	"That's what she said!");
         	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  
   	roleArray[2]= r3;
      
   	return roleArray;	      
   }


  	public Role[] secretHideoutRoleArray(){	 
   	Role[] roleArray = new Role[4];
   	
   	Role r1=	new Role(1,	false, "Clumsy Pit Fighter", "Hit me!");
   	Role r2=	new Role(2,	false, "Thug with Knife",	"Meet Suzy, my murderin' knife.");	
   	Role r3=	new Role(3,	false, "Dangerous Tom",	"There's two ways we can do this....");
   	Role r4=	new Role(4,	false, "Penny, who is Lost",	"Oh, woe! For I am lost!");
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  
   	roleArray[2]= r3;
   	roleArray[3]= r4;      
   	return roleArray;	      
   }   
   
  	public Role[] bankRoleArray(){	 
   	Role[] roleArray = new Role[2];
   	
   	Role r1=	new Role(3,	false, "Flustered Teller", "Would you like a large bill, sir?");
   	Role r2=	new Role(2,	false, "Suspicious Gentleman",	"Can you be more specific?");	
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  

   	return roleArray;	      
   }   
   
  	public Role[] churchRoleArray(){	 
   	Role[] roleArray = new Role[2];
   	
   	Role r1=	new Role(1,	false, "Dead Man", "....");
   	Role r2=	new Role(2,	false, "Crying Woman",	"Oh, the humanity!");	
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  

   	return roleArray;	      
   }   
  
  	public Role[] hotelRoleArray(){	 
   	Role[] roleArray = new Role[4];
   	
   	Role r1=	new Role(1,	false, "Sleeping Drunkard", "Zzzzzz... Whiskey!");
   	Role r2=	new Role(1,	false, "Faro Player",	"Hit me!");	
   	Role r3=	new Role(2,	false, "Falls from Balcony",	"Arrrgghh!!");
   	Role r4=	new Role(3,	false, "Australian Bartender",	"What'll it be, mate?");
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  
   	roleArray[2]= r3;
   	roleArray[3]= r4;      
   	return roleArray;	      
   }   
   
   
   
  	public Role[] trainStationRoleArray(){	 
   	Role[] roleArray = new Role[4];
   	
   	Role r1=	new Role(1,	false, "Crusty Propector", "Aww, peaches!");
   	Role r2=	new Role(1,	false, "Dragged by Train",	"Omgeezers!");	
   	Role r3=	new Role(2,	false, "Preacher with Bag",	"The Lord will provide.");
   	Role r4=	new Role(4,	false, "Cyrus the Gunfighter",	"Git to fightin' or git away!");
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  
   	roleArray[2]= r3;
   	roleArray[3]= r4;      
   	return roleArray;	      
   }  
   
  	public Role[] jailRoleArray(){	 
   	Role[] roleArray = new Role[2];
   	
   	Role r1=	new Role(2,	false, "Prisoner in Cell", "Zzzzzzz... Whiskey!");
   	Role r2=	new Role(3,	false, "Feller in Irons",	"Ah kilt the wrong man!");	
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  

   	return roleArray;	      
   }  
   
  	public Role[] generalStoreRoleArray(){	 
   	Role[] roleArray = new Role[2];
   	
   	Role r1=	new Role(1,	false, "Man in Overalls", "Looks like a storm's comin' in.");
   	Role r2=	new Role(3,	false, "Mister Keach",	"Howdy, stranger.");	
               	
   	roleArray[0]= r1;
   	roleArray[1]= r2;	  

   	return roleArray;	      
   }     
   /***************************************************************/
   
   
   /* Method: resetBoard()
    * Purpose: resets the shot counts of the rooms and puts new scenes in rooms
    * Return: void
    * Technique: loops through rooms, reseting each room
    */
   public void resetBoard(){
      currentNumRooms = numRooms-2;
      dayNotEnded=true;
      for (int i=0; i<numRooms-2; i++){
         rooms[i].resetRoom(sceneLibrary.getRandomScene());
      }
   }









}
