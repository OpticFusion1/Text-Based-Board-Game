/* Program: Processing.java
 * Purpose: Main program to run for Processing GUI
 * Authors: Marshall Powell, Ryan Wendling, and Dalainee Viernes
 * About: Runs only front-end implementation. Includes ability to move two players around rooms and take shots
 *        To take a shot, click on the penny covering the shot. To move a player, click and drag their dice.
 *        When a player moves to a new room for the first time, the scene card will flip.
 *        To see an example of a player changing rank, click ALT or CTRL.
 *        To see an example of text-based input, type anything and hit ENTER. The input will be displayed below.
 */

package net.processing;

import processing.core.*;

public class Processing extends PApplet {

    // player dice placements
    public float bx;
    public float by;
    public float ax;
    public float ay;
    public int boxSize = 50;
    public boolean overBox = false;
    public boolean overBox2 = false;
    public boolean locked = false;
    public boolean locked2 = false;
    public float bxOffset = (float)0.0;
    public float byOffset = (float)0.0;
    public float axOffset = (float)0.0;
    public float ayOffset = (float)0.0;

    // scene card flip booleans and size
    public boolean jailScene = false;
    public boolean generalStoreScene = false;
    public boolean saloonScene = false;
    public boolean mainStreetScene = false;
    public boolean bankScene = false;
    public boolean churchScene = false;
    public boolean ranchScene = false;
    public boolean secretHideoutScene = false;
    public boolean trainScene = false;
    public boolean hotelScene = false;
    public int sceneXSize = 202;
    public int sceneYSize = 117;
    public int randomizer;
    public PImage jailImage;
    public PImage generalStoreImage;
    public PImage saloonImage;
    public PImage mainStreetImage;
    public PImage bankImage;
    public PImage churchImage;
    public PImage ranchImage;
    public PImage secretHideoutImage;
    public PImage trainImage;
    public PImage hotelImage;
    public boolean jailLocked = false;
    public boolean generalStoreLocked = false;
    public boolean saloonLocked = false;
    public boolean mainStreetLocked = false;
    public boolean bankLocked = false;
    public boolean churchLocked = false;
    public boolean ranchLocked = false;
    public boolean secretHideoutLocked = false;
    public boolean trainLocked = false;
    public boolean hotelLocked = false;


    // player values
    public int rank1 = 1;
    public int rank2 = 1;
    public int credits1 = 0;
    public int credits2 = 0;
    public int dollars1 = 0;
    public int dollars2 = 0;
    public int rehearsals1 = 0;
    public int rehearsals2 = 0;
    public String room1 = "";
    public String room2 = "";
    public boolean ranked1 = false;
    public boolean ranked2 = false;

    // board image
    public PImage bg;

    // shots image
    public PImage shot;

    // shot taken booleans
    public boolean shot1 = true;
    public boolean shot2 = true;
    public boolean shot3 = true;
    public boolean shot4 = true;
    public boolean shot5 = true;
    public boolean shot6 = true;
    public boolean shot7 = true;
    public boolean shot8 = true;
    public boolean shot9 = true;
    public boolean shot10 = true;
    public boolean shot11 = true;
    public boolean shot12 = true;
    public boolean shot13 = true;
    public boolean shot14 = true;
    public boolean shot15 = true;
    public boolean shot16 = true;
    public boolean shot17 = true;
    public boolean shot18 = true;
    public boolean shot19 = true;
    public boolean shot20 = true;
    public boolean shot21 = true;
    public boolean shot22 = true;
    public boolean overShot1 = false;
    public boolean overShot2 = false;
    public boolean overShot3 = false;
    public boolean overShot4 = false;
    public boolean overShot5 = false;
    public boolean overShot6 = false;
    public boolean overShot7 = false;
    public boolean overShot8 = false;
    public boolean overShot9 = false;
    public boolean overShot10 = false;
    public boolean overShot11 = false;
    public boolean overShot12 = false;
    public boolean overShot13 = false;
    public boolean overShot14 = false;
    public boolean overShot15 = false;
    public boolean overShot16 = false;
    public boolean overShot17 = false;
    public boolean overShot18 = false;
    public boolean overShot19 = false;
    public boolean overShot20 = false;
    public boolean overShot21 = false;
    public boolean overShot22 = false;


    // shot size
    public int shotSize = 46;


