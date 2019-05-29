import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class ReserveTicketsPanel extends JFrame {

   protected int people;
   protected ArrayList<Integer> seats;
   protected int count = 0;
   protected JTextField name;
   protected JTextField surname;
   protected JTextField email;
   protected String flightDate = "";
   protected String returnDate = "";
   protected String fromC="";
   protected String toC ="";
   protected int seatChoosen;
   protected int seatChoosenIndex;
   protected JLabel title;
   
   Database database = new Database();

   ReserveTicketsPanel(int people, ArrayList<Integer> freeSeats) {
      this.people = people;
      this.seats = freeSeats;
   
      JFrame f = new JFrame("Ticket");       
      JPanel panel = new ReserveTickets();
      panel.setBounds(0, 0, 800, 600);
   
   
      title = new JLabel();
      title.setText("Fill information for each  person, one at a time");
      title.setFont(new Font("Serif", Font.ITALIC, 30));
      title.setBounds(100, 40, 600, 30);
      
      JLabel nameLabel = new JLabel("Name:");
      nameLabel.setBounds(100, 100, 80, 30);
   
      name = new JTextField(20);
      name.setBounds(200, 100, 150, 30);
   
      JLabel surnameLabel = new JLabel("Surname:");
      surnameLabel.setBounds(100, 200, 80, 30);
   
      surname = new JTextField(20);
      surname.setBounds(200, 200, 150, 30);
   
      JLabel emailLabel = new JLabel("Email:");
      emailLabel.setBounds(100, 300, 80, 30);
   
      email = new JTextField(20);
      email.setBounds(200, 300, 150, 30);
   
      JLabel seatsLabel = new JLabel("Seat:");
      seatsLabel.setBounds(100, 400, 80, 30);
   
      JComboBox seatsList = new JComboBox(seats.toArray());
      seatsList.addItemListener(
         new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
               seatChoosen =(int) itemEvent.getItem();
               seatChoosenIndex = seatsList.getSelectedIndex();
            }
         });
      
      JLabel fromDate = new JLabel("Flight Date:");
      fromDate.setBounds(400,100,80,30);
    
      JComboBox datacombobox = new JComboBox();
      datacombobox.setBounds(500, 100, 130, 30);
      datacombobox.setEditable(false);
      datacombobox.addItemListener(
         e -> {
         
            flightDate = String.valueOf(datacombobox.getSelectedItem());
         
         });

       Calendar calendar = Calendar.getInstance();
      for (int i = 0; i < 300; ++i) {
      
       SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

         datacombobox.addItem(data.format(calendar.getTime()));
         calendar.add(Calendar.DATE, 1);
      }

      JLabel returnD = new JLabel("Return Date:");
      returnD.setBounds(400, 200, 80, 30);
   
      JComboBox datacombobox1 = new JComboBox();
      datacombobox1.setBounds(500, 200, 130, 30);
      datacombobox1.setEditable(false);
      datacombobox1.addItemListener(
         (ItemEvent e) -> {
         
            returnDate = String.valueOf(datacombobox1.getSelectedItem());
         
         });
         
      Calendar calendar1 = Calendar.getInstance();
      
      for (int i = 0; i < 300; ++i) {
      
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

           datacombobox1.addItem(data.format(calendar1.getTime()));
         calendar1.add(Calendar.DATE, 1);
      }
      
     
      String []cities = new String[7];
      
      cities[0] = "--";
      cities[1] ="Prishtina";
      cities[2] = "Amsterdam";
      cities[3] = "Milan";
      cities[4] = "London";
      cities[5] = "Berlin";
      cities[6] = "Paris";

      
      JLabel fromText1 = new JLabel("From:");
      fromText1.setBounds(440, 300, 50, 30);
   

      JComboBox fromOptions = new JComboBox(cities);
      fromOptions.setBounds(500, 300, 130, 30);
      fromOptions.setEditable(false);
      fromOptions.addItemListener(e -> fromC = String.valueOf(fromOptions.getSelectedItem()));
      
   
      JLabel toText1 = new JLabel("To:");
      toText1.setBounds(440, 400, 30, 30);
        
      JComboBox toOptions = new JComboBox(cities);
      toOptions.setBounds(500, 400, 130, 30);
      toOptions.setEditable(false);
      toOptions.addItemListener(
         (ItemEvent e) -> {
            toC = String.valueOf(toOptions.getSelectedItem());
         });
      
      JButton button = new JButton("Next");
      button.setBounds(200, 500, 80, 30);
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                            
            if (!validation()){
            return;
            }
            else { try{
            
               Date flightDateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(flightDate);
               Date returnDateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(returnDate);
               
               if(flightDateCheck.after(returnDateCheck)){
               
                  JOptionPane.showMessageDialog(null,"Flight date cannot be after return date.");
                  
                  return;
               } 
            
            } 
            catch(Exception e ){
            }

            OnePersonTicket onePersonTicket = new OnePersonTicket(name.getText(), surname.getText(), email.getText(), seatChoosen, flightDate,returnDate,fromC,toC);
            
            database.addPerson(onePersonTicket);
            
               name.setText("");
               surname.setText("");
               email.setText("");
               seatsList.removeItem(seatChoosen);
               seatsList.setSelectedIndex(0);
               count = count + 1;
            
               if (count == people - 1) {
               
                  button.setText("DONE");
               } 
              
               else if (count == people) {
                  f.dispose();
                  new TicketPrintPanel(database.getListaPersonave());
               }
            }
         }});
      seatsList.setBounds(200, 400, 150, 30);
   
   
      f.getContentPane().add(panel);
      f.setSize(800, 600);
      f.add(nameLabel);
      f.add(name);
      f.add(button);
      f.add(surnameLabel);
      f.add(surname);
      f.add(email);
      f.add(emailLabel);
      f.add(title);
      f.add(seatsLabel);
      f.add(seatsList);
      f.setLayout(null);
      f.setLocationRelativeTo(null);
      f.add(fromDate);
      f.add(datacombobox);
      f.add(returnD);
      f.add(datacombobox1);
      f.add(toText1);
      f.add(fromOptions);
      f.add(fromText1);
      f.add(toOptions);

      pack();
      f.setVisible(true);
      f.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   
   protected boolean validation(){
   boolean isRight = true;
     if(name.getText() == "" || name.getText().length() == 0) {
                  isRight = false;
                  JOptionPane.showMessageDialog(null,"Please fill in your name.");
               }
            
               else if(surname.getText() == "" || surname.getText().length() == 0 ) {
                  isRight = false;
                  JOptionPane.showMessageDialog(null,"Please fill in your surname.");

               }
            
               else if(email.getText() == "" || email.getText().length() == 0) {
                  isRight = false;
                  JOptionPane.showMessageDialog(null,"Please fill in your email.");

               }
              else if( !email.getText().contains("@")) {
              isRight = false;
              JOptionPane.showMessageDialog(null, "Email should contain @"); }
               else if(seatChoosen == 0){
                isRight = false;
                JOptionPane.showMessageDialog(null,"Please select your seat.");
                    }
               
            else   if(fromC == "" || fromC.length() == 0){
                               isRight = false;

               JOptionPane.showMessageDialog(null, "Choose city");
              
               }
               
             else  if(toC == "" || toC.length() == 0){
                               isRight = false;

               JOptionPane.showMessageDialog(null, "Choose city");
             
               }
               return isRight;

   }
   protected class ReserveTickets extends JPanel {
   
   
      @Override
      public void paint(Graphics graphics) {
      
      }
   }


}
