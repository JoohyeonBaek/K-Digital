// 람다 무명함수를 유명함수로 만드는 방법 : 람다함수를 인터페이스에 대입
// 인터페이스는 무명함수를 가리킬 수 있다 ( 단 매개변수 형태가 같아야 함)

interface IntegerMath {				// 인터페이스는 추상함수로만 구성
	int operation(int a, int b);	// 자동으로 public static이 붙음, 추상함수 (abstract)
}

public class D_02_ramda {
	public int operateBinary(int a, int b, IntegerMath op) {		// 인터페이스는 인스턴스는 안되지만 부모는 가능
		return op.operation(a, b);
	}
	
	public static void main(String[] args) {
		D_02_ramda myApp = new D_02_ramda();
		IntegerMath addition = (a,b) -> a+b;
		IntegerMath substraction = (a,b) -> a-b;
		
		
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 20 = " + myApp.operateBinary(20, 20, substraction));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, (a, b)->a-b));		// 함수의 매개변수로 함수를 전달 가능
		System.out.println("10 * 3 = " + myApp.operateBinary(10, 3, (a,b) -> a*b));
	}
}
