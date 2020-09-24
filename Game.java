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
    System.out.println("The longest distance is: " + b.maxRange);
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

      Soldier dealer = b.getSoldier(i0, j0);
      if(dealer == null)
      {
        System.out.println("No soldier at entry coords...");
        continue;
      }
      else if (dealer.getColour() == SoldierColour.RED && !redsTurn
              || dealer.getColour() == SoldierColour.BLUE && redsTurn) {
        System.out.println("You dont get to move opponents soldiers.");
        continue;
      }
      if(option == 1)
      {
        if(dealer.isLegitMove(i0,j0,i1,j1))
        {
          b.moveSoldier(i0,j0,i1,j1, dealer);
        }
        else
        {
          System.out.println("This moved is not allowed.");
          continue;
        }
      }
      else {
        Soldier target = b.getSoldier(i1,j1);
        double damage = calculateDamage(i0,j0,i1,j1, dealer, target);
        if(target == null)
        {
          System.out.println("You're shooting grass, well done.");
          continue;
        }
        else if (target.getColour() == SoldierColour.RED && redsTurn
                || target.getColour() == SoldierColour.BLUE && !redsTurn) {
          System.out.println("Friendly fire is not allowed.");
          continue;
        }
        else if(target.alive(damage)){
          target.setHealth(target.getHealth()-damage);
          System.out.println("DMG:" + damage + " new hp:" + target.getHealth());
          //System.out.println("Theye're wounded, but they live through.");
        }
        else{
          System.out.println("Target eliminated.");
          b.removeSoldier(i1,j1);
          if(target.getColour() == SoldierColour.RED)
          {
            Game.redSoldiers--;
          }
          else
          {
            Game.blueSoldiers--;
          }
          }
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

  public double calculateDamage(int i0, int j0, int i1,
      int j1, Soldier dealer, Soldier target){

    /*
    If the target is in the dealer's proficiency distance, he takes full damage
    i.e. the dealer hits all shots and ignores cover

    else if the distance is off by 1 from profeciency
        there's 15% chance for the unit to miss (chance to miss = 0.15)

    else if the distance is off by 2
        chance to miss = 0.3

    now

    if dealer doesnt miss (Random r > chance to miss, where 0 < r < 1)


    there's  still a chance they hit the target, not the cover.
    that chance (called "clean hit") is equal to gun accuracy * (1 - cover)
    e.g. if the target has full cover (1.0) there is no chance for clean hit
    but if the target has no cover, chance to hit is equal to guns accuracy

    for a clean hit the target takes full damage
    else, damage is multiplied by the penetration value.
    e.g. for gun with high penetration (0.9) shooting through cover is close to
    full firearms potential damage
    but a firearm with low penetration (0.5) damage is sharply reduce

    TBC
    */
    double theDAMAGE = dealer.getFirearm().getDMGPotential();
    float chanceToMiss = 0;
    float cover = target.getCover();
    float penetration = dealer.getFirearm().getPenetration();
    float accuracy = dealer.getFirearm().getAccuracy();
    int distanceDifference = math.mod(
        dealer.distanceToEnemy(i0,j0,i1,j1) - dealer.getDistanceProficiency());
    if(distanceDifference == 0){
      return theDAMAGE;  //within profeciency distance, deal full damage
    }
    else if(distanceDifference == 1){
      chanceToMiss = 0.15;
    }
    else if(distanceDifference == 2){
      chanceToMiss = 0.3;
    }
    else{Exception somethingWentWrong = new WeirdException();}

    float precision = Random.between(0,1);

    if (precision > chanceToMiss){ /*dealer hits!
      is it a clean hit tho?*/
      cleanHitChance = dealer.getFirearm().getAccuracy() * (1.0 - cover);

      float isClean = Random.between(0,1);
      if(isClean < cleanHitChance){
        return theDAMAGE; //still full damage, if they hit precisely and cleanly
      }
      else{
      //hit, but not clean. So, reduce damage by mul with pen value
      theDAMAGE *= penetration;
      }

    }
    else{
      // YOU MISS, 0 dmg, lul, kek
    }
    return 0;
  };


}
