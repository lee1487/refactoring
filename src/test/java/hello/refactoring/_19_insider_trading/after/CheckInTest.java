package hello.refactoring._19_insider_trading.after;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CheckInTest {

	@Test
	void isFastPass() {
		assertTrue(new Ticket(LocalDate.of(2021, 12, 31), true).isFastPass());
		assertFalse(new Ticket(LocalDate.of(2021, 12, 31), false).isFastPass());
		assertFalse(new Ticket(LocalDate.of(2022, 1, 2), true).isFastPass());
	}

}
