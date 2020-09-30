package game.soldier;

public class MP5 extends Firearm{
  public MP5(){
    super.setPenetVal(0.3);
    super.setDMGPotential(100);
    super.setAutomatic(true);
    super.setModel("MP5");
    super.setMagCap(30);
    super.setAccuracy(0.7);
//unbeatable at close range against unarmoured opponents
  }
}
