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

float tpf;
float time;
float outSideScreen = 1;
ArrayList<Ball> ballList = new ArrayList<Ball>();
int numberOfBalls = 100;
BigFatBall fatBall= new BigFatBall(50);
public void setup() {
	
	frameRate(60);
	for (int i = 0; i < numberOfBalls; ++i) {
		ballList.add(new Ball(random(0, 800), random(0, 600), random(0, 255), random(0, 255), random(0, 255)));	
	}
	
	
}

public void draw() {
	long currentTime = millis();
	tpf = (currentTime - time) * 0.001f; 
	background(255);
	for (Ball ball : ballList) {
		checkBorders(ball);
		ball.movement(tpf);
		ball.paintBall();
	}
	fatBall.setSpeed();
	fatBall.paintBigFat();
	time = currentTime;
}

public void checkBorders(Ball ball){
		if(ball.posY >= height){
			ball.posY = height - 1;
	    	ball.vY = -ball.vY  * 0.9f;
		}

		if(ball.posY < 0) ball.vY = -ball.vY;
		if(ball.posX > width + outSideScreen){
			ball.posX = 0;
		}

}

public class Ball{
	float c1;
	float c2;
	float c3;
	float posX;
	float posY;
	float vY = 100;
	float vX = 50;
	float a = 10;
	int size = 10;
	
	Ball(float x, float y, float color1, float color2, float color3){
		this.c1 = color1;
		this.c2 = color2;
		this.c3 = color3;
		this.posX = x;
		this.posY = y;
		
	}

	public void movement(float tpf){
		posY = posY + vY * tpf;
		vY = vY + a * tpf;
		posX = posX + vX * tpf;
	}
	
	public void paintBall(){
		fill(c1,c2,c3);
		ellipse(posX, posY, size, size);
	}
}							

public class BigFatBall{
	int ballSize;
	float delay = 0.7f;
	PVector bigFatBall1 = new PVector(width/2,height/2);
	PVector bigFatBall2 = new PVector(width/2,height/2);

	
	BigFatBall(int size){
		this.ballSize = size;
	}	
	
	public void paintBigFat(){
		ellipse(bigFatBall2.x, bigFatBall2.y, ballSize, ballSize);
	}
	
	public void setSpeed(){
		bigFatBall1.set(mouseX - bigFatBall2.x, mouseY - bigFatBall2.y);
		bigFatBall1.normalize();
		bigFatBall2.add(bigFatBall1);
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
