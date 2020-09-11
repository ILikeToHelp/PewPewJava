public class Mercenary extends Soldier{
  public Mercenary(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("M");
    // if(redOrBlue ==  SoldierColour.RED){
    //   super.setSymbol("M"); //camp
    // }
    // else{
    //   super.setSymbol("M"); //whatever
    // }
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return false;
  }
}
