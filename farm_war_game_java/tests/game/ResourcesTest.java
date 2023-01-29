package game;
import org.junit.Before;

import game.resource.Rock;
import game.resource.Sand;
import game.resource.Wheat;
import game.resource.Wood;

public abstract class ResourcesTest {
	
	protected Wheat wheat;
	protected Wheat wheat2;
	
	protected Sand sand; 
	protected Sand sand2;
	
	protected Wood wood;
	protected Wood wood2;
	
	protected Rock rock;
	protected Rock rock2;
	

	@Before
	public void Before() {
		this.wheat = new Wheat(5);
		this.wheat2 = new Wheat(5);
		
		this.sand = new Sand(2);
		this.sand2 = new Sand(2);
		
		this.wood = new Wood(1);
		this.wood2 = new Wood(1);
		
		this.rock = new Rock(4);
		this.rock2 = new Rock(4);
		
	}
	
}
