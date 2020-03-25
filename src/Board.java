import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Map map;
	private Actor actor;
	private Game game;
//	private Food food;
	
	public Board() {
		
		map = new Map();
		actor = new Actor();
//		food = new Food();
				
		timer = new Timer(25, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		for(int y = 0; y < 16; y++) {
			for(int x = 0; x < 16; x++) {
				if(map.getMap(x , y).equals("g")){
					g.drawImage(map.getGround(), x * 32, y * 32, null);
//					food.render(g);
//					g.setColor(Color.LIGHT_GRAY);
//					g.fillOval(x * 32 + 15, y * 32 + 15, 5, 5);
				}
				if(map.getMap(x , y).equals("w")){
					g.drawImage(map.getIce(), x * 32, y * 32, null);
				}
			}
		}
	}

}
