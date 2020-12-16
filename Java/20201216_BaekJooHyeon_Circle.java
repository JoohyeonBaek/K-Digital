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
	public static double distancePointToPoint(Point point1, Point point2) {	// 원점간 거리 계산 메소드
		double distance = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
		return distance;		
	}
	
	public static boolean isCircleCrush(Circle circle1, Circle circle2) {	// 원 충돌 확인 메소드
		double distancePointToPoint = distancePointToPoint(circle1.point, circle2.point);
		double sumRadius = circle1.radius + circle2.radius;
		
		if(circle1.point.x == circle2.point.x && circle1.point.y == circle2.point.y && circle1.radius != circle2.radius)	// 두 원의 원점이 같고 반지름이 다를 때
			return false;
		else if(distancePointToPoint > sumRadius)	// 원점간의 거리가 각 반지름의 길이의 합보다 클 때
			return false;
		else				// 원점간의 거리가 각 반지름의 길이의 합보다 작거나 같을 때
			return true;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point[] pointArr = new Point[2];
		Circle[] circleArr = new Circle[2];
		
		for(int i=0; i<=1; i++) {
			System.out.print("원의 중심 (x,y)을 입력하세요 :");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			pointArr[i] = new Point(x,y);
			
			System.out.print("반지름을 입력하세요 :");
			double radius = sc.nextDouble();
			circleArr[i] = new Circle(pointArr[i], radius);			
		}
		
		if(isCircleCrush(circleArr[0],circleArr[1]))
			System.out.println("두 원은 충돌했습니다.");
		else
			System.out.println("두 원은 충돌하지 않았습니다.");				
	}
}
