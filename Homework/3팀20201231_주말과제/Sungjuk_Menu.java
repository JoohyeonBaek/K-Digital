package usunmoon;
import java.util.*;

public class Sungjuk_Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		while(true) {
			System.out.print("���ϴ� �޴��� �����ϼ��� (1.��ü��� 2.���� 3.���� 4.���� 5.�˻� 6.����) : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:		// 1. ��ü���
				Sungjuk_print sp = new Sungjuk_print();
				sp.print();
				break;
				
			case 2:		// 2. ����
				Sungjuk_insert si = new Sungjuk_insert();
				si.insert();
				break;
				
			case 3:		// 3. ����
				System.out.print("������ ��ȣ �Է� : ");
				Sungjuk_delete sd = new Sungjuk_delete();
				sd.delete(sc.nextInt());				
				break;
				
			case 4:		// 4. ����
				Sungjuk_update su = new Sungjuk_update();
				su.update();
				break;
				
			case 5:		// 5. �˻�
				Sungjuk_select ss = new Sungjuk_select();      
	            System.out.print("�˻��Ͻ� �̸��� �Է� : ");
	            ss.select(sc.next());				
				break;
			
			case 6:		// 6. ����
				System.out.println("�����մϴ�");
				return;				
			}
			System.out.println();
		}

	}
}
