import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {


    ArrayList<OnePersonTicket> listaPersonave = new ArrayList<>();


    protected void addPerson(OnePersonTicket personTicket) {

        listaPersonave.add(personTicket);
    }

    protected ArrayList<OnePersonTicket> getListaPersonave() {
        return listaPersonave;
    }
     
    @Override
    public String toString() {
        return "Database{" +
                "listaPersonave=" + listaPersonave +
                '}';
    }
}

