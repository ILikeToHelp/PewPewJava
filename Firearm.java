public abstract class Firearm{
  private String model;
  private int damagePotential;
  private int magazineCapacity;
  private float rangeValue;
  private double penetrationValue;
  private boolean isAutomatic;
  public Firearm(){}
  public String getModel(){return this.model;}
  public int getDMGPotential(){return this.damagePotential;}
  public int getMagCapacity(){return this.magazineCapacity;}
  public float getRangeVal(){return this.rangeValue;}
  public double getPenetVal(){return this.penetrationValue;}
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
  public void setRangeVal(float rangeVal){
    this.rangeValue = rangeVal;
  }
  public void setPenetVal(double penetVal){
    this.penetrationValue = penetVal;
  }
  public void setAutomatic(boolean isIt){
    this.isAutomatic = isIt;
  }
}
