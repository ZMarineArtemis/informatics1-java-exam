
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
		
		
	}
	
	public void addToBuffer(int i, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public int getFromBuffer(boolean b) {
		// TODO Auto-generated method stub
		return 0;
	}
}
