public class Mercenary extends Soldier{
  public Mercenary(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("M");
    super.setHealth(100);
    super.setGunPower(40);
    super.setProficiencyDistance(Distance.SHORT);

    // if(redOrBlue ==  SoldierColour.RED){
    //   super.setSymbol("M"); //camp
    // }
    // else{
    //   super.setSymbol("M"); //whatever
    // }
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
