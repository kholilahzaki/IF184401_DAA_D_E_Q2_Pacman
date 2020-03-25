import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Map {

	private Scanner m;
	private String Map[] = new String[16];
	private Image ice, ground;
	
	public Map() {
		
		ImageIcon img = new ImageIcon("images/miniice.png");
		ice = img.getImage();
		img = new ImageIcon("images/iceice1.png");
		ground = img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getIce() {
		return ice;
	}
	
	public Image getGround() {
		return ground;
	}
	
	public String getMap(int x, int y) {
		String index = Map[y].substring(x , x + 1);
		return index;
	}
	
	private void openFile() {
		
		try {
			m = new Scanner(new File("images/map.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error Loading Map");
			e.printStackTrace();
		}
	}

	private void readFile() {
		while(m.hasNext()) {
			for(int i = 0; i < 16; i++) {
				Map[i] = m.next();	
			}
		}
	}
	
	private void closeFile() {
		
	}
	
}
