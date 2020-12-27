import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpadajaceElementy<object> extends JPanel implements MouseListener {

    private static final int D_HEIGHT = 700;
    public static final int D_WIDTH = 900;
    private static final double INCREMENT = 3;
    private List<Shape> shapes;
    private List<String> colors;
    int clickX;
    int clickY;
    public Timer timer = null;
    Image imgGame;
    public int ilosc_kulek;
    public String r = "R";
    public int delay = 60;
    boolean clicked = false;
    public String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "W", "U", "X", "Y", "Z"};
    private List<String> poziom1 = new ArrayList<String>();
    ImageIcon tlo = new ImageIcon("tlo.jpg");
    JLabel punkty = new JLabel("PUNKTY ");
    JLabel poziom = new JLabel("POZIOM ");
    JLabel szanse = new JLabel("SZANSE ");
    JButton zakoncz = new JButton("Koniec gry", tlo);
    JLabel WORD = new JLabel("D_G");
    JPanel jpegi = new JPanel();
    boolean level1 = true;
    boolean level2 = false;
    boolean word1 = true;
    boolean word2 = false;
    boolean word3 = false;
    boolean word4 = false;
    boolean word5 = false;
    boolean word6 = false;
    boolean word7 = false;
    boolean word8 = false;
    boolean word9 = false;
    JLabel nextlvl = new JLabel();
    LocalDateTime then = LocalDateTime.now();
    boolean tak = true;
    BufferedImage image1 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\dog2.jpg"));
    BufferedImage image2 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\ball2.jpg"));
    BufferedImage image3 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\ski2.png"));
    BufferedImage image4 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\mouse2.png"));
    BufferedImage image5 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\cherry2.png"));
    BufferedImage image6 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\collar3.png"));
    JLabel picLabel1 = new JLabel(new ImageIcon(image1));
    JLabel picLabel2 = new JLabel(new ImageIcon(image2));
    JLabel picLabel3 = new JLabel(new ImageIcon(image3));
    JLabel picLabel4 = new JLabel(new ImageIcon(image4));
    JLabel picLabel5 = new JLabel(new ImageIcon(image5));
    JLabel picLabel6 = new JLabel(new ImageIcon(image6));
    BufferedImage hearts3 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\obraz.PNG"));
    JLabel heartslab3 = new JLabel(new ImageIcon(hearts3));
    Font czcionka = new Font("Bauhaus 93", Font.BOLD, 18);
    JPanel szansa = new JPanel();
    int a;

    public SpadajaceElementy() throws IOException {

        imgGame = new ImageIcon("chmury.jpg").getImage();
        jpegi.add(picLabel1);


        this.add(punkty);
        punkty.setLocation(350, 0);
        punkty.setSize(100, 70);
        punkty.setFont(czcionka);

        this.add(poziom);
        poziom.setLocation(20, 0);
        poziom.setSize(100, 70);
        poziom.setFont(czcionka);

        this.add(szanse);
        szanse.setLocation(680, 0);
        szanse.setSize(100, 70);
        szanse.setFont(czcionka);

        zakoncz.setHorizontalTextPosition(JButton.CENTER);
        zakoncz.setVerticalTextPosition(JButton.CENTER);
        zakoncz.setSize(150, 60);
        zakoncz.setLocation(700, 600);
        zakoncz.setFont(czcionka);
        this.add(zakoncz);


        this.add(WORD);
        WORD.setLocation(370, 610);
        WORD.setSize(70, 70);
        WORD.setFont(czcionka);

        jpegi.setSize(200, 200);
        jpegi.setLocation(20, 500);
        this.add(jpegi);

        this.add(nextlvl);
        nextlvl.setLocation(350, 250);
        nextlvl.setSize(100, 70);

        this.setLayout(null);

        this.add(szansa);
        szansa.setLocation(740, 20);
        szansa.setSize(100, 30);
        szansa.add(heartslab3);


        colors = createColorList();
        shapes = createShapeList();
        addMouseListener(this);


        timer = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                for (Shape shape : shapes) {
                    shape.move();
                    shape.decreaseDelay();
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {

        boolean nie;

        super.paintComponent(g);
        g.drawRect(10, 10, 500, 200);
        g.drawImage(imgGame, 0, 0, null);

        for (Shape shape : shapes) {
            shape.drawShape(g);
            repaint();
        }
    }


    public Dimension getPreferredSize() {
        return new Dimension(D_WIDTH, D_HEIGHT);

    }

    private List<String> createColorList() {
        List<String> color = new ArrayList<String>();

        color.add("T");
        color.add("U");
        color.add("K");
        color.add("J");
        color.add("E");

        return color;
    }

    private List<Shape> createShapeList() {
        List<Shape> list = new ArrayList<>();
        Random random = new Random();
        poziom1.removeAll(poziom1);

        if ((word1)||(word4)) {
            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));
            poziom1_letters_list.remove("O");
            poziom1_letters_list.remove("M");
            poziom1_letters_list.remove("S");

            for (int i = 0; i < 3; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("O");
            for (int i = 4; i < 7; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("M");
            for (int i = 8; i < 13; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("O");

            System.out.println(poziom1);
            ilosc_kulek = poziom1.size();

            for (int i = 0; i < ilosc_kulek; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {Color.red, Color.blue, Color.pink, Color.cyan, Color.green, Color.gray};
                int randszer = 60 * i + 60;
                int x = random.nextInt(kolor.length);
                int y = random.nextInt(letters.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], poziom1.get(i), i));
                System.out.println(y);
            }
        }
        if ((word2)||(word5)){
            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));
            poziom1_letters_list.remove("L");
            poziom1_letters_list.remove("H");
            poziom1_letters_list.remove("R");
            for (int i = 0; i < 5; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("H");
            for (int i = 6; i < 11; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("L");
            poziom1.add("R");
            System.out.println(poziom1);
            ilosc_kulek = poziom1.size();

            for (int i = 0; i < ilosc_kulek; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {Color.red, Color.blue, Color.pink, Color.cyan, Color.green, Color.gray};
                int randszer =  60* i + 60;
                int x = random.nextInt(kolor.length);
                int y = random.nextInt(letters.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], poziom1.get(i), i));
                System.out.println(y);
            }
        }
        if (word3) {
            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));
            poziom1_letters_list.remove("O");
            poziom1_letters_list.remove("A");
            poziom1_letters_list.remove("S");
            for (int i = 0; i < 5; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("O");
            for (int i = 6; i < 8; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            poziom1.add("A");
            poziom1.add("S");
            for (int i = 9; i < 13; i++) {
                poziom1.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }

            System.out.println(poziom1);
            ilosc_kulek = poziom1.size();


            for (int i = 0; i < ilosc_kulek; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {Color.red, Color.blue, Color.pink, Color.cyan, Color.green, Color.gray};

                int randszer = 60 * i + 60;
                int x = random.nextInt(kolor.length);
                int y = random.nextInt(letters.length);

                list.add(new Shape(randszer, randomDelayedStart, kolor[x], poziom1.get(i), i));

                System.out.println(y);
            }
        }
        return list;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("klik");
        clickX = e.getX();
        System.out.println("klik X: "+ clickX);
        clickY = e.getY();
        System.out.println("klik Y: "+ clickY);
        clicked=true;
        for (Shape shape : shapes) {
            System.out.println("Sprawdzam w funkcji click");
            try {
                shape.sprawdzenie();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        shapes = createShapeList();
        timer.restart();
    }
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    class Shape {

        int randszer;
        int y = 0;
        int randomDelayedStart;
        boolean draw = false;
        Color color;
        String letters;
        Integer i;


        public Shape(int randszer, int randomDelayedStart, Color color, String letters, Integer i) {

            this.randszer = randszer;
            this.randomDelayedStart = randomDelayedStart;
            this.color = color;
            this.letters = letters;
            this.i = i;
        }

        public void drawShape(Graphics g) {

            if (draw) {
                g.setColor(color);

                FontMetrics fm = g.getFontMetrics();
                double textWidth = fm.getStringBounds(r, g).getWidth();
                g.fillOval(randszer, y, 60, 60);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Bauhaus 93", Font.LAYOUT_NO_LIMIT_CONTEXT, 35));
                g.drawString(letters, (int) (randszer + 25 - textWidth / 4), (y + 29 + fm.getMaxAscent() / 4));
            }
        }

        public void sprawdzenie() throws IOException {


            if (level1) {
                poziom.setText("POZIOM 1");
            }
            if (level2) {
                poziom.setText("POZIOM 2");
            }

            if (word1) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((poziom1.get(i) == "O")) {
                        a += 1;
                        punkty.setText("PUNKTY " + a);
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        WORD.setText("DOG");
                        word2 = true;
                        WORD.setText("BA_L");
                        word1 = false;
                        jpegi.remove(picLabel1);
                        jpegi.add(picLabel2);
                    }
                    if ((poziom1.get(i) != "O")) {
                        a -= 1;
                        punkty.setText("PUNKTY " + a);
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\negatywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                    }
                }
            }
            if (word2) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((poziom1.get(i) == "L")) {

                        a += 1;
                        punkty.setText("PUNKTY " + a);

                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }

                        WORD.setText("BALL");
                        word3 = true;
                        WORD.setText("_KI");
                        word2 = false;
                        jpegi.remove(picLabel2);
                        jpegi.add(picLabel3);
                    }
                }
                if ((poziom1.get(i) != "L")) {

                    a -= 1;
                    punkty.setText("PUNKTY " + a);

                    try {
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\negatywny.wav")));
                        clip.start();
                    } catch (Exception exc) {
                        exc.printStackTrace(System.out);
                    }
                }
            }
            if (word3) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((poziom1.get(i) == "S")) {

                        a += 3;
                        punkty.setText("PUNKTY " + a);
                        WORD.setText("SKI");
                        level2 = true;
                        word4 = true;
                        word3 = false;
                        level1 = false;
                        tak = true;
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        jpegi.remove(picLabel3);
                        jpegi.add(picLabel4);
                        WORD.setText("_OU_E");
                    }
                    if ((poziom1.get(i) != "S")) {
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\negatywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                    }
                }
            }
            if (word4) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((poziom1.get(i).equals("M"))) {
                        a += 4;
                        punkty.setText("PUNKTY " + a);
                        WORD.setText("MOU_E");
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        word5 = true;
                    }
                    if(!poziom1.get(i).equals("M")){
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\negatywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                    }
                }
            }
            if (word5) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((poziom1.get(i) == "S")) {
                        a += 1;
                        punkty.setText("PUNKTY " + a);
                        WORD.setText("MOUSE");
                        word6 = true;
                        WORD.setText("C_ER_Y");
                        jpegi.remove(picLabel4);
                        jpegi.add(picLabel5);
                    }
                }
            }

                if (word6) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((poziom1.get(i) == "H")) {
                            a += 1;
                            punkty.setText("PUNKTY " + a);
                            WORD.setText("C_ER_Y");
                            word7 = true;
                        }
                    }
                }
                if (word7) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((poziom1.get(i) == "R")) {
                            a += 1;
                            punkty.setText("PUNKTY " + a);
                            WORD.setText("CHERRY");
                            word8 = true;
                            WORD.setText("C_LL_R");

                            jpegi.remove(picLabel5);
                            jpegi.add(picLabel6);
                        }
                    }
                }

                if (word8) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((poziom1.get(i) == "O")) {
                            a += 1;
                            punkty.setText("PUNKTY " + a);
                            WORD.setText("COLL_R");
                            word9 = true;
                        }
                    }
                }
                if (word9) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((poziom1.get(i) == "A")) {

                            a += 1;
                            punkty.setText("PUNKTY " + a);
                            WORD.setText("COLLAR");
                            word3 = false;
                        }
                    }
                }
        }
        public void move() {
            if (draw) {
                y += INCREMENT;
            }
        }

        public void decreaseDelay() {
            if (randomDelayedStart <= 0) {
                draw = true;
            }
             else {
                randomDelayedStart -= 1;
            }
        }
    }
}


