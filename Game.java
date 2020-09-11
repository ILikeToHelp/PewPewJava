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

    while(redSoldiers > 0 && blueSoldiers > 0)
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("\n- - - - - - - - - ");
      if(redsTurn){
        System.out.println("It's RED's move.");
      }
      else {
        System.out.println("It's BLUE's move.");
      }
      System.out.println("- - - - - - - - - \n");
      while(true){
        System.out.println("Choose option:\n1.Move 2.Shoot");
        try {
          option = sc.nextInt();
          if(option > 2)
          {
            throw new ArithmeticException("Only 1 or 2 are valid options");
          }
          System.out.println(option);
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
        String from = scr.nextLine();
        from = from.toLowerCase();
        if(validCoordinates(from))
        {
          System.out.println("Type target coordinates: ");
          Scanner scan = new Scanner(System.in);
          String to = scan.nextLine();
          to = to.toLowerCase();
          if(validCoordinates(to))
          {
            validCoords = true;
          }
        }
        else
        {
          System.out.println("From incorrect.");
        }
        if (validCoords == false)
        {
          System.out.println(" ! ! ! ! ! ! ! \n Invalid coords. Try again.\n");
        }
      }
      if(option == 1) {

      }
      else {

      }

      redsTurn = !redsTurn;
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
