package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
public class gui extends LPTSQL {
    public JPanel main;
    public JLabel tytuł;
    public JLabel IloscMaszyn;
    public JLabel NazwaZadania;
    public JLabel czas;
    public JTextField ilosc;
    public JTextField nazwa;
    public JTextField czast;
    public JLabel Zapiswynik;
    public JButton Zapisz;
    public JButton WykresB;
    public JButton obliczButton;
    public JButton usun;
    private JTextField txtid;
    private JButton wczytaj;
    private JTextField sciezka;
    private  JTable table1;
    private JButton zaktualizujButton;
    private JTextField update;

    public gui() {

        polacz pol=new polacz();
        pol.connect();
        load_table tab=new load_table();
        tab.tabela(table1);


        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa1, czas1;
                nazwa1 = nazwa.getText();
                czas1 = czast.getText();
                zapis test = new zapis();
                test.zapisanie(nazwa1, czas1);
                nazwa.setText("");
                czast.setText("");
                tab.tabela(table1);
            }
        });
        obliczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                int numMachines = Integer.parseInt(ilosc.getText());
                LPTSQL lpt = new LPTSQL();
                    if (numMachines >= 2 && numMachines <= 6) {
                            lpt.LPT(numMachines);
                        ilosc.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Zły numer podaj liczbe od 2 do 6");
                    }
                }
                catch (Exception e2){
                    JOptionPane.showMessageDialog(null, "Podaj LICZBE od 2 do 6");
                }
            }
        });
        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                id = txtid.getText();
                Usun test = new Usun();
                test.delete(id);
                txtid.setText("");
                nazwa.requestFocus();
                tab.tabela(table1);
            }
        });
        wczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wczytanie z=new wczytanie();
                String sciezka1= sciezka.getText();
                sciezka1+=".txt";
                try {
                    z.wczytaniez(sciezka1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                tab.tabela(table1);
                }
        });
        zaktualizujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update z=new update();
                String nazwa1,czas1,id;
                nazwa1= nazwa.getText();
                czas1=czast.getText();
                id=update.getText();
                z.updated(nazwa1,czas1,id);
                nazwa.setText("");
                czast.setText("");
                tab.tabela(table1);
            }
        });
    }

    public static void main(String[] args)  {
        JFrame frame = new JFrame("gui");
        frame.setContentPane(new gui().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
