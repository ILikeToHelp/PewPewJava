public abstract class Firearm{
  private String model;
  private int damagePotential;
  private int magazineCapacity;
  private double penetrationValue;
  private double accuracy;
  private boolean isAutomatic;
  public Firearm(){}
  public String getModel(){return this.model;}
  public int getDMGPotential(){return this.damagePotential;}
  public int getMagCapacity(){return this.magazineCapacity;}
  public double getPenetVal(){return this.penetrationValue;}
  public double getAccuracy(){return this.accuracy;}
  public boolean isItAutomatic(){return this.isAutomatic;}
  public void setModel(String model){
    this.model = model;
  }
  public void setDMGPotential(int DMGp){
    this.damagePotential = DMGp;
  }
  public void setMagCap(int magCap){
    this.magazineCapacity = magCap;
  }
  public void setPenetVal(double penetVal){
    this.penetrationValue = penetVal;
  }
  public void setAccuracy(double accuracy){
    this.accuracy = accuracy;
  }
  public void setAutomatic(boolean isIt){
    this.isAutomatic = isIt;
  }
}
