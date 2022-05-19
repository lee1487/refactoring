package hello.refactoring._13_loop._33_replace_loop_with_pipeline.after;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class AuthorTest {

	@Test
	void twiterHandler() {
		Author hslee = new Author("ms", null);
		Author whiteship = new Author("naver", "whiteship");
		assertEquals(List.of("whiteship"), Author.twitterHandles(List.of(hslee, whiteship), "naver"));
		
	}

}
