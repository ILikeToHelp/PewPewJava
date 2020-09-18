public class Infantry extends Soldier{
  public Infantry(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("I");
    super.setHealth(200);
    super.setGunPower(40);
    super.setProficiencyDistance(Distance.MEDIUM);

    // if(redOrBlue ==  SoldierColour.RED){
    //   super.setSymbol("\u26FC"); //camp
    // }
    // else{
    //   super.setSymbol("\u26FD"); //whatever
    // }
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
