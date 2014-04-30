import java.util.Date;

public class CustomsEventGateway {
	
	private EventProcessor processor;

	public void notify(Date arrivalDate, Ship ship, Port port) {
		if (processor.isActive()) {
			sendToCustoms(arrivalDate, ship, port);
		}
	}

	private void sendToCustoms(Date arrivalDate, Ship ship, Port port) {
		//TODO - call some external logic
	}
}