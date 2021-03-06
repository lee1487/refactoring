package hello.refactoring._19_insider_trading.after;

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

	public boolean isFastPass() {
		LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
		return isPrime() && getPurchasesDate().isBefore(earlyBirdDate);
	}


}
