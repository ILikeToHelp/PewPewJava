package game.map;

public class Plain extends FieldType{
  public Plain(){
    super.setSymbol('P');
    super.setCover(0);
    super.setViewRange(1);
    super.setConcealment(0);
  }
}
