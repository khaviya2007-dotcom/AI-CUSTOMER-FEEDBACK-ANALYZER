import java.util.*;

class Feedback {
    int id;
    String name;
    String feedback;
    String sentiment;

    Feedback(int id, String name, String feedback, String sentiment) {
        this.id = id;
        this.name = name;
        this.feedback = feedback;
        this.sentiment = sentiment;
    }
}

public class AICustomerFeedbackAnalyzer {

    static HashMap<Integer, Feedback> map = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    static String analyzeSentiment(String feedback) {
        String text = feedback.toLowerCase();

        String[] positive = {
            "good", "great", "excellent", "happy",
            "amazing", "love", "best", "satisfied"
        };

        String[] negative = {
            "bad", "poor", "worst", "hate",
            "angry", "disappointed", "slow", "problem"
        };

        for (String word : positive) {
            if (text.contains(word)) {
                return "Positive";
            }
        }

        for (String word : negative) {
            if (text.contains(word)) {
                return "Negative";
            }
        }

        return "Neutral";
    }

    static void addFeedback() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        String sentiment = analyzeSentiment(feedback);

        Feedback f = new Feedback(id, name, feedback, sentiment);
        map.put(id, f);

        System.out.println("Feedback added successfully!");
        System.out.println("Feedback ID: " + id);
        System.out.println("Sentiment: " + sentiment);

        id++;
    }

    static void displayFeedback() {
        if (map.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        System.out.println("\n----- Customer Feedback -----");

        for (Feedback f : map.values()) {
            System.out.println("ID        : " + f.id);
            System.out.println("Name      : " + f.name);
            System.out.println("Feedback  : " + f.feedback);
            System.out.println("Sentiment : " + f.sentiment);
            System.out.println("-----------------------------");
        }
    }

    static void searchFeedback() {
        System.out.print("Enter feedback ID to search: ");
        int searchId = sc.nextInt();
        sc.nextLine();

        if (map.containsKey(searchId)) {
            Feedback f = map.get(searchId);

            System.out.println("ID        : " + f.id);
            System.out.println("Name      : " + f.name);
            System.out.println("Feedback  : " + f.feedback);
            System.out.println("Sentiment : " + f.sentiment);
        } else {
            System.out.println("Feedback ID not found.");
        }
    }

    static void updateFeedback() {
        System.out.print("Enter feedback ID to update: ");
        int searchId = sc.nextInt();
        sc.nextLine();

        if (map.containsKey(searchId)) {
            Feedback f = map.get(searchId);

            System.out.print("Enter new feedback: ");
            String feedback = sc.nextLine();

            f.feedback = feedback;
            f.sentiment = analyzeSentiment(feedback);

            map.put(searchId, f);

            System.out.println("Feedback updated successfully!");
            System.out.println("New Sentiment: " + f.sentiment);
        } else {
            System.out.println("Feedback ID not found.");
        }
    }

    static void deleteFeedback() {
        System.out.print("Enter feedback ID to delete: ");
        int searchId = sc.nextInt();
        sc.nextLine();

        if (map.containsKey(searchId)) {
            map.remove(searchId);
            System.out.println("Feedback deleted successfully!");
        } else {
            System.out.println("Feedback ID not found.");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== AI CUSTOMER FEEDBACK ANALYZER =====");
            System.out.println("1. Add Feedback");
            System.out.println("2. Display Feedback");
            System.out.println("3. Search Feedback");
            System.out.println("4. Update Feedback");
            System.out.println("5. Delete Feedback");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addFeedback();
                    break;

                case 2:
                    displayFeedback();
                    break;

                case 3:
                    searchFeedback();
                    break;

                case 4:
                    updateFeedback();
                    break;

                case 5:
                    deleteFeedback();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}