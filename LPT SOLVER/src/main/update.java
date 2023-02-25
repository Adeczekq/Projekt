package main;

import javax.swing.*;
import java.sql.SQLException;

public class update extends polacz{
    public void updated( String nazwa,String czas,String id){
        try {
            pst = con.prepareStatement("update  LPT2 set nazwa= ?,czas = ? where id = ?");
            pst.setString(1, nazwa);
            pst.setString(2, czas);
            pst.setString(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Czynność zaktualizowana");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}


