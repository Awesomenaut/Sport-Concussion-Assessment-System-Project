import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Athlete athlete = new Athlete();

        System.out.println("Please select one of the following options:");
        System.out.println("1. Enter Symptoms");
        System.out.println("2. Display Symptoms Summary");
        System.out.println("3. Am I at Risk?");
        System.out.println("4. Exit");
        System.out.println("Enter your choice (1-4):");

        String userType = scan.nextLine();

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        // Add an array to the end of the list.
        String[] array = {"This", "is", "an", "array"};
        list.add(Arrays.toString(array));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        switch(userType){
            case "1":
                athlete.inputSymptoms();
                break;
            case "2":
                System.out.println("4. ");
                break;
            case "3":
                System.out.println("4. Exit");
                break;
            case "4":
                System.out.println("Exiting Application");
                break;
        }

    }
}