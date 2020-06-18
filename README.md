#Happy Farmer
Happy Farmer is a SENG201 Project in university of Canterbury. 

It's a farm simulator which allows you play a simple farm game, 
please refer "Game Introduction" for more information.


#Prerequisites

Preferred Java SE "12.0.1" <br/>but you can also use University of Canterbury lab machine.
   For downloading, please refer: https://www.oracle.com/java/technologies/javase/jdk12-archive-downloads.html


Install Eclipse IDE https://www.eclipse.org

#Getting Started
###Runnable jar file
Please make sure you have installed Java before running jar file
To run, simply use "java -jar .../HappyFarmer.jar" in terminal

###_Open project_
Eclipse -> File -> Open Projects from File System.. -> Import source(Root directory) -> finish

You should be able to see "src", "JUnit 5" and "JRE System Library".
###Run App.java
Using Eclipse, Project Explorer: src -> main -> App.java

#Game Introduction
The Goal of this game is earning as much money as you can given limited time! The player must find a balance point between his money and time. In the end, there would be a weighted final score considering the player's overall property.<br/><br/>
At the beginning, the player can choose days between 5-10, inclusive. The more starting days the player chooses, the less staring money the player has. Even though the player chooses 5 days at first, there is a "Time Machine" in general store, which allows the player having a chance to increase left time, but it's very expensive.<br/><br/>
4 types of farm: Standard, crop, animal, and fish farm. Each of them has its own special advantage and disadvantage, but all of them allows the player to grow crops and feed animals<br/><br/>
6 species of crops and 3 species of animals are provided in general store. The player will only have starting money at the beginning.<br/><br/>
6 types of actions: Tend farm land, feed animals, harvest crops, tend crops by water or by fertilizer, play with animals and fishing(Fishing farm only). There are only 2 actions allowed to perform per day.<br/><br/>
There will be random events happening which are broken fence, drought and county fair encouraging and discouraging the player throughout the whole game when switching to the next day. Even though animals are relatively expensive, broken fence is very likely to happen due to poor management.

#Enable GUI Design
**Please read this section care fully so that you can manage to open our design mode**

Install Window Builder:
<br/>Eclipse -> Help -> Eclipse Marketplace -> Window Builder 1.9.3


Setup Design:
<br/>Because all the classes under main.GUI package are using one shared Frame, Window builder is unable to switch design mode(except StartWindow.java).
<br/><br/>To resolve this, please insert one single line "mainFrame = new JFrame()" under line "======app mode====="<br/> also comment out all the other constructors except the first one.
	
#Unit Test
Right click package unitTest, Run As -> JUnit Test

#Reference
All the pictures from web included in the project are for demonstration purpose only.<br/>
Full reference list please see ExamplePictures.txt, their designers reserve all rights.

#Author
Changxing Gong<br/>
Rayhan Aristia

#Date
Project start Time: 17/04/20<br/>
Project finish Time: 24/05/2020
