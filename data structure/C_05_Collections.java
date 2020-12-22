import java.util.*;

public class C_05_Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arraylist = new ArrayList<String>();		
		arraylist.add("천안");
		arraylist.add("아산");
		arraylist.add("수원");
		arraylist.add("서울");	
		// 천안 아산 수원 서울
		
		System.out.println(arraylist.get(0));
		Collections.sort(arraylist);	// 서울 수원 아산 천안
		System.out.println(arraylist.get(1));
		
		System.out.println(Collections.frequency(arraylist, "천안"));
		System.out.println(Collections.binarySearch(arraylist, "천안"));
		System.out.println(arraylist);
		
	}

}
