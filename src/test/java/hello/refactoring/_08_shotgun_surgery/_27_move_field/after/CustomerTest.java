package hello.refactoring._08_shotgun_surgery._27_move_field.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void applyDiscount() {
		Customer customer = new Customer("hslee", 0.5);
		assertEquals(50, customer.applyDiscount(100));

		customer.becomePreferred();
		assertEquals(47, customer.applyDiscount(100));
	}

}
