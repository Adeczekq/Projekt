package main;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class wyszukanie extends polaczenie {
    public void szukanie(String id,JTextField nazwa,JTextField godzinat,JTextField waznosct){
         try {
        pst = con.prepareStatement("select Nazwa,godzina,waznosc from lista where id = ?");
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();

        if(rs.next()==true)
        {
            String nazwa2 = rs.getString(1);
            String godzina = rs.getString(2);
            String waznosc = rs.getString(3);

            nazwa.setText(nazwa2);
            godzinat.setText(godzina);
            waznosct.setText(waznosc);

        }
        else
        {
            nazwa.setText("");
            godzinat.setText("");
            waznosct.setText("");
            JOptionPane.showMessageDialog(null,"Brak czynności o takim numerze id");

        }
    }
                catch (SQLException ex)
    {
        ex.printStackTrace();
    }
}
}
