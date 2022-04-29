package hello.refactoring._06_mutable_data._18_split_variable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void updateGeometry() {
		Rectangle rectangle = new Rectangle();
		rectangle.updateGeometry(10, 5);
		assertEquals(50d, rectangle.getArea());
		assertEquals(30d, rectangle.getPerimeter());

		rectangle.updateGeometry(5, 5);
		assertEquals(25d, rectangle.getArea());
		assertEquals(20d, rectangle.getPerimeter());
	}

}
