package main;

import java.sql.*;

public class polaczenie {
    static Connection con;
    PreparedStatement pst;
    protected void connect() {
      try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/lista ", "root", "");
          if(con!=null){ System.out.println("Successs");
           }
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();

       }
        catch (SQLException ex) {
            ex.printStackTrace();
       }


   }

}
