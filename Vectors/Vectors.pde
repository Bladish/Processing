PVector mouseBall = new PVector(0,0);
PVector mouseBall2 = new PVector(0,0);
PVector movingBall = new PVector(0,0);
int vX = 1;
int vY = 1;
boolean incSpeed = false;
void setup() {
	size(600,600);

}

void draw() {
	stroke(0);
	background(255,255,255);
	checkBoarders();
	setSpeed();
	movingBallSpeed();
	ellipse(mouseBall2.x, mouseBall2.y, 30, 30);
	ellipse(movingBall.x, movingBall.y, 30, 30);

}

void setSpeed(){
	mouseBall.set(mouseX - mouseBall2.x,mouseY - mouseBall2.y);
	mouseBall.normalize();
	mouseBall2.add(mouseBall);

}

void movingBallSpeed(){
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

void checkBoarders(){
	if(movingBall.x > width) vX = -vX;
			
	if(movingBall.y > height) vY = -vY;

	if(movingBall.x < 0) vX = 1;

	if (movingBall.y < 0) vY = 1;

}
