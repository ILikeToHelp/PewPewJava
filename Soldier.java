public abstract class Soldier{
  private int speed;
  private int morale;
  private int price;
  private int shootingPower;
  private double health;
  private double cover;
  private String symbol;
  protected SoldierColour colour;

  public SoldierColour getColour(){
    return this.colour;
  }
  public Soldier (SoldierColour redOrBlue){
    this.colour = redOrBlue;
    if(redOrBlue == SoldierColour.RED)
    {
      Game.redSoldiers++;
    }
    else
    {
      Game.blueSoldiers++;
    }
  }
  public String getSymbol(){
    return this.symbol;
  }
  public void setSymbol(String symbolIn){
    this.symbol = symbolIn;
  }
  public int getShootingPower(){
    return this.shootingPower;
  }
  public void setShootingPower(int sp){
    this.shootingPower = sp;
  }
  public double getHealth(){
    return this.health;
  }
  public void setHealth(double hp) {
    this.health = hp;
  }
  public boolean alive(int dmg){
    if (this.health - dmg <= 0)
    {
      return false;
    }
    else
    {
    this.health -= dmg;
    }
    return true;
  }

  public abstract boolean isLegitMove(int i0, int j0, int i1, int j1);
}
