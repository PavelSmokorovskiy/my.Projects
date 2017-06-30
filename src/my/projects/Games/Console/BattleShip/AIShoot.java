package my.projects.Games.Console.BattleShip;

import java.util.Random;

public class AIShoot {
    static void shoot() {

        Random rand = new Random();
        Board.playerBoard[rand.nextInt(10)][rand.nextInt(10)].shooted = true;


    }

}
