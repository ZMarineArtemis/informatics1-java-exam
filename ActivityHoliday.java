import java.util.HashMap;

public class ActivityHoliday extends Holiday{
    private  HashMap<String, Cost> activites;
    
	public ActivityHoliday(String destination, int days) {
		super(destination, days);
	    this.activites = new HashMap<String, Cost>(10);
	}

	public void addActivity(String name, Cost cost) {
		  activites.put(name, cost);
	}
	
	public String toString() {
		String output = super.toString() + "\n";
		output += "Activities: \n";
		for(int i = 0; i < activites.size(); i++) {
			output += activites.keySet().toArray()[i] + " " + activites.get(activites.keySet().toArray()[i]) + "\n";
		}
		return output;
	}
}
