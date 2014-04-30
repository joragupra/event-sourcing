import org.junit.Test;
import org.junit.Before;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tester {
	
	private Ship kr;

	private Port sfo, la, yyv;

	private Cargo refact;

	private EventProcessor eProc;

	@Before
	public void setUp() {
		eProc = new EventProcessor();
		refact = new Cargo("Refactoring");
		kr = new Ship("King Roy");
		sfo = new Port("San Francisco", Country.US);
		la = new Port("Los Angeles", Country.US);
		yyv = new Port("Vancouver", Country.CANADA);
	}

	@Test
	public void testArrivalSetsShipsLocaltion() {
		ArrivalEvent ev = new ArrivalEvent(new Date(2005, 11, 1), sfo, kr);
		eProc.process(ev);
		assertEquals(sfo, kr.getPort());
	}

	@Test
	public void testDeparturePutsShipOutToSea() {
		eProc.process(new ArrivalEvent(new Date(2005,10,1), la, kr));
		eProc.process(new ArrivalEvent(new Date(2005,11,1), sfo, kr));
		eProc.process(new DepartureEvent(new Date(2005,11,1), sfo, kr));
		assertEquals(Port.AT_SEA, kr.getPort());    
	}

	@Test
	public void VisitingCanadaMarksCargo() {
		eProc.process(new LoadEvent(new Date(2005,11,1), refact, kr));
		eProc.process(new ArrivalEvent(new Date(2005,11,2), yyv, kr));
		eProc.process(new DepartureEvent(new Date(2005,11,3), yyv, kr ));
		eProc.process(new ArrivalEvent(new Date(2005,11,4), sfo, kr));
		eProc.process(new UnloadEvent(new Date(2005,11,5), refact, kr));
		assertTrue(refact.hasBeenInCanada());
	}

}