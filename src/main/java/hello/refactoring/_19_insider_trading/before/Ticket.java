package hello.refactoring._19_insider_trading.before;

import java.time.LocalDate;

public class Ticket {

	private LocalDate purchasesDate;
	private boolean prime;

	public Ticket(LocalDate purchasesDate, boolean prime) {
		this.purchasesDate = purchasesDate;
		this.prime = prime;
	}
	
	public LocalDate getPurchasesDate() {
		return purchasesDate;
	}
	
	public boolean isPrime() {
		return prime;
	}
	
	
}
