public abstract class Soldier{
  private int speed;
  private int morale;
  private int price;
  private int gunPower; //simplification of the Firearm class for testing
  private int health;
  private double cover;
  private String symbol;
  private Firearm firearm;
  protected SoldierColour colour;

  public void setPrice(int price){
    this.price = price;
  }
  public int getPrice(){
    return this.price;
  }
  public void setSpeed(int speed){
    this.speed = speed;
  }
  public int getSpeed(){
    return this.speed;
  }
  public void setMorale(int morale){
    this.morale = morale;
  }
  public int getMorale(){
    return this.morale;
  }
  public void setCover(double cover){
    this.cover = cover;
  }
  public double getCover(){
    return this.cover;
  }
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
  public void setSymbol(String symbol){
    this.symbol = symbol;
  }
  public int getGunPower(){
    return this.gunPower;
  }
  public void setGunPower(int gunPower){
    this.gunPower = gunPower;
  }
  public int getHealth(){
    return this.health;
  }
  public void setHealth(int hp) {
    this.health = hp;
  }
  public boolean alive(int dmg){
    if (this.health - dmg <= 0)
    {
      return false;
    }
    return true;
  }

  public abstract boolean isLegitMove(int i0, int j0, int i1, int j1);
}
