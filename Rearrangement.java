import java.util.Arrays;

public class Rearrangement {

	public static int dotWith(int[] first, int[] second) {
		int result = 0;
		if(first.length == second.length) {
			for(int i = 0; i < first.length; i++) {
				result += first[i] * second[i];
			}
		}else {
		result = 0;
		}
		return result;
	}

	public static void rotate(int[] b) {
		int[] tmp = new int[b.length];
		int lastNumber = b[b.length-1];
	    for(int i = 0; i < b.length; i++) {
	    	tmp[i] = b[i];
	    }
	    b[0] = lastNumber;
	    for(int j = 0; j < tmp.length - 1; j++) {
	    	for(int k = 1; k < b.length - 1; k++) {
	    	b[k] = tmp[j];
	        }
	    }
	}
	
    public static int useRotations(int[] a, int[] b) {
    	int result = dotWith(a,b);
    	int[] tmp = new int[b.length];
		int lastNumber = b[b.length-1];
	    for(int i = 0; i < b.length; i++) {
	    	tmp[i] = b[i];
	    }
	    tmp[0] = lastNumber;
	    for(int j = 0; j < tmp.length - 1; j++) {
	    	for(int k = 1; k < b.length - 1; k++) {
	    	tmp[k] = b[j];
	        }
	    }
	    int resultSecond = dotWith(a,tmp);
	    if(result >= resultSecond) {
	    	return result;
	    }else {
	    	return resultSecond;
	    }
    }
    
	public static int useSorted(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		return dotWith(a,b);

	}
}
