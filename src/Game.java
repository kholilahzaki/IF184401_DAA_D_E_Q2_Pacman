import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JFrame;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Game extends Canvas implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isRunning = false;
	
	public static final int WIDTH = 512;
	public static final int HEIGHT = 512;
	public static final String TITLE = "Pac-Man 4.0";
	private int x = 1;
	private int y = 1;
	private int d = 1;
	private int a = 1;
	private int u = 1;
	private int s = 1;
	private int i = 0;
	private int l = 0;
	private int score = 0;
	
	private Thread thread;
	private Actor actor;
	private Menu menu;
	private Board board;
	private Map map;
	private Food food;
	private Enemy enemy;
	private Controller controller;	
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage background = null;
	
	public static enum STATE {
		MENU,
		GAME
	};
	
	public static enum FOOD {
		YES,
		NO
	};
	
	public static STATE State = STATE.MENU;
	
	public void init() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			background = loader.loadImage("/menu1.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		menu = new Menu();
		board = new Board();
		actor = new Actor();
		map = new Map();
		food = new Food();
		controller = new Controller(this);
		
		enemy = new Enemy();
		
		this.addMouseListener(new MouseInput());
		
		for(int y = 0; y < 16; y++) {
			for(int x = 0; x < 16; x++) {
					if(map.getMap(x , y).equals("g")){

					}
			}
		}
		
	}
	
	public Game() {
		
		Dimension dimension = new Dimension(Game.WIDTH, Game.HEIGHT);
		
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		
		addKeyListener(this);
		
	}
	
	public synchronized void start() {
		
		if(isRunning) return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		
		if(!isRunning) return;
		isRunning = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void tick() {
		if(State == STATE.GAME) {

		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		if(State == STATE.GAME) {
			board.paint(g);
			controller.render(g);
			
			for(int y = 0; y < 16; y++) {
				for(int x = 0; x < 16; x++) {
			
						if(map.getMap(x , y).equals("g")){	

							g.setColor(Color.LIGHT_GRAY);
							g.fillOval(x * 32 + 15, y * 32 + 15, 4, 4);
						}
						
						if(actor.getTileX() == food.getTileX() && actor.getTileY() == food.getTileY()) {
							if(map.getMap(x , y).equals("g")){

									food.render(g);

								}
						}
						
				}
			}
					
								if(actor.lastDir == 1) {
									for(l = 0; l < d; l++) {
										g.fillOval((food.getTileX() - l) * 32 + 15, food.getTileY() * 32 + 15, 4, 4);
										g.setColor(Color.WHITE);
									}
								}
							
								if(actor.lastDir == -1) {
									for(l = 0; l < a; l++) {
										g.fillOval((food.getTileX() + l) * 32 + 15, food.getTileY() * 32 + 15, 4, 4);
										g.setColor(Color.WHITE);
									}
								}
								
								if(actor.lastDir == 2) {
									for(l = 0; l < u; l++) {
										g.fillOval(food.getTileX() * 32 + 15, (food.getTileY() + 1) * 32 + 15, 4, 4);
										g.setColor(Color.WHITE);
									}
								}
								if(actor.lastDir == -2) {
									for(l = 0; l < s; l++) {
										g.fillOval(food.getTileX() * 32 + 15, (food.getTileY() - 1) * 32 + 15, 4, 4);
										g.setColor(Color.WHITE);
									}
								}
			
			actor.render(g);
			enemy.render(g);
			
			
		} else if(State == STATE.MENU) {
			g.drawImage(background.getScaledInstance(WIDTH, -1, Image.SCALE_SMOOTH), 0, 0, null);
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		
		init();
		music();
		
		
		int fps = 0;
		double timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double targetTick = 60.0;
		double delta = 0;
		double ns = 1000000000 / targetTick;
		
		while(isRunning) {
			
			long now = System.nanoTime();
			delta +=(now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				render();
				fps++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				fps = 0;
				timer+=1000;
			}
	
		}
		
		stop();
	}
	

	public static void music() {
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop = null;
		
		try {
			BGM = new AudioStream(new FileInputStream("music/summer1.wav"));
			AudioPlayer.player.start(BGM);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(State == STATE.GAME) {
			MGP.start(loop);
		} else {
			MGP.stop(loop);
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.setTitle(Game.TITLE);
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		game.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(State == STATE.GAME) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				actor.lastDir = 1;
				if(!map.getMap(actor.getTileX() + 1, actor.getTileY()).equals("w")) {
					actor.move(1, 0);
					food.move(1, 0);
					d++;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				actor.lastDir = -1;
				if(!map.getMap(actor.getTileX() - 1, actor.getTileY()).equals("w")) {
					actor.move(-1, 0);
					food.move(-1, 0);
					a++;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				actor.lastDir = 2;
				if(!map.getMap(actor.getTileX(), actor.getTileY() - 1).equals("w")) {
					actor.move(0, -1);
					food.move(0, -1);
					u++;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				actor.lastDir = -2;
				if(!map.getMap(actor.getTileX(), actor.getTileY() + 1).equals("w")) {
					actor.move(0, 1);
					food.move(0, 1);
					s++;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
