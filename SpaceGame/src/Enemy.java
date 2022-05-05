import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends Entity {

	private EntityManager em;

	public Enemy(EntityManager entityManager) {
		this.y = 800;
		this.x = (float) (Math.random() * 600);
		this.texture = new Texture("resources/enemy.png");
		this.em = entityManager;
		this.bounds = new Rectangle();
		this.bounds.setWidth(texture.getWidth());
		this.bounds.setHeight(texture.getHeight());

	}

	@Override
	public void update() {
		this.y -= 5;
		this.bounds.setCenter(x, y);
		if (y < -100) {
			this.em.remove(this);
		}

	}

}
