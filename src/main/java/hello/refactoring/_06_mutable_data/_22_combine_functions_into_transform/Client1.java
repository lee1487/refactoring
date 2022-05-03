package hello.refactoring._06_mutable_data._22_combine_functions_into_transform;

import hello.refactoring._06_mutable_data._22_combine_functions_into_transform.Reading;
import hello.refactoring._06_mutable_data._22_combine_functions_into_transform.ReadingClient;

public class Client1 extends ReadingClient{

	double baseCharge;

	public Client1(Reading reading) {
		this.baseCharge = enrichReading(reading).baseCharge();
	}


	public double getBaseCharge() {
		return baseCharge;
	}
}
