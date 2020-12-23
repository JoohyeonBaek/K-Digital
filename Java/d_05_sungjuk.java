
import java.util.*;

class Student {
	String name;
	int ban;
	int no;
	int korea;
	int eng;
	int math;
	int total;
	
	Student(String name, int ban, int no, int korea, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.korea = korea;
		this.eng = eng;
		this.math = math;
		total = korea + eng + math;
	}	
	
	void print() {
		System.out.println("이름 : " + name + " 반 : " + ban + " 번호 : " + no + " 국어 : " + korea + " 영어 : " + eng + " 수학 : " + math + " 합계 : " + total);
	}	
}

public class d_05_sungjuk {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> al = new ArrayList<Student>();
		Iterator<Student> iter = al.iterator();
		
		while(true) {
			System.out.println("1.입력 2.삭제 3.편집 4.조회 5.출력 6.종료");
			System.out.print("메뉴를 입력하세요 : ");
			int menu = sc.nextInt();
			
			
			switch(menu) {
			case 1:		// 입력
				System.out.println("학생 정보를 입력하세요");
				System.out.print("이름, 반, 번호, 국어, 영어, 수학 : ");
				String name = sc.next();
				int ban = sc.nextInt();				
				int no = sc.nextInt();				
				int korea = sc.nextInt();				
				int eng = sc.nextInt();
				int math = sc.nextInt();
				al.add(new Student(name,ban,no,korea,eng,math));				
				break;
			
			case 2:		// 삭제				
				System.out.print("삭제하고 싶은 학생의 번호를 입력하세요 : ");
				int removeNum = sc.nextInt();
				int index = 0;
				for(Student std : al) {
					if(std.no == removeNum) {
						al.remove(index);
						break;
					}
					index++;
				}
											
				break;
				
			case 3:		// 편집
				if(al.size()==0)
					System.out.println("학생이 입력되지 않았습니다.");
				else {
					System.out.print("편집하고 싶은 학생의 번호를 입력하세요 : ");
					int editNum = sc.nextInt();
					al.forEach(a->{
						if(a.no == editNum) {
							System.out.println("편집 할 학생 정보를 입력하세요");
							System.out.print("이름, 반, 번호, 국어, 영어, 수학 : ");
							a.name = sc.next();
							a.ban = sc.nextInt();
							a.no = sc.nextInt();
							a.korea = sc.nextInt();
							a.eng = sc.nextInt();
							a.math = sc.nextInt();
						}
					});
				}
				
				break;
				
			case 4:		// 조회
				if(al.size()==0)
					System.out.println("학생이 입력되지 않았습니다.");
				else {
					System.out.print("조회할 학생의 번호를 입력하세요 : ");
					int searchNum = sc.nextInt();
					al.forEach(a->{
						if(a.no == searchNum) {
							a.print();						
						}
					});
				}			
				break;
				
			case 5:		// 모두 출력
				if(al.size()==0)
					System.out.println("학생이 입력되지 않았습니다.");
				for(int i=0; i<al.size(); i++) {
					al.get(i).print();
				}
				break;
				
			case 6:		// 종료
				return;
			}
			System.out.println();
		}

	}

}
