
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel implements Runnable {
	int[] wallX = { 96, 144, 192, 96, 144, 144, 144, 144, 336, 336, 288, 384, 480, 480, 624, 624, 576, 576, 624, 672,
			720 };
	int[] wallY = { 48, 48, 48, 336, 336, 384, 432, 480, 192, 288, 240, 240, 48, 96, 48, 96, 336, 384, 336, 336, 336,
			336 };
	int[] pelletX = { 24, 72, 120, 168, 216, 264, 312, 360, 408, 456, 504, 552, 600, 648, 696, 744, 24, 72, 264, 312,
			360, 408, 456, 552, 600, 696, 744, 24, 72, 120, 168, 216, 264, 312, 360, 408, 456, 552, 600, 696, 744, 24,
			72, 120, 168, 216, 264, 312, 360, 408, 456, 504, 552, 600, 648, 696, 744, 24, 72, 120, 168, 216, 264, 312,
			408, 456, 504, 552, 600, 648, 696, 744, 24, 72, 120, 168, 216, 264, 456, 504, 552, 600, 648, 696, 744, 24,
			72, 120, 168, 216, 264, 312, 408, 456, 504, 552, 600, 648, 696, 744, 24, 72, 216, 264, 312, 360, 408, 456,
			504, 552, 24, 72, 120, 216, 264, 312, 360, 408, 456, 504, 552, 648, 696, 744, 24, 72, 120, 216, 264, 312,
			360, 408, 456, 504, 552, 600, 648, 696, 744, 24, 72, 120, 216, 264, 312, 360, 408, 456, 504, 552, 600, 648,
			696, 744, };

	int[] pelletY = { 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 72, 72, 72, 72, 72, 72, 72, 72,
			72, 72, 72, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 168, 168, 168, 168, 168,
			168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 216, 216, 216, 216, 216, 216, 216, 216, 216, 216,
			216, 216, 216, 216, 216, 264, 264, 264, 264, 264, 264, 264, 264, 264, 264, 264, 264, 264, 312, 312, 312,
			312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 360, 360, 360, 360, 360, 360, 360, 360, 360,
			360, 408, 408, 408, 408, 408, 408, 408, 408, 408, 408, 408, 408, 408, 408, 456, 456, 456, 456, 456, 456,
			456, 456, 456, 456, 456, 456, 456, 456, 456, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504,
			504, 504, 504, };

	boolean[] pelletStatus = { false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false };

	final int W = 10 * pelletStatus.length;
	final String GhostRed = "./sprites/kırmızı-sag.png";
	final String win = "./sprites/youve_won.png";
	final String GhostOrange = "./sprites/turuncu-sag.png";
	final String GhostBlue = "./sprites/mavi-sag.png";
	final String GhostPink = "./sprites/pembe-sag.png";
	final String PacMan = "./sprites/pagging.gif";// gif algilama koncak pacman classi bozulabilir ama
	final String yem = "./sprites/yem.png";
	final String yendi = "./sprites/yemyendi.png";
	final String map = "./sprites/haritason.png";
	final String mapHealth2 = "./sprites/harita2.png";
	final String mapHealth1 = "./sprites/harita1.png";
	final String ending = "./sprites/game over.png";
	final int tileSize = 48;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	int pacmanX = 96, pacmanY = 96;
	int pacmanSpeed = 2;
	int timer = 0, lives = 3;
	KeyListen keyL = new KeyListen();
	Ghost HayaletK = new Ghost(GhostRed, 48, 336);
	Ghost HayaletM = new Ghost(GhostBlue, 96, 192);
	Ghost HayaletT = new Ghost(GhostOrange, 672, 240);
	Ghost HayaletP = new Ghost(GhostPink, 528, 432);
	Ghost[] hayaletListesi = { HayaletK, HayaletM, HayaletP, HayaletT };
	Pacman pag = new Pacman(PacMan, pacmanX, pacmanY, pacmanSpeed);
	public int score = 0;
	BufferedImage pt, won, end;
	BufferedImage ptE;

	BaseCharacter harita = new BaseCharacter(map, 0, 0);

	Thread gameThread;

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}

	public Panel() {
		try {
			won = ImageIO.read(new File(win));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyL);
		this.setFocusable(true);

	}

	public void waitFrames() {

		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		while (gameThread != null) {

			if (score == W) {
			}
			try {
				pt = ImageIO.read(new File(yem));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ptE = ImageIO.read(new File(yendi));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			update();

			waitFrames();
			pag.move();
			for (int i = 0; i < pelletX.length; i++) {

				if (pag.eaten(pelletX, pelletY, i)) {
					if (pelletStatus[i] == true) {
					} else {
						score += 10;
						try {
							pt = ImageIO.read(new File(yendi));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					pelletStatus[i] = true;

				}
			}

			for (Ghost h : hayaletListesi) {
				h.crash(wallX, wallY);
				h.limitBorders();
				h.crash(wallX, wallY);
				h.move();
				if (h.distance(pag.getXcor() + 24, pag.getYcor() + 24) < 40) {
					lives--;
					if (lives == 2) {
						try {
							harita.setSprite(mapHealth2);
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else if (lives == 1) {
						try {
							harita.setSprite(mapHealth1);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						pt = ImageIO.read(new File(yem));
					} catch (IOException e) {
						e.printStackTrace();
					}

					for (int i = 0; i < pelletStatus.length; i++) {
						pelletStatus[i] = false;
					}

					pag.setXcor(96);

					pag.setYcor(96);
					score = 0;
					h.randomDirection();

					HayaletK.setCoor(48, 336);
					HayaletM.setCoor(96, 192);
					HayaletT.setCoor(672, 240);
					HayaletP.setCoor(528, 432);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			if (!pag.wallDown && keyL.down && pag.xcor % 48 == 0) {
				pag.headDOWN();
			} else if (!pag.wallUp && keyL.up && pag.xcor % 48 == 0) {
				pag.headUP();
			} else if (!pag.wallLeft && keyL.left && pag.ycor % 48 == 0) {
				pag.headLEFT();
			} else if (!pag.wallRight && keyL.right && pag.ycor % 48 == 0) {
				pag.headRIGHT();
			} else
				pag.resetWallStatus();

			pag.crash(wallX, wallY);

			repaint();
			if (lives == 0) {

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reset();
			}
			if (score == W) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reset();

			}

		}

	}

	public void update() {

	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(harita.getSprite(), null, 0, 0);

		for (int i = 0; i < pelletX.length; i++) {
			if (pelletStatus[i]) {
				g2D.drawImage(ptE, null, pelletX[i], pelletY[i]);
			} else {
				g2D.drawImage(pt, null, pelletX[i], pelletY[i]);
			}
		}

		for (Ghost h : hayaletListesi)
			g2D.drawImage(h.getSprite(), null, h.getXcor(), h.getYcor());
		String gg = "GAME OVER";
		String w = "YOU WIN!!";
		g2D.setFont(new Font("Courier", Font.BOLD, 36));
		g2D.setColor(Color.white);
		g2D.drawString("SCORE:", 404, 565);

		g2D.setColor(Color.red);
		g2D.drawString(Integer.toString(score), 600, 565);
		g2D.drawImage(pag.getSprite(), null, pag.getXcor(), pag.getYcor());
		if (lives == 0) {
			g2D.setFont(new Font("Courier", Font.BOLD, 120));
			g2D.setColor(Color.red);
			g2D.drawString(gg, 25, 315);

		}

		if (score == W) {

			g2D.setFont(new Font("Courier", Font.BOLD, 120));
			g2D.setColor(Color.yellow);
			g2D.drawString(w, 24, 300);

		}

		g2D.dispose();

	}

	public void reset() {
		if (lives == 0) {
			try {
				harita.setSprite(map);
			} catch (IOException e) {
				e.printStackTrace();
			}
			score = 0;
			lives = 3;
		}

		else if (score == W) {
			score = 0;

			for (int i = 0; i < pelletStatus.length; i++) {
				pelletStatus[i] = false;
			}

			pag.setCoor(96, 96);

			HayaletK.setCoor(48, 336);
			HayaletM.setCoor(96, 192);
			HayaletT.setCoor(672, 240);
			HayaletP.setCoor(528, 432);

		}

	}

}