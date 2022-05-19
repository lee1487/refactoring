package hello.refactoring._16_temporary_field._36_introduce_special_case.after;

public class PaymentHistory {

	private int weeksDelinquentInLastYear;

	public PaymentHistory(int weeksDelinquentInLastYear) {
		this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
	}
	
	public int getWeeksDelinquentInLastYear() {
		return weeksDelinquentInLastYear;
	}
	
	
}
