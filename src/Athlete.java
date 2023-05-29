import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Athlete {



    static ArrayList<int[]> gameSymptoms = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void inputSymptoms(){

        int[] symptomArray = new int[22];

        System.out.println("Please enter your headache score: ");
        symptomArray[0] = scan.nextInt();
        System.out.println("Please enter your pressure in head score: ");
        symptomArray[1] = scan.nextInt();
        System.out.println("Please enter your neck pain score: ");
        symptomArray[2] = scan.nextInt();
        System.out.println("Please enter your nausea or vomiting score: ");
        symptomArray[3] = scan.nextInt();
        System.out.println("Please enter your dizziness score: ");
        symptomArray[4] = scan.nextInt();
        System.out.println("Please enter your blurred vision score: ");
        symptomArray[5] = scan.nextInt();
        System.out.println("Please enter your balance problems score: ");
        symptomArray[6] = scan.nextInt();
        System.out.println("Please enter your sensitivity to light score: ");
        symptomArray[7] = scan.nextInt();
        System.out.println("Please enter your sensitivity to noise score: ");
        symptomArray[8] = scan.nextInt();
        System.out.println("Please enter your feeling slowed down score: ");
        symptomArray[9] = scan.nextInt();
        System.out.println("Please enter your feeling like in a fog score: ");
        symptomArray[10] = scan.nextInt();
        System.out.println("Please enter your don't feel right score: ");
        symptomArray[11] = scan.nextInt();
        System.out.println("Please enter your difficulty concentrating score: ");
        symptomArray[12] = scan.nextInt();
        System.out.println("Please enter your difficulty remembering score: ");
        symptomArray[13] = scan.nextInt();
        System.out.println("Please enter your fatigue or low energy score: ");
        symptomArray[14] = scan.nextInt();
        System.out.println("Please enter your confusion score: ");
        symptomArray[15] = scan.nextInt();
        System.out.println("Please enter your drowsiness score: ");
        symptomArray[16] = scan.nextInt();
        System.out.println("Please enter your trouble falling asleep score: ");
        symptomArray[17] = scan.nextInt();
        System.out.println("Please enter your more emotional score: ");
        symptomArray[18] = scan.nextInt();
        System.out.println("Please enter your irritability score: ");
        symptomArray[19] = scan.nextInt();
        System.out.println("Please enter your sadness score: ");
        symptomArray[20] = scan.nextInt();
        System.out.println("Please enter your nervous or anxious score: ");
        symptomArray[21] = scan.nextInt();
        System.out.println("Done!\r\n");


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
            System.out.println("The overall rating for game " + actualGameNum + " and the previous game is: "+ overallRating);
        }
    }

    public void riskyConditionIndicator(){

        int gameSize = gameSymptoms.size();
        if (gameSize == 1) {
            System.out.println("The risk indicator cannot be determined as there is only one game inputted");
        }else {
            String overallRating = calculateOverallRating(gameSize - 1);
            calculateRiskyCondition(overallRating);
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

    public void calculateRiskyCondition(String overallRating){

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

        System.out.println("The following is the Risky Condition indicator :");
        System.out.println("");
        if(overallRating.equals("Very different")){
            System.out.println(ANSI_RED_BACKGROUND + overallRating.toString() + ANSI_RESET + "\r\n");
        }else if(overallRating.equals("Unsure")){
            System.out.println(ANSI_YELLOW_BACKGROUND + overallRating.toString() + ANSI_RESET + "\r\n");
        }else if(overallRating.equals("No difference")){
            System.out.println(ANSI_GREEN_BACKGROUND + overallRating.toString() + ANSI_RESET + "\r\n");
        }
    }
}
