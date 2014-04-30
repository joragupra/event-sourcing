import java.util.ArrayList;
import java.util.List;

public class EventProcessor {

	private List<DomainEvent> log = new ArrayList<>();
	
	public void process(DomainEvent e) {
		e.process();
		log.add(e);
	}
}