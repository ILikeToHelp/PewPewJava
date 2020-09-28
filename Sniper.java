public class Sniper extends Soldier{
  public Sniper(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("S");
    super.setHealth(50);
    super.setProficiencyDistance(Distance.LONG);
    super.setFirearm(new AWP());
  }

  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
