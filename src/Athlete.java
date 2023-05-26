import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Athlete {



    static ArrayList<int[]> gameSymptoms = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void inputSymptoms(){

        int[] symptomArray = new int[22];

        System.out.println("Please enter Symptoms for the latest game");
        System.out.println("Please score yourself on the following symptoms on a scale of 0(none) to 6(severe)");
        System.out.println("Headache: ");
        symptomArray[0] = scan.nextInt();
        System.out.println("Pressure in head: ");
        symptomArray[1] = scan.nextInt();
        System.out.println("Neck Pain: ");
        symptomArray[2] = scan.nextInt();
        System.out.println("Nausea or Vomiting: ");
        symptomArray[3] = scan.nextInt();
        System.out.println("Dizziness: ");
        symptomArray[4] = scan.nextInt();
        System.out.println("Blurred Vision: ");
        symptomArray[5] = scan.nextInt();
        System.out.println("Balance Problems: ");
        symptomArray[6] = scan.nextInt();
        System.out.println("Sensitivity to light: ");
        symptomArray[7] = scan.nextInt();
        System.out.println("Sensitivity to noise: ");
        symptomArray[8] = scan.nextInt();
        System.out.println("Feeling slowed down: ");
        symptomArray[9] = scan.nextInt();
        System.out.println("Feeling like in a fog: ");
        symptomArray[10] = scan.nextInt();
        System.out.println("Don't feel right: ");
        symptomArray[11] = scan.nextInt();
        System.out.println("Difficulty concentrating: ");
        symptomArray[12] = scan.nextInt();
        System.out.println("Difficulty Remembering: ");
        symptomArray[13] = scan.nextInt();
        System.out.println("Fatigue or low energy: ");
        symptomArray[14] = scan.nextInt();
        System.out.println("Confusion: ");
        symptomArray[15] = scan.nextInt();
        System.out.println("Drowsiness: ");
        symptomArray[16] = scan.nextInt();
        System.out.println("Trouble falling asleep: ");
        symptomArray[17] = scan.nextInt();
        System.out.println("More Emotional: ");
        symptomArray[18] = scan.nextInt();
        System.out.println("Irritability: ");
        symptomArray[19] = scan.nextInt();
        System.out.println("Sadness: ");
        symptomArray[20] = scan.nextInt();
        System.out.println("Nervous or anxious: ");
        symptomArray[21] = scan.nextInt();
        System.out.println("Thank you!");

        System.out.println(Arrays.toString(symptomArray));

        gameSymptoms.add(symptomArray);

    }

    public void printdata(){
        for (int i = 0; i < gameSymptoms.size(); i++) {
            System.out.println(Arrays.toString(gameSymptoms.get(i)));
        }
    }

}
