package hello.refactoring._11_primitive_obsession._30_repliace_primitive_with_object.after;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import hello.refactoring._11_primitive_obsession._30_repliace_primitive_with_object.after.Order;
import hello.refactoring._11_primitive_obsession._30_repliace_primitive_with_object.after.OrderProcessor;

class OrderProcessorTest {

	@Test
	void numberOfHighPriorityOrders() {
		OrderProcessor orderProcessor = new OrderProcessor();
		long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
				List.of(new Order("low"),
						new Order("normal"),
						new Order("high"),
						new Order("rush")));
		assertEquals(2, highPriorityOrders);
	}

}
