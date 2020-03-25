package id.ac.its.tari.pacman;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class ImportImage {

	protected int x;
	protected int y;
	protected int WIDTH;
	protected int HEIGHT;
	protected boolean visible;
	protected Image image;
	
	public ImportImage(int x, int y) {
		
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	protected void getImageDimensions() {
		
		WIDTH = image.getWidth(null);
		HEIGHT = image.getHeight(null);
	}
	
	protected void loadImage(String imageName) {
		
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

}
