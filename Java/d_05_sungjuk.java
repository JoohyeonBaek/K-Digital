
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
		System.out.println("�̸� : " + name + " �� : " + ban + " ��ȣ : " + no + " ���� : " + korea + " ���� : " + eng + " ���� : " + math + " �հ� : " + total);
	}	
}

public class d_05_sungjuk {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> al = new ArrayList<Student>();
		Iterator<Student> iter = al.iterator();
		
		while(true) {
			System.out.println("1.�Է� 2.���� 3.���� 4.��ȸ 5.��� 6.����");
			System.out.print("�޴��� �Է��ϼ��� : ");
			int menu = sc.nextInt();
			
			
			switch(menu) {
			case 1:		// �Է�
				System.out.println("�л� ������ �Է��ϼ���");
				System.out.print("�̸�, ��, ��ȣ, ����, ����, ���� : ");
				String name = sc.next();
				int ban = sc.nextInt();				
				int no = sc.nextInt();				
				int korea = sc.nextInt();				
				int eng = sc.nextInt();
				int math = sc.nextInt();
				al.add(new Student(name,ban,no,korea,eng,math));				
				break;
			
			case 2:		// ����				
				System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ��� : ");
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
				
			case 3:		// ����
				if(al.size()==0)
					System.out.println("�л��� �Էµ��� �ʾҽ��ϴ�.");
				else {
					System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ��� : ");
					int editNum = sc.nextInt();
					al.forEach(a->{
						if(a.no == editNum) {
							System.out.println("���� �� �л� ������ �Է��ϼ���");
							System.out.print("�̸�, ��, ��ȣ, ����, ����, ���� : ");
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
				
			case 4:		// ��ȸ
				if(al.size()==0)
					System.out.println("�л��� �Էµ��� �ʾҽ��ϴ�.");
				else {
					System.out.print("��ȸ�� �л��� ��ȣ�� �Է��ϼ��� : ");
					int searchNum = sc.nextInt();
					al.forEach(a->{
						if(a.no == searchNum) {
							a.print();						
						}
					});
				}			
				break;
				
			case 5:		// ��� ���
				if(al.size()==0)
					System.out.println("�л��� �Էµ��� �ʾҽ��ϴ�.");
				for(int i=0; i<al.size(); i++) {
					al.get(i).print();
				}
				break;
				
			case 6:		// ����
				return;
			}
			System.out.println();
		}

	}

}
