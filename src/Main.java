import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean runProgram = true;

        Athlete athlete = new Athlete();
        Scanner scan = new Scanner(System.in);


        while(runProgram){

            System.out.println("Please select one of the following options:");
            System.out.println("1. Enter Symptoms");
            System.out.println("2. Display Symptoms Summary");
            System.out.println("3. Am I at Risk?");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-4):");

            int userType = Integer.parseInt(scan.nextLine());

            switch (userType) {
                case 1:
                    athlete.inputSymptoms();
                    break;
                case 2:
                    System.out.println("4. ");
                    break;
                case 3:
                    System.out.println("4. Exit");
                    break;
                case 4:
                    System.out.println("Exiting Application");
                    runProgram = false;
                    break;
            }
        }
    }
}