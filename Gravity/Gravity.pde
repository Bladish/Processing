float tpf;
float time;
float outSideScreen = 1;
ArrayList<Ball> ballList = new ArrayList<Ball>();
int numberOfBalls = 100;
BigFatBall fatBall = new BigFatBall(50);
PVector ballTmp = new PVector(0,0); 
void setup() {
	size(800,600);
	frameRate(60);
	for (int i = 0; i < numberOfBalls; ++i) {
		ballList.add(new Ball(random(0, width), random(0, height), random(0, 255), random(0, 255), random(0, 255)));	
	}
	
	
}

void draw() {
	long currentTime = millis();
	tpf = (currentTime - time) * 0.001f; 
	background(255);
	for (Ball ball : ballList) {
		checkBorders(ball);
		movement(ball);
		ball.paintBall();
	}

	fatBall.setSpeed();
	fatBall.paintBigFat();
	time = currentTime;
}

void checkBorders(Ball ball){
	if(ball.balls.y >= height){
		ball.balls.y = height - 1;
    	ball.vY = -ball.vY  * 0.9f;
	}

	if(ball.balls.x < 0) ball.vY = -ball.vY;
	if(ball.balls.x > width + outSideScreen){
		ball.balls.x = 0;
	}
}
//c^2 = x^2 + y^2
void movement(Ball ball){
		float x = fatBall.bigFatBall2.x - ball.balls.x;
		float y = fatBall.bigFatBall2.y - ball.balls.y;
		ballTmp.set(x, y); 
		ballTmp.normalize();
		ball.balls.add(ballTmp); 
	}	

public class Ball{
	float c1;
	float c2;
	float c3;
	PVector balls = new PVector(0,0);
	float vY = 100;
	float vX = 50;
	float a = 10;
	int size = 10;
	

	Ball(float x, float y, float color1, float color2, float color3){
		this.c1 = color1;
		this.c2 = color2;
		this.c3 = color3;
		this.balls.x = x;
		this.balls.y = y;
	}

	void paintBall(){
		fill(c1,c2,c3);
		ellipse(balls.x, balls.y, size, size);
	}
}							

public class BigFatBall{
	int ballSize;
	PVector bigFatBall1 = new PVector(width/2,height/2);
	PVector bigFatBall2 = new PVector(width/2,height/2);

	
	BigFatBall(int size){
		this.ballSize = size;
	}	
	
	void paintBigFat(){
		ellipse(bigFatBall2.x, bigFatBall2.y, ballSize, ballSize);
	}
	
	void setSpeed(){
		bigFatBall1.set(mouseX - bigFatBall2.x, mouseY - bigFatBall2.y);
		bigFatBall1.normalize();
		bigFatBall2.add(bigFatBall1.mult(2));
	}
}	