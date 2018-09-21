class Zombie extends Human{
	int c; 


	Zombie(float size, float x, float y, int c){
		super(size, x, y);
		this.c = c;
	}

	void draw(){
		fill(0,c,0);
		ellipse(position.x, position.y, size, size);
	}
}