import controller.Controller;
import model.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.startGame(3);
    }
}