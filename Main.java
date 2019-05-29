import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

   private static int numri;
   
   public static void main(String[] args) {
   
      String numriPersonave = JOptionPane.showInputDialog("How many people will be flying?");        
      try{
         numri = new Integer(numriPersonave).intValue();
      }
      catch(Exception e){
         JOptionPane.showMessageDialog(null, "Please enter a number between 1-5");
         return;
      }
      
      if(numri < 0){
         JOptionPane.showMessageDialog(null,"Please type a positive number."); }
      else if(numri > 5 ){
         JOptionPane.showMessageDialog(null, "The system cannot process more than 5 tickets at a time.");
      }
       
      else{ 
         Main main = new Main();
         HashMap<Integer, Integer> uleset = main.getSeats();
      
         new SeatsPanel(numri,uleset);
      }
   }

   public HashMap<Integer, Integer> getSeats() {
      HashMap<Integer, Integer> seats = new LinkedHashMap<>();
   
      seats.put(0,0);
      for(int i = 1; i <= 36; i++){
         seats.put(i,(int)Math.round(Math.random()));
      }
      return seats;
   }
}
