package main;
import javax.swing.*;
import java.sql.SQLException;
public class zapis extends polacz {
    public void zapisanie(String nazwa, String czas) {

        try {
            pst = con.prepareStatement("insert into LPT2(Nazwa,czas) values(?,?)");
            pst.setString(1, nazwa);
            pst.setString(2, czas);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dodano czynność");
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}
