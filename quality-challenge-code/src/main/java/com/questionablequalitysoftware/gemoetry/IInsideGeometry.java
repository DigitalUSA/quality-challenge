package com.questionablequalitysoftware.gemoetry;

public interface IInsideGeometry {
	boolean isInsidePolygon(Point2D p, Point2D [] polygon );
	boolean isInsideRegularPolygon(Point2D p, int n, int r, int x, int y);
	boolean isInsideCircle(Point2D p, int r, int x, int y);
}
