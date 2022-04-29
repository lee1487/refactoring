package hello.refactoring._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Criminal {

	public String alertForMiscrent(List<Person> people) {
//		for (Person p : people) {
//			if (p.getName().equals("Don")) {
//				setOffAlarms();
//			}
//
//			if (p.getName().equals("John")) {
//				setOffAlarms();
//			}
//		}

		if (!findMiscreant(people).isBlank()) setOffAlarms();

		return "";
	}

	public String findMiscreant(List<Person> people) {
		for (Person p : people) {
			if (p.getName().equals("Don")) {
				return "Don";
			}

			if (p.getName().equals("John")) {
				return "John";
			}
		}

		return "";
	}

	private void setOffAlarms() {
		System.out.println("set off alarm");
	}
}
