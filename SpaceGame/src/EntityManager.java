import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityManager {

	private List<Entity> entities;
	private List<Entity> toBeAdded;
	private List<Entity> entitiesToRemove;

	public EntityManager() {
		this.entities = new ArrayList<Entity>();
		this.toBeAdded = new ArrayList<Entity>();
		this.entitiesToRemove = new ArrayList<Entity>();
	}

	public void createPlayer() {
		Player p = new Player(this);
		this.toBeAdded.add(p);
	}

	public void createBullet(float x, float y) {
		Bullet b = new Bullet(x - 25, y + 60, this);
		Bullet c = new Bullet(x + 25, y + 60, this);
		this.toBeAdded.add(b);
		this.toBeAdded.add(c);

	}

	public void createEnemy() {
		Enemy e = new Enemy(this);
		this.toBeAdded.add(e);
	}

	public void update() {
		this.entities.addAll(this.toBeAdded);
		this.toBeAdded.clear();

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}

		this.entities.removeAll(this.entitiesToRemove);
		for (int i = 0; i < this.entitiesToRemove.size(); i++) {
			this.entitiesToRemove.get(i).dispose();
		}

		this.entitiesToRemove.clear();
		 System.out.println(entities.size());
	}

	public void render(SpriteBatch sb) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(sb);
		}
	}

	public void dispose() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).dispose();
		}
		this.entities.clear();

	}

	public void remove(Entity e) {

		this.entitiesToRemove.add(e);

	}

	public List<Entity> getEntities() {
		return this.entities;
	}

}
