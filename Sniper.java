public class Sniper extends Soldier{
  public Sniper(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("S");
    super.setGunPower(100);
    super.setHealth(50);
    // if(redOrBlue ==  SoldierColour.RED){
    //   super.setSymbol("\u26FE"); //camp
    // }
    // else{
    //   super.setSymbol("\u26FF"); //whatever
    // }
  }

  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
