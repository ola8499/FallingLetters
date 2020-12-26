import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PierwszeOkno {
    PierwszeOkno() {

        //definicja wykorzystanych obrazów
        ImageIcon img = new ImageIcon("TloOkna.jpg");
        ImageIcon tlo = new ImageIcon("tlo.jpg");
        ImageIcon imgGame = new ImageIcon("chmury.jpg");

        //definicja elementów okna
        JFrame okno = new JFrame("Falling Letters");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        JButton przycisk = new JButton("START", tlo);

        //Ustawienie wymiarów okna
        okno.setSize(1024, 768);

        //ustawienie wymiarów tła
        background.setSize(1024, 768);

        //zmiana ikony
        Image icon = Toolkit.getDefaultToolkit().getImage("ikonka.jpg");
        okno.setIconImage(icon);

        //ustawienie czcionki
        Font czcionka = new Font("Bauhaus 93", Font.BOLD, 55);

        //dodanie elementów do okna
        okno.add(background);
        okno.add(przycisk);

        //ustawienie przycisku
        przycisk.setHorizontalTextPosition(JButton.CENTER);
        przycisk.setVerticalTextPosition(JButton.CENTER);
        przycisk.setFont(czcionka);
        przycisk.setBounds(362, 500, 300, 100);

        //zamkniecie i otwarcie okna
        okno.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        okno.setLayout((LayoutManager) null);
        okno.setVisible(true);

        przycisk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                okno.dispose();
                try {
                    new OknoGry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
