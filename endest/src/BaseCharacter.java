import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseCharacter {
	protected String fileLocation;
	protected BufferedImage sprite;
	protected int xcor;
	protected int ycor;
	protected boolean headingRight = true, headingLeft, headingDown, headingUp;
	protected int speed = 2;
	protected int charSpeedX = speed, charSpeedY = 0;
	protected boolean wallUp, wallDown, wallLeft, wallRight;

	public BaseCharacter(String fileLocation, int x, int y) {
		this.fileLocation = fileLocation;
		this.xcor = x;
		this.ycor = y;
		try {
			sprite = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void resetWallStatus() {
		wallUp = false;
		wallDown = false;
		wallLeft = false;
		wallRight = false;
	}

	public BaseCharacter(String fileLocation, int x, int y, int speed) {
		this.speed = speed;
		this.xcor = x;
		this.ycor = y;
		try {
			sprite = ImageIO.read(new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.speed = speed;
		charSpeedX = speed;

	}

	public void move() {

		xcor += charSpeedX;
		ycor += charSpeedY;

	}

	public void headRIGHT() {
		charSpeedX = speed;
		charSpeedY = 0;
		headingRight = true;
		headingDown = false;
		headingUp = false;
		headingLeft = false;
	}

	public void headUP() {
		charSpeedX = 0;
		charSpeedY = -speed;
		headingUp = true;
		headingDown = false;
		headingRight = false;
		headingLeft = false;
	}

	public void headLEFT() {
		charSpeedX = -speed;
		charSpeedY = 0;
		headingLeft = true;
		headingDown = false;
		headingUp = false;
		headingRight = false;
	}

	public void headDOWN() {
		charSpeedX = 0;
		charSpeedY = speed;
		headingDown = true;
		headingUp = false;
		headingRight = false;
		headingLeft = false;
	}

	public int getXcor() {
		return xcor;
	}

	public void setXcor(int xcor) {
		this.xcor = xcor;
	}

	public int getYcor() {
		return ycor;
	}
	public void setCoor(int xcor,int ycor) {

		this.xcor = xcor;
		this.ycor = ycor;

	}
	public void setYcor(int ycor) {
		this.ycor = ycor;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public void stop() {
		charSpeedX = 0;
		charSpeedY = 0;
		headingDown = false;
		headingUp = false;
		headingRight = false;
		headingLeft = false;
	}

	public void setSprite(String file) throws IOException {
		this.sprite = ImageIO.read(new File(file));
	}

	public double distance(int x, int y) {
		double dst = StrictMath.hypot(StrictMath.abs((xcor+24) - x) , (StrictMath.abs((ycor+24) - y)));
		return dst;
	}
}
