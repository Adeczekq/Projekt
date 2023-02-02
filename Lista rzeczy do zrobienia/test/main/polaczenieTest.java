package main;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class polaczenieTest {
    protected Connection con;
    private int wybor;
    private int expectedRowCount = 1;
    @Test
    void connect() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ","root","");
            assertNotNull(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void zapisanie(){
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ","root","");
            PreparedStatement pst = con.prepareStatement("insert into lista(Nazwa,godzina,waznosc) values(?,?,?)");
            String nazwa_czynnosci="test";
            pst.setString(1, nazwa_czynnosci);
            assertEquals("test", nazwa_czynnosci);
            String godzina="test";
            pst.setString(2, godzina);
            assertEquals("test", nazwa_czynnosci);
            String waznosc="test";
            pst.setString(3, waznosc);
            assertEquals("test", nazwa_czynnosci);
            pst.executeUpdate();
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    @Test
    void update() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ","root","");
            PreparedStatement pst = con.prepareStatement("update lista set nazwa= ?,godzina = ?,waznosc = ? where id = ?");
            String nazwa_czynnosci="test";
            pst.setString(1, nazwa_czynnosci);
            String godzina="test";
            pst.setString(2, godzina);
            String waznosc="test";
            pst.setString(3, waznosc);
            String id="test";
            pst.setString(4, id);
            pst.executeUpdate();
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    @Test
    void tabela(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ", "root", "");
            PreparedStatement pst = con.prepareStatement("select * from lista");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from lista");
            assertTrue(result.next());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    @Test
    void usun(){
        try {
            String id="test";
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ", "root", "");
            PreparedStatement pst = con.prepareStatement("delete from lista where id = ?");
            pst.setString(1, id);
            pst.executeUpdate();
            assertEquals("test", id);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    @Test
    public void szukanie(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lista ", "root", "");
            PreparedStatement pst = con.prepareStatement("select Nazwa,godzina,waznosc from lista where id = ?");
            String id="test";
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();
            assertEquals("test", id);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}




