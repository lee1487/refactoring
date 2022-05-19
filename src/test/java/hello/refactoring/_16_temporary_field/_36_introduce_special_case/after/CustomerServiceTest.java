package hello.refactoring._16_temporary_field._36_introduce_special_case.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerServiceTest {

	CustomerService customerService = new CustomerService();
	Customer unknown = new Customer("unknown", null, null);
	BillingPlan hsleeBillingPlan = new BillingPlan();
	Customer hslee = new Customer("hslee", hsleeBillingPlan, new PaymentHistory(1));
	
	@Test
	void customerName() {
		String unknownCustomerName = customerService.customerName(new Site(unknown));
		assertEquals("occupant", unknownCustomerName);
		
		String customer = customerService.customerName(new Site(hslee));
		assertEquals("hslee", customer);
	}
	
	@Test
	void billingPlan() {
		assertTrue((customerService.billingPlan(new Site(unknown)) instanceof BasicBillingPlan));
		
		assertEquals(hsleeBillingPlan, customerService.billingPlan(new Site(hslee)));
	}
	
	@Test
	void weeksDelinquent() {
		assertEquals(1, customerService.weeksDelinquent(new Site(hslee)));
		assertEquals(0, customerService.weeksDelinquent(new Site(unknown)));
		
	}

}
