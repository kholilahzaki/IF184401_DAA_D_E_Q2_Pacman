import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.midi.SysexMessage;
import javax.swing.JButton;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx= e.getX();
		int my = e.getY();
		
		//Play Button
		if(mx >= Game.WIDTH / 7 + 150 && mx <= Game.WIDTH / 7 + 250) {
			if (my >= 170 && my <= 220) {
				Game.State = Game.STATE.GAME;
			}
		}
		
		//Quit Button
				if(mx >= Game.WIDTH / 7 + 150 && mx <= Game.WIDTH / 7 + 250) {
					if (my >= 370 && my <= 420) {
						System.exit(1);
					}
				}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
