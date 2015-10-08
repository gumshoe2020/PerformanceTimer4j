package wat.gumshoe.test;

import wat.gumshoe.performance.PerformanceTimer;
import wat.gumshoe.performance.PerformanceTimerFactory;

public class Test {

	public static void main(String[] args) throws Exception{
		PerformanceTimer pft = PerformanceTimerFactory.create();
		pft.mark().s0();
	}
	
}
