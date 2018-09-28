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

public class InputDemo extends PApplet {

PVector position;
float speed = 5;

public void setup() {
	
	position = new PVector(width/2, height/2);
	ellipseMode(CENTER);
}

public void draw() {
	background(255);
	ellipse(position.x, position.y, 50, 50);
	float xMovement = getAxisRaw("Horizontal") * speed;
	float yMovement = getAxisRaw("Vertical") * speed;
	position.x += xMovement;
	position.y += yMovement;
}

/*void move(){
	if(moveLeft){
		position.x -= 5;
	}

	if(moveRight){
		position.x += 5;
	}

	if(moveUp){
		position.y -= 5;
	}

	if(moveDown){
		position.x += 5;
	}
}*/
boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;



public void keyPressed(){
	if(key == 'd'){
		moveRight = true;
	}
	else if(key == 'a'){
		moveLeft = true;
	}
	else if(key == 'w'){
		moveUp = true;
	}
	else if(key == 's'){
		moveDown = true;
	}
}

public void keyReleased(){
	if(key == 'd'){
		moveRight = false;
	}
	else if(key == 'a'){
		moveLeft = false;
	}
	else if(key == 'w'){
		moveUp = false;
	}
	else if(key == 's'){
		moveDown = false;
	}	
}

public float getAxisRaw(String axis){
	if(axis == "Horizontal") {
		if(moveLeft){
			return -1;
		}

		if(moveRight){
			return 1;
		}
	}

	if(axis == "Vertical"){
		if(moveUp){
			return -1;
		}

		if(moveDown){
			return 1;
		}

	}

	return 0;
} 
  public void settings() { 	size(1024, 1024); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "InputDemo" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
