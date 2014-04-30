import java.util.Date;

public class UnloadEvent extends DomainEvent {
	
	private Cargo cargo;

	private Ship ship;

	public UnloadEvent(Date occurred, Cargo cargo, Ship ship) {
		super(occurred);
		this.ship = ship;
		this.cargo = cargo;
	}

	public void process() {
		ship.handleUnload(this);
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public Ship getShip() {
		return this.ship;
	}
}