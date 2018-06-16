package com.questionablequalitysoftware.gemoetry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsideGeometryTest {

	@Autowired
    private IInsideGeometry geometry;
	
	@Test
	public void test04() {
		Point2D p = new Point2D(0, 0);
		assertTrue(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test05() {
		Point2D p = new Point2D(150, 150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test06() {
		Point2D p = new Point2D(-150, 150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test07() {
		Point2D p = new Point2D(-150, -150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test08() {
		Point2D p = new Point2D(150, -150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test09() {
		Point2D p = new Point2D(-150, 0);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}

	@Test
	public void test10() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}
	@Test
	public void test11() {
		Point2D p = new Point2D(150, 0);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}
	@Test
	public void test12() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideCircle(p, 100, 0, 0));
	}
	@Test
	public void test22() {
		Point2D p = new Point2D(0, 0);
		assertTrue(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test23() {
		Point2D p = new Point2D(150, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test24() {
		Point2D p = new Point2D(-150, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test25() {
		Point2D p = new Point2D(-150, -150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test26() {
		Point2D p = new Point2D(150, -150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test27() {
		Point2D p = new Point2D(-150, 0);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}

	@Test
	public void test28() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}
	@Test
	public void test29() {
		Point2D p = new Point2D(150, 0);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}
	@Test
	public void test30() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 3, 100, 0, 0));
	}
	@Test
	public void test31() {
		Point2D p = new Point2D(0, 0);
		assertTrue(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test32() {
		Point2D p = new Point2D(150, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test33() {
		Point2D p = new Point2D(-150, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test34() {
		Point2D p = new Point2D(-150, -150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test35() {
		Point2D p = new Point2D(150, -150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test36() {
		Point2D p = new Point2D(-150, 0);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}

	@Test
	public void test37() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}
	@Test
	public void test38() {
		Point2D p = new Point2D(150, 0);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}
	@Test
	public void test39() {
		Point2D p = new Point2D(0, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 8, 100, 0, 0));
	}
	
	@Test
	public void test40() {
		Point2D p = new Point2D(0, 0);
		assertFalse(geometry.isInsideRegularPolygon(p, 2, 100, 0, 0));
	}

	@Test
	public void test41() {
		Point2D p = new Point2D(150, 150);
		assertFalse(geometry.isInsideRegularPolygon(p, 2, 100, 0, 0));
	}
	
	@Test
	public void test42() {
		Point2D p1 = new Point2D(100,0);
		Point2D q1 = new Point2D(400,0);
		Point2D p2 = new Point2D(200,0);
		Point2D q2 = new Point2D(300,100);
		assertTrue(((InsideGeometry)geometry).doIntersect(p1, q1, p2, q2));
	}

	@Test
	public void test43() {
		Point2D p1 = new Point2D(100,0);
		Point2D q1 = new Point2D(400,0);
		Point2D p2 = new Point2D(350,0);
		Point2D q2 = new Point2D(300,0);
		assertTrue(((InsideGeometry)geometry).doIntersect(p1, q1, p2, q2));
	}
	
	@Test
	public void test44() {
		Point2D [] polygon = new Point2D[4];
		polygon[0] = new Point2D(0,0);
		polygon[1] = new Point2D(10, 0);
		polygon[2] = new Point2D(10, 10);
		polygon[3] = new Point2D(0, 10);
		Point2D p;
		p = new Point2D(20, 20);
		assertFalse(geometry.isInsidePolygon(p, polygon));
		p = new Point2D(5,5);
		assertTrue(geometry.isInsidePolygon(p, polygon));
	    p = new Point2D(-1, 10);
		assertFalse(geometry.isInsidePolygon(p, polygon));
	}

	@Test
	public void test45() {
		Point2D [] polygon = new Point2D[3];
		polygon[0] = new Point2D(0,0);
		polygon[1] = new Point2D(5, 5);
		polygon[2] = new Point2D(5, 0);
		Point2D p;
		p = new Point2D(3, 3);
		assertTrue(geometry.isInsidePolygon(p, polygon));
		p = new Point2D(5,1);
		assertTrue(geometry.isInsidePolygon(p, polygon));
		p = new Point2D(8,1);
		assertFalse(geometry.isInsidePolygon(p, polygon));
	}
}
