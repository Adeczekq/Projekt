package main;

import javax.swing.*;
import java.io.*;
import java.sql.SQLException;
public class wczytanie extends polacz {
    public void wczytaniez(String sciezka) throws IOException {
        try {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(sciezka));
                String query = "INSERT INTO  LPT2 (nazwa, czas) VALUES (?, ?)";
                String line;
                pst = con.prepareStatement(query);
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    pst.setString(1, values[0]);
                    pst.setString(2, values[1]);
                    pst.executeUpdate();
                }
                reader.close();
                JOptionPane.showMessageDialog(null, "Dane zostały wczytane do tabeli w bazie danych.");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Nie ma takiego pliku.");
            }
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}