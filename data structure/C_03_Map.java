import java.util.*;

public class C_03_Map {

	public static void main(String[] args) {
		List<String> al = new java.util.ArrayList<String>();
		al.add("�ڶ�");
		al.add("��");
		al.add("�۾�");
		System.out.println("ArrayList ��� : ");
		System.out.println("\t " + al);
		
		List<String> ll = new LinkedList<String>();
		ll.add("�ڶ�");
		ll.add("��");
		ll.add("�۾�");
		System.out.println("\t" + ll);
		
		Set sl = new HashSet();
		sl.add("�ڶ�");
		sl.add("��");
		sl.add("�۾�");
		System.out.println("\t" + sl);
		
		HashMap m1 = new HashMap();
		m1.put("�ڶ�","��");
		m1.put("��","���");
		m1.put("�۾�","����");
		System.out.println("\t" + sl);
		
	}

}
