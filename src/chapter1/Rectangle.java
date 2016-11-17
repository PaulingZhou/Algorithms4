package chapter1;

class Rectangle {
	final double minX;
	final double minY;
	final double maxX;
	final double maxY;
	
	public Rectangle(double x, double y, double halfWidth, double halfHeight) {
		minX = x - halfWidth;
		maxX = x + halfWidth;
		minY = y - halfHeight;
		maxY = y + halfHeight;
	}
	
	private Point[] getPoints() {
		Point[] points = new Point[4];
		points[0] = new Point(minX, minY);
		points[1] = new Point(maxX, minY);
		points[2] = new Point(maxX, maxY);
		points[3] = new Point(minX, maxY);
		return points;
	}
	
	public Line[] getLines() {
		Point[] points = getPoints();
		Line[] lines = new Line[4];
		lines[0] = new Line(points[0], points[1]);
		lines[1] = new Line(points[1], points[2]);
		lines[2] = new Line(points[2], points[3]);
		lines[3] = new Line(points[3], points[0]);
		return lines;
	}
	
	public static boolean isIntersect(Rectangle rectangle1, Rectangle rectangle2) {
		Line[] lines1 = rectangle1.getLines();
		Line[] lines2 = rectangle2.getLines();
		for(Line line1 : lines1) {
			for(Line line2 : lines2) {
				if(Line.isLineIntersect(line1, line2)) return true;
			}
		}
		return false;
	}
	
	public static boolean isContain(Rectangle rectangle1, Rectangle rectangle2) {
		if(rectangle1.minX >= rectangle2.minX) {
			if(rectangle1.maxX <= rectangle2.maxX && rectangle1.minY >= rectangle2.minY && rectangle1.maxY <= rectangle2.maxY) return true;
		}
		return false;
	}
}
