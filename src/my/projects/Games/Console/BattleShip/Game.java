package my.projects.Games.Console.BattleShip;

public class Game {

    Game(){
        Board.printBoard();
        System.out.println("\u001B[35mИгра началась!\u001B[34m");
        while (!checkWin()) {
            shoot();
        }
    }

    static void shoot() {
        Board.printBoard();
        String input = ConsoleGameBattleShip.scanner.nextLine();
        checkPlayerShoot(input);

    }

    static boolean checkPlayerShoot(String input) {

        int x = -1;

        if (input.charAt(0) >= 'A' && input.charAt(0) <= 'J') {
            x = (int) input.charAt(0) - 65; //Преобразует 'А' в 0
        } else if (input.charAt(0) >= 'a' && input.charAt(0) <= 'j') {
            x = (int) input.charAt(0) - 97; //Преобразует 'a' в 0
        }

        int start = 1;
        int end = input.length();
        char buf[] = new char[end - start];
        input.getChars(start, end, buf, 0);   //Извлекает цифры
        int y = Integer.parseInt(new String(buf)) - 1;  //Преобразует char[] в int

        if (0 <= x && x <= 9 && 0 <= y && y <= 9) {
            if (Board.enemyBoard[y][x].used) {
                Board.enemyBoard[y][x].shooted = true;
                System.out.println("Попал");
            } else {
                Board.enemyBoard[y][x].shooted = true;
                AIShoot.shoot();
                Board.printBoard();
                System.out.println("Мимо");
            }
            return Board.enemyBoard[y][x].used;
        } else {
            System.out.println("Неверный ввод. Используйте координаты: А-j, 1-10");
        }

        return false;

    }

    static boolean checkWin() {
        int playerShipCounter = 0;
        int enemyShipCounter = 0;
        for (int y = 0; y < Board.playerBoard.length; y++) {
            for (int x = 0; x < Board.playerBoard.length; x++) {
                if (Board.playerBoard[y][x].used & !Board.playerBoard[y][x].shooted) {
                    playerShipCounter++;
                }
            }
        }
        for (int y = 0; y < Board.enemyBoard.length; y++) {
            for (int x = 0; x < Board.enemyBoard.length; x++) {
                if (Board.enemyBoard[y][x].used & !Board.enemyBoard[y][x].shooted) {
                    enemyShipCounter++;
                }
            }
        }
        System.out.println("Ваш остаток кораблей:" + playerShipCounter + "      Остаток кораблей противника:" + enemyShipCounter);
        System.out.println("Ваш ход:");

        if (playerShipCounter == 0) {
            System.out.println("К сожалению Вы проиграли! Игра закончилась.");
            return true;
        } else if (enemyShipCounter == 0) {
            System.out.println("Поздравляем! Вы выиграли! Игра закончилась.");
            return true;
        }
        return false;
    }

}
