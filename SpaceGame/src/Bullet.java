import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends Entity {

	private EntityManager em;

	public Bullet(float x, float y, EntityManager em) {
		this.texture = new Texture("resources/bullet.png");
		this.x = x;
		this.y = y;
		this.em = em;
		this.bounds = new Rectangle();
		this.bounds.setWidth(texture.getWidth());
		this.bounds.setHeight(texture.getHeight());
	}

	public void update() {
		this.y += 5;
		this.bounds.setCenter(x, y);
		if (y > 800) {
			this.em.remove(this);
		}

		List<Entity> allEntities = this.em.getEntities();

		for (int i = 0; i < allEntities.size(); i++) {
			Entity other = allEntities.get(i);
			if (other instanceof Enemy) {
				if (this.collidesWith(other)) {
					this.em.remove(other);
					this.em.remove(this);

				}
			}
		}

	}

	public float getY() {
		return y;
	}

}