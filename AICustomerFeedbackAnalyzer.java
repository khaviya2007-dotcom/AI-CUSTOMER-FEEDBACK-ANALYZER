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

    static ArrayList<Feedback> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int idCounter = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== AI CUSTOMER FEEDBACK ANALYZER =====");
            System.out.println("1. Add Feedback");
            System.out.println("2. View All Feedbacks");
            System.out.println("3. Analyze Sentiment Summary");
            System.out.println("4. Search Feedback by Keyword");
            System.out.println("5. Delete Feedback by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addFeedback();
                    break;
                case 2:
                    viewFeedbacks();
                    break;
                case 3:
                    sentimentSummary();
                    break;
                case 4:
                    searchFeedback();
                    break;
                case 5:
                    deleteFeedback();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addFeedback() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter feedback: ");
        String fb = sc.nextLine();

        String sentiment = analyzeSentiment(fb);

        list.add(new Feedback(idCounter++, name, fb, sentiment));

        System.out.println("Feedback added successfully!");
        System.out.println("Detected Sentiment: " + sentiment);
    }

    static String analyzeSentiment(String text) {
        text = text.toLowerCase();

        String[] positive = {"good", "great", "excellent", "amazing", "happy", "love"};
        String[] negative = {"bad", "poor", "worst", "hate", "slow", "issue"};

        for (String word : positive) {
            if (text.contains(word))
                return "Positive";
        }

        for (String word : negative) {
            if (text.contains(word))
                return "Negative";
        }

        return "Neutral";
    }

    static void viewFeedbacks() {
        if (list.isEmpty()) {
            System.out.println("No feedbacks available.");
            return;
        }

        System.out.println("\nID\tName\tFeedback\tSentiment");
        for (Feedback f : list) {
            System.out.println(f.id + "\t" + f.name + "\t" + f.feedback + "\t" + f.sentiment);
        }
    }

    static void sentimentSummary() {
        int pos = 0, neg = 0, neu = 0;

        for (Feedback f : list) {
            if (f.sentiment.equals("Positive"))
                pos++;
            else if (f.sentiment.equals("Negative"))
                neg++;
            else
                neu++;
        }

        System.out.println("\n===== SENTIMENT SUMMARY =====");
        System.out.println("Positive: " + pos);
        System.out.println("Negative: " + neg);
        System.out.println("Neutral : " + neu);
    }

    static void searchFeedback() {
        System.out.print("Enter keyword to search: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Feedback f : list) {
            if (f.feedback.toLowerCase().contains(key)) {
                System.out.println(f.id + " | " + f.name + " | " + f.feedback + " | " + f.sentiment);
                found = true;
            }
        }

        if (!found)
            System.out.println("No matching feedback found.");
    }

    static void deleteFeedback() {
        System.out.print("Enter feedback ID to delete: ");
        int id = sc.nextInt();

        boolean removed = list.removeIf(f -> f.id == id);

        if (removed)
            System.out.println("Feedback deleted successfully.");
        else
            System.out.println("Feedback ID not found.");
    }
}