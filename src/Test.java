import java.util.Random;

public class Test{
  public static void main(String args[]){
    Random r = new Random();
    double precision = 0 + r.nextDouble() * (1 - 0);
    System.out.println(precision);
  }
}
