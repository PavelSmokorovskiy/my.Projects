package my.projects.Games.Console.BattleShip;

class Ship  {
    static Ship playerSingle = new Ship(1);
    static Ship playerDouble = new Ship(2);
    static Ship playerTriple = new Ship(3);
    static Ship playerQuadruple = new Ship(4);
    static Ship enemySingle = new Ship(1);
    static Ship enemyDouble = new Ship(2);
    static Ship enemyTriple = new Ship(3);
    static Ship enemyQuadruple = new Ship(4);


    int size;
    public boolean placed;
    public boolean destroyed;
    public String location;
    public char orientation;

    Ship(int size) {
        this.size = size;
        placed = false;
        destroyed = false;
        location = "";
        orientation = ' ';
    }
}