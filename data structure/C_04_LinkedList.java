import java.util.*;
public class C_04_LinkedList {

	public static void main(String[] args) {
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		list.add("����");
		list.add("����");
		list.add("������");
		list.add(2, "Ű��");
		list.set(0, "������");
		list.remove("Ű��");
		System.out.println("list�� ũ�� = " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}

// ���� ���� ������
// ���� ���� Ű�� ������
// ������ ���� Ű�� ������
// ������ ���� ������