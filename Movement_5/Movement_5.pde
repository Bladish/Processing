PVector ball =new PVector(0,0); 
float vY = 100;
float vX = 50;
float a = 100;
float outSideScreen = 1;
float tpf;
float time;
void setup() {
	size(800,600);
	ball.x = width / 2;
	ball.y = height / 2;
	frameRate(60);
}

void draw() {
	long currentTime = millis();
	tpf = (currentTime - time) * 0.001f; 
	background(255);
	ball();
	movement();
	checkBoarders();
	time = currentTime;
}

void ball(){
	ellipse(ball.x, ball.y, 30, 30);
}

void movement(){
	ball.y = ball.y + vY * tpf;
	vY = vY + a * tpf;
	ball.x = ball.x + vX * tpf;
}

void checkBoarders(){
	if(ball.y >= height){
		ball.y = height - 1;
    	vY = -vY  * 0.9f;
	}

	if(ball.x > width + outSideScreen){
		ball.x = 0;
	}
}								