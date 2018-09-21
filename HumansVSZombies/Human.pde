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

	void update(){
		position.x += velocity.x;
		position.y += velocity.y;
	}

	void draw(){
		fill(255, 0, 0);
		ellipse(position.x, position.y, size, size);
	}
}