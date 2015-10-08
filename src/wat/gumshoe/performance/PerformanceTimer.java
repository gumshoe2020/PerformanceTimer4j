package wat.gumshoe.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class PerformanceTimer {
	
	private CopyOnWriteArrayList<PerformanceTimer> multiThreaded = null;
	private List<Long> simple = null;
	private ConcurrentHashMap<String, PerformanceTimer> multiThreadLabelled = null;
	private Map<String, Long> simpleLabel = null;
	private final int depth;
	private final boolean isRoot;
	private final int totalDepth; //2D size
	private boolean multiThreadFlag = false;
	private boolean labelFlag = false;
	private long lastTime;
	
	
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Setup and config methods
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	PerformanceTimer(int dp, boolean isR, int tDp){
		this.depth = dp;
		this.isRoot = isR;
		this.totalDepth = tDp;
		this.check();
	}
	
//	public PerformanceTimer multiThreadSupport(){
//		multiThreadFlag =  true;
//		this.check();
//		multiThreaded = new CopyOnWriteArrayList<PerformanceTimer>();
//		return this;
//	}
	
	public PerformanceTimer initializeSize(int size){
		simple = new ArrayList<Long>(size);
		return this;
	}
	
//	public PerformanceTimer useLabels(){
//		this.labelFlag = true;
//		if(multiThreadFlag) multiThreadLabelled = new ConcurrentHashMap<String, PerformanceTimer>(10, 0.9f, 1);
//		simpleLabel = new HashMap<String, Long>();
//		return this;
//	}
	
	private void check(){
		if(labelFlag){
			if(simpleLabel==null) simpleLabel = new HashMap<String, Long>();
		}
		else {
			if(simple==null) simple = new ArrayList<Long>();
		}
	}
	
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Common Methods
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public int depth(){
		return this.depth;
	}
	
	public int totalDepth(){
		return this.totalDepth;
	}
	
	public boolean isRootPfT(){
		return this.isRoot;
	}
	
	public Marker mark() throws Exception{
		if(!labelFlag){
			if(multiThreadFlag){
				return null;
			} else { // not multithreaded
				simple.add(Math.abs(lastTime - System.nanoTime()));
				lastTime = System.nanoTime();
				return new Marker();
			}
		} else throw new Exception("Cannot call non-label mark on label performance timer.");
	}
	
	public void mark(String label) throws Exception{
		if(labelFlag){
			if(multiThreadFlag){
				
			} else { // not multithreaded
				
			}
		} else throw new Exception("Cannot call label mark on non-label performance timer.");
	}
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Simple Methods
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	
	
	
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Concurrent Methods
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	
	
	
}
