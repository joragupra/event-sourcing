import java.util.Date;

public class DepartureEvent extends DomainEvent {

	private Port port;

	private Ship ship;

	public DepartureEvent(Date occurred, Port to, Ship who) {
		super(occurred);
		this.port = to;
		this.ship = who;
	}
	
	public void process() {
		ship.handleDeparture(this);
	}
}