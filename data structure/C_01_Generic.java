
class GenericEx<T> {
	T v[];
	public void set(T [] n) {
		v=n;
	}
	public void print() {
		for(T s:v) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}

public class C_01_Generic {
	
	public static void main(String[] args) {
		GenericEx<String> ge = new GenericEx<String>();
		GenericEx<Integer> ge2 = new GenericEx<Integer>();
		GenericEx<Double> ge3 = new GenericEx<Double>();
		
		String[] ss = {"컬랙션이란", "제네릭과", "container", "알고리즘"};
		ge.set(ss);
		ge.print();
		
		Integer[] ss2 = {1,2,3,4};
		ge2.set(ss2);
		ge2.print();
		
		Double[] ss3 = {3.0,4.0,5.0,6.0,9.0,8.0};
		ge3.set(ss3);
		ge3.print();
	}

}
