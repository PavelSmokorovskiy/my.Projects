package my.projects.Games.Console.BattleShip;

import java.util.Scanner;

public class ConsoleGameBattleShip {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        main();
    }   //Main для вызова из текущего пакета

    public static void main (){

        Board.printBoard();
        new UserPlace();
        AIPlace.placeShips();
        new Game();

    }   //Main для вызова из других пакетов
}
