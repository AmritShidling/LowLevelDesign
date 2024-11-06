import java.util.*;

public class SnakeLadderOrchestrator {
    public SnakeLadderOrchestrator(){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board size");
        int boardSize = scanner.nextInt();

        System.out.println("Enter Number of Dice");
        Dice dice = new Dice(scanner.nextInt());
        Deque<Player> players = new LinkedList<>();
        System.out.println("Enter Number of Players");
        int numPlayers = scanner.nextInt();
        Map<String, Integer> currentPosition = new HashMap<>();
        for(int i = 0; i < numPlayers; i++){
            System.out.println(String.format("Enter  player %d name: ", i+1));
            String name = scanner.next();
            Player player = new Player(name);
            players.add(player);
            currentPosition.put(player.getId(), 0);
        }
        System.out.println("Enter Number of Snakes");

        List<Jumper> snakes = new LinkedList<>();
        int snakeCount = scanner.nextInt();

        while(snakes.size() < snakeCount){
            System.out.println(String.format("Enter snake %d start position: ", snakes.size()+1));
            int start = scanner.nextInt();
            System.out.println(String.format("Enter snake %d end position: ", snakes.size()+1));
            int end = scanner.nextInt();
            if(start < end || end < 1 || start >= boardSize) {
                System.out.println("Enter valid snake");
            }
            else {
                snakes.add(new Jumper(start, end));

            }
        }
        System.out.println("Enter Number of Ladders");

        List<Jumper> ladders = new LinkedList<>();
        int ladderCount = scanner.nextInt();
        while (ladders.size()<ladderCount){
            System.out.println(String.format("Enter ladder %d start position: ", ladders.size()+1));
            int start = scanner.nextInt();
            System.out.println(String.format("Enter ladder %d end position: ", ladders.size()+1));
            int end = scanner.nextInt();
            if(start > end || start < 1 || end >= boardSize) {
                System.out.println("Enter valid ladder");
            }
            else
                ladders.add(new Jumper(start, end));
        }

        Board board = new Board(dice, players, snakes, ladders, currentPosition, boardSize);
        board.startGame();
    }
}
