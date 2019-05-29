public class OnePersonTicket {


    protected String name;
    protected String surname;
    protected String email;
    protected int seat;
    protected String flightDate;
    protected String returnDate;
    protected String fromC;
    protected String toC;

    public OnePersonTicket(String name, String surname, String email, int seat,String flightDate, String returnDate, String fromC,String toC) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.seat = seat;
        this.flightDate = flightDate;
        this.returnDate = returnDate;
        this.fromC = fromC;
        this.toC = toC;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getFlightDate() {
      return flightDate;
   }
   
   public void setFlightDate(String flightDate) {
      this.flightDate = flightDate;
   }

   public String getReturnDate() {
      return returnDate;
   }
   
   public void setReturnDate(String returnDate) {
      this.returnDate = returnDate;
   }


   public String getFromC() {
      return fromC;
   }
   
   public void setFromC(String fromC) {
      this.fromC = fromC;
   }

   public String getToC() {
      return toC;
   }
   
    public void setToC(String toC) {
      this.toC = toC;
   }


    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "OnePersonTicket{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", seat=" + seat +
                '}';
    }
}
