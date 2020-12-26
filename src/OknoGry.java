import javax.swing.*;
import java.io.IOException;

public class OknoGry{

    public JFrame oknoGry = new JFrame("Falling Letters");
    public OknoGry() throws IOException {


        oknoGry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oknoGry.setSize(1024,768);
        oknoGry.setVisible(true);


        SpadajaceElementy sp = new SpadajaceElementy();
        oknoGry.add(sp);
        sp.timer.start();
        oknoGry.pack();

    }

}
