public class SectionBuffer extends Buffer{

private int frontEnd;
private int backEnd;
private int frontElementCount;
private int backElementCount;
	
    public SectionBuffer(int capacity) {
	       super(capacity);
	       frontEnd = 0;
     		if(capacity%2 == 0) {
			backEnd = capacity/2;	
			}else {
				backEnd = (capacity+1)/2;
			}
			frontElementCount = backEnd - frontEnd;
			backElementCount = capacity - frontElementCount;
			
			}
    
	public SectionBuffer() {
		super(10);	
	}
	
	public boolean isFull(boolean args) {
		boolean result = false;
		if(args == true) {
			result = (frontElementCount == (frontEnd +1));
		}else if(args == false){
			result = (backElementCount == (backEnd + 1));
		}
		return result;
	}
	
	public boolean isEmpty(boolean args) {
		boolean result = false;
		if(args == true) {
			result = (frontElementCount == 0);
		}else if(args == false){
			result = (backElementCount == 0);
		}
		return result;
	}
   
	public void clear() {
		frontEnd = 0;
		backEnd = 5;
		frontElementCount = 0;
		backElementCount = 0;
	}
   
	public void addToBuffer(int value, boolean args) {
		if(args == true) {
			if(frontEnd == 0) {
				buffer[frontEnd] = value;
				frontElementCount ++;
			}else {
			buffer[frontEnd] = value;
			frontEnd ++;
			frontElementCount ++;
			}
		}else if(args == false) {
			if(backEnd == 0) {
				buffer[backEnd] = value;
				backElementCount ++;
			}else {
			buffer[backEnd] = value;
			backEnd ++;
			backElementCount ++;
			}
		}	
	}

	public int getFromBuffer(boolean args) {
		int result = 0;
		if(args == true) {
			if(frontEnd == 0) {
				System.out.println("Buffer is empty");
				result = -1;
			}else {
			result = buffer[frontEnd];
			frontEnd --;
			frontElementCount --;
			buffer[frontElementCount] = -1;
			}
		}else if(args == false) {
			if(backEnd == 0) {
				System.out.println("Buffer is empty");
				result = -1;
			}else {
			result = buffer[backEnd];
			backEnd --;
			backElementCount --;
			buffer[backElementCount] = -1;
			
	}
	}
		return result;
	}
}
	

	

	
	
