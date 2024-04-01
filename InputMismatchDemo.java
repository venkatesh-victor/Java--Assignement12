import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your phone number: ");
        String phNo = sc.nextLine();
        
        try {
            if(!phNo.matches("[0-9]+")) {
                throw new InputMismatchException();
            } else {
                System.out.println("That is a valid phone number!!!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid phone number.");
            System.out.println("Enter a valid one.");
        }
    }
}
