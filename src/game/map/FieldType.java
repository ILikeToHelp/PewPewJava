package game.map;

public abstract class FieldType{
  private double concealment;
  private double cover;
  private double view;
  private char symbol;

  public char getSymbol(){return this.symbol;}
  public double getConcealmentRating(){return this.concealment;}
  public double getViewRange(){return this.view;}
  public double getCover(){return this.cover;}

  public void setSymbol(char symbol){this.symbol = symbol;}
  public void setCover(double cover){this.cover = cover;}
  public void setViewRange(double view){this.view = view;}
  public void setConcealment(double clmnt){this.concealment = clmnt;}

  public FieldType(){};
}
