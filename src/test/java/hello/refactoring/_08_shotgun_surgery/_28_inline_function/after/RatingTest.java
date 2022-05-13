package hello.refactoring._08_shotgun_surgery._28_inline_function.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {

	@Test
	void rating() {
		Rating rating = new Rating();
		assertEquals(2, rating.rating(new Driver(15)));
		assertEquals(1, rating.rating(new Driver(3)));
	}

}
