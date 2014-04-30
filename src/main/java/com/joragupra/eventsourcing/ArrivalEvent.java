import java.util.Date;

public class ArrivalEvent extends DomainEvent {

	private Port port;

	private Ship ship;

	public ArrivalEvent(Date occurred, Port to, Ship who) {
		super(occurred);
		this.port = to;
		this.ship = who;
	}

	public Port getPort() {
		return this.port;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void process() {
		ship.handleArrival(this);
	}

}