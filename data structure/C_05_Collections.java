import java.util.*;

public class C_05_Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arraylist = new ArrayList<String>();		
		arraylist.add("õ��");
		arraylist.add("�ƻ�");
		arraylist.add("����");
		arraylist.add("����");	
		// õ�� �ƻ� ���� ����
		
		System.out.println(arraylist.get(0));
		Collections.sort(arraylist);	// ���� ���� �ƻ� õ��
		System.out.println(arraylist.get(1));
		
		System.out.println(Collections.frequency(arraylist, "õ��"));
		System.out.println(Collections.binarySearch(arraylist, "õ��"));
		System.out.println(arraylist);
		
	}

}
