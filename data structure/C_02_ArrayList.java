import java.util.*;

class Student {
	int rollno;
	String name;
	int age;
	
	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}
public class C_02_ArrayList {

	public static void main(String[] args) {
		Student s1 = new Student(101, "대한이", 23);
		Student s2 = new Student(102, "민국이", 24);
		Student s3 = new Student(103, "만세", 22);
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		Iterator<Student> iter = al.iterator();
		while(iter.hasNext()) {
			Student st = (Student) iter.next();
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
		al.forEach(a-> {
			System.out.println(a.rollno + " " + a.name + " " + a.age);
		});
	
    
	}	

}
