
public class D_01_exception {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i=0; i<10; i++) {
			try {
				result = number / (int) (Math.random() * 10);
				System.out.println(result);
			} catch(ArithmeticException e) {
				System.out.println("0으로 나누었습니다.");
			}
		}
		
		try {
			System.out.println(3);
			System.out.println(4);			
		} catch(Exception e) {
			System.out.println(5);
		}
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(ArithmeticException e) {
			System.out.println("예외발생");
		}
		System.out.println(6);
	}

}
