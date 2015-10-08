# PerformanceTimer4j
No license.  Do anything you want with this, or not.  It is my fiddling.  No functionality is guaranteed.  
# Use at your own risk.

The purpose of this project is to provide a simple, stupid, trivial to use performance timing library for quickly characterizing code performance using a timer mark system utilizing the System.nanoTime().

Primary Files:
PerformanceTimer - The actual timer object that will track times between specific marker flags.
PerformanceTimerFactory - Spits out new PerformanceTimers.

PerformanceTimer pft = new PerformanceTimerFactory().createPfTimer().set(<parameter>)...

Use:
pft.mark() for a straight linear timer in a synchronized code.

Use:
pft.fork(0).mark() for multithreaded processes or specific logic forks.

Use:
pft.report() to get a JSON formatted string of the data collected.

Uses Gson.  It is included.
