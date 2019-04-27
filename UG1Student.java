
public class UG1Student extends Student {
private char mainSchedule;
public UG1Student(String n, String u, char mainSchedule){
	super(n,u,1);
	this.mainSchedule = mainSchedule;
}

public UG1Student() {
	this("no setting", "no setting", 'X');	
}

public boolean addCourse(Course co) {
if(co.getLevel() == 7 || co.getLevel() == 8) {
	return true;
}else {
	return false;
}
}

public boolean addCourses(Course[] cs) {
	boolean result = true;
	for(int i = 0; i < cs.length; i++) {
		if(!addCourse(cs[i])) {
			result = false;
			break;
			}
		result = true;
	}
	return result;
}

public String toString() {
	String output = super.toString()+"\n";
	output += "mainSchedule is" + mainSchedule + "course:";
	Course[] cs = super.getCourses();
	for(int i = 0; i < cs.length; i++) {
		output =cs[i].getName() + "\n";
	}
	return output;
}
}
