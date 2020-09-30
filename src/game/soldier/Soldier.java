package game.soldier;

public abstract class Soldier{
  private int speed;
  private int morale;
  private int price;
  private double health;
  private float cover;
  private String symbol;
  private Firearm firearm;
  protected SoldierColour colour;
  private Distance profeciency;
  private int gunPower; /*simplification of the Firearm class for testing,
                          to be replaced by calculations in getGunPower method */

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
  public void setCover(float cover){
    this.cover = cover;
  }
  public float getCover(){
    return this.cover;
  }
  public SoldierColour getColour(){
    return this.colour;
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
  public double getHealth(){
    return this.health;
  }
  public void setHealth(double hp) {
    this.health = hp;
  }
  public boolean alive(double dmg){
    if (this.health - dmg <= 0)
    {
      return false;
    }
    return true;
  }
  public Distance getDistanceProficiency(){
    return this.profeciency;
  }
  public void setProficiencyDistance(Distance x){
    this.profeciency = x;
  }
  public abstract boolean isLegitMove(int i0, int j0, int i1, int j1);

  public  Distance distanceToEnemy(int i0, int j0, int i1, int j1){
    double x = Math.sqrt(Math.pow((i1-i0),2) + Math.pow((j1-j0),2));
    if (x / Board.maxRange <= 0.3){
      return Distance.SHORT;
    }
    else if (x / Board.maxRange > 0.7){
      return Distance.LONG;
    }
    return Distance.MEDIUM;
  }

  public Firearm getFirearm(){
    return this.firearm;
  }
  public void setFirearm(Firearm firearm){
    this.firearm = firearm;
  }
}
