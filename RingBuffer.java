
public class RingBuffer extends Buffer  {
private int start;
private int end;
private int elementCount;
	public RingBuffer(int capacity) {
		super(capacity);
		if(capacity <1) {
			throw new IllegalArgumentException("The given buffer capacity must be larger than one.");
		}else {
			start = 0;
			end = 0;
			elementCount = 0;
		}
	}

	public RingBuffer() {
		super(10);
	}
	
	public boolean isFull() {
		if(10 == elementCount) {
			return true;
		}else {
		return false;
		}
	}
	
	public boolean isEmpty() {
		if(elementCount == 0) {
		return true;
		}else {
		return false;
		}
	}
	
	public void clear() {
		    
	        for(int i = 0; i < buffer.length; i++)
	            buffer[i] = -1;
	        start = 0;
	        end = 0;
	        elementCount = 0;
    }

	public void addToBuffer(int argument) {
		if(!!isFull()) {
        end +=  1;
        elementCount +=  1;
        buffer[elementCount] = argument;
		}else {
			System.out.println("Buffer is full");
		}
		
	}
	
	public int getFromBuffer() {
		if(!!isEmpty()) {
		start += 1;
		elementCount -= 1;
	   int result = buffer[0];
	   int[] tmp = new int[buffer.length-1];
	   for(int i=0; i < buffer.length-1; i++) {
		    tmp[i] = buffer[i+1];
	   }
	   
	   return result;
	}else {
		return -1;
	}
		
	}

}
