import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VotingSystem {

    private Map<String, Integer> candidates;

    public VotingSystem() {
        candidates = new HashMap<>();
    }

    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    public void vote(String name) {
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
        } else {
            System.out.println("Candidate not found.");
        }
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding candidates
        votingSystem.addCandidate("Alice");
        votingSystem.addCandidate("Bob");
        votingSystem.addCandidate("Charlie");

        System.out.println("Welcome to the Voting System!");
        System.out.println("Candidates: Alice, Bob, Charlie");
        System.out.println("Enter 'exit' to finish voting.");

        while (true) {
            System.out.print("Vote for a candidate: ");
            String vote = scanner.nextLine();

            if (vote.equalsIgnoreCase("exit")) {
                break;
            }

            votingSystem.vote(vote);
        }

        votingSystem.displayResults();
        scanner.close();
    }
}
