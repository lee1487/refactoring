package hello.refactoring._09_feature_envy.after;

public class Bill {

	private ElectricityUsage electricityUsage;
	private GasUsage gasUsage;

	public double calculateBill() {
		return electricityUsage.getElectricityBill() * gasUsage. getGasBill();
	}





}
