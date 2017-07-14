package net.processing;/* Program: Deadwood.java
 * Class: Actor.java
 * Authors: Marshall Powell, Ryan Wendling, Dalainee Viernes
 * Purpose: implement the Actor objects for the individual players
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Actor {
    private int rank = 1;
    private int credits = 0;
    private int dollars = 0;
    private int rehearsals;
    private Role currentRole = null;
    private Room currentRoom;
    private CastingOffice office;
    private String name;
    private Dice dice = new Dice();
    Scanner reader = new Scanner(System.in);

    public Actor(Room trailer, CastingOffice office, String name) {
        this.currentRoom = trailer;
        this.office = office;
        this.name = name;
    }

    public int getRank() {
        return this.rank;
    }

    public int getCredits() {
        return this.credits;
    }

    public int getDollars() {
        return this.dollars;
    }

    public Role getRole() {
        return this.currentRole;
    }

    public String getName() {
        return this.name;
    }

    public Room getRoom() {
        return this.currentRoom;
    }

    public void changeRank(int newRank) {
        this.rank = newRank;
    }

    public void changeCredits(int newCredits) {
        this.credits += newCredits;
    }

    public void changeDollars(int newDollars) {
        this.dollars += newDollars;
    }

    public void resetRehearsals() {
        this.rehearsals = 0;
    }

    public void removeRole() {
        this.currentRole = null;
    }

    public void resetRoom(Room room) {
        this.currentRoom = room;
    }

    public void upgrade() {
        this.office.checkEligibility(this.rank, this.credits, this.dollars, this);
    }

    public void move() {
        Room[] adjRooms = this.currentRoom.getAdjRooms();
        System.out.println("You've chosen to move rooms. Here are the rooms possible for you to move to:");
        System.out.println("\t(To cancel, enter 0)");
        int printCount = 1;
        for (Room room : adjRooms) {
            System.out.println("\t" + printCount + ": " + room.getTitle());
            if (room.getTitle() != "Trailer" ^ room.getTitle() == "Casting Office") {
                System.out.println("\t\tNumber of shots left: " + room.getShots());
                System.out.println("\t\tScene budget: " + room.getScene().getBudget());
            }
            ++printCount;
        }
        int choice = 99;
        boolean loop = true;
        while (loop) {
            try {
                choice = this.reader.nextInt();
                if (choice < printCount && choice >= 0) {
                    loop = false;
                    continue;
                }
                System.out.println("Your input was not valid. Please try again.");
            }
            catch (InputMismatchException e) {
                System.out.println("Your input was not a valid integer. Please try again.");
                this.reader.next();
            }
        }
        if (choice != 0) {
            this.currentRoom = adjRooms[--choice];
            System.out.println("You've chosen to move to the room " + this.currentRoom.getTitle());
            if (!this.currentRoom.ifEnded()) {
                if (this.currentRoom.getTitle() != "Trailer" ^ this.currentRoom.getTitle() == "Casting Office") {
                    System.out.println("You now have the option to take a role in this room. Would you like to take a role?");
                    System.out.println("\t0: Yes");
                    System.out.println("\t1: No");
                    int response = 99;
                    loop = true;
                    while (loop) {
                        try {
                            response = this.reader.nextInt();
                            if (response == 0 ^ response == 1) {
                                loop = false;
                                continue;
                            }
                            System.out.println("Your input was not valid. Please try agian.");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Your input was not a valid integer. Please try again.");
                            this.reader.next();
                        }
                    }
                    if (response == 0) {
                        System.out.println("You have chosen to take a role.");
                        this.takeRole();
                    } else {
                        System.out.println("You have chosen not to take a role.");
                    }
                }
            } else {
                System.out.println("This room has already been ended.");
            }
        }
    }

    public void takeRole() {
        if (!(this.currentRoom.getTitle() == "Trailer" ^ this.currentRoom.getTitle() == "Casting Office")) {
            int numSceneRoles;
            ArrayList<Role> roomRoles = new ArrayList<Role>(Arrays.asList(this.currentRoom.getRoles()));
            ArrayList<Role> sceneRoles = new ArrayList<Role>(Arrays.asList(this.currentRoom.getScene().getRoles()));
            Iterator<Role> roomItr = roomRoles.iterator();
            while (roomItr.hasNext()) {
                Role current = roomItr.next();
                if (!(this.rank < current.getRank() ^ current.ifTaken())) continue;
                roomItr.remove();
            }
            Iterator<Role> sceneItr = sceneRoles.iterator();
            while (sceneItr.hasNext()) {
                Role current = sceneItr.next();
                if (!(this.rank < current.getRank() ^ current.ifTaken())) continue;
                sceneItr.remove();
            }
            int numRoomRoles = roomRoles.size();
            if (numRoomRoles + (numSceneRoles = sceneRoles.size()) > 0) {
                System.out.println("You may now take a role. Here are your possible roles:");
                int printCount = 1;
                System.out.println("\t(To cancel, enter 0)");
                if (numRoomRoles > 0) {
                    System.out.println("\tRoom roles: ");
                    for (Role possibleRole : roomRoles) {
                        System.out.println("\t\t" + printCount + ": " + possibleRole.getTitle());
                        System.out.println("\t\t\tQuote:  " + possibleRole.getQuote());
                        System.out.println("\t\t\t Rank: " + possibleRole.getRank());
                        ++printCount;
                    }
                }
                if (numSceneRoles > 0) {
                    Scene currentScene = this.currentRoom.getScene();
                    System.out.println("\tScene: " + currentScene.getTitle());
                    System.out.println("\tDescription: " + currentScene.getDescription());
                    System.out.println("\tBudget: " + currentScene.getBudget());
                    System.out.println("\tRoles: ");
                    for (Role possibleRole : sceneRoles) {
                        System.out.println("\t\t" + printCount + ": " + possibleRole.getTitle());
                        System.out.println("\t\t\tQuote: " + possibleRole.getQuote());
                        System.out.println("\t\t\tRank: " + possibleRole.getRank());
                        ++printCount;
                    }
                }
                int choice = 99;
                boolean loop = true;
                while (loop) {
                    try {
                        choice = this.reader.nextInt();
                        if (choice < printCount && choice >= 0) {
                            loop = false;
                            continue;
                        }
                        System.out.println("Your input was not valid. Please try again.");
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Your input was not a valid integer. Please try again.");
                        this.reader.next();
                    }
                }
                if (choice != 0) {
                    this.currentRole = --choice > numRoomRoles - 1 ? sceneRoles.get(choice -= numRoomRoles) : roomRoles.get(choice);
                    this.currentRole.takeRole();
                    this.currentRoom.addActor(this);
                    System.out.println("You have taken the role " + this.currentRole.getTitle());
                } else {
                    System.out.println("You have decided not to take a role.");
                }
            } else {
                System.out.println("I'm sorry, there are no possible roles left in this room.");
            }
            return;
        }
    }

    public void rehearse() {
        ++this.rehearsals;
        System.out.println("You've chosen to rehearse. You now have " + this.rehearsals + " in the role " + this.currentRole.getTitle());
    }

    public void act() {
        Scene currentScene = this.currentRoom.getScene();
        System.out.println("Your current room is " + this.currentRoom.getTitle() + " which currently has the scene " + currentScene.getTitle() + ", which has a budget of " + currentScene.getBudget() + ".");
        int diceRoll = Dice.roll();
        System.out.println("You rolled the dice. Your roll was " + diceRoll);
        if (diceRoll + this.rehearsals < this.currentRoom.getScene().getBudget()) {
            System.out.println("Your acting was unsuccessful. You do not get to take a shot.");
            if (this.currentRole.ifMain()) {
                System.out.println("You are a main actor, so nothing happens.");
            } else {
                ++this.dollars;
                System.out.println("You are an extra, however, so you get a dollar. You now have " + this.dollars + " dollars.");
            }
        } else {
            System.out.println("Your acting was successful! You get to take a shot.");
            if (this.currentRole.ifMain()) {
                this.credits += 2;
                System.out.println("You are a main actor, so you got two credits. You now have " + this.credits + " credits.");
            } else {
                ++this.credits;
                ++this.dollars;
                System.out.println("You are an extra, so you get one credit and one dollar. You now have " + this.credits + " credits and " + this.dollars + " dollars.");
            }
            this.currentRoom.updateShots();
        }
    }

    public void takeAMove() {
        System.out.println("Would you like to upgrade your rank?");
        System.out.println("\t0: Yes");
        System.out.println("\t1: No");
        int choice = 99;
        boolean loop = true;
        while (loop) {
            try {
                choice = this.reader.nextInt();
                if (choice == 0 ^ choice == 1) {
                    loop = false;
                    continue;
                }
                System.out.println("Your input was not valid. Please try again.");
            }
            catch (InputMismatchException e) {
                System.out.println("Your input was not a valid integer. Please try again.");
                this.reader.next();
            }
        }
        if (choice == 0) {
            System.out.println("You have chosen to upgrade.");
            this.upgrade();
        } else {
            System.out.println("You have chosen not to upgrade.");
        }
        if (this.currentRole == null) {
            if (this.currentRoom.ifEnded()) {
                System.out.println("Your room has ended.");
                this.move();
            } else {
                if (this.currentRoom.getTitle() != "Trailer" ^ this.currentRoom.getTitle() == "Casting Office") {
                    System.out.println("Your current room " + this.currentRoom.getTitle() + " has not ended. Would you like to take a role in this room?");
                    System.out.println("\t0: Yes");
                    System.out.println("\t1: No");
                    int response = 99;
                    loop = true;
                    while (loop) {
                        try {
                            response = this.reader.nextInt();
                            if (response == 0 ^ response == 1) {
                                loop = false;
                                continue;
                            }
                            System.out.println("Your input was not valid. Please try agian.");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Your input was not a valid integer. Please try again.");
                            this.reader.next();
                        }
                    }
                    if (response == 0) {
                        this.takeRole();
                    }
                }
                if (this.currentRole == null) {
                    System.out.println("Would you like to move?");
                    System.out.println("\t0: Yes");
                    System.out.println("\t1: No");
                    int answer = 99;
                    loop = true;
                    while (loop) {
                        try {
                            answer = this.reader.nextInt();
                            if (answer == 0 ^ answer == 1) {
                                loop = false;
                                continue;
                            }
                            System.out.println("Your input was not valid. Please try agian.");
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Your input was not a valid integer. Please try again.");
                            this.reader.next();
                        }
                    }
                    if (answer == 0) {
                        this.move();
                    }
                }
            }
        } else if (!(this.currentRoom.getTitle() == "Trailer" ^ this.currentRoom.getTitle() == "Casting Office")) {
            if (this.rehearsals < this.currentRoom.getScene().getBudget()) {
                System.out.println("Would you like to act or rehearse?");
                System.out.println("\t0: Act");
                System.out.println("\t1: Rehearse");
                int input = 99;
                loop = true;
                while (loop) {
                    try {
                        input = this.reader.nextInt();
                        if (input == 0 ^ input == 1) {
                            loop = false;
                            continue;
                        }
                        System.out.println("Your input was not valid. Please try again.");
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Your input was not a valid integer. Please try again.");
                        this.reader.next();
                    }
                }
                if (input == 0) {
                    this.act();
                } else {
                    this.rehearse();
                }
            } else {
                System.out.println("You have rehearsed enough. Time to act.");
                this.act();
            }
        }
        System.out.println("Would you like to upgrade your rank now?");
        System.out.println("\t0: Yes");
        System.out.println("\t1: No");
        int reply = 99;
        loop = true;
        while (loop) {
            try {
                reply = this.reader.nextInt();
                if (reply == 0 ^ reply == 1) {
                    loop = false;
                    continue;
                }
                System.out.println("Your input was not valid. Please try again.");
            }
            catch (InputMismatchException e) {
                System.out.println("Your input was not a valid integer. Please try again.");
                this.reader.next();
            }
        }
        if (reply == 0) {
            this.upgrade();
        } else {
            System.out.println("You have chosen not to upgrade.");
        }
    }
}