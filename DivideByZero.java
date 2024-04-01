import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter divdend: ");
        int a = sc.nextInt();

        System.out.print("Enter divisor: ");
        int b = sc.nextInt();

        try {
            System.out.println("The quotient is: " + a / b);
        } 
        catch(ArithmeticException e) {
            System.out.println("You have attempted to divide by zero.");
            System.out.println("It is not possible.");
        }

    }
}