import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Invalid input provided.");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}

public class CustomException {
    public static int processInput(int input) throws InvalidInputException {
        if (input < 0) {
            throw new InvalidInputException("Input must be a positive integer.");
        }
        return input;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int a = sc.nextInt();
            int result = processInput(a);
            System.out.println("Input processing successful: " + a);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input error: " + e.getMessage());
        }
    }
}
