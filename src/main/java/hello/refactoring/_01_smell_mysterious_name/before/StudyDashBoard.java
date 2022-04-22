package hello.refactoring._01_smell_mysterious_name.before;



import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StudyDashBoard {

	
	private Set<String> usernames = new HashSet<>();
	private Set<String> reviews = new HashSet<>();
	
	/**
	 * 스터리 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
	 * @param issue
	 * @throws IOException
	 */

	private void loadReviews() throws IOException {
		GitHub gitHub = GitHub.connect();
		GHRepository repository = gitHub.getRepository("whiteship/live-study");
		GHIssue issue = repository.getIssue(30);
		
		List<GHIssueComment> reviews = issue.getComments();
		for (GHIssueComment review : reviews) {
			usernames.add(review.getUserName());
			this.reviews.add(review.getBody());
			
		}
	}
	
	public Set<String> getUsernames() {
		return usernames;
	}
	
	public Set<String> getReviews() {
		return reviews;
	}
	
	public static void main(String[] args) throws IOException {
		StudyDashBoard studyDashBoard = new StudyDashBoard();
		studyDashBoard.loadReviews();
		studyDashBoard.getUsernames().forEach(System.out::println);
		studyDashBoard.getReviews().forEach(System.out::println);
	}
}
