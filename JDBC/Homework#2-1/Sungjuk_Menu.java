package usunmoon;
import java.sql.*;
import java.util.*;

public class Sungjuk_Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		while(true) {
			System.out.print("���ϴ� �޴��� �����ϼ��� (1.��ü��� 2.���� 3.���� 4.���� 5.�˻� 6.����) : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:		// 1. ��ü���
				new Sungjuk_print().main(args);
				break;
				
			case 2:		// 2. ����
				new Sungjuk_insert().main(args);
				break;
				
			case 3:		// 3. ����
				new Sungjuk_delete().main(args);
				break;
				
			case 4:		// 4. ����
				new Sungjuk_update().main(args);
				break;
				
			case 5:		// 5. �˻�
				new Sungjuk_select().main(args);
				break;
			
			case 6:		// 6. ����
				System.out.println("�����մϴ�");
				return;				
			}
			System.out.println();
		}

	}
}
