package game.map;

public abstract class FieldType{

  private double concealment;
  private double cover;
  private double view;
  private char symbol;
  private int i;
  private int j;
  private boolean hasSoldier;
  private Soldier soldier;

  public char getSymbol(){return this.symbol;}
  public double getConcealmentRating(){return this.concealment;}
  public double getViewRange(){return this.view;}
  public double getCover(){return this.cover;}
  public int getI(){return this.i;}
  public int getJ(){return this.j;}
  public Soldier getSoldier(){return this.soldier;}
  public boolean hasSoldier(){return this.hasSoldier;}


  public void setSymbol(char symbol){this.symbol = symbol;}
  public void setCover(double cover){this.cover = cover;}
  public void setViewRange(double view){this.view = view;}
  public void setConcealment(double clmnt){this.concealment = clmnt;}
  public void setSoldier(Soldier newSoldier){
    this.soldier = newSoldier;
    this.hasSoldier = true;
  }


  public void removeSoldier(){
    this.soldier = null;
    this.hasSoldier = false;
  }

  public FieldType(int iIn, int jIn){
    this.i=iIn;
		this.j=jIn;
  }
}
