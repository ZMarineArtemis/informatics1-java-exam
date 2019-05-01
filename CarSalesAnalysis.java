import java.util.Objects;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class CarSalesAnalysis {

    protected static Map<String, Integer> countByBrand(List<CarItem> soldCars) {
       Map<String,Integer> result = new Hashtable<>();
       if(soldCars.isEmpty()) {
    	   return result;
       }else {
    	   for(int i =0; i< soldCars.size(); i++) {
    		   for(int j = 0; j < result.size(); j++) {
    			  if(soldCars.get(i).equals(result.keySet().toArray()[j])) {
    				  result.put(soldCars.get(i).toString(), 1);
    			  }else {
    				  result.replace(soldCars.get(i).toString(),(result.get(soldCars.get(i).toString())+1));
    			  }
    	   }
    	   }
       }
       return result;
        
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a car sales file,"
                    + " e.g. java CarSalesAnalysis ./carSales01.txt");
            System.exit(1);
        }

        System.out.println("\nParsing expense items ...");
	    List<CarItem> carData = CarSalesUtils.readDataFromFile(args[0]);

        System.out.println(carData.size() + " entries found in " + args[0]);
        CarSalesUtils.printCarItemList(carData);

	    System.out.println("\nCounting car sales for each car brand...");
        Map<String, Integer> carCounts = countByBrand(carData);
	    if (!Objects.isNull(carCounts)) {
	    	System.out.println("Car Counts per Brand:\n");
            CarSalesUtils.printCarMappings(carCounts);
	    }
    }
}
