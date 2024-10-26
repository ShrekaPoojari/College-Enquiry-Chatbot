import java.util.Scanner;

public class CollegeEnquiryChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to College Enquiry Chatbot. Type 'exit' to end the conversation.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }
            String botResponse = DatabaseConnection.getResponse(userInput);
            System.out.println("Bot: " + botResponse);
        }
        scanner.close();
    }
}
