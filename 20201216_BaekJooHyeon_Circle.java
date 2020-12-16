package sunmoon;

import java.util.Scanner;

class Point {
	double x;
	double y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Circle {
	Point point;
	double radius;
	
	Circle(Point point, double radius) {
		this.point = point;		
		this.radius = radius;
	}	
}

public class BaekJooHyeon_20201216_Circle {
	public static double distancePointToPoint(Point point1, Point point2) {	// ������ �Ÿ� ��� �޼ҵ�
		double distance = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
		return distance;		
	}
	
	public static boolean isCircleCrush(Circle circle1, Circle circle2) {	// �� �浹 Ȯ�� �޼ҵ�
		double distancePointToPoint = distancePointToPoint(circle1.point, circle2.point);
		double sumRadius = circle1.radius + circle2.radius;
		
		if(circle1.point.x == circle2.point.x && circle1.point.y == circle2.point.y && circle1.radius != circle2.radius)	// �� ���� ������ ���� �������� �ٸ� ��
			return false;
		else if(distancePointToPoint > sumRadius)	// �������� �Ÿ��� �� �������� ������ �պ��� Ŭ ��
			return false;
		else				// �������� �Ÿ��� �� �������� ������ �պ��� �۰ų� ���� ��
			return true;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point[] pointArr = new Point[2];
		Circle[] circleArr = new Circle[2];
		
		for(int i=0; i<=1; i++) {
			System.out.print("���� �߽� (x,y)�� �Է��ϼ��� :");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			pointArr[i] = new Point(x,y);
			
			System.out.print("�������� �Է��ϼ��� :");
			double radius = sc.nextDouble();
			circleArr[i] = new Circle(pointArr[i], radius);			
		}
		
		if(isCircleCrush(circleArr[0],circleArr[1]))
			System.out.println("�� ���� �浹�߽��ϴ�.");
		else
			System.out.println("�� ���� �浹���� �ʾҽ��ϴ�.");				
	}
}
