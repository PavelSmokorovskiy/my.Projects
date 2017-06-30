package my.projects.Games.Console.BattleShip;

class Board {
    static Cell[][] playerBoard = {{new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()}};
    static Cell[][] enemyBoard = {{new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
            {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell()}};

    static void printBoard() {
        System.out.println("\u001B[35m          Игрок                      Противник");
        System.out.println("\u001B[32m   A B C D E F G H I J         A B C D E F G H I J");
        for (int y = 0; y < 10; y++) {
            if (y < 9) {
                System.out.print(" " + (1 + y) + " ");
            } else {
                System.out.print((1 + y) + " ");
            }
            for (int x = 0; x < 10; x++) {
                if (!playerBoard[y][x].used && !playerBoard[y][x].shooted) {
                    playerBoard[y][x].cell = "\u001B[32m_|";
                } else if (playerBoard[y][x].used && !playerBoard[y][x].shooted) {
                    playerBoard[y][x].cell = "\u001B[31mO\u001B[32m|";
                } else if (playerBoard[y][x].used && playerBoard[y][x].shooted) {
                    playerBoard[y][x].cell = "\u001B[31m*\u001B[32m|";
                } else if (!playerBoard[y][x].used && playerBoard[y][x].shooted) {
                    playerBoard[y][x].cell = "\u001B[31mx\u001B[32m|";
                }
                System.out.print(playerBoard[y][x].cell);
            }
            System.out.print("     ");
            if (y < 9) {
                System.out.print(" " + (1 + y) + " ");
            } else {
                System.out.print((1 + y) + " ");
            }
            for (int x = 0; x < 10; x++) {
                if (!enemyBoard[y][x].used && !enemyBoard[y][x].shooted) {
                    enemyBoard[y][x].cell = "_|";
                } else if (enemyBoard[y][x].used && !enemyBoard[y][x].shooted) {
                    enemyBoard[y][x].cell = "\u001B[31mO\u001B[32m|";
                } else if (enemyBoard[y][x].used && enemyBoard[y][x].shooted) {
                    enemyBoard[y][x].cell = "\u001B[31m*\u001B[32m|";
                } else if (!enemyBoard[y][x].used && enemyBoard[y][x].shooted) {
                    enemyBoard[y][x].cell = "\u001B[31mx\u001B[32m|";
                }
                System.out.print(enemyBoard[y][x].cell);
            }
            System.out.println();
        }


    }   //Выводит доску на экран
}

