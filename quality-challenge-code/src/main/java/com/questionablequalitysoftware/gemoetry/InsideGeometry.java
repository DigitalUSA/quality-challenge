package com.questionablequalitysoftware.gemoetry;

import org.springframework.stereotype.Component;

@Component
public class InsideGeometry implements IInsideGeometry {
	
	@Override
	public boolean isInsidePolygon(Point2D p, Point2D[] polygon) {
		if (polygon.length < 3) {
			return false;
		}
		Point2D extreme = new Point2D(Integer.MAX_VALUE, p.y);
		int count = 0;
		for (int i = 0; i < polygon.length; i++) {
			int j = (i + 1) % polygon.length;
//			System.out.println(String.format("%d [%s], [%s]", i, format(polygon[i], polygon[j]), format(p, extreme)));
			if (doIntersect(polygon[i], polygon[j], p, extreme)) {
				if (orientation(polygon[i], p, polygon[j]) == 0) {
					return onSegment(polygon[i], p, polygon[j]);
				}
				if (! onSegment(p, polygon[j], extreme)) {
					count++;					
				}
//				System.out.println("p " + count);
			}
		}
//		System.out.println("r " + count);
		return count % 2 == 1;
	}

	@Override
	public boolean isInsideRegularPolygon(Point2D p, int n, int r, int x, int y) {
		double arc = (2 * Math.PI) / (double)n;
		Point2D [] polygon = new Point2D[n];
		for (int i = 0; i < n; i++) {
			int px = x + (int)(Math.cos(arc * (double)i) * (double)r);
			int py = y + (int)(Math.sin(arc * (double)i) * (double)r);
			polygon[i] = new Point2D(px, py);
//			System.out.println(String.format("regPoly %d (%d,%d)", i, px, py));
		}
		return isInsidePolygon(p, polygon);
	}

	@Override
	public boolean isInsideCircle(Point2D p, int r, int x, int y) {
		double a = (double)(p.x - x);
		double b = (double)(p.y - y);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c <= r;
	}
	
	public boolean onSegment(Point2D p, Point2D q, Point2D r)
	{
		boolean ret = q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
					  q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
//		System.out.println(String.format("onSegment %s %s %s => %s", format(p), format(q), format(r), ret));
	    return ret; 
	}

	public boolean doIntersect(Point2D p1, Point2D q1, Point2D p2, Point2D q2) {
	    int o1 = orientation(p1, q1, p2);
	    int o2 = orientation(p1, q1, q2);
	    int o3 = orientation(p2, q2, p1);
	    int o4 = orientation(p2, q2, q1);
	 
	    if (o1 != o2 && o3 != o4) {
	        return true;
	    }
	    if (o1 == 0 && onSegment(p1, p2, q1)) {
	    	return true;
	    }
	 
	    if (o2 == 0 && onSegment(p1, q2, q1)) {
	    	return true;
	    }
	 
	    if (o3 == 0 && onSegment(p2, p1, q2)) {
	    	return true;
	    }
	    if (o4 == 0 && onSegment(p2, q1, q2)) {
	    	return true;
	    }
	    return false;
	}
	public int orientation(Point2D p, Point2D q, Point2D r)
	{
	    int val = (q.y - p.y) * (r.x - q.x) -
	              (q.x - p.x) * (r.y - q.y);	    
	    if (val > 0) {
	    	val = 1;
	    } else if (val < 0) {
	    	val = -1;
	    }
//		System.out.println(String.format("orientation %s %s %s => %d", format(p), format(q), format(r), val));
	    return val;
	}
/*	
	private String format(Point2D p1, Point2D p2) {
		return format(p1) + "-" + format(p2);
	}
	
	private String format(Point2D p) {
		return "(" + p.x + "," + p.y + ")";
	}
*/
}
