package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class lista extends polaczenie {
    public JPanel main;
    public JTextField nazwa;
    public JTextField godzinat;
    public JTextField waznosct;
    public JButton saveButton;
    public JTable table1;
    public JButton zaktualizujButton;
    public JButton usuńButton;
    public JButton wyszukajButton;
    public JTextField txtid;



    public lista() {
        polaczenie pol=new polaczenie();
        pol.connect();
        table_load tab=new table_load();
        tab.tabela(table1);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa_czynnosci, godzina, waznosc;
                nazwa_czynnosci = nazwa.getText();
                godzina = godzinat.getText();
                waznosc = waznosct.getText();
                zapis test = new zapis();
                test.zapisanie(nazwa_czynnosci, godzina, waznosc);
                nazwa.setText("");
                godzinat.setText("");
                waznosct.setText("");
                nazwa.requestFocus();
                tab.tabela(table1);
            }

        });
        zaktualizujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa_czynnosci, godzina, waznosc, id;
                nazwa_czynnosci = nazwa.getText();
                godzina = godzinat.getText();
                waznosc = waznosct.getText();
                id = txtid.getText();
                aktualizacja test = new aktualizacja();
                test.update(nazwa_czynnosci, godzina, waznosc, id);
                nazwa.setText("");
                godzinat.setText("");
                waznosct.setText("");
                nazwa.requestFocus();
                tab.tabela(table1);
            }
        });
        wyszukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();
                wyszukanie test = new wyszukanie();
                test.szukanie(id, nazwa, godzinat, waznosct);
            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                id = txtid.getText();
                usuwanie test = new usuwanie();
                test.usun(id, nazwa, godzinat, waznosct);
                tab.tabela(table1);
            }
        });
    }
}

