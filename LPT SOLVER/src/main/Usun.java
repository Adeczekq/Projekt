package main;

import javax.swing.*;
import java.sql.SQLException;

public class Usun extends polacz{
    public void delete (String id) {
        try {
            pst = con.prepareStatement("delete from  LPT2 where id = ?");
            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Czynność usunięta");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

