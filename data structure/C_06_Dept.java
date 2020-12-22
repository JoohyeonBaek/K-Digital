import java.util.*;

class Dept {
	int deptNum;
	String deptName;
	String location;
	
	Dept(int deptNum, String deptName, String location) {
		this.deptNum = deptNum;
		this.deptName = deptName;
		this.location = location;
	}
}
public class C_06_Dept {

	public static void main(String[] args) {
		Dept d1 = new Dept(10,"ȸ���","����");
		Dept d2 = new Dept(20,"������","����");
		Dept d3 = new Dept(30,"������","�뱸");
		Dept d4 = new Dept(40,"�����","õ��");
		Dept d5 = new Dept(50,"���ߺ�","����");
		
		ArrayList<Dept> deptArrayList = new ArrayList<Dept>();
		
		deptArrayList.add(d1);
		deptArrayList.add(d2);
		deptArrayList.add(d3);
		deptArrayList.add(d4);
		deptArrayList.add(d5);
		
		Iterator<Dept> it = deptArrayList.iterator();
		deptArrayList.forEach(a->{
			System.out.println(a.deptNum + "\t" + a.deptName + "\t" + a.location);
		});
		
		for(int i=0; i<deptArrayList.size(); i++) {
			if(deptArrayList.get(i).deptNum == 30)
				deptArrayList.get(i).deptName = "���ߺ�";
			if(deptArrayList.get(i).deptNum == 50)
				deptArrayList.remove(i);
			}
		
		System.out.println();		
		deptArrayList.forEach(a->{
			System.out.println(a.deptNum + "\t" + a.deptName + "\t" + a.location);
		});

	}

}
