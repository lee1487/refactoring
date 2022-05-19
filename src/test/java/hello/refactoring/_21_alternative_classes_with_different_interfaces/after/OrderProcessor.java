package hello.refactoring._21_alternative_classes_with_different_interfaces.after;

public class OrderProcessor {

	private NotificationService notificationService;

	public OrderProcessor(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void notifyShipping(Shipping shipping) {
		sendNotification(Notification.newNotification(shipping.getOrder() + " is shipped")
												.receiver(shipping.getEmail())
												.sender("no-reply@whiteship.com"));
    }

	private void sendNotification(Notification notification) {
		notificationService.sendNotification(notification);
	}
}
