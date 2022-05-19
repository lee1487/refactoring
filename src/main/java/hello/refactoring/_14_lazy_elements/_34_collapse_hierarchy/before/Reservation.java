package hello.refactoring._14_lazy_elements._34_collapse_hierarchy.before;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {

	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private List<String> members;
	private StringBuilder owner;
	private boolean paid;
	private String courtNumber;
}
