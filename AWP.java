public class AWP extends Firearm{
  public AWP(){
    super.setPenetVal(1.0);
    super.setDMGPotential(200);
    super.setAutomatic(false);
    super.setModel("AWP");
    super.setMagCap(5);
    super.setAccuracy(0.95);
  }
//one shot one kill at all ranges, takes a turn to reload

}
