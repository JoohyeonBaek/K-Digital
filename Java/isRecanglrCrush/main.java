package homework_2;

public class main {
	public static void main(String[] args) {
		ColorPoint p1 = new ColorPoint();
		ColorPoint p2 = new ColorPoint();
		ColorPoint p3 = new ColorPoint();
		ColorPoint p4 = new ColorPoint();		
		
		p1.setPoint(0.0, 0.0);
		p2.setPoint(3.0, 3.0);
		p3.setPoint(2.0, 2.0);
		p4.setPoint(4.0, 4.0);		

		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();		

		r1.setRectangle(p1, p2);
		r2.setRectangle(p3, p4);		

		if(r1.isRectangleCrash(r2))
			System.out.println("iscrush");		
	}
}
