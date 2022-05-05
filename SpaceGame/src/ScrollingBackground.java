import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {

	private float speed;
	private Texture background;
	private float scrollY;

	public ScrollingBackground(float speed, Texture background) {
		this.speed = speed;
		this.background = background;
	}

	public void update() {
		this.scrollY -= this.speed;
		if (scrollY < -this.background.getHeight()) {
			scrollY = 0;
		}

	}

	public void render(SpriteBatch sb) {
		sb.draw(background, 0, scrollY + this.background.getHeight());

		sb.draw(background, 0, scrollY);

	}

}
