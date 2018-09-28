PVector position;
float speed = 5;

void setup() {
	size(1024, 1024);
	position = new PVector(width/2, height/2);
	ellipseMode(CENTER);
}

void draw() {
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