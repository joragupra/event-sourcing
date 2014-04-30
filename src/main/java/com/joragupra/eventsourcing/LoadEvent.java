import java.util.Date;

public class LoadEvent extends DomainEvent {
	
	private Cargo cargo;

	private Ship ship;

	private Port priorPort;

	public LoadEvent(Date occurred, Cargo cargo, Ship ship) {
		super(occurred);
		this.ship = ship;
		this.cargo = cargo;
	}

	public void process() {
		cargo.handleLoad(this);
	}

	public void reverse() {
		cargo.reverseLoad(this);
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public Ship getShip() {
		return this.ship;
	}

	public Port getPriorPort() {
		return this.priorPort;
	}

	public void setPriorPort(Port port) {
		this.priorPort = port;
	}

}