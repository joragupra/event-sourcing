import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ArrivalEvent extends DomainEvent {

	private Port port;

	private Ship ship;

	private Port priorPort;

	private Map<Cargo, Boolean> priorCargoInCanada = new HashMap<>();

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

	public void reverse() {

	}

	public Port getPriorPort() {
		return this.priorPort;
	}

	public void setPriorPort(Port port) {
		this.priorPort = port;
	}

	public boolean priorCargoInCanada(Cargo cargo) {
		return this.priorCargoInCanada.containsKey(cargo) ? this.priorCargoInCanada.get(cargo) : false;
	}

	public void priorCargoInCanada(Cargo cargo, boolean hasBeenInCanada) {
		this.priorCargoInCanada.put(cargo, hasBeenInCanada);
	}

}