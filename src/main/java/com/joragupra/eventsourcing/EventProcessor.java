import java.util.ArrayList;
import java.util.List;

public class EventProcessor {

	private List<DomainEvent> log = new ArrayList<>();

	private boolean isActive = false;
	
	public void process(DomainEvent e) {
		isActive = true;
		e.process();
		isActive = false;
		log.add(e);
	}

	public boolean isActive() {
		return this.isActive;
	}
}