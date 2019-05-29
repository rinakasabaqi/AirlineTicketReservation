import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class TicketPrintPanel extends JFrame {

    protected ArrayList<OnePersonTicket> personTickets;
    
    protected int size; 

    TicketPrintPanel(ArrayList<OnePersonTicket> persons) {

        personTickets = persons;
        
        size =  personTickets.size();
        JFrame f = new JFrame("Ticket");
        JPanel panel = new TicketPanel();
        panel.setBounds(0, 0, 800, 700);

        f.getContentPane().add(panel);
        f.setSize(800, 700);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        int x = 10;
        int y = 10;
        int w = 80;
        int h = 20;

        for (OnePersonTicket personTicket : personTickets) {

            JLabel name = new JLabel("Name:");
            name.setBounds(x, y, 80, 30);

            JLabel emripernime = new JLabel(personTicket.getName());
            emripernime.setBounds(x+80, y, 80, 30);
            
            JLabel date = new JLabel("Flight Date:");
            date.setBounds(x+160,y,80,30);
            
            JLabel data = new JLabel(personTicket.getFlightDate());
            data.setBounds(x+250,y,80,30);

            JLabel surname = new JLabel("Surname:");
            surname.setBounds(x, y+20, 80, 30);

            JLabel mbiemri = new JLabel(personTicket.getSurname());
            mbiemri.setBounds(x + 80, y+20, 80, 30);

            JLabel rdate = new JLabel("Return Date:");
            rdate.setBounds(x+160,y+20,80,30);
            
            JLabel rdata = new JLabel(personTicket.getReturnDate());
            rdata.setBounds(x+250,y+20,80,30);
            
            JLabel seat = new JLabel("Seat:");
            seat.setBounds(x, y+40, 80, 30);

            JLabel ulesja = new JLabel(personTicket.getSeat()+"");
            ulesja.setBounds(x + 80, y+40, 80, 30);
            
            JLabel from = new JLabel("From:");
            from.setBounds(x+160,y+40,80,30);
            
            JLabel fromC = new JLabel(personTicket.getFromC());
            fromC.setBounds(x+200,y+40,80,30);
            
                  
            JLabel to = new JLabel("To:");
            to.setBounds(x+275,y+40,80,30);
            
            JLabel toC = new JLabel(personTicket.getToC());
            toC.setBounds(x+295,y+40,80,30);
            
            f.add(rdata);
            f.add(rdate);
            f.add(from);
            f.add(fromC);
            f.add(to);
            f.add(toC);
            

            JLabel vija = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            vija.setBounds(x,y+60,800,30);
            
            y = y + 120;
            f.add(name);
            f.add(surname);
            f.add(mbiemri);
            f.add(seat);
            f.add(date);
            f.add(data);
            f.add(ulesja);
            f.add(emripernime);
            f.add(vija);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);

        }

        JButton doneButton = new JButton("Done");
        doneButton.setBounds(600,600,80,30);
        f.add(doneButton);
        doneButton.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               f.dispose();
               System.exit(0);
            
} 
});
        
        pack();
        f.setVisible(true);

    }


    protected class TicketPanel extends JPanel {
        @Override
        public void paint(Graphics graphics) {

        }
    }


}
