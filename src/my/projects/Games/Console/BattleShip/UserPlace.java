package my.projects.Games.Console.BattleShip;

public class UserPlace {

    UserPlace() {
        System.out.println("\u001B[34mУ вас есть 4 корабля: Четырехпалубный, Трехпалубный, Двухпалубный и Однопалубный");
        System.out.println("Задайте координаты расположения корабля, например: 'C4' или 'c4' \nДля начала игры, расставьте все корабли или введите: 'S' или 's'");

        System.out.println("\u001B[34mУстановите четырехпалубный корабль.");
        placeShip(Ship.playerQuadruple);
        System.out.println("\u001B[34mУстановите трехпалубный корабль.");
        placeShip(Ship.playerTriple);
        System.out.println("\u001B[34mУстановите двухпалубный корабль.");
        placeShip(Ship.playerDouble);
        System.out.println("\u001B[34mУстановите однопалубный корабль.");
        placeShip(Ship.playerSingle);

    }


    static void placeShip(Ship ship) {
        boolean placeShip = false;
        while (!placeShip) {
            String input = ConsoleGameBattleShip.scanner.nextLine();
            if (input.length() == 1) {
                if (input.charAt(0) == 'S' | input.charAt(0) == 's') {
                    AIPlace.placeShips();
                    new Game();
                } else {
                    System.out.println("Неверный ввод. Для старта игры введите: S, s");
                }
            } else {
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
                    if (ship.size == 1) {
                        Board.playerBoard[y][x].used = true;
                        Board.printBoard();
                    } else {
                        System.out.println("Выберите ориентацию корабля: V, v = вертикальная, H, h = горизонтальная");
                        input = ConsoleGameBattleShip.scanner.nextLine();
                        if (input.length() == 1) {
                            if (input.charAt(0) == 'V' | input.charAt(0) == 'v') {

                                if (overlap(y, x, ship.size, 'V')) {
                                    System.out.println("Корабль перекрывается другим кораблем! Введите координаты повторно:");
                                } else {
                                    for (int i = 0; i < ship.size; i++) {
                                        Board.playerBoard[y + i][x].used = true;
                                    }
                                    placeShip = true;
                                }
                            } else if (input.charAt(0) == 'H' | input.charAt(0) == 'h') {

                                if (overlap(y, x, ship.size, 'H')) {
                                    System.out.println("Корабль перекрывается другим кораблем! Введите координаты повторно:");
                                } else {
                                    for (int i = 0; i < ship.size; i++) {
                                        Board.playerBoard[y][x + i].used = true;
                                    }
                                    placeShip = true;
                                }
                            } else {
                                System.out.println("Неверный ввод. Используйте символы: V, v, H, h");
                            }
                        }
                    }
                    Board.printBoard();
                } else {
                    System.out.println("Неверный ввод. Используйте координаты: А-j, 1-10");
                }
            }
        }
    }

    static boolean overlap(int y, int x, int shipSize, char orientation) {

        if (orientation == 'V') {
            for (int i = 0; i < shipSize; i++) {
                if (Board.playerBoard[y + i][x].used) {
                    return true;
                }
            }
        } else if (orientation == 'H') {
            for (int i = 0; i < shipSize; i++) {
                if (Board.playerBoard[y][x + i].used) {
                    return true;
                }
            }
        }
        return false;
    }


}
