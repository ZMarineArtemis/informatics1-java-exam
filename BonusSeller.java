import java.util.HashMap;

public class BonusSeller extends Seller {
private HashMap<String,Double> sales;

	public BonusSeller(String n) {
		super(n);
		sales = new HashMap<String, Double> (10);
	}

	public void sale(String name, double number) {
		super.sale(number);
		sales.put(name, number);		
	}

	
	public String toString() {
		String output = super.toString() + "\n";
		output += "Sales per customer: \n";
		for(int i = 0; i < sales.size(); i++) {
		output += sales.keySet().toArray()[i] + ":" + sales.get(i) + "kg \n";
		}
		return output;
	}
	
	public int calculateBonus() {
		int result = -1;
		for(int i = 0; i < sales.size(); i++) {
		if(sales.get(i) < 20) {
			sales.remove(i);
		}
	}
		if(sales.values().size() < 5) {
			result = 0;
		}else if(sales.values().size() < 10 || sales.values().size() >= 5) {
			result = 5;
		}else if(sales.values().size() >= 10) {
			result = 7;
		}
		return result;
	}
}
