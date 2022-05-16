package misc;

public class Stats {
	private double sum;
	private int[] xs;
	private int[] ys;
	
	public Stats(int[] xs, int[] ys) {
		this.xs = xs;
		this.ys = ys;
		this.sum = 0;
	}
	
	public void Calculate() {
		double sum_a = 0;
	    for(int i=0; i<xs.length; i++) {
	    	for(int j=0; j<ys.length; j++) {
	    		sum_a += Math.pow(xs[i], ys[j]);
		    }
	    }
	    synchronized(this) {
	    	sum+=sum_a;
	    }
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int[] getXs() {
		return xs;
	}

	public void setXs(int[] xs) {
		this.xs = xs;
	}

	public int[] getYs() {
		return ys;
	}

	public void setYs(int[] ys) {
		this.ys = ys;
	}
}
