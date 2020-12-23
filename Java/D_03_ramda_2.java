/*
 *  문제
 *  4차산업, IOT, 빅데이타, 인공지능, ARVR, 5G. Block Chain 단어를 ArrayList에 저장하고
 *  iterator enumeration, enhanced for, forEach문을 활용하여 출력 *  
 */
import java.util.*;

public class D_03_ramda_2 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("4차산업");
		al.add("IOT");
		al.add("빅데이터");
		al.add("인공지능");
		al.add("ARVR");
		al.add("5G");
		al.add("Block Chain");
		
		System.out.println("1. iterator을 통해 출력");
		Iterator<String> iter = al.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("2. enumeration을 통해 출력");
		Enumeration<String> e = Collections.enumeration(al);
		while(e.hasMoreElements()) {
			System.out.print(e.nextElement() + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("3. enhanced for을 통해 출력");
		for(String i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("4. foreach를 통해 출력");
		al.forEach(a->{
			System.out.print(a + " ");
		});

	}

}
