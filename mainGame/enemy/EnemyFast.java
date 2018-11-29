package mainGame.enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import mainGame.*;
import mainGame.gfx.*;

/**
 * A type of enemy in the game
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class EnemyFast extends GameObject {

	private Handler handler;

	public EnemyFast(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = 2;
		velY = 9;
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;

		if (this.y <= 0 || this.y >= Game.HEIGHT - 11) {
			velY *= -1;
		}
		if (this.x <= 0 || this.x >= Game.WIDTH - 11) {
			velX *= -1;
		}

		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 11, 11, 0.025, this.handler));

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int) x, (int) y, 11, 11);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) this.x, (int) this.y, 11, 11);
	}

}
