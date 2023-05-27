import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Athlete {



    static ArrayList<int[]> gameSymptoms = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void inputSymptoms(){

        int[] symptomArray = new int[3];

        System.out.println("Please score yourself on the following symptoms on a scale of 0(none) to 6(severe)");
        System.out.println("Headache: ");
        symptomArray[0] = scan.nextInt();
        System.out.println("Pressure in head: ");
        symptomArray[1] = scan.nextInt();
        System.out.println("Neck Pain: ");
        symptomArray[2] = scan.nextInt();
//        System.out.println("Nausea or Vomiting: ");
//        symptomArray[3] = scan.nextInt();
//        System.out.println("Dizziness: ");
//        symptomArray[4] = scan.nextInt();
//        System.out.println("Blurred Vision: ");
//        symptomArray[5] = scan.nextInt();
//        System.out.println("Balance Problems: ");
//        symptomArray[6] = scan.nextInt();
//        System.out.println("Sensitivity to light: ");
//        symptomArray[7] = scan.nextInt();
//        System.out.println("Sensitivity to noise: ");
//        symptomArray[8] = scan.nextInt();
//        System.out.println("Feeling slowed down: ");
//        symptomArray[9] = scan.nextInt();
//        System.out.println("Feeling like in a fog: ");
//        symptomArray[10] = scan.nextInt();
//        System.out.println("Don't feel right: ");
//        symptomArray[11] = scan.nextInt();
//        System.out.println("Difficulty concentrating: ");
//        symptomArray[12] = scan.nextInt();
//        System.out.println("Difficulty Remembering: ");
//        symptomArray[13] = scan.nextInt();
//        System.out.println("Fatigue or low energy: ");
//        symptomArray[14] = scan.nextInt();
//        System.out.println("Confusion: ");
//        symptomArray[15] = scan.nextInt();
//        System.out.println("Drowsiness: ");
//        symptomArray[16] = scan.nextInt();
//        System.out.println("Trouble falling asleep: ");
//        symptomArray[17] = scan.nextInt();
//        System.out.println("More Emotional: ");
//        symptomArray[18] = scan.nextInt();
//        System.out.println("Irritability: ");
//        symptomArray[19] = scan.nextInt();
//        System.out.println("Sadness: ");
//        symptomArray[20] = scan.nextInt();
//        System.out.println("Nervous or anxious: ");
//        symptomArray[21] = scan.nextInt();
        System.out.println("Thank you!\r\n");


        gameSymptoms.add(symptomArray);
        if (gameSymptoms.size() > 5){
            gameSymptoms.remove(0);
        }

    }

    public void symptomSummary(){

        int gameNum;
        int gameSize = gameSymptoms.size();

        System.out.println("You have " + gameSize + " stored games. Which game do you want to see the summary for?");
        if (gameSize <5){
            System.out.println("Please select between 1 - " + gameSize);
        }else{
            System.out.println("Please select between the last 5 games: 1 - 5");
        }
        gameNum = scan.nextInt() - 1;
        int actualGameNum = gameNum + 1;

        int totalSymptoms = calculateTotalSymptoms(gameNum);
        System.out.println("The total number of symptoms is: "+ totalSymptoms);

        int severityScore = calculateSeverityScore(gameNum);
        System.out.println("The symptom severity score is: "+ severityScore);

        if (gameSize == 1 || gameNum == 0) {
            System.out.println("The overall rating cannot be calculated as there is only one game inputted or you have selected the first game\r\n");
        }else{
            String overallRating = calculateOverallRating(gameNum);
            System.out.println("The overall rating for game " + actualGameNum + " and the previous game is: "+ overallRating + "\r\n");
        }
    }

    public String calculateOverallRating(int gameNum){

        String overallRating = "";

        int totalSymptoms1 = calculateTotalSymptoms(gameNum);
        int totalSymptoms2 = calculateTotalSymptoms(gameNum - 1);

        int severityScore1 = calculateSeverityScore(gameNum);
        int severityScore2 = calculateSeverityScore(gameNum - 1);

        int totalSymptomdiff = Math.abs(totalSymptoms1 - totalSymptoms2);
        int totalSeveritydiff = Math.abs(severityScore1 - severityScore2);

        if (totalSymptomdiff < 3 && totalSeveritydiff < 10){
            overallRating = "No difference";
        } else if (totalSymptomdiff < 3 && totalSeveritydiff >= 10) {
            overallRating = "Unsure";
        } else if (totalSymptomdiff >= 3 || totalSeveritydiff >= 15) {
            overallRating = "Very different";
        }

        return overallRating;
    }

    public int calculateSeverityScore(int gameNum){
        int severityScore = 0;
        for(int i = 0; i < gameSymptoms.get(gameNum).length; i++){
            severityScore += gameSymptoms.get(gameNum)[i];
        }
        return severityScore;
    }

    public int calculateTotalSymptoms(int gameNum){
        int totalSymptoms = 0;
        for (int i = 0; i < gameSymptoms.get(gameNum).length; i++){
            if(gameSymptoms.get(gameNum)[i] != 0){
                totalSymptoms++;
            }
        }
        return totalSymptoms;
    }

    public void printData(){
        for (int i = 0; i < gameSymptoms.size(); i++) {
            System.out.println(Arrays.toString(gameSymptoms.get(i)));
        }
    }
}
