float tpf;
float time;
float outSideScreen = 1;
ArrayList<Ball> ballList = new ArrayList<Ball>();
int numberOfBalls = 100;
BigFatBall fatBall= new BigFatBall(50);
void setup() {
	size(800,600);
	frameRate(60);
	for (int i = 0; i < numberOfBalls; ++i) {
		ballList.add(new Ball(random(0, 800), random(0, 600), random(0, 255), random(0, 255), random(0, 255)));	
	}
	
	
}

void draw() {
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

public class Ball{
	float c1;
	float c2;
	float c3;
	PVector balls = new PVector(0,0);
	float vY = random(100, -50);;
	float vX = random(100, -50);;
	float a = 10;
	int size = 10;
	
	Ball(float x, float y, float color1, float color2, float color3){
		this.c1 = color1;
		this.c2 = color2;
		this.c3 = color3;
		this.balls.x = x;
		this.balls.y = y;
	}

	void movement(float tpf){
		balls.y = balls.y + vY * tpf;
		vY = vY + a * tpf;
		balls.x = balls.x + vX * tpf;
	}
	
	void paintBall(){
		fill(c1,c2,c3);
		ellipse(balls.x, balls.y, size, size);
	}
}							

public class BigFatBall{
	int ballSize;
	float delay = 0.7;
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
		bigFatBall2.add(bigFatBall1);
	}
}	