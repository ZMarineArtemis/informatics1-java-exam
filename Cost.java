
public class Cost {
      private int amount;
      private String currency;
      public Cost() {
            this.amount = 0;
            this.currency = "pound sterling";
      }

      public void convert(String newCurrency, double rate) {
	         if((newCurrency.equals("US dollars") || newCurrency.equals("euros")) && amount >= 0) {
	        	  currency = newCurrency;
	        	  double tmp = rate * amount;
	        	  amount = Math.getExponent(tmp);
	   	         }
      }
      
      public String toString() {
    	  String result = null;
    	  result = "amount" + " " + currency;
    	  return result;
      }     
}


