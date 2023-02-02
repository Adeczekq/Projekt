package main;

import javax.swing.*;
import java.sql.SQLException;

public class usuwanie extends polaczenie {
    public void usun (String id,JTextField nazwa,JTextField godzinat,JTextField waznosct) {
        try {
            pst = con.prepareStatement("delete from lista where id = ?");

            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Czynność usunięta");
            nazwa.setText("");
            godzinat.setText("");
            waznosct.setText("");
            nazwa.requestFocus();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

