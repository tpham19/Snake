import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Token {

	private int x, y, score;
	private Snake snake;
	private Random rand = new Random();

	public Token(Snake s) {
		x = rand.nextInt(395); // Token is 6 by 6
		y = rand.nextInt(395);
		snake = s;
	}

	public void changePosition() {
		x = rand.nextInt(395);
		y = rand.nextInt(395);
	}

	public int getScore() {
		return score;
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 6, 6);
	}

	public boolean snakeCollision() {
		int snakeX = snake.getX() + 2; // Center of the head
		int snakeY = snake.getY() + 2;
		if (snakeX >= x - 1 && snakeX <= (x + 7)) {
			if (snakeY >= y - 1 && snakeY <= (y + 7)) {
				changePosition();
				score++;
				snake.setElongate(true);
				return true;
			}
		}
		return false;
	}
}