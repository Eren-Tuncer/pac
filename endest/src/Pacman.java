
public class Pacman extends BaseCharacter {

	public Pacman(String fileLocation, int x, int y, int speed) {
		super(fileLocation, x, y, speed);
	}

	// Pacman ayarlari buraya
	public boolean eaten(int[] x, int[] y, int i) {
		int a = i;

		if (this.distance(x[a], y[a]) <20) {

			return true;
		} else {
			return false;
		}

	}

	public void crash(int[] x, int[] y) {
		if (xcor == 0 && headingLeft) {
			charSpeedX = 0;

		}
		if (xcor == 768-48 && headingRight) {
			charSpeedX = 0;

		}
		if (ycor == 0 && headingUp) {
			charSpeedY = 0;

		}
		if (ycor == 576-48-48 && headingDown) {
			charSpeedY = 0;

		}

		for (int i = 0; i < x.length; i++) {

			if (y[i] - ycor == -48 && x[i] == xcor && headingUp) {
				wallUp = true;
				charSpeedY = 0;
			} else if (y[i] - ycor == 48 && x[i] == xcor && headingDown) {
				charSpeedY = 0;
				wallDown = true;
			} else if (x[i] - xcor == 48 && y[i] == ycor && headingRight) {
				charSpeedX = 0;
				wallRight = true;
			} else if (x[i] - xcor == -48 && y[i] == ycor && headingLeft) {
				charSpeedX = 0;
				wallLeft = true;
			}

		}
	}

}
