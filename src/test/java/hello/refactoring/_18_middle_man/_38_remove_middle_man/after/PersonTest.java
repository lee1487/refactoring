package hello.refactoring._18_middle_man._38_remove_middle_man.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void getManager() {
		Person nick = new Person("nick", null);
		Person hslee = new Person("hslee", new Department(nick));
		assertEquals(nick, hslee.getDepartment().getManager());
	}

}
