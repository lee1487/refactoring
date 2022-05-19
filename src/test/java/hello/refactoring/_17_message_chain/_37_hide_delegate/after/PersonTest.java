package hello.refactoring._17_message_chain._37_hide_delegate.after;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void manager() {
		Person hslee = new Person("hslee");
		Person nick = new Person("nick");
		hslee.setDepartment(new Department("m365deploy", nick));
		
		Person manager = hslee.getManager();
		assertEquals(nick, manager);
	}

}
