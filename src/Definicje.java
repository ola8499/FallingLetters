import javax.swing.*;

public class Definicje extends MojeOkno{
    ImageIcon img = new ImageIcon("TloOkna.jpg");
    JFrame okno = new JFrame("Falling Letters");
    //ImageIcon img = new ImageIcon("TloOkna.jpg");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    ImageIcon tlo = new ImageIcon("tlo.jpg");
    JButton przycisk = new JButton("START", tlo);
}
