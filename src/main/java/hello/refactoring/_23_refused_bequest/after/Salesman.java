package hello.refactoring._23_refused_bequest.after;

public class Salesman extends Employee {

	protected Quota quota;

	protected Quota getQuota() {
		return new Quota();
	}

}
