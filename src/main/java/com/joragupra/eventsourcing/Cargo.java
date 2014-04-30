import java.util.Date;

public class Cargo {
	
	private String name;

	private boolean hasBeenInCanada = false;

	public Cargo(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void handleArrival(ArrivalEvent arrivalEvt) {
		if (Country.CANADA == arrivalEvt.getPort().getCountry()) {
			this.hasBeenInCanada = true;
		}
	}

	public boolean hasBeenInCanada() {
		return this.hasBeenInCanada;
	}

}