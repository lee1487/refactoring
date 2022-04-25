package hello.refactoring._03_long_function._12_split_loop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
	private List<Participant> participants;
	private Participant[] firstParticipantsForEachEvents;

	public StudyDashboard(int totalNumberOfEvents) {
		this.totalNumberOfEvents = totalNumberOfEvents;
		participants = new CopyOnWriteArrayList<>();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		StudyDashboard studyDashboard = new StudyDashboard(15);
		studyDashboard.print();
	}

	private void print() throws IOException, InterruptedException {
		checkGithubIssues(getGhRepository());
		new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();
		printFirstParticipants();
	}

	private void printFirstParticipants() {
		Arrays.stream(firstParticipantsForEachEvents).forEach(p -> System.out.println(p.username()));
	}

	private GHRepository getGhRepository() throws IOException {
		GitHub gitHub = GitHub.connect();
		GHRepository repository = gitHub.getRepository("whiteship/live-study");
		firstParticipantsForEachEvents = new Participant[this.totalNumberOfEvents];
		return repository;
	}

	private void checkGithubIssues(GHRepository repository) throws InterruptedException {
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

						checkHomework(participants, eventId, comments);
						firstParticipantsForEachEvents[eventId - 1] = findFirst(participants, comments);

						latch.countDown();
					} catch (IOException e) {
						throw new IllegalArgumentException(e);
					}
				}

			});
		}

		latch.await();
		service.shutdown();
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

	private Participant findFirst(List<Participant> participants, List<GHIssueComment> comments) throws IOException {
		Date firstCreatedAt = null;
		Participant first = null;
		for (GHIssueComment comment : comments) {
			Participant participant = findParticipant(comment.getUserName(), participants);

			if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
				firstCreatedAt = comment.getCreatedAt();
				first = participant;
			}
		}
		return first;
	}

	private void checkHomework(List<Participant> participants, int eventId, List<GHIssueComment> comments) {
		for (GHIssueComment comment : comments) {
			Participant participant = findParticipant(comment.getUserName(), participants);
			participant.setHomeworkDone(eventId);
		}
	}

}
