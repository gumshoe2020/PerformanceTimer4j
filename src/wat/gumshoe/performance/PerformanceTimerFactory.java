package wat.gumshoe.performance;

public final class PerformanceTimerFactory {

	private PerformanceTimerFactory(){}
	
	public static PerformanceTimer create(){
		return new PerformanceTimer(0, true, 0);
	}
	
}
