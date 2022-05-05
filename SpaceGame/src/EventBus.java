import java.util.ArrayList;
import java.util.List;

public class EventBus {

	private static EventBus instance = new EventBus();

	public static EventBus getInstance() {
		return instance;
	}

	private List<Handler> handlers;

	private EventBus() {
		this.handlers = new ArrayList<Handler>();
	}

	public void send(Event e) {
		for (int i = 0; i < this.handlers.size(); i++) {
			Handler h = this.handlers.get(i);
			h.handle(e);

		}
	}

	public void addHandler(Handler h) {
		this.handlers.add(h);
	}
}
