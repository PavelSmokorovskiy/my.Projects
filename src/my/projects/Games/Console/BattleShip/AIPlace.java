package my.projects.Games.Console.BattleShip;

public class AIPlace {
    static void placeShips() {

        Board.enemyBoard[0][1].used = true;
        Board.enemyBoard[1][1].used = true;
        Board.enemyBoard[2][1].used = true;
        Board.enemyBoard[3][1].used = true;
        Board.enemyBoard[3][6].used = true;
        Board.enemyBoard[3][7].used = true;
        Board.enemyBoard[3][8].used = true;
        Board.enemyBoard[5][3].used = true;
        Board.enemyBoard[6][3].used = true;
        Board.enemyBoard[7][7].used = true;
        Board.printBoard();



    }

}
