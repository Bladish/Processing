import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Vectors extends PApplet {

PVector mouseBall = new PVector(0,0);
PVector mouseBall2 = new PVector(0,0);
PVector movingBall = new PVector(0,0);
int vX = 1;
int vY = 1;
boolean incSpeed = false;
public void setup() {
	

}

public void draw() {
	stroke(0);
	background(255,255,255);
	checkBoarders();
	setSpeed();
	movingBallSpeed();
	ellipse(mouseBall2.x, mouseBall2.y, 30, 30);
	ellipse(movingBall.x, movingBall.y, 30, 30);

}

public void setSpeed(){
	mouseBall.set(mouseX - mouseBall2.x,mouseY - mouseBall2.y);
	mouseBall.normalize();
	mouseBall2.add(mouseBall);

}

public void movingBallSpeed(){
	if(mousePressed && (mouseButton == LEFT)){
		incSpeed = true;
	}
	
	if(incSpeed){
		movingBall.x = movingBall.x + vX;
		movingBall.y = movingBall.y + vY;
	}
	
	if(mousePressed && (mouseButton == RIGHT)){
		incSpeed = false;
	}
	movingBall.set(movingBall.x, movingBall.y);
}

public void checkBoarders(){
	if(movingBall.x > width) vX = -vX;
			
	if(movingBall.y > height) vY = -vY;

	if(movingBall.x < 0) vX = 1;

	if (movingBall.y < 0) vY = 1;

}
  public void settings() { 	size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Vectors" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
