
public class Rabbit {
private Integer[][] r;
private int n;

	public Rabbit(int n) {
		this.n = n;
	    this.r = new Integer[n][n];
	}

	public void init() {
		if(n >= 2) {
			r[0] = new Integer[] {1};
			r[1] = new Integer[] {1,0};
		}
	}

	public String toString() {	
	      String result = null;
	      for(int i = 0; i < r.length; i++) {
		  result += r[i].toString() + "\n";
	}
	      return result;
	}
	
	public int subsequenceIndex(Integer[] target) {
		return -1;
	}

	public static void main(String[] args) {
		
	}

}
