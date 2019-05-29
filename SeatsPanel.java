import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SeatsPanel extends JFrame {

   private int people;
   private HashMap<Integer, Integer> seats;


   SeatsPanel(int people, HashMap<Integer, Integer> seats) {
   
      this.people = people;
      this.seats = seats;
   
      JFrame f = new JFrame("Available seats chart");
      JPanel panel = new DrawSeats(seats);
      panel.setBounds(0, 0, 800, 600);
      
      JLabel freeSeats = new JLabel("Seats chart at the moment");
      freeSeats.setBounds(250, 20, 500, 30);
      freeSeats.setFont(new Font("Serif", Font.ITALIC, 30));

   
      JButton buttonReserve = new JButton("Reserve Tickets");
      buttonReserve.setBounds(300, 500, 200, 30);
   
      buttonReserve.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               f.dispose();
            
               ArrayList<Integer> freeSeats = new ArrayList<Integer>();
               for (int seat : seats.keySet()) {
                  if (seats.get(seat)==1) {
                  
                        //is reserved
                  } else {
                     freeSeats.add(seat);
                  }
               }
               new ReserveTicketsPanel(people, freeSeats);
            }
         });
         
      f.add(buttonReserve);
      f.add(freeSeats);
      f.getContentPane().add(panel);
      f.setSize(800, 600);
      f.setLocationRelativeTo(null);
      f.setLayout(null);
      f.setVisible(true);
      f.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }


   protected class DrawSeats extends JPanel {
      HashMap<Integer, Integer> seats;
   
      DrawSeats(HashMap<Integer, Integer> seats) {
      
         this.seats = seats;
      }
   
      @Override
        public void paint(Graphics graphics) {
         int x = 300;
         int y = 80;
         int i = 0;
         for (int seat : seats.keySet()) {
            if(seat == 0 ){
            }
            else{    
               if (seats.get(seat)==1) {
                  graphics.drawString("X", x, y);
               } else {
                  graphics.drawString(String.valueOf(seat), x, y);
               }
               i += 1;
               x += 20;
               if( i == 2) {
                  x +=100;
               }
               if (i == 4) {
                  y += 50;
                  x = 300;
                  i = 0;
               
               
               }
            }
         
         }
      
      }
   }
}



