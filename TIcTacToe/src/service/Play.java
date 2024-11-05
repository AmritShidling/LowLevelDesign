package service;

import model.Board;
import model.Player;
import util.Piece;
import util.Status;

public class Play {
    public Status markMove(Board board, int r, int c, Player player){
        Piece[][] b = board.getBoard();
        if(r < 0 || c < 0 || r >= board.getCount() || c >= board.getCount() || b[r][c] != null){
            System.out.println("PLease enter valid move!");
            return Status.RETRY;
        }
        Piece piece = player.getPiece();

        b[r][c] =piece;
        for(int i = 0; i < board.getCount(); i++) {
            if ( (b[i][0] == b[i][1] && b[i][1] == b[i][2] && b[i][1] == piece) || (b[0][i] == b[1][i] && b[1][i] == b[2][i] && b[2][i] == piece)) {
                System.out.println(player.getName() + " Won the game");
                printBoard(board);
                return Status.END;
            }
        }

        if(b[0][0] == b[1][1] && b[1][1] == b[2][2] && b[2][2] == piece || (b[0][2] == b[1][1] && b[1][1] == b[2][0] && b[2][0] == piece)){
            System.out.println(player.getName() + " Won the game");
            printBoard(board);
            return Status.END;
        }

        boolean tie = true;
        for(int i = 0; i < board.getCount(); i++) {
            for(int j = 0; j < board.getCount(); j++)
                if ( b[i][j] != null) {
                    tie = false;
                    break;
                }
        }
        printBoard(board);
        if (tie)
        System.out.println("It is a Tie!");
        return tie ? Status.END : Status.CONTINUE;
    }

    public void printBoard(Board board){
        for(int i = 0; i < board.getCount(); i++){
            System.out.print("|");
            for(int j = 0; j < board.getCount(); j++){
                System.out.print(board.getBoard()[i][j] == null? "   |" : " " +board.getBoard()[i][j]+" |");
            }
            System.out.println();
        }
    }
}
