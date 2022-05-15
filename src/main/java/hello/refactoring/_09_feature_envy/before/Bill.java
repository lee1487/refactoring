package hello.refactoring._09_feature_envy.before;

public class Bill {

	private ElectricityUsage electricityUsage;
	private GasUsage gasUsage;

	public double calculateBill() {
		var electicityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
		var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();

		return electicityBill * gasBill;
	}
}
