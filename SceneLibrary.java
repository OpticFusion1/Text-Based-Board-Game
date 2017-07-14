/* Program: Deadwood.java
 * Class: SceneLibrary.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: Maintains active scenes and returns random scenes
 */

package net.processing;

import java.util.*;

public class SceneLibrary {
   
   
   // private data
   private static ArrayList<Scene> scenes = new ArrayList<Scene>();
   
   // constructor
   public SceneLibrary() {
      	
   	Role[] thisRoleSet3 = new Role[3];
   	Role[] thisRoleSet2 = new Role[2];
   	Role[] thisRoleSet1 = new Role[1];
   	
   	Role role1 = new Role(1, true, "Angry Barber", "Hold him still");
   	Role role2 = new Role(3, true, "Woman With Board",	"Nonsense Frank");
   	Role role3 = new Role(5, true, "Man On Fire", "It Burns!");	 
   	thisRoleSet3 =	new Role[]{role1,	role2, role3};	  
   	Scene	scene1 =	new Scene( 3, thisRoleSet3, "Down In The Valley", "A tripped waiter is the spark igniting a brawl of cataclysmic proportions. Walter is injured in the neck.",	this,	30);
   	
   	Role role4 = new Role(1, true, "Rug Merchant", "Don't leave my store!");
   	Role role5 = new Role(2, true, "banker", "Trust me");
   	Role role6 = new Role(5, true, "Talking Mule", "Nice Work, Johnny");	 
   	thisRoleSet3 =	new Role[]{role4,	role5, role6};	  
   	Scene	scene2 =	new Scene( 3, thisRoleSet3, "Law and the Old West", "Charlie \"Three Guns\" Henderson cooperates with Johnny Law and reluctantly enters the witless protection program.", this, 27);
   	
   	Role role7 = new Role(1, true, "Falls From Tree", "What Ho!");
   	Role role8 = new Role(3, true, "Laughing Woman", "Tis to Laugh!");
   	Role role9 = new Role(4, true, "Man With Whistle",	"Tweeeeet");  
   	thisRoleSet3 =	new Role[]{role7,	role8, role9};	  
   	Scene	scene3 =	new Scene( 3, thisRoleSet3, "Shakespeare In Lubbock",	"William decides that it is the time to be movin' on. Julia convinces him to stick around just long enough to get into big trouble.", this, 29);
   	
   	Role role10	= new	Role(4, true, "Ex-convict", "Never Again!");
   	Role role11	= new	Role(6, true, "Man with Onion", "Fresh Onions!"); 
   	thisRoleSet2 =	new Role[]{role10, role11};	
   	Scene	scene4 =	new Scene( 3, thisRoleSet2, "Go West, You!",	"Susan and Peter encounter some of the perils of the Badlands: rutted mud roads, torrential rain storms, and a bad case of \"grumble tummy\"", this, 34);
   
   	Role role12	= new	Role(2, true, "Fraternity Pledge", "Beer Me!");
   	Role role13	= new	Role(6, true, "Man with Sword", "None Shall Pass!"); 
   	thisRoleSet2 =	new Role[]{role12, role13};	
   	Scene	scene5 =	new Scene( 3, thisRoleSet2, "Breakin' in Trick Ponies", "Uncle Stewart reveals what to do when all else fails.", this, 25);
   	
   	Role role14	= new	Role(2, true, "Willard", "Ain't that a sight?");
   	Role role15	= new	Role(3, true, "Leprechaun", "Begorrah!");
   	Role role16	= new	Role(5, true, "Startled Ox", "Mrr?");	
   	thisRoleSet3 =	new Role[]{role14, role15,	role16};	  
   	Scene	scene6 =	new Scene( 5, thisRoleSet3, "My Years on the Prarie",	"Loiuse takes the instruction from Henry, the neighbor boy, in an abusrdly suggestive explanation of how to plow a field.", this, 33);
   	
   	Role role17	= new	Role(1, true, "Thrifty Mike",	"call!");
   	Role role18	= new	Role(3, true, "Sober Physician",	"Raise!");
   	Role role19	= new	Role(5, true, "Man on Floor",	"Fold!");  
   	thisRoleSet3 =	new Role[]{role17, role18,	role19};	  
   	Scene	scene7 =	new Scene( 6, thisRoleSet3, "Swing 'Em Wide", "Black Jack invites Dixon and The Captain to a late-night poker game. Little do they know that Gertrude and Isabella await them at the table.", this, 26);
   	
   	Role role20	= new	Role(3, true, "Drunk", "Where's Willard?");
   	Role role21	= new	Role(4, true, "Librarian",	"Shhhh!");
   	Role role22	= new	Role(6, true, "Man With Hay",	"Hey!");	 
   	thisRoleSet3 =	new Role[]{role20, role21,	role22};	  
   	Scene	scene8 =	new Scene( 5, thisRoleSet3, "My Years on the Prarie",	"Virgil and Stacy set out at midnight to track down the stray cows, unaware that they are being pursued by inch-high aliens from outer space.",	this,	36);
    
   	Role role23	= new	Role(3, true, "Bewisker'd cowpoke",	"Oh, sweet Lord!");
   	Role role24	= new	Role(5, true, "Dog",	"Wurf!"); 
   	thisRoleSet2 =	new Role[]{role23, role24};	
   	Scene	scene9 =	new Scene( 2, thisRoleSet2, "Picante Sauce Commercial", "A dozen grizzled cowboys surround a fire. Suddenly, they exclaim, \"That’s not mayonnaise!\"", this, 1);
   	
   	Role role25	= new	Role(2, true, "Cow",	"Moo.");
   	Role role26	= new	Role(3, true, "St. Clement of Alexandria", "Peace be with you, Child");
   	Role role27	= new	Role(4, true, "Josie", "Yikes!");  
   	thisRoleSet3 =	new Role[]{role25, role26,	role27};	  
   	Scene	scene10 = new Scene(	4,	thisRoleSet3, "How they get Milk", "Josie asks the Milkman how they get milk. After a thoughtful pause, he begins. \"Not like you’d expect!\"",	this,	2);
   	
   	Role role28	= new	Role(3, true, "Curious Girl",	"Are you sure?");
   	Role role29	= new	Role(4, true, "Ghost of Plato", "It happened to me!"); 
   	thisRoleSet2 =	new Role[]{role28, role29};	
   	Scene	scene11 = new Scene(	2,	thisRoleSet2, "Taffy Commercial", "Jackson encourages the children to eat taffy, because gum can kill them stone dead.", this, 3);
   	
   	Role role30	= new	Role(2, true, "Surprised Bison",	"Mmrrrrrph");
   	Role role31	= new	Role(5, true, "Man With Horn", "Ta Daaaa"); 
   	thisRoleSet2 =	new Role[]{role30, role31};	
   	Scene	scene12 = new Scene(	2,	thisRoleSet2, "Gun Commercial", "Inspector Pete speaks to a riveted audience about the many hidden dangers of taffy, not the least of which is that taffy can kill you stone dead.", this, 4);	 
   	
   	Role role32	= new	Role(2, true, "Buring Man", "Make it Stop!");
   	Role role33	= new	Role(4, true, "Cheese Vendor", "Opa!");
   	Role role34	= new	Role(5, true, "Hit with table", "Ow! A table?");  
   	thisRoleSet3 =	new Role[]{role32, role33,	role34};	  
   	Scene	scene13 = new Scene(	4,	thisRoleSet3, "Trials of the First Pioneers", "A fire breaks out in the town library. Before long, the surrounding buildings are engulfed in flame. The world falls into chaos.", this, 5);	
   		
   	Role role35	= new	Role(2, true, "Piano Player",	"It's a nocturne!");
   	Role role36	= new	Role(3, true, "Man in Turban", "My Stars!");
   	Role role37	= new	Role(4, true, "Falls on Hoe",	"Ow!");	
   	thisRoleSet3 =	new Role[]{role35, role36,	role37};	  
   	Scene	scene14 = new Scene(	5,	thisRoleSet3, "Disaster at Flying J", "After the mine explosion, the traveling circus takes time out to get drunk and start a fight.",	this,	6);
   	
   	Role role38	= new	Role(2, true, "Defrocked Priest", "Lookout Below!");
   	Role role39	= new	Role(3, true, "Marshall Canfield", "Hold Fast!");
   	Role role40	= new	Role(4, true, "One-Eyed Man",	"Balderdash!");  
   	thisRoleSet3 =	new Role[]{role38, role39,	role40};	  
   	Scene	scene15 = new Scene(	4,	thisRoleSet3, "Evil Wears a Hat", "Calhoun is separated from the group during a white-knuckle chase near Desperation Bluff.",	this,	7);
   	
   	Role role41	= new	Role(2, true, "Shot in Back",	"Arggh!");
   	Role role42	= new	Role(4, true, "Shot in Leg", "Ooh, Lordy!");
   	Role role43	= new	Role(5, true, "Leaps into cake",	"Dangit, Jesse!");  
   	thisRoleSet3 =	new Role[]{role41, role42,	role43};	  
   	Scene	scene16 = new Scene(	5,	thisRoleSet3, "Jesse James: Man of Action", "Jesse’s brothers Jed and Henry throw him a surprise birthday party. Jesse’s nerves get the better of him when the birthday cake explodes.", this, 8);
   	
   	Role role44	= new	Role(4, true, "Marksman", "Pull");
   	Role role45	= new	Role(5, true, "Postal Worker", "It's about time!");
   	Role role46	= new	Role(6, true, "A Horse", "Yes Sir!");	
   	thisRoleSet3 =	new Role[]{role44, role45,	role46};	  
   	Scene	scene17 = new Scene(	4,	thisRoleSet3, "How They get Milk", "Josie is thoroughly off milk at this point. The Milkman shows her one more way that she might not have heard of before.", this, 9);
   	
   	Role role47	= new	Role(3, true, "Detective",	"I have a hunch.");
   	Role role48	= new	Role(4, true, "File Clerk", "My Stapler!");
   	Role role49	= new	Role(5, true, "Cindy Lou",	"Dear Lord!");	 
   	thisRoleSet3 =	new Role[]{role47, role48,	role49};	  
   	Scene	scene18 = new Scene(	5,	thisRoleSet3, "How the Grinch Stole Texas", "The doe-eyed citizens of El Paso gather together around a warm fire and pray for the safety of those poor souls in Oklahoma. It almost works.",	this,	10);
   	
   	Role role50	= new	Role(2, true, "Voice of God",	"Grab hold, son!");
   	Role role51	= new	Role(3, true, "hands of God",	"!");
   	Role role52	= new	Role(4, true, "Jack Kemp",	"America!");  
   	thisRoleSet3 =	new Role[]{role50, role51,	role52};	  
   	Scene	scene19 = new Scene(	4,	thisRoleSet3, "Davy Crockett: A Drunkard's tale", "In an absurd dream sequence, Crockett recalls an episode of fear and chaos in which his childhood friend Timmy was trapped at the bottom of a well.",	this,	11);
   
   	Role role53	= new	Role(5, true, "Film Critic", "Implausible!");
   	Role role54	= new	Role(6, true, "Hobo with Bat", "Nice house!"); 
   	thisRoleSet2 =	new Role[]{role53, role54};	
   	Scene	scene20 = new Scene(	6,	thisRoleSet2, "The Search for Maggie White",	"Alone in the wilderness, Maggie makes the best of her situation. In what seems like no time at all, she constructs a sturdy two-story house from branches and mud.", this, 12);
   	
   	Role role55	= new	Role(2, true, "Hollering Boy", "Over here, Mister!");
   	Role role56	= new	Role(3, true, "Drunk Farmer",	"Git outta me barn!");
   	Role role57	= new	Role(5, true, "Meek Litte Sarah", "he's so cute!");  
   	thisRoleSet3 =	new Role[]{role55, role56,	role57};	  
   	Scene	scene21 = new Scene(	4,	thisRoleSet3, "Buffalo Bill: The Lost Years", "Buffalo Bill’s companion Marty disappears in a freak electrical storm. Bill enlists the aid of the Sidekick Friends Network.",	this,	13);
   
   	Role role58	= new	Role(6, true, "Martin",	"Have you tried soy cheese?");
   	thisRoleSet1 =	new Role[]{role58};	 
   	Scene	scene22 = new Scene(	2,	thisRoleSet1, "Beyond the Pail: Life without Lactose", "Henry's life is in a crisis when he discovers he is lactose intolerant.", this, 14);
   								  
   	Role role59	= new	Role(1, true, "Man With Rope", "Look out below!");
   	Role role60	= new	Role(2, true, "Svetlana", "Says who?");
   	Role role61	= new	Role(5, true, "Accidental Victim", "ow, my spine!");	
   	thisRoleSet3 =	new Role[]{role59, role60,	role61};	  
   	Scene	scene23 = new Scene(	4,	thisRoleSet3, "J. Robert Lucky, man of Substance",	"Horace and Mathilde discover that the mysterious orange powder filling Doctor Lucky’s air vents is neither Agent Orange nor weaponized Tang, but a rare form of cheese mold.", this, 15); 
   	
   	Role role62	= new	Role(1, true, "Sleeping Man",	"Snnkkkk, snnkkk, snkkkk");
   	Role role63	= new	Role(3, true, "Man with Pig",	"tally-hoo!");
   	Role role64	= new	Role(5, true, "Shooter", "Where's my britches?");	
   	thisRoleSet3 =	new Role[]{role62, role63,	role64};	  
   	Scene	scene24 = new Scene(	4,	thisRoleSet3, "Ol' Shooter and Little Doll",	"Shooter discovers that he has been proceeding for days with no trousers. This causes him no small embarrassment as he searches for them with Little Doll.", this, 16);	 
     
   	Role role65	= new	Role(2, true, "Squeaking boy", "I'll say!");
   	Role role66	= new	Role(4, true, "Pharaoh Imhotep",	"Attack, soldiers!");
   	Role role67	= new	Role(6, true, "Aunt Martha", "You got nothin'!");	
   	thisRoleSet3 =	new Role[]{role65, role66,	role67};	  
   	Scene	scene25 = new Scene(	6,	thisRoleSet3, "Square Deal City", "Douglas and Katherine confront Aunt Martha about her missing pies. Devin sulks quietly in a side room.", this, 17);
   				 
   	Role role68	= new	Role(1, true, "Shot in Head",	"Argggh!");
   	Role role69	= new	Role(4, true, "Leaps out of cake", "Oh, for pete's sake!");
   	Role role70	= new	Role(6, true, "Shot Three Times", "Ow! Ow! Ow!");	
   	thisRoleSet3 =	new Role[]{role68, role69,	role70};	  
   	Scene	scene26 = new Scene(	5,	thisRoleSet3, "Jesse James: Man of Action", "A hail of gunfire results when Jesse’s friend Barton marries Jesse’s childhood sweetheart.",	this,	18);
   	
   	Role role71	= new	Role(1, true, "Man in Poncho", "Howdy, Jones!");
   	Role role72	= new	Role(3, true, "Ecstatic Housewife",	"This is fine!");
   	Role role73	= new	Role(5, true, "Isaac", "the mail!");  
   	thisRoleSet3 =	new Role[]{role71, role72,	role73};	  
   	Scene	scene27 = new Scene(	5,	thisRoleSet3, "Thirteen the Hard Way",	"After some delay, the Pony Express arrives. Isaac, Gwen, Francis, Terry, Conrad, Brooke, Jerry Howard, MacNeill, Jones, Spike, Cornwall and Crawford are all there.", this, 19);	
   
   	Role role74	= new	Role(2, true, "Staggering Man", "you never know!");
   	Role role75	= new	Role(3, true, "Woman with Beer",	"Howdy, stranger!");
   	Role role76	= new	Role(5, true, "Marcie",	"Welcome Home!");	 
   	thisRoleSet3 =	new Role[]{role74, role75,	role76};	  
   	Scene	scene28 = new Scene(	5,	thisRoleSet3, "the Life and Times of John Skywalker",	"John discovers his long-lost sister Marcie, and instructs her in the ways of gunfighting and whiskey distillation.", this, 20);	  
   	
   	Role role77	= new	Role(3, true, "Preacher", "My word!");
   	Role role78	= new	Role(6, true, "Amused Witness", "Tee hee hee!"); 
   	thisRoleSet2 =	new Role[]{role77, role78};	
   	Scene	scene29 = new Scene(	3,	thisRoleSet2, "A Man Called Cow", "Nothing will settle the debates among the skeptical locals, short of a demonstration of Hector’s special talents.", this, 21);
   	
   	Role role79	= new	Role(2, true, "Jailer",	"you there!");
   	Role role80	= new	Role(3, true, "Mephistopheles", "Be not afraid!");
   	Role role81	= new	Role(5, true, "Breaks a Window",	"Oops!");  
   	thisRoleSet3 =	new Role[]{role79, role80,	role81};	  
   	Scene	scene30 = new Scene(	5,	thisRoleSet3, "Humor at the Expense of Others",	"Phil and his cohort of unfeeling smart-mouths make fun of Sancho and his great big hat.", this, 22);
   	
   	Role role82	= new	Role(2, true, "Very Wet Man",	"Sheesh!");
   	Role role83	= new	Role(4, true, "Dejected HouseWife",	"It's time had come.");
   	Role role84	= new	Role(5, true, "Man with Box",	"Progress!");	
   	thisRoleSet3 =	new Role[]{role82, role83,	role84};	  
   	Scene	scene31 = new Scene(	5,	thisRoleSet3, "Thirteen the hard way",	"After operating for only six minutes, the Pony Express disbands and gives way to the international Telegraph and Railroad systems. Little boys cry.", this, 23);			 
   				
   	Role role85	= new	Role(1, true, "Buster",	"One two three, go!");
   	Role role86	= new	Role(4, true, "Dejected HouseWife",	"Ouchie!");
   	Role role87	= new	Role(5, true, "Fat Pete", "Nice kick, boss!");	
   	thisRoleSet3 =	new Role[]{role85, role86,	role87};	  
   	Scene	scene32 = new Scene(	4,	thisRoleSet3, "The Robbers of Trains",	"Coogan confronts the toughest thug in his gang, Big Jake, in an abbreviated knife fight. Coogan settles the dispute with fearless guile and a kick in the family jewels.", this, 24);		
   
   	Role role88	= new	Role(5, true, "Auctioneer", "Going once!");
   	Role role89	= new	Role(6, true, "General Custer", "Go west!");	
   	thisRoleSet2 =	new Role[]{role88, role89};	
   	Scene	scene33 = new Scene(	5,	thisRoleSet2, "The Life and Times of John Skywalker",	"Disheatened by his lack of business acumen and his poor choice of investment parters. John Skywalker sets off into the Cree Nation to convince them to kidnap his wife.",	this,	28);
    
   	Role role90	= new	Role(5, true, "Opice(Monkey)", "Ukk! (ook!)");
   	Role role91	= new	Role(6, true, "man with Gun",	"Hold it right there!"); 
   	thisRoleSet2 =	new Role[]{role90, role91};	
   	Scene	scene34 = new Scene(	4,	thisRoleSet2, "Czechs in the Sonora", "Bob reverts to his anscestral ways in a short fight over a disembodied hand.", this, 31);
   	
   	Role role92	= new	Role(4, true, "Looks like Elvis", "Thankouverymuch.");
   	Role role93	= new	Role(5, true, "Singning Dead Man", "Yeah!");
   	Role role94	= new	Role(6, true, "Apohtecary", "Such drugs I have.");	 
   	thisRoleSet3 =	new Role[]{role92, role93,	role94};	  
   	Scene	scene35 = new Scene(	6,	thisRoleSet3, "Gun! The Musical", "A song and dance extravaganza, \" Hunka Hunka burnin' Lead \"",	this,	32);	  
     
   	Role role95	= new	Role(4, true, "The Duck", "Waaaak!");
   	Role role96	= new	Role(6, true, "His Brother", "Waaaaaak!"); 
   	thisRoleSet2 =	new Role[]{role95, role96};	
   	Scene	scene36 = new Scene(	4,	thisRoleSet2, "Davy Crockett: A Drunkard's Tale", "Robert enlists the aid of several farm aniamsl in order to ascertain the efficacy of his new hangover remedy.", this, 35);
   	
   	Role role97	= new	Role(2, true, "Tower Drunk", "Even me!");
   	Role role98	= new	Role(4, true, "Squinting Miner",	"Sure we can!");
   	Role role99	= new	Role(5, true, "Poltergeist", "Woooo!");  
   	thisRoleSet3 =	new Role[]{role97, role98,	role99};	  
   	Scene	scene37 = new Scene(	4,	thisRoleSet3, "The Way The West Was Run",	"Jose expains patiently, but with thinly veiled contempt, the intricacies of Arizona bureaucracy, as though speaking to a simple and distracted child.",	this,	37); 
   	
   	Role role100 =	new Role(2,	true,	"Liberated Nun", "Let me have it!");
   	Role role101 =	new Role(4,	true,	"Witch Doctor", "oogie boogie!");
   	Role role102 =	new Role(5,	true,	"Voice of Reason", "Come on, Now!");  
   	thisRoleSet3 =	new Role[]{role100, role101, role102};	  
   	Scene	scene38 = new Scene(	6,	thisRoleSet3, "The Way The West Was Run",	"Hector makes a suprising discovery behind the Chinese grocery store.",	this,	38);
   	
   	Role role103 =	new Role(1,	true,	"Flustered Man", "Well, I never!");
   	Role role104 =	new Role(2,	true,	"Space monkey", "Ook!");
   	Role role105 =	new Role(5,	true,	"Cowbot Dan", "Bzzzzzzt!");  
   	thisRoleSet3 =	new Role[]{role103, role104, role105};	  
   	Scene	scene39 = new Scene(	6,	thisRoleSet3, "One False Step for Mankind", "After a dozen falied attempt,s one rocket carries horatio and his six children to the Moon, where they enjoy a picnic and a spirited game of badminton.", this, 39);
   	
   	Role role106 =	new Role(2,	true,	"Farmer", "Git off a that!");
   	Role role107 =	new Role(4,	true,	"exploding horse", "Boom!");
   	Role role108 =	new Role(6,	true,	"Jack", "Here we go again!");	 
   	thisRoleSet3 =	new Role[]{role100, role101, role102};	  
   	Scene	scene40 = new Scene(	6,	thisRoleSet3, "Custer's Other Stands",	"General George Armstrong Custer clinches another victory at the battle of Little Sands. His trusty steed Cairo is not so lucky.", this, 40);		  
   		 
   	scenes.add(scene1);
   	scenes.add(scene2);	
   	scenes.add(scene3);	
   	scenes.add(scene4);	
   	scenes.add(scene5);	
   	scenes.add(scene6);	
   	scenes.add(scene7);	
   	scenes.add(scene8);	
   	scenes.add(scene9);	
   	scenes.add(scene10);	 
   	scenes.add(scene11);	 
   	scenes.add(scene12);	 
   	scenes.add(scene13);	 
   	scenes.add(scene14);	 
   	scenes.add(scene15);	 
   	scenes.add(scene16);	 
   	scenes.add(scene17);	 
   	scenes.add(scene18);	 
   	scenes.add(scene19);	 
   	scenes.add(scene20);	 
   	scenes.add(scene21);	 
   	scenes.add(scene22);	 
   	scenes.add(scene23);	 
   	scenes.add(scene24);	 
   	scenes.add(scene25);	 
   	scenes.add(scene26);	 
   	scenes.add(scene27);
   	scenes.add(scene28);	 
   	scenes.add(scene29);	 
   	scenes.add(scene30);	 
   	scenes.add(scene31);	 
   	scenes.add(scene32);	 
   	scenes.add(scene33);	 
   	scenes.add(scene34);	 
   	scenes.add(scene35);	 
   	scenes.add(scene36);	 
   	scenes.add(scene37);	 
   	scenes.add(scene38);	 
   	scenes.add(scene39);	 
   	scenes.add(scene40);		
  
   }
   
   
   /* Method: roll()
    * Purpose: generates random number from 0 to size of scene array
    * Return: int
    * Technique: uses Random number generator
    */
   public static int roll(){
      Random rand = new Random();
      int n;
      n = rand.nextInt(scenes.size());
      return n;
   }
   
   /* Method: removeScene(int)
    * Purpose: removes specific scene from sceneArray
    * Return: void
    * Technique: uses iterator to find specific scene and remove it from sceneArray
    */
   public void removeScene(int sceneNumber) {
       Iterator<Scene> itr = this.scenes.iterator();
       boolean found = false;
       while (!found) {
           Scene current = itr.next();
           if (current.getSceneNumber() == sceneNumber) {
               itr.remove();
               found = true;
           }
       }
   }
 
 
   /* Method: getRandomScene()
    * Purpose: returns randomScene
    * Return: Scene
    * Technique: uses roll() to get random number within index bounds of array, returns
    *            Scene at that array
    */
   public Scene getRandomScene() {
      int randomSceneNumber = SceneLibrary.roll();
      Scene thisScene = scenes.get(randomSceneNumber); 
      return thisScene;
   }                 
}    
