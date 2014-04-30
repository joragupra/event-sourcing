import java.util.Date;

public abstract class DomainEvent {
	
	private Date recorded;

	private Date occurred;

	public DomainEvent(Date occurred) {
		this.occurred = occurred;
		this.recorded = new Date();
	}

	public abstract void process();

	public Date getRecorded() {
		return this.recorded;
	}

	public Date getOccurred() {
		return this.occurred;
	}
	
}