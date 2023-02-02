package main;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class table_load extends polaczenie{
    PreparedStatement pst;

    public void tabela(JTable table1)
    {
        try
        {
            pst = con.prepareStatement("select * from lista");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
