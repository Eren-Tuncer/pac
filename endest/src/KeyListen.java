import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyListen implements KeyListener {

	boolean up, down, right, left;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			down = true;
			left = false;
			right = false;
			up = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			right = true;
			down = false;
			left = false;
			up = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			left = true;
			right = false;
			up = false;
			down = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			// up = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			// down = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			// right = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			// left = false;
		}

	}

}
