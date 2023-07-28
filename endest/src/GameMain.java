import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("PACMAN");
		ImageIcon img = new ImageIcon("./sprites/pagging.gif");
		window.setIconImage(img.getImage());

		Panel gamePanel = new Panel();

		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.startGameThread();
	}

}