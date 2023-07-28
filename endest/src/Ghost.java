import java.io.IOException;
import java.util.Random;

public class Ghost extends BaseCharacter {
	String rightSprite = fileLocation.substring(0, fileLocation.indexOf('-') + 1) + "sag.png";
	String upSprite = fileLocation.substring(0, fileLocation.indexOf('-') + 1) + "yukarý.png";
	String downSprite = fileLocation.substring(0, fileLocation.indexOf('-') + 1) + "asagi.png";
	String leftSprite = fileLocation.substring(0, fileLocation.indexOf('-') + 1) + "sol.png";

	public Ghost(String fileLocation, int x, int y) {
		super(fileLocation, x, y);
		randomDirection();
	}

	Random r = new Random();

	@Override
	public void headDOWN() {
		super.headDOWN();
		try {
			setSprite(downSprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void headUP() {
		super.headUP();
		try {
			setSprite(upSprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void headLEFT() {
		super.headLEFT();
		try {
			setSprite(leftSprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void headRIGHT() {
		super.headRIGHT();
		try {
			setSprite(rightSprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limitBorders() {
		if (xcor < 0) {
			xcor = 0;
			randomDirection();
		}
		if (xcor > 768 - 48) {
			xcor = 768 - 48;
			randomDirection();
		}
		if (ycor < 0) {
			ycor = 0;
			randomDirection();
		}
		if (ycor > 480) {
			ycor = 480;
			randomDirection();
		}
	}

	public void crash(int[] x, int[] y) {
		

		for (int i = 0; i < x.length; i++) {
			if (y[i] - ycor == -48 && x[i] == xcor && headingUp) {
				wallUp = true;
				charSpeedY = 0;
				randomDirection();
			}
			  if (y[i] - ycor == 48 && x[i] == xcor && headingDown) {
				wallDown = true;
				charSpeedY = 0;
				randomDirection();
			}  if (x[i] - xcor == 48 && y[i] == ycor && headingRight) {
				wallRight = true;
				charSpeedX = 0;
				randomDirection();
			}  if (x[i] - xcor == -48 && y[i] == ycor && headingLeft) {
				wallLeft = true;
				charSpeedX = 0;
				randomDirection();
			}
			

		}
		resetWallStatus();
	}
	
		
	public void randomDirection() {

		int key = (int) (r.nextFloat() * 4);

		if (!wallDown&&key==0) {
			headDOWN();
		}  if (!wallUp&&key==1) {
			headUP();
		}  if (!wallLeft&&key==2 ) {
			headLEFT();
		}  if (!wallRight && key==3) {
			headRIGHT();
		}
			
		}

	

}
