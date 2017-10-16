# text-based-board-game
Working with a small group, created UML class/sequence diagrams and use cases to design and implement a text-based version of the Deadwood board game. This build used concepts such as association, aggregation, implementation and inheritance. 

To start the program: Start the Deadwood.java file and enter the number of players to get started!

* See "DesignAssignment.pdf" for detailed look into how the program operates!
* See http://cheapass.com/free-games/deadwood/ on detailed explanation on how this game is played!

How to play (quick summary): 
Try to get the highest score (money + credit + rank*5) during three to four rounds. Each player begins at the "trailer" location with a rank of 1. From there, every location on the map is given a randomized, face-down "scene" card. Players travel to these scenes, revealing them to all players as they go. When a player flips and sees the scene, they will see that the scene has both starring and extra "roles" that the player can partake in. A player can take a starring role if their rank is high enough for the particular role. Working these roles is how players earn money/credit. A player can use money/credit to upgrade their rank. Rolling a die determines your success while shooting for the role. Better paying roles = lower likelihood of a successful shoot. A player can spend a turn rehearsing to up their chances of successfully completing a shoot. When a scene has the right number of succesful shoots, the scene is closed and there is a bonus payout for all players that are involved. When all the scenes are over, save one, the round is over. Rinse repeat.





* Processing.java is for the GUI component of the game. It is not currently connected to the text-based version.
