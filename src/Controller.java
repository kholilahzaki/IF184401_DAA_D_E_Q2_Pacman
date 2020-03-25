import java.awt.Graphics;
import java.util.ArrayList;

public class Controller {

	private ArrayList <Food> f = new ArrayList <Food>();
	
	private Food food;
	private Game game;
	
	public Controller(Game game) {
		this.game = game;
		
		
		addFood(new Food());
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < f.size(); i++) {
			food = f.get(i);
			
			food.render(g);
		}
	}
	
	public void addFood(Food block) {
		f.add(block);
	}
	
	public void removeFood(Food block) {
		f.remove(block);
	}
}
