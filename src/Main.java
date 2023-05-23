// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to add another game? (Y/N) ");
            String input = scanner.nextLine();
            if (input.equals("N")) {
                break;
            }
        }
    }
}