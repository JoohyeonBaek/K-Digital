package homework_2;

public class Rectangle {
	Point p1;
	Point p2;	
	Point p3 = new Point();
	Point p4 = new Point();	

	void setRectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		p3.setPoint(p1.x, p1.y+p2.y);
		p4.setPoint(p1.x+p2.x, p1.y);
	}
	
	boolean isRectangleCrash(Rectangle r) {
		if(p1.x <= r.p2.x && p1.y <= r.p2.y)
			return true;
		else if(p2.x >= r.p1.x && p2.y >= r.p2.y)
			return true;
		else if(p3.x <= r.p4.x && p3.y >= r.p4.y)
			return true;
		else if(p4.x >= r.p3.x && p4.y <= r.p3.y)
			return true;
		else
			return false;
	}
}
