package hello.refactoring._21_alternative_classes_with_different_interfaces.after;

public class OrderAlerts {

	private NotificationService notificationService;

	public OrderAlerts(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void alertShipped(Order order) {
		sendNotification(Notification.newNotification(order.toString() + " is shipped"));
	}

	private void sendNotification(Notification notification) {
		notificationService.sendNotification(notification);
	}
}
