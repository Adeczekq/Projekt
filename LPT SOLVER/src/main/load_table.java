package main;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class load_table extends polacz {
    public void tabela(JTable table1)
    {
        try
        {
            pst = con.prepareStatement("select * from lpt2");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
