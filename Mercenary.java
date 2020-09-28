public class Mercenary extends Soldier{
  public Mercenary(SoldierColour redOrBlue){
    super(redOrBlue);
    super.setSymbol("M");
    super.setHealth(100);
    super.setProficiencyDistance(Distance.SHORT);
    super.setFirearm(new MP5());
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return true;
  }
}
