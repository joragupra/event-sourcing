import java.util.Date;

public class Cargo {
	
	private String name;

	private boolean hasBeenInCanada = false;

	private Ship ship;

	private Port port;

	public Cargo(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Port getPort() {
		return this.port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void handleArrival(ArrivalEvent arrivalEvt) {
		arrivalEvt.priorCargoInCanada(this, hasBeenInCanada);
		if (Country.CANADA == arrivalEvt.getPort().getCountry()) {
			this.hasBeenInCanada = true;
		}
	}

	public void reverseArrival(ArrivalEvent arrivalEvt) {
		this.hasBeenInCanada = arrivalEvt.priorCargoInCanada(this);
	}

	public void handleLoad(LoadEvent loadEvt) {
		loadEvt.setPriorPort(this.port);
		this.port = null;
		this.ship = loadEvt.getShip();
		ship.handleLoad(loadEvt);
	}

	public void reverseLoad(LoadEvent loadEvt) {
		ship.reverseLoad(loadEvt);
		this.ship = null;
		port = loadEvt.getPriorPort();
	}

	public boolean hasBeenInCanada() {
		return this.hasBeenInCanada;
	}

}