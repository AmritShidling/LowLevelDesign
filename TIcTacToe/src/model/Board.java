package model;

import util.Piece;

public class Board {
    Piece board[][];
    int count;
    public Board(int count){
        this.count = count;
        board = new Piece[this.count][this.count];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public int getCount() {
        return count;
    }
}
