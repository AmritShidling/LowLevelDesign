import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
    private Dice dice;
    private Deque<Player> players;
    private List<Jumper> snake;
    private List<Jumper> ladder;
    Map<String, Integer> playerCurrentPosition;
    int boardSize;

    public Board(Dice dice, Deque<Player> players, List<Jumper> snake, List<Jumper> ladder, Map<String, Integer> playerCurrentPosition, int boardSize) {
        this.dice = dice;
        this.players = players;
        this.snake = snake;
        this.ladder = ladder;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        while (players.size() > 1){
            Player player = players.poll();
            System.out.println("Please press key and enter to roll dice "+ player.getName());
            scanner.next();
            int currentPosition = playerCurrentPosition.get(player.getId());
            int diceValue = dice.rollDice();
            System.out.println(String.format("Dice value is %d", diceValue));
            int nextPosition = diceValue + currentPosition;
            if(nextPosition > boardSize){
                players.offer(player);
            }
            else if(nextPosition == boardSize){
                System.out.println(player.getName() +" Won the game");
            }
            else{
                for(Jumper s: snake){
                    if(nextPosition == s.getStart()){
                        nextPosition = s.getEnd();
                    }
                }
                for (Jumper l: ladder){
                    if(nextPosition == l.getStart()){
                        nextPosition = l.getEnd();
                    }
                }
                players.offer(player);
            }
            playerCurrentPosition.put(player.getId(), nextPosition);
            System.out.println(String.format("Next position of %s is %d", player.getName(),  nextPosition));
        }
    }
}
