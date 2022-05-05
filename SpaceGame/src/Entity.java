import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
	protected float x;
	protected float y;
	protected Rectangle bounds;
	protected Texture texture;

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean collidesWith(Entity other) {

		return this.bounds.overlaps(other.bounds);
	}

	public abstract void update();

	public void render(SpriteBatch sb) {
		sb.draw(this.texture, x - this.texture.getWidth() / 2, y - this.texture.getHeight() / 2);
	}

	public void dispose() {
		this.texture.dispose();
	}

}
