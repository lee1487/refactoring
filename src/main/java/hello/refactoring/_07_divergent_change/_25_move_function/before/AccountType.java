package hello.refactoring._07_divergent_change._25_move_function.before;

public class AccountType {

	private boolean premium;

	public AccountType(boolean premium) {
		this.premium = premium;
	}

	public boolean isPremium() {
		return this.premium;
	}


}
