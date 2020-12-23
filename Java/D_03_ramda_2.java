/*
 *  ����
 *  4�����, IOT, ����Ÿ, �ΰ�����, ARVR, 5G. Block Chain �ܾ ArrayList�� �����ϰ�
 *  iterator enumeration, enhanced for, forEach���� Ȱ���Ͽ� ��� *  
 */
import java.util.*;

public class D_03_ramda_2 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("4�����");
		al.add("IOT");
		al.add("������");
		al.add("�ΰ�����");
		al.add("ARVR");
		al.add("5G");
		al.add("Block Chain");
		
		System.out.println("1. iterator�� ���� ���");
		Iterator<String> iter = al.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("2. enumeration�� ���� ���");
		Enumeration<String> e = Collections.enumeration(al);
		while(e.hasMoreElements()) {
			System.out.print(e.nextElement() + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("3. enhanced for�� ���� ���");
		for(String i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("4. foreach�� ���� ���");
		al.forEach(a->{
			System.out.print(a + " ");
		});

	}

}
