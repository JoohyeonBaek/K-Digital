import java.util.*;
public class C_04_LinkedList {

	public static void main(String[] args) {
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		list.add("Æ÷µµ");
		list.add("µş±â");
		list.add("º¹¼ş¾Æ");
		list.add(2, "Å°À§");
		list.set(0, "¿À·»Áö");
		list.remove("Å°À§");
		System.out.println("listÀÇ Å©±â = " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}

// Æ÷µµ µş±â º¹¼ş¾Æ
// Æ÷µµ µş±â Å°À§ º¹¼ş¾Æ
// ¿À·»Áö µş±â Å°À§ º¹¼ş¾Æ
// ¿À·»Áö µş±â º¹¼ş¾Æ