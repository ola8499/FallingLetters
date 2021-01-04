import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OknoGry{

    public JFrame oknoGry = new JFrame("Falling Letters");

    public OknoGry() throws IOException {


        oknoGry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oknoGry.setSize(1024,768);
        Image icon = Toolkit.getDefaultToolkit().getImage("ikonka.jpg");
        oknoGry.setIconImage(icon);
        oknoGry.setVisible(true);


        SpadajaceElementy sp = new SpadajaceElementy();
        oknoGry.add(sp);
        sp.timer.start();
        sp.gmover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                oknoGry.dispose();
                new PierwszeOkno();
            }
        });
        oknoGry.pack();

    }

}
