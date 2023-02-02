package main;
import javax.swing.*;
import java.sql.SQLException;


public class zapis extends polaczenie {

    public void zapisanie(String nazwa_czynnosci, String godzina, String waznosc) {

        try {
            pst = con.prepareStatement("insert into lista(Nazwa,godzina,waznosc) values(?,?,?)");
            pst.setString(1, nazwa_czynnosci);
            pst.setString(2, godzina);
            pst.setString(3, waznosc);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dodano czynność");
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}





