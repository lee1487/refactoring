package hello.refactoring._13_loop._33_replace_loop_with_pipeline.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author {

	private String company;
	private String twitterHandle;

	public Author(String company, String twitterHandle) {
		this.company = company;
		this.twitterHandle = twitterHandle;
	}

	static public List<String> twitterHandles(List<Author> authors, String company) {
		return authors.stream()
				.filter(a -> a.equals(company))
				.map(author -> author.twitterHandle)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

	}

}
