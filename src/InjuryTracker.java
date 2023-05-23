import java.util.Scanner;
import java.util.Arrays;
public class InjuryTracker {

    private static final int MAX_GAMES = 5;

    private String athleteName;
    private Game[] games;

    public InjuryTracker(String athleteName) {
        this.athleteName = athleteName;
        this.games = new Game[MAX_GAMES];
    }

    public void addGame(Game game) {
        for (int i = 0; i < games.length; i++) {
            if (games[i] == null) {
                games[i] = game;
                break;
            }
        }
    }

    public void printGames() {
        for (Game game : games) {
            System.out.println(game);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the athlete's name: ");
        String athleteName = scanner.nextLine();

        InjuryTracker injuryTracker = new InjuryTracker(athleteName);

        while (true) {
            System.out.println("Enter the game date: ");
            String gameDate = scanner.nextLine();

            System.out.println("Enter the symptom severity for each factor (1-10): ");
            int[] symptomSeverities = new int[1];
            for (int i = 0; i < symptomSeverities.length; i++) {
                symptomSeverities[i] = scanner.nextInt();
            }

            Game game = new Game(gameDate, symptomSeverities);
            injuryTracker.addGame(game);

            System.out.println("Would you like to add another game? (Y/N) ");
            String input = scanner.nextLine();
            if (input.equals("N")) {
                break;
            }
        }

        System.out.println("Here are the athlete's most recent games: ");
        injuryTracker.printGames();
    }
}

class Game {

    private String gameDate;
    private int[] symptomSeverities;

    public Game(String gameDate, int[] symptomSeverities) {
        this.gameDate = gameDate;
        this.symptomSeverities = symptomSeverities;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameDate='" + gameDate + '\'' +
                ", symptomSeverities=" + Arrays.toString(symptomSeverities) +
                '}';
    }
}