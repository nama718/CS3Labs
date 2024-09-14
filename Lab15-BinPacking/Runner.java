import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Runner {
  public static void main(String[] args) {
      try {
        Scanner scan = new Scanner(new File("C:/Users/amanb/Documents/CS3-Labs/Lab15-BinPacking/input20.txt"));
        ArrayList<Integer> f = new ArrayList<>();
        while(scan.hasNext()) 
        f.add(scan.nextInt());
        Sorters x = new Sorters();
        x.BestFit(f);
        
        
        
      } 
      catch(Exception ex) {
        }
  }
}