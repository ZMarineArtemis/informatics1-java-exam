import java.util.HashMap;

public class BonusSeller extends Seller {
private HashMap<String,Double> sales;

	public BonusSeller(String n) {
		super(n);
		int capacity = sales.size();
		capacity = 10;
	}

	public void sale(String name, double number) {
		super.sale(number);
		sales.put(name, number);		
	}

	
	public String toString() {
		String output = super.toString() + "\n";
		output += "Sales per customer: \n";
		for(int i = 0; i < sales.size(); i++) {
		outptut += sales.+ ":" + sales.get(i) + "kg \n";
		}
	}
	
	public int calculateBonus() {
		return 0;
	}

}
