package controller;

import model.Board;
import model.Player;
import service.Play;
import util.Piece;
import util.Status;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Controller {

    Deque<Player> players;
    Play play = new Play();
    public void startGame(int count){
        Board board = new Board(count);
        players = new LinkedList<>();
        Player playerX = new Player("Amrit", Piece.X);
        Player playerO = new Player("Shidling", Piece.O);
        players.add(playerX);
        players.add(playerO);

        Status status = Status.CONTINUE;
        while (!status.equals(Status.END)){
            Player player= players.poll();
            System.out.println("Enter your move "+ player.getName());
            do {

            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

                status = play.markMove(board, row, col, player);

            } while (status.equals(Status.RETRY));

            players.offer(player);
        }
    }

}
