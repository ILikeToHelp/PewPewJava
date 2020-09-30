package game.map;

public class Square {
	private int i;
	private int j;
	private boolean hasSoldier;
	private Soldier s;

	public Square(int iIn, int jIn){
		this.i=iIn;
		this.j=jIn;
	}
  public void setSoldier(Soldier newS){
    this.s = newS;
    this.hasSoldier = true;
  }
  public Soldier getSoldier(){
    return this.s;
  }
  public boolean hasSoldier(){
    return this.hasSoldier;
  }
  public void removeSoldier(){
    this.s = null;
    this.hasSoldier = false;
  }
	public int getI(){
		return this.i;
	}
	public int getJ(){
		return this.j;
	}

}
