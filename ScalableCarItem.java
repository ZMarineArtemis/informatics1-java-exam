
public class ScalableCarItem extends CarItem {
   
	private double scaledPrice;
	private int sales;
	
	public ScalableCarItem(String brand, String model, double price ) {
	super(brand, model, price);
	this.sales = 0;
	this.scaledPrice = price;
	}

	public double getPrice() {
		super.getPrice();
		return scaledPrice;
	}
	
	public void updateSales(int i) {
		if(i < 0) {
			throw new IllegalArgumentException("must be positive");
		}else {
	          sales += i;
	          scaledPrice = Math.round(price + sales * 0.01 * price);
			}
		}
	
	public String toString() {
		String result = super.toString() + "\n";
		result += "sales: " + sales + "\n";
		result += "scaled price: " + scaledPrice + "GBP \n";
		return result;
	}
	

}
