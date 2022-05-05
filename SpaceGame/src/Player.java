
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Entity {

	private EntityManager em;

	public Player(EntityManager em) {
		this.texture = new Texture("resources/player.png");
		this.em = em;
		this.bounds = new Rectangle();
		this.bounds.setWidth(texture.getWidth());
		this.bounds.setHeight(texture.getHeight());
	}

	public void update() {
		this.x = Gdx.input.getX();
		this.y = Gdx.graphics.getHeight() - Gdx.input.getY();
		this.bounds.setCenter(x, y);

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			EventBus.getInstance().send(new Event(Event.PLAYER_FIRED, this, null));
		}

		List<Entity> allEntities = this.em.getEntities();

		for (int i = 0; i < allEntities.size(); i++) {
			Entity other = allEntities.get(i);
			if (other instanceof Enemy) {
				if (this.collidesWith(other)) {
					EventBus.getInstance().send(new Event(Event.PLAYER_HIT_ENEMY, this, null));
					EventBus.getInstance().send(new Event(Event.ENEMY_HIT_PLAYER, other, null));
					System.out.println("Ouch!!");

				}
			}
		}

	}

}