    // player dice images
    public PImage currentImage1;
    public PImage currentImage2;
    public PImage dice11;
    public PImage dice21;
    public PImage dice1in;
    public PImage dice12;
    public PImage dice22;
    public PImage dice2in;
    public PImage dice13;
    public PImage dice23;
    public PImage dice3in;
    public PImage dice14;
    public PImage dice24;
    public PImage dice4in;
    public PImage dice15;
    public PImage dice25;
    public PImage dice5in;
    public PImage dice16;
    public PImage dice26;
    public PImage dice6in;

    // scene library images
    public PImage scenein;
    public PImage[] scene = new PImage[40];


    // input text
    public String myText = "";
    public String input = "";


    public static void main(String args[]) {
        PApplet.main(new String[]{"net.processing.Processing"});
    }


    public void settings() {
        size(1451,958);

        // shot image
        shot = loadImage("shot.jpg");

        // dice images
        bg = loadImage("DeadwoodBoardsPDF.jpg");
        dice11 = loadImage("dice1.1.jpg");
        dice21 = loadImage("dice2.1.jpg");
        currentImage1 = dice11;
        currentImage2 = dice21;
        dice1in = loadImage("dice1in.jpg");
        dice12 = loadImage("dice1.2.jpg");
        dice22 = loadImage("dice2.2.jpg");
        dice2in = loadImage("dice2in.jpg");
        dice13 = loadImage("dice1.3.jpg");
        dice23 = loadImage("dice2.3.jpg");
        dice3in = loadImage("dice3in.jpg");
        dice14 = loadImage("dice1.4.jpg");
        dice24 = loadImage("dice2.4.jpg");
        dice4in = loadImage("dice4in.jpg");
        dice15 = loadImage("dice1.5.jpg");
        dice25 = loadImage("dice2.5.jpg");
        dice5in = loadImage("dice5in.jpg");
        dice16 = loadImage("dice1.6.jpg");
        dice26 = loadImage("dice2.6.jpg");
        dice6in = loadImage("dice6in.jpg");

        // dice placements
        bx = (float)(1100);
        by = (float)(330);
        ax = (float)(1160);
        ay = (float)(330);

        //scene images

        scenein = loadImage("cardback.jpg");
        jailImage = scenein;
        generalStoreImage = scenein;
        saloonImage = scenein;
        mainStreetImage = scenein;
        bankImage = scenein;
        churchImage = scenein;
        ranchImage = scenein;
        secretHideoutImage = scenein;
        trainImage = scenein;
        hotelImage = scenein;
        scene[1] = loadImage("a.jpg");
        scene[2] = loadImage("aa.jpg");
        scene[3] = loadImage("ab.jpg");
        scene[4] = loadImage("ac.jpg");
        scene[5] = loadImage("ad.jpg");
        scene[6] = loadImage("ae.jpg");
        scene[7] = loadImage("af.jpg");
        scene[8] = loadImage("ag.jpg");
        scene[9] = loadImage("ah.jpg");
        scene[10] = loadImage("ai.jpg");
        scene[11] = loadImage("aj.jpg");
        scene[12] = loadImage("ak.jpg");
        scene[13] = loadImage("al.jpg");
        scene[14] = loadImage("am.jpg");
        scene[15] = loadImage("b.jpg");
        scene[16] = loadImage("c.jpg");
        scene[17] = loadImage("d.jpg");
        scene[18] = loadImage("e.jpg");
        scene[19] = loadImage("f.jpg");
        scene[20] = loadImage("g.jpg");
        scene[21] = loadImage("h.jpg");
        scene[22] = loadImage("i.jpg");
        scene[23] = loadImage("j.jpg");
        scene[24] = loadImage("k.jpg");
        scene[25] = loadImage("l.jpg");
        scene[26] = loadImage("m.jpg");
        scene[27] = loadImage("n.jpg");
        scene[28] = loadImage("o.jpg");
        scene[29] = loadImage("p.jpg");
        scene[30] = loadImage("q.jpg");
        scene[31] = loadImage("r.jpg");
        scene[32] = loadImage("s.jpg");
        scene[33] = loadImage("t.jpg");
        scene[34] = loadImage("u.jpg");
        scene[35] = loadImage("v.jpg");
        scene[36] = loadImage("w.jpg");
        scene[37] = loadImage("x.jpg");
        scene[38] = loadImage("y.jpg");
        scene[39] = loadImage("z.jpg");
        scene[0] = loadImage("a.jpg");
    }


