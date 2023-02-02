package main;
import javax.swing.*;
import java.sql.SQLException;



public class aktualizacja extends polaczenie{

public void update( String nazwa_czynnosci,String godzina,String waznosc,String id){
      try {
        pst = con.prepareStatement("update lista set nazwa= ?,godzina = ?,waznosc = ? where id = ?");
        pst.setString(1, nazwa_czynnosci);
        pst.setString(2, godzina);
        pst.setString(3, waznosc);
        pst.setString(4, id);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Czynność zaktualizowana");
    }

      catch (SQLException e1)
    {
        e1.printStackTrace();
    }
}
}
