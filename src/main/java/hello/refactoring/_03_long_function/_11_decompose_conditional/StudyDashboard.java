package hello.refactoring._03_long_function._11_decompose_conditional;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StudyDashboard {

	final int totalNumberOfEvents;

	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		StudyDashboard studyDashboard = new StudyDashboard(15);
		studyDashboard.print();
	}

	private Participant findParticipant(String username, List<Participant> participants) {
		return isNewParticipant(username, participants) ? createNewParticipant(username, participants)
				: findExistingParticipant(username, participants);
	}

	private Participant findExistingParticipant(String username, List<Participant> participants) {
		return participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
	}

	private Participant createNewParticipant(String username, List<Participant> participants) {
		Participant participant = new Participant(username);
		participants.add(participant);
		return participant;
	}

	private boolean isNewParticipant(String username, List<Participant> participants) {
		return participants.stream().noneMatch(p -> p.username().equals(username));
	}

	private void print() throws IOException, InterruptedException {
		GitHub gitHub = GitHub.connect();
		GHRepository repository = gitHub.getRepository("whiteship/live-study");
		List<Participant> participants = new CopyOnWriteArrayList<>();

		ExecutorService service = Executors.newFixedThreadPool(8);
		CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

		for (int index = 1; index <= totalNumberOfEvents; index++) {
			int eventId = index;
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						GHIssue issue = repository.getIssue(eventId);
						List<GHIssueComment> comments = issue.getComments();

						for (GHIssueComment comment : comments) {
							Participant participant = findParticipant(comment.getUserName(), participants);
							participant.setHomeworkDone(eventId);
						}

						latch.countDown();
					} catch (IOException e) {
						throw new IllegalArgumentException(e);
					}
				}

			});
		}

		latch.await();
		service.shutdown();

		new StudyPrinter(this.totalNumberOfEvents, participants).execute();
	}

}
