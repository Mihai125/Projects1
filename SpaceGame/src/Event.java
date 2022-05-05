
public class Event {

	public static final int PLAYER_FIRED = 0;
	public static final int PLAYER_HIT_ENEMY = 1;
	public static final int ENEMY_HIT_PLAYER = 2;
	public static final int REMOVE_ENTITY = 3;
	public static final int PLAYER_FIRE = 4;

	private Entity owner;
	private Entity other;
	private int id;

	public Event(int id, Entity owner, Entity other) {

		this.owner = owner;
		this.other = other;
		this.id = id;
	}

	public Entity getOther() {
		return other;
	}

	public Entity getOwner() {
		return owner;
	}

	public int getId() {
		return id;
	}
}
