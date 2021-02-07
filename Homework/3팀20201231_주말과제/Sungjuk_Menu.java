package usunmoon;
import java.util.*;

public class Sungjuk_Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		while(true) {
			System.out.print("원하는 메뉴를 선택하세요 (1.전체출력 2.삽입 3.삭제 4.수정 5.검색 6.종료) : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:		// 1. 전체출력
				Sungjuk_print sp = new Sungjuk_print();
				sp.print();
				break;
				
			case 2:		// 2. 삽입
				Sungjuk_insert si = new Sungjuk_insert();
				si.insert();
				break;
				
			case 3:		// 3. 삭제
				System.out.print("삭제할 번호 입력 : ");
				Sungjuk_delete sd = new Sungjuk_delete();
				sd.delete(sc.nextInt());				
				break;
				
			case 4:		// 4. 수정
				Sungjuk_update su = new Sungjuk_update();
				su.update();
				break;
				
			case 5:		// 5. 검색
				Sungjuk_select ss = new Sungjuk_select();      
	            System.out.print("검색하실 이름을 입력 : ");
	            ss.select(sc.next());				
				break;
			
			case 6:		// 6. 종료
				System.out.println("종료합니다");
				return;				
			}
			System.out.println();
		}

	}
}
