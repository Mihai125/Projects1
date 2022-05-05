import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {

	float frameTime;
	float timerPerFrame;
	TextureRegion[] animation;
	int currentFrame;
	boolean done;
	float positionX;
	float positionY;

	public Animation(float timerPerFrame, int frameSize, Texture spriteSheet) {
		this.currentFrame = 0;
		this.timerPerFrame = timerPerFrame;
		this.frameTime = 0;
		this.done = false;

	}

	public void update() {
		if (done) {
			return;
		}
		frameTime += Gdx.graphics.getDeltaTime();
		if (frameTime > timerPerFrame) {
			frameTime = 0;
			currentFrame++;
			if (currentFrame >= this.animation.length - 1) { // cand am ajuns la ultimul cadru ne oprim
				done = true;
			}
		}
	}

	public void render(SpriteBatch sb, float x, float y) {
	//	sb.draw(this.frame[currentFrame], x, y);
	}

	public boolean isDone() {
		return this.done;
	}
}