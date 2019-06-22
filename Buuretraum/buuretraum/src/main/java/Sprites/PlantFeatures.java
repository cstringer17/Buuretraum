package Sprites;

public class PlantFeatures {

	public int money = 0;
	public int height = 0;
	public int maxheight = 10;
	public String name;
	
	public PlantFeatures() {
		
	}
	
	public void growth() { // Plant grows
	int height = 0;
	
		if (height<10) {
			this.height++;
		}
		
	}
	
	public void checkHeight(){ //Checks Height of the Plant
		if(height>4)
			
			height=4;
	}
	

	

	public void revenue() {
				
	}

	
	
}
