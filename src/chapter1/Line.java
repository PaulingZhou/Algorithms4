package chapter1;

public class Line {
	private final Point point1;
	private final Point point2;
	
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	
	public Point getPoint1() {
		return point1;
	}
	
	public Point getPoint2() {
		return point2;
	}
	
	public static boolean isLineIntersect(Line line1, Line line2) {
		if((line1.getPoint1().getX() - line2.getPoint1().getX()) * (line1.getPoint2().getX() - line2.getPoint2().getX()) <= 0) {
			if((line1.getPoint1().getY() - line2.getPoint1().getY()) * (line1.getPoint2().getY() - line2.getPoint2().getY()) <= 0) {
				return true;
			}
		}
			return false;
	}
}
