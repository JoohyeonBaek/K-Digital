package homework_2;

public class Point {
	double x;
	double y;	

	void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}	

	void movePoint(double x, double y) {
		this.x = x;
		this.y = y;
	}	

	void printPoint() {
		System.out.println("Point : (" + x + "," + y + ")");
	}	

	double distacneZeroToPoint() {
		double distance = Math.pow(x, 2) + Math.pow(y, 2);
		return distance;
	}	

	double distancePointToPoint(Point p) {
		double distance = Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
		return distance;
	}
}