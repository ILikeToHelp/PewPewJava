public class Infantry extends Soldier{
  public Infantry(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("I");
    super.setHealth(200);
    super.setProficiencyDistance(Distance.MEDIUM);
    super.setFirearm(new M4());
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
