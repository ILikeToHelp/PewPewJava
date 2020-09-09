public class Game {
  private static boolean gameOver = false;
  public static void main(String[] args) {
    Game g = new Game();
  }
  public Game () {
    Board b = new Board();
    initialisePieces(b);
    b.printBoard();
  }
  public void initialisePieces(Board b){
    //Black pieces
    b.setSoldier(0,3,new Sniper(SoldierColour.RED));
    b.setSoldier(0,4,new Infantry(SoldierColour.RED));
    b.setSoldier(0,5,new Mercenary(SoldierColour.RED));


    b.setSoldier(8,3,new Sniper(SoldierColour.BLUE));
    b.setSoldier(8,4,new Infantry(SoldierColour.BLUE));
    b.setSoldier(8,5,new Mercenary(SoldierColour.BLUE));
  }
}
