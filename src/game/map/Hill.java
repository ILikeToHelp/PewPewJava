package game.map;

public class Hill extends FieldType{
  public Hill(){
    super.setSymbol('H');
    super.setCover(0);
    super.setConcealment(0);
    super.setViewRange(3);
  }
}
