package game.map;

public class Bush extends FieldType{
  public Bush(){
    super.setSymbol('B');
    super.setCover(0);
    super.setViewRange(0.9);
    super.setConcealment(1);
  }
}
