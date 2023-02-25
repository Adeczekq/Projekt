package main;
import java.sql.*;
public class polacz  {
        static Connection con;
        PreparedStatement pst;
        public void connect() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/test2 ", "root", "");
                if(con!=null){ System.out.println("Połączono z bazą danych");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


}

