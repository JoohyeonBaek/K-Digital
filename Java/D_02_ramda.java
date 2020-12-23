// ���� �����Լ��� �����Լ��� ����� ��� : �����Լ��� �������̽��� ����
// �������̽��� �����Լ��� ����ų �� �ִ� ( �� �Ű����� ���°� ���ƾ� ��)

interface IntegerMath {				// �������̽��� �߻��Լ��θ� ����
	int operation(int a, int b);	// �ڵ����� public static�� ����, �߻��Լ� (abstract)
}

public class D_02_ramda {
	public int operateBinary(int a, int b, IntegerMath op) {		// �������̽��� �ν��Ͻ��� �ȵ����� �θ�� ����
		return op.operation(a, b);
	}
	
	public static void main(String[] args) {
		D_02_ramda myApp = new D_02_ramda();
		IntegerMath addition = (a,b) -> a+b;
		IntegerMath substraction = (a,b) -> a-b;
		
		
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 20 = " + myApp.operateBinary(20, 20, substraction));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, (a, b)->a-b));		// �Լ��� �Ű������� �Լ��� ���� ����
		System.out.println("10 * 3 = " + myApp.operateBinary(10, 3, (a,b) -> a*b));
	}
}
