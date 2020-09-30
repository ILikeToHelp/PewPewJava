package game.map;

public class Tree extends FieldType{
  public Tree(){
    super.setSymbol('T');
    super.setCover(0.3);
    super.setConcealment(0.3);
    super.setViewRange(0.9);
  }
}
