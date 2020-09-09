public class Mercenary extends Soldier{
  public Mercenary(SoldierColour redOrBlue){
    super(redOrBlue);
    if(redOrBlue ==  SoldierColour.RED){
      super.setSymbol("\u26FA"); //camp
    }
    else{
      super.setSymbol("\u26FB"); //whatever
    }
  }
  @Override
  public boolean isLegitMove(int j0, int i0, int j1, int i1){
    return false;
  }
}
