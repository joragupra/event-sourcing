import java.util.Date;

public class LoadEvent extends DomainEvent {
	
	private Cargo cargo;

	private Ship ship;

	public LoadEvent(Date occurred, Cargo cargo, Ship ship) {
		super(occurred);
		this.ship = ship;
		this.cargo = cargo;
	}

	public void process() {
		ship.handleLoad(this);
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public Ship getShip() {
		return this.ship;
	}

}