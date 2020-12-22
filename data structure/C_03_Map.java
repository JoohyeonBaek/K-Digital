import java.util.*;

public class C_03_Map {

	public static void main(String[] args) {
		List<String> al = new java.util.ArrayList<String>();
		al.add("자라");
		al.add("고래");
		al.add("송어");
		System.out.println("ArrayList 출력 : ");
		System.out.println("\t " + al);
		
		List<String> ll = new LinkedList<String>();
		ll.add("자라");
		ll.add("고래");
		ll.add("송어");
		System.out.println("\t" + ll);
		
		Set sl = new HashSet();
		sl.add("자라");
		sl.add("고래");
		sl.add("송어");
		System.out.println("\t" + sl);
		
		HashMap m1 = new HashMap();
		m1.put("자라","피");
		m1.put("고래","고기");
		m1.put("송어","어장");
		System.out.println("\t" + sl);
		
	}

}
