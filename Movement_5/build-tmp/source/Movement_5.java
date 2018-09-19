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

public class Movement_5 extends PApplet {

PVector ball =new PVector(0,0); 
float vY = 100;
float vX = 50;
float a = 100;
float outSideScreen = 1;
float tpf;
float time;
public void setup() {
	
	ball.x = width / 2;
	ball.y = height / 2;
	frameRate(30);
}

public void draw() {
	long currentTime = millis();
	tpf = (currentTime - time) * 0.001f; 
	background(255);
	ball();
	movement();
	checkBoarders();
	time = currentTime;
}

public void ball(){
	ellipse(ball.x, ball.y, 30, 30);
}

public void movement(){
	ball.y = ball.y + vY * tpf;
	vY = vY + a * tpf;
	ball.x = ball.x + vX * tpf;
}

public void checkBoarders(){
	if(ball.y >= height){
		ball.y = height - 1;
    	vY = -vY  * 0.9f;
	}

	if(ball.x > width + outSideScreen){
		ball.x = 0;
	}
}								
  public void settings() { 	size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Movement_5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