    public void draw() {

        // background and board
        background(0);
        fill(255);
        image(bg,0,0);


        // rank change for example
        if(ranked1) {
            if (rank1 < 7) {
                rank1++;
            }
            ranked1 = false;
        }
            if (ranked2){
                if (rank2 < 7) {
                    rank2++;
                }
                ranked2= false;
            }

        // scene card images
        randomizer = (int)random((float)0,(float)40);
        if (jailScene) {
            jailImage = scene[randomizer];
            jailScene = false;
            jailLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (generalStoreScene) {
            generalStoreImage = scene[randomizer];
            generalStoreScene = false;
            generalStoreLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (saloonScene) {
            saloonImage = scene[randomizer];
            saloonScene = false;
            saloonLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (mainStreetScene) {
            mainStreetImage = scene[randomizer];
            mainStreetScene = false;
            mainStreetLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (bankScene) {
            bankImage = scene[randomizer];
            bankScene = false;
            bankLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (churchScene) {
            churchImage = scene[randomizer];
            churchScene = false;
            churchLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (ranchScene) {
            ranchImage = scene[randomizer];
            ranchScene = false;
            ranchLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (secretHideoutScene) {
            secretHideoutImage = scene[randomizer];
            secretHideoutScene = false;
            secretHideoutLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (trainScene) {
            trainImage = scene[randomizer];
            trainScene = false;
            trainLocked = true;
        }
        randomizer = (int)random((float)0,(float)40);
        if (hotelScene) {
            hotelImage = scene[randomizer];
            hotelScene = false;
            hotelLocked = true;
        }

        // player 1 image changes for rank
        if (mouseX > bx && mouseX < bx+boxSize &&
                mouseY > by && mouseY < by+boxSize) {
            overBox = true;
            if(!locked) {
                if (rank1 == 1) {
                    currentImage1= dice1in;
                }
                else if (rank1 == 2) {
                    currentImage1 = dice2in;
                }
                else if (rank1 == 3) {
                    currentImage1 = dice3in;
                }
                else if (rank1 == 4) {
                    currentImage1 = dice4in;
                }
                else if (rank1 == 5) {
                    currentImage1 = dice5in;
                }
                else if (rank1 == 6) {
                    currentImage1 = dice6in;
                }
            }
        } else {
            if (rank1 == 1) {
                currentImage1 = dice11;
            }
            else if (rank1 == 2) {
                currentImage1 = dice12;
            }
            else if (rank1 == 3) {
                currentImage1 = dice13;
            }
            else if (rank1 == 4) {
                currentImage1 = dice14;
            }
            else if (rank1 == 5) {
                currentImage1 = dice15;
            }
            else if (rank1 == 6) {
                currentImage1 = dice16;
            }
            overBox = false;
        }

        // player 2 image changes for rank
        if (mouseX > ax && mouseX < ax+boxSize &&
                mouseY > ay && mouseY < ay+boxSize) {
            overBox2 = true;
            if (!locked2) {
                if (rank2 == 1) {
                    currentImage2 = dice1in;
                } else if (rank2 == 2) {
                    currentImage2 = dice2in;
                } else if (rank2 == 3) {
                    currentImage2 = dice3in;
                } else if (rank2 == 4) {
                    currentImage2 = dice4in;
                } else if (rank2 == 5) {
                    currentImage2 = dice5in;
                } else if (rank2 == 6) {
                    currentImage2 = dice6in;
                }
            }
        } else {
            if (rank2 == 1) {
                currentImage2 = dice21;
            }
            else if (rank2 == 2){
                currentImage2 = dice22;
            }
            else if (rank2 == 3){
                currentImage2 = dice23;
            }
            else if (rank2 == 4){
                currentImage2 = dice24;
            }
            else if (rank2 == 5){
                currentImage2 = dice25;
            }
            else if (rank2 == 6){
                currentImage2 = dice26;
            }
            overBox2 = false;
        }

        // if over shots
        if (mouseX > 30 && mouseX < 30+shotSize && mouseY > 165 && mouseY < 165+shotSize) {
            overShot1 = true;
        }
        else {
            overShot1 = false;
        }
        if (mouseX > 81 && mouseX < 81+shotSize && mouseY > 165 && mouseY < 165+shotSize) {
            overShot2 = true;
        }
        else {
            overShot2 = false;
        }
        if (mouseX > 133 && mouseX < 133+shotSize && mouseY > 165 && mouseY < 165+shotSize) {
            overShot3 = true;
        }
        else {
            overShot3 = false;
        }
        if (mouseX > 442 && mouseX < 442+shotSize && mouseY > 161 && mouseY < 161+shotSize) {
            overShot4 = true;
        }
        else {
            overShot4 = false;
        }
        if (mouseX > 315 && mouseX < 315+shotSize && mouseY > 280 && mouseY < 280+shotSize) {
            overShot5 = true;
        }
        else {
            overShot5 = false;
        }
        if (mouseX > 315 && mouseX < 315+shotSize && mouseY > 332 && mouseY < 332+shotSize) {
            overShot6 = true;
        }
        else {
            overShot6 = false;
        }
        if (mouseX > 470 && mouseX < 470+shotSize && mouseY > 529 && mouseY < 529+shotSize) {
            overShot7 = true;
        }
        else {
            overShot7 = false;
        }
        if (mouseX > 522 && mouseX < 522+shotSize && mouseY > 529 && mouseY < 529+shotSize) {
            overShot8 = true;
        }
        else {
            overShot8 = false;
        }
        if (mouseX > 247 && mouseX < 247+shotSize && mouseY > 814 && mouseY < 814+shotSize) {
            overShot9 = true;
        }
        else {
            overShot9 = false;
        }
        if (mouseX > 300 && mouseX < 300+shotSize && mouseY > 814 && mouseY < 814+shotSize) {
            overShot10 = true;
        }
        else {
            overShot10 = false;
        }
        if (mouseX > 354 && mouseX < 354+shotSize && mouseY > 814 && mouseY < 814+shotSize) {
            overShot11 = true;
        }
        else {
            overShot11 = false;
        }
        if (mouseX > 855 && mouseX < 855+shotSize && mouseY > 31 && mouseY < 31+shotSize) {
            overShot12 = true;
        }
        else {
            overShot12 = false;
        }
        if (mouseX > 907 && mouseX < 907+shotSize && mouseY > 31 && mouseY < 31+shotSize) {
            overShot13 = true;
        }
        else {
            overShot13 = false;
        }
        if (mouseX > 960 && mouseX < 960+shotSize && mouseY > 31 && mouseY < 31+shotSize) {
            overShot14 = true;
        }
        else {
            overShot14 = false;
        }
        if (mouseX > 680 && mouseX < 680+shotSize && mouseY > 220 && mouseY < 220+shotSize) {
            overShot15 = true;
        }
        else {
            overShot15 = false;
        }
        if (mouseX > 733 && mouseX < 733+shotSize && mouseY > 220 && mouseY < 220+shotSize) {
            overShot16 = true;
        }
        else {
            overShot16 = false;
        }
        if (mouseX > 891 && mouseX < 891+shotSize && mouseY > 605 && mouseY < 605+shotSize) {
            overShot17 = true;
        }
        else {
            overShot17 = false;
        }
        if (mouseX > 677 && mouseX < 677+shotSize && mouseY > 729 && mouseY < 729+shotSize) {
            overShot18 = true;
        }
        else {
            overShot18 = false;
        }
        if (mouseX > 737 && mouseX < 737+shotSize && mouseY > 729 && mouseY < 729+shotSize) {
            overShot19 = true;
        }
        else {
            overShot19 = false;
        }
        if (mouseX > 1065 && mouseX < 1065+shotSize && mouseY > 749 && mouseY < 729+shotSize) {
            overShot20 = true;
        }
        else {
            overShot20 = false;
        }
        if (mouseX > 1122 && mouseX < 1122+shotSize && mouseY > 749 && mouseY < 749+shotSize) {
            overShot21 = true;
        }
        else {
            overShot21 = false;
        }
        if (mouseX > 1176 && mouseX < 1176+shotSize && mouseY > 749 && mouseY < 749+shotSize) {
            overShot22 = true;
        }
        else {
            overShot22 = false;
        }


        // draw shots if shots not taken
        if (shot1) {
            image(shot,30,165);
        }
        if (shot2) {
            image(shot,81,165);
        }
        if (shot3) {
            image(shot,133,165);
        }
        if (shot4) {
            image(shot,442,161);
        }
        if (shot5) {
            image(shot,315,280);
        }
        if (shot6) {
            image(shot,315,332);
        }
        if (shot7) {
            image(shot,470,529);
        }
        if (shot8) {
            image(shot,522,529);
        }
        if (shot9) {
            image(shot,247,814);
        }
        if (shot10) {
            image(shot,300,814);
        }
        if (shot11) {
            image(shot,354,814);
        }
        if (shot12) {
            image(shot,855,31);
        }
        if (shot13) {
            image(shot,907,31);
        }
        if (shot14) {
            image(shot,960,31);
        }
        if (shot15) {
            image(shot,680,220);
        }
        if (shot16) {
            image(shot,733,220);
        }
        if (shot17) {
            image(shot,891,605);
        }
        if (shot18) {
            image(shot,677,729);
        }
        if (shot19) {
            image(shot,737,729);
        }
        if (shot20) {
            image(shot,1065,749);
        }
        if (shot21) {
            image(shot,1122,749);
        }
        if (shot22) {
            image(shot,1176,749);
        }

        // Draw the scene cards
        image(jailImage, 284, 33);
        image(generalStoreImage, 371, 282);
        image(saloonImage, 686, 281);
        image(mainStreetImage, 1016, 33);
        image(bankImage, 678, 531);
        image(churchImage, 678, 785);
        image(ranchImage, 254, 531);
        image(secretHideoutImage, 33, 781);

        // Sideways scene cards
        pushMatrix();
        translate(33, 424);
        rotate(-90*TWO_PI/360);
        image(trainImage,0,0);
        popMatrix();
        pushMatrix();
        translate(1103, 735);
        rotate(-90*TWO_PI/360);
        image(hotelImage,0,0);
        popMatrix();



        // Draw the dice for player 1 and 2
        image(currentImage1, bx, by);
        image(currentImage2, ax, ay);



        // Current room changes for player 1
        if (!locked) {
            if (by-boxSize > 0 && bx-boxSize < 250 && by-boxSize > 0 && by-boxSize < 475) {
                room1 = "Train Station";
                if (!trainLocked) {
                    trainScene = true;
                }
            }
            else if (bx > 250 && bx < 625 && by > 0 && by < 250) {
                room1 = "Jail";
                if (!jailLocked) {
                    jailScene = true;
                }
            }
            else if (bx > 250 && bx< 625 && by > 250 && by < 475) {
                room1 = "General Store";
                if (!generalStoreLocked) {
                    generalStoreScene = true;
                }
            }
            else if (bx > 625 && bx< 1250 && by > 0 && by < 200) {
                room1 = "Main Street";
                if (!mainStreetLocked) {
                    mainStreetScene = true;
                }
            }
            else if (bx > 625 && bx< 1025 && by > 200 && by < 475) {
                room1 = "Saloon";
                if (!saloonLocked) {
                    saloonScene = true;
                }
            }
            else if (bx > 1025 && bx< 1250 && by > 200 && by < 475) {
                room1 = "Trailer";
            }
            else if (bx > 0 && bx< 225 && by > 475 && by < 745) {
                room1 = "Casting Office";
            }
            else if (bx > 225 && bx< 625 && by > 475 && by < 745) {
                room1 = "Ranch";
                if (!ranchLocked) {
                    ranchScene = true;
                }
            }
            else if (bx > 0 && bx< 625 && by > 745 && by < 950) {
                room1 = "Secret Hideout";
                if (!secretHideoutLocked) {
                    secretHideoutScene = true;
                }
            }
            else if (bx > 625 && bx< 1040 && by > 475 && by < 700) {
                room1 = "Bank";
                if (!bankLocked) {
                    bankScene = true;
                }
            }
            else if (bx > 1040 && bx< 1250 && by > 475 && by < 950) {
                room1 = "Hotel";
                if (!hotelLocked) {
                    hotelScene = true;
                }
            }
            else if (bx > 625 && bx< 1040 && by > 700 && by < 950) {
                room1 = "Church";
                if (!churchLocked) {
                    churchScene = true;
                }
            }
        }


        // Current room changes for player 2
        if (!locked2) {
            if (ay-boxSize > 0 && ax-boxSize < 250 && ay-boxSize > 0 && ay-boxSize < 475) {
                room2 = "Train Station";
                if (!trainLocked) {
                    trainScene = true;
                }
            }
            else if (ax > 250 && ax < 625 && ay > 0 && ay < 250) {
                room2 = "Jail";
                if (!jailLocked) {
                    jailScene = true;
                }
            }
            else if (ax > 250 && ax< 625 && ay > 250 && ay < 475) {
                room2 = "General Store";
                if (!generalStoreLocked) {
                    generalStoreScene = true;
                }
            }
            else if (ax > 625 && ax< 1250 && ay > 0 && ay < 200) {
                room2 = "Main Street";
                if (!mainStreetLocked) {
                    mainStreetScene = true;
                }
            }
            else if (ax > 625 && ax< 1025 && ay > 200 && ay < 475) {
                room2 = "Saloon";
                if (!saloonLocked) {
                    saloonScene = true;
                }
            }
            else if (ax > 1025 && ax< 1250 && ay > 200 && ay < 475) {
                room2 = "Trailer";
            }
            else if (ax > 0 && ax< 225 && ay > 475 && ay < 745) {
                room2 = "Casting Office";
            }
            else if (ax > 225 && ax< 625 && ay > 475 && ay < 745) {
                room2 = "Ranch";
                if (!ranchLocked) {
                    ranchScene = true;
                }
            }
            else if (ax > 0 && ax< 625 && ay > 745 && ay < 950) {
                room2 = "Secret Hideout";
                if (!secretHideoutLocked) {
                    secretHideoutScene = true;
                }
            }
            else if (ax > 625 && ax< 1040 && ay > 475 && ay < 700) {
                room2 = "Bank";
                if (!bankLocked) {
                    bankScene = true;
                }
            }
            else if (ax > 1040 && ax< 1250 && ay > 475 && ay < 950) {
                room2 = "Hotel";
                if (!hotelLocked) {
                    hotelScene = true;
                }
            }
            else if (ax > 625 && ax< 1040 && ay > 700 && ay < 950) {
                room2 = "Church";
                if (!churchLocked) {
                    churchScene = true;
                }
            }
        }


        // example of input text
        text(myText, 1260, 550);
        text(input, 1260, 575);

        // Player scoreboards
        text("Player 1: \n \t Credits: " + credits1 + "\n \t Dollars: " + dollars1 + "\n \t Current Room: " + room1 + "\n \t Current Role: N/A \n \t Rehearsals: " + rehearsals1, 1260, 350);
        text("Player 2: \n \t Credits: " + credits2 + "\n \t Dollars: " + dollars2 + "\n \t Current Room: " + room2 + "\n \t Current Role: N/A \n \t Rehearsals: " + rehearsals2, 1260, 450);


    }

    public void keyPressed() {
        // Player input
        if (keyCode == BACKSPACE) {
            if (myText.length() > 0) {
                myText = myText.substring(0, myText.length()-1);
            }
        } else if (keyCode == DELETE) {
            myText = "";
        } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
            myText = myText + key;
        } if (keyCode == ENTER) {
            input = myText;
            myText = "";
        } if (keyCode == ALT){
            ranked1 = true;
        } if (keyCode == CONTROL){
            ranked2 = true;
        }

    }


    public void mousePressed() {

        // booleans for moving players with mouse
        if(overBox) {
            locked = true;
        } else {
            locked = false;
        }
        if(overBox2) {
            locked2 = true;
        }
        else {
            locked2 = false;
        }

        // booleans for taking a shot
        if (overShot1) {
            shot1 = false;
        }
        if (overShot2) {
            shot2 = false;
        }
        if (overShot3) {
            shot3 = false;
        }
        if (overShot4) {
            shot4 = false;
        }
        if (overShot5) {
            shot5 = false;
        }
        if (overShot6) {
            shot6 = false;
        }
        if (overShot7) {
            shot7 = false;
        }
        if (overShot8) {
            shot8 = false;
        }
        if (overShot9) {
            shot9 = false;
        }
        if (overShot10) {
            shot10 = false;
        }
        if (overShot11) {
            shot11 = false;
        }
        if (overShot12) {
            shot12 = false;
        }
        if (overShot13) {
            shot13 = false;
        }
        if (overShot14) {
            shot14 = false;
        }
        if (overShot15) {
            shot15 = false;
        }
        if (overShot16) {
            shot16 = false;
        }
        if (overShot17) {
            shot17 = false;
        }
        if (overShot18) {
            shot18 = false;
        }
        if (overShot19) {
            shot19 = false;
        }
        if (overShot20) {
            shot20 = false;
        }
        if (overShot21) {
            shot21 = false;
        }
        if (overShot22) {
            shot22 = false;
        }

        // offsets for mouse
        bxOffset= mouseX-bx;
        byOffset = mouseY-by;
        axOffset= mouseX-ax;
        ayOffset = mouseY-ay;
    }


    public void mouseDragged() {
        // actually moves die
        if(locked) {
            bx = mouseX-bxOffset;
            by = mouseY-byOffset;
        }
        if(locked2) {
            ax = mouseX-axOffset;
            ay = mouseY-ayOffset;
        }
    }


    public void mouseReleased() {
        locked = false;
        locked2 = false;
    }


}