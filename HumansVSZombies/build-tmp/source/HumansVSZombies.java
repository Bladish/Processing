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

public class HumansVSZombies extends PApplet {


Controler controler;
public void setup() {
	
	controler = new Controler();
}

public void draw() {
	background(255);
	controler.update();
	controler.collision();
	controler.checkBorders();
}
class Controler{
	int numberOfHumans = 99;
	ArrayList<Human> humansList = new ArrayList<Human>();
	float size = 30;
	int c = 255;
	float posX = width/2;
	float posY = height/2;
	Controler(){
		for (int i = 0; i < numberOfHumans; i++) {
			humansList.add(new Human(size, random(0, 1024), random(0, 800)));		
		}
		humansList.add(new Zombie(size, posX, posY, c));

	}

	public void update(){
		for (Human human : humansList) {
			human.update();
			human.draw();
		}
	}

	public void checkBorders(){
		for (Human human : humansList) {
			if(human.position.x > width) human.position.x = 0;
			if(human.position.y > height) human.position.y = 0;
			if(human.position.x < 0) human.position.x = width;
			if(human.position.y < 0) human.position.y = height;
		}
			
	}

	public boolean checkCollision(float x1, float y1, float size1, float x2, float y2, float size2){
		float maxDistance = (size1 + size2) / 2;
		if(abs(x1 - x2) > maxDistance) {
			return false;
		}
		
		if(abs(y1 - y2) > maxDistance) {
			return false;
		}
		if(dist(x1, y1, x2, y2) > maxDistance){
			return false;
		}

		return true;
	}
	
	public void collision(){
		for(int i = 0; i < humansList.size() -1; i++){
			for (int j = i + 1; j < humansList.size(); j++) {
				if(humansList.get(j) instanceof Zombie ^ humansList.get(i) instanceof Zombie){	
				boolean hasCollided = checkCollision(humansList.get(i).position.x,
													 humansList.get(i).position.y,
													 humansList.get(i).size,	
													 
													 humansList.get(j).position.x,
													 humansList.get(j).position.y,							
													 humansList.get(j).size);	
			

				 	if(hasCollided && humansList.get(i) instanceof Zombie){
				 		humansList.set(j, new Zombie(size, humansList.get(j).position.x, humansList.get(j).position.y, c));
				 	}

					 	if(hasCollided && humansList.get(j) instanceof Zombie){
					 		humansList.set(i, new Zombie(size, humansList.get(i).position.x, humansList.get(i).position.y, c));
					 	}
				}
 			}	
	 	}
	}
}	
class Human{
	PVector position;
	PVector velocity;
	float size;
	
	Human(float size, float x, float y){
		position =  new PVector(x, y);
		
		this.size = size;

		velocity = new PVector();
		velocity.x = random(10) - 5;
		velocity.y = random(10) - 5;
	}

	public void update(){
		position.x += velocity.x;
		position.y += velocity.y;
	}

	public void draw(){
		fill(255, 0, 0);
		ellipse(position.x, position.y, size, size);
	}
}
class Zombie extends Human{
	int c; 


	Zombie(float size, float x, float y, int c){
		super(size, x, y);
		this.c = c;
	}

	public void draw(){
		fill(0,c,0);
		ellipse(position.x, position.y, size, size);
	}
}
  public void settings() { 	size(1024,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "HumansVSZombies" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
