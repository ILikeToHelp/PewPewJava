import java.util.Scanner;

public class Game {

  private static boolean gameOver = false;
  public static int redSoldiers = 0;
  public static int blueSoldiers = 0;

  public static void main(String[] args) {
    Game g = new Game();
  }

  public Game () {
    Board b = new Board();
    initialisePieces(b);
    b.printBoard();
    boolean redsTurn = true;
    int option = 0;
    String from;
    String to;
    int i0 = 0;
    int j0 = 0;
    int i1 = 0;
    int j1 = 0;
    while(redSoldiers > 0 && blueSoldiers > 0)
    {
      System.out.println("\n- - - - - - - - - ");
      if(redsTurn){
        System.out.println("It's RED's move.");
      }
      else {
        System.out.println("It's BLUE's move.");
      }
      System.out.println("- - - - - - - - - \n");
      while(true){

        b.printBoard();

        System.out.println("Choose option:\n1.Move 2.Shoot");
        try {
          Scanner sc = new Scanner(System.in);
          option = sc.nextInt();
          if(option > 2)
          {
            throw new ArithmeticException("Only 1 or 2 are valid options");
          }
          break;
        }
        catch (Exception e) {
          System.out.println("Invalid option. Try again.\n");
            option = 0;
        }
      }
      boolean validCoords = false;
      while(!validCoords)
      {
        System.out.println("Type coordinates of your soldier: ");
        Scanner scr = new Scanner(System.in);
        from = scr.nextLine();
        from = from.toLowerCase();
        if(validCoordinates(from))
        {
          System.out.println("Type target coordinates: ");
          Scanner scan = new Scanner(System.in);
          to = scan.nextLine();
          to = to.toLowerCase();
          if(validCoordinates(to))
          {
            validCoords = true;
            i0 = (int) from.charAt(0) - 49;
            j0 = (int) from.charAt(1) - 97;
            i1 = (int) to.charAt(0) - 49;
            j1 = (int) to.charAt(1) - 97;
          }
        }
        else
        {
          System.out.println("From incorrect.");
        }
        if (validCoords == false)
        {
          System.out.println("\nInvalid coords. Try again.\n");
        }
      }

      Soldier s = b.getSoldier(i0, j0);
      if(s == null)
      {
        System.out.println("No soldier at entry coords...");
        continue;
      }
      else if (s.getColour() == SoldierColour.RED && !redsTurn
              || s.getColour() == SoldierColour.BLUE && redsTurn) {
        System.out.println("Not your soldier.");
        continue;
      }
      if(option == 1)
      {
        if(s.isLegitMove(i0,j0,i1,j1))
        {
          b.moveSoldier(i0,j0,i1,j1, s);
        }
        else
        {
          System.out.println("This moved is not allowed.");
          continue;
        }
      }
      else {
        Soldier pray = b.getSoldier(i0,j0);
        if(pray == null)
        {
          System.out.println("You're shooting grass, well done.");
          continue;
        }
        else if (pray.getColour() == SoldierColour.RED && !redsTurn
                || pray.getColour() == SoldierColour.BLUE && redsTurn) {
          System.out.println("Friendly fire is not allowed.");
          continue;
        }
        else if(pray.alive(s.getShootingPower())){
          System.out.println("Their wounded, but they live through.");
        }
        else{
          System.out.println("Target eliminated.");
          b.removeSoldier(i1,j1);
        }

      redsTurn = !redsTurn;
    }
  }
}
  public boolean validCoordinates(String input){

    char[] inputArray;
    inputArray = input.toCharArray();

    if (inputArray.length != 2){
      return false;
    }

    int j = (int) inputArray[0]- 49;
    int i = (int) inputArray[1]- 97;

    if (i < 0 | i > 8 | j < 0 | j > 8){
      return false;
    }
    return true;
  }

  public void initialisePieces(Board b){
    //Black pieces
    b.setSoldier(0,3,new Sniper(SoldierColour.RED));
    b.setSoldier(0,4,new Infantry(SoldierColour.RED));
    b.setSoldier(0,6,new Mercenary(SoldierColour.RED));


    b.setSoldier(8,2,new Sniper(SoldierColour.BLUE));
    b.setSoldier(7,7,new Infantry(SoldierColour.BLUE));
    b.setSoldier(6,1,new Mercenary(SoldierColour.BLUE));
  }
}
