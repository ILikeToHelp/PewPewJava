package game.map;

public class Rock extends FieldType{
  public Rock(){
    super.setSymbol('R');
    super.setCover(0.6);
    super.setViewRange(0.9);
    super.setConcealment(0.1);
  }
}
