import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Game implements ApplicationListener, Handler {

	private SpriteBatch batch;
	private EntityManager entityManager;
	private ScrollingBackground background;
	private ScrollingBackground background2;
	private ScrollingBackground background3;

	@Override
	public void handle(Event e) {

		if (e.getId() == Event.PLAYER_FIRED) {
			Entity owner = e.getOwner();
			this.entityManager.createBullet(owner.getX(), owner.getY());
		}

	}

	@Override
	public void create() {
		Gdx.gl20.glClearColor(0.1f, 0.1f, 0.4f, 1f);

		this.batch = new SpriteBatch();
		this.entityManager = new EntityManager();
		this.entityManager.createPlayer();
		this.background = new ScrollingBackground(6f, new Texture("resources/layer0.png"));
		this.background2 = new ScrollingBackground(5f, new Texture("resources/layer1.png"));
		this.background3 = new ScrollingBackground(3f, new Texture("resources/layer2.png"));
		EventBus.getInstance().addHandler(this);

	}

	@Override
	public void dispose() {

		this.entityManager.dispose();
		this.batch.dispose();

	}

	@Override
	public void pause() {

	}

	float timp = 0;

	@Override

	public void render() {
		timp += Gdx.graphics.getDeltaTime();

		if (timp > 2) {
			this.entityManager.createEnemy();
			timp = 0;
		}

		this.entityManager.update();

		this.background.update();
		this.background2.update();
		this.background3.update();

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();

		this.background.render(batch);
		this.background2.render(batch);
		this.background3.render(batch);

		this.entityManager.render(batch);
		this.batch.end();

	}

	@Override
	public void resize(int arg0, int arg1) {

	}

	@Override
	public void resume() {

	}

}
