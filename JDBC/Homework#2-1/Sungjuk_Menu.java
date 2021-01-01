package usunmoon;
import java.sql.*;
import java.util.*;

public class Sungjuk_Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		while(true) {
			System.out.print("원하는 메뉴를 선택하세요 (1.전체출력 2.삽입 3.삭제 4.수정 5.검색 6.종료) : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:		// 1. 전체출력
				new Sungjuk_print().main(args);
				break;
				
			case 2:		// 2. 삽입
				new Sungjuk_insert().main(args);
				break;
				
			case 3:		// 3. 삭제
				new Sungjuk_delete().main(args);
				break;
				
			case 4:		// 4. 수정
				new Sungjuk_update().main(args);
				break;
				
			case 5:		// 5. 검색
				new Sungjuk_select().main(args);
				break;
			
			case 6:		// 6. 종료
				System.out.println("종료합니다");
				return;				
			}
			System.out.println();
		}

	}
}
