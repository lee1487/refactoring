package hello.refactoring._08_shotgun_surgery._28_inline_function.before;

public class Driver {

	private int numberOfLateDeliveries;

	public Driver(int numberOfLateDeliveries) {
		this.numberOfLateDeliveries = numberOfLateDeliveries;
	}

	public int getNumberOfLateDeliveries() {
		return numberOfLateDeliveries;
	}


}
