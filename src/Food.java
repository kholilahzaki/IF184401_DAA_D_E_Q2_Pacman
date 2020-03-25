import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Food extends Actor{
	
	private Map map;
	private Actor actor;
	private Game game;
	
	private int foodX, foodY;
	private int tileX = 1;
	private int tileY = 1;
	public int kondisi = 1;
	private int eat;
	
	public Food() {
		
		map = new Map();
		actor = new Actor();
		game = new Game();
		
	}

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		super.move(dx, dy);
		
		tileX += dx;
		tileY += dy;
	}

	public void tick() {
//		y -= 1;
	}
	
	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}
	
	public int score() {
		int score = 0;
		return score += 10;
	}

	public void render(Graphics g) {
		
//		if(kondisi == 1) {
//			for(int y = 0; y < 16; y++) {
//				for(int x = 0; x < 16; x++) {
//			
//					if(map.getMap(x , y).equals("g")){
//						g.setColor(Color.LIGHT_GRAY);
//						g.fillOval(x * 32 + 15, y * 32 + 15, 4, 4);
//					}
//				}
//			}
//		}
//		if(kondisi == 2) {
			g.setColor(Color.WHITE);
			g.fillOval(this.tileX * 32 + 15, this.tileY * 32 + 15, 4, 4);
//		}
//		if(lastDir == 1) {
//			g.setColor(Color.BLACK);
//			g.fillOval(this.tileX * 32 + 15, this.tileY * 32 + 15, 4, 4);
//		}
//		else if(lastDir == -1) {
//			g.setColor(Color.LIGHT_GRAY);
//			g.fillOval(this.tileX * 32 + 15, this.tileY * 32 + 15, 4, 4);
//		}
//		else if(lastDir == 2){
//			g.setColor(Color.LIGHT_GRAY);
//			g.fillOval(this.tileX * 32 + 15, this.tileY * 32 + 15, 4, 4);
//		}
//		else if(lastDir == -2){
//			g.setColor(Color.LIGHT_GRAY);
//			g.fillOval(this.tileX * 32 + 15, this.tileY * 32 + 15, 4, 4);
//		}
	}
	
}
