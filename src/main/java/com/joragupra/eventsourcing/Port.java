public class Port {
	
	private Country country;

	private String name;

	public Port(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public Country getCountry() {
		return this.country;
	}

	public String getName() {
		return this.name;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Port)) return false;
		Port that = (Port) obj;
		return this.name == that.name && this.country == that.country;
	}

	public String toString() {
		return name + "[" + country + "]";
	}

	public static final Port AT_SEA = new Port("At Sea", Country.NONE);

}