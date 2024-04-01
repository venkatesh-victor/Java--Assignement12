import java.util.Scanner;

public class ArrayIndexDemo {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("I have an array that contains the first 5 natural numbers.");
        System.out.println("Input an index to access the number in the array...");
        int index = sc.nextInt();

        try {
            System.out.println("The element in that index is: " + arr[index]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! It looks like you have entered a number which is not in the bounds of the array index.");
            System.out.println("Enter a valid index next time.");
            System.out.println("Bye bye!!!");
        }
    }
    
}
