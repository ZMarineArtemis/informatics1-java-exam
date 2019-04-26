import java.util.ArrayList;
import java.util.Arrays;


public class Entropy {
	public static int[] charCount(String s) {
		ArrayList<Integer> str = new ArrayList<Integer>();
		if(s.equals(null)) {
			return null;
	    }else {
           int frequency;
            for(int i = 96; i<=122; i++) {
            	frequency = 0;
	    	for(int j = 0; j<=s.length()-1; j++) {
	    	if(s.charAt(j)+1 == (char)i) {
	    		frequency ++;
	        }
	    	}
	    	str.add(frequency);
	    	}
	    }
		int[] c = new int[26];
		for(int k=0; k< 26; k++) {
			c[k] = str.get(k);
		}
		return c;
	    }

	public static double[] normalise(int[] is) {
		int sum = 0;
		double[] copy =new double[is.length];
		for(int i : is) {
		 sum += i ;
		}
		for(int j = 0; j <= is.length-1; j++) {
			double tmp = (is[j]/(double)sum);
			copy[j]=tmp;
		}
		return copy;
	}
	
public static double entropyOf(double[] ds) {
      int sum = 0;
      double[] copy = new double[ds.length];
      for(int j =0; j<= ds.length-1; j++) {
    	  copy[j] = ds[j] * Math.exp(ds[j]); 
      }
      for(int i = 0; i<= ds.length-1; i++) {
    	  sum += copy[i];
      }
      return sum;
    }
	
public static int[][] charCountArray(String[] strings) {
		String firstString = new String();
		String secondString = new String();
		for(int i=0; i <strings.length%2;i++) {
			firstString = strings[i];
		}
		for(int j = 1; j<strings.length; j++) {
			secondString = strings[j];
		}
		ArrayList<Integer> str = new ArrayList<Integer>();
		int[] first;
		if(firstString.equals(null)) {
			 first = null;
	    }else {
           int frequency;
            for(int i = 96; i<=122; i++) {
            	frequency = 0;
	    	for(int j = 0; j<=firstString.length()-1; j++) {
	    	if(firstString.charAt(j)+1 == (char)i) {
	    		frequency ++;
	        }
	    	}
	    	str.add(frequency);
	    	}
	    }
		first = new int[26];
		for(int k=0; k< 26; k++) {
			first[k] = str.get(k);
		}
		ArrayList<Integer> stc = new ArrayList<Integer>();
		int[] second;
		if(secondString.equals(null)) {
		   second = null;
	    }else {
           int frequency = 0;
            for(int i = 96; i<=122; i++) {
            	frequency = 0;
	    	for(int j = 0; j<=secondString.length()-1; j++) {
	    	if(secondString.charAt(j)+1 == (char)i) {
	    		frequency ++;
	        }
	    	}
	    	str.add(frequency);
	    	}
	    }
		second = new int[26];
		for(int k=0; k< 26; k++) {
			second[k] = str.get(k);
		}
		int[][] result = new int[first.length][second.length];
		for(int c = 0; c <first.length && c < second.length; c++) {
	    result = new int [first[c]] [second[c]];
		}
		return result;
	    }
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(charCountArray(new String[] {"abbcccxx", "bbccyzdd"})));
		
	}

}