package misc;

public class StatsMulti extends Thread {
	private Stats stats;
	
	public StatsMulti(String name, ThreadGroup tg, Stats stats) {
		super(tg, name);
		this.stats = stats;
	}
	
	public void run() {
		this.stats.Calculate();
	}
}
