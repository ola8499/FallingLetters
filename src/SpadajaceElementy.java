import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
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

    private static final int D_HEIGHT = 768;
    public static final int D_WIDTH = 1024;
    private static final double INCREMENT = 3;
    private List<Shape> shapes;
    int clickX;
    int clickY;
    public Timer timer = null;
    Image imgGame;
    public int amount_sphere;
    public String r = "R";
    public int delay = 60;
    boolean clicked = false;
    public String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "W", "U", "X", "Y", "Z"};
    private List<String> level = new ArrayList<String>();
    ImageIcon background = new ImageIcon("tlo.jpg");
    JLabel points = new JLabel("PUNKTY 0");
    JLabel jl_level = new JLabel("POZIOM I");
    JLabel chance = new JLabel("SZANSE ");
    JButton gmover = new JButton("Koniec gry", background);
    JLabel WORD = new JLabel("D_G");
    JPanel pictures = new JPanel();
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
    boolean endgame = false;
    JLabel nextlvl = new JLabel();
    BufferedImage image1 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\dog2.jpg"));
    BufferedImage image2 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\ball2.jpg"));
    BufferedImage image3 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\ski2.png"));
    BufferedImage image4 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\mouse2.png"));
    BufferedImage image5 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\cherry2.png"));
    BufferedImage image6 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\collar3.png"));
    BufferedImage image7 = ImageIO.read(new File("C:\\Users\\HP NoteBook\\Desktop\\WJP\\imggame\\smile.jpg"));
    JLabel picLabel1 = new JLabel(new ImageIcon(image1));
    JLabel picLabel2 = new JLabel(new ImageIcon(image2));
    JLabel picLabel3 = new JLabel(new ImageIcon(image3));
    JLabel picLabel4 = new JLabel(new ImageIcon(image4));
    JLabel picLabel5 = new JLabel(new ImageIcon(image5));
    JLabel picLabel6 = new JLabel(new ImageIcon(image6));
    JLabel picLabel7 = new JLabel(new ImageIcon(image7));
    Font fontup = new Font("Bauhaus 93", Font.BOLD, 25);
    Font fontdown = new Font("Bauhaus 93", Font.BOLD, 60);
    Font fontbttn = new Font("Bauhaus 93", Font.BOLD, 20);
    JLabel inscr = new JLabel();
    JLabel result = new JLabel();
    public static final Color LIGHT_BLUE = new Color(25,94,139);
    public static final Color LIGHT_PINK = new Color(224, 184, 184);
    public static final Color color1 = new Color(100, 158, 199, 255);
    public static final Color color2 = new Color(187, 96, 148);
    public static final Color color3 = new Color(91, 109, 179);
    public static final Color color4 = new Color(201, 133, 241);
    public static final Color color5 = new Color(186, 116, 186);
    public static final Color color6 = new Color(62, 127, 203, 255);
    public static final Color color_hearts = new Color(199, 33, 133, 255);
    int a;
    int b;
    int c;

    public SpadajaceElementy() throws IOException {

        imgGame = new ImageIcon("chmury.jpg").getImage();
        pictures.add(picLabel1);

        this.add(points);
        points.setLocation(400, 15);
        points.setSize(150, 70);
        points.setFont(fontup);
        points.setForeground(LIGHT_PINK);

        this.add(jl_level);
        jl_level.setLocation(30, 15);
        jl_level.setSize(150, 70);
        jl_level.setFont(fontup);
        jl_level.setForeground(LIGHT_PINK);

        this.add(chance);
        chance.setLocation(760, 15);
        chance.setSize(150, 70);
        chance.setFont(fontup);
        chance.setForeground(LIGHT_PINK);

        gmover.setHorizontalTextPosition(JButton.CENTER);
        gmover.setVerticalTextPosition(JButton.CENTER);
        gmover.setSize(150, 45);
        gmover.setLocation(800, 700);
        gmover.setFont(fontbttn);
        gmover.setForeground(LIGHT_BLUE);
        this.add(gmover);

        this.add(WORD);
        WORD.setLocation(420, 670);
        WORD.setSize(230, 70);
        WORD.setFont(fontdown);
        WORD.setForeground(LIGHT_BLUE);

        pictures.setSize(200, 200);
        pictures.setLocation(20, 550);
        this.add(pictures);

        this.add(nextlvl);
        nextlvl.setLocation(400, 250);
        nextlvl.setSize(100, 70);

        this.setLayout(null);

        inscr.setFont(fontdown);
        inscr.setLocation(320,220);
        inscr.setSize(500,100);
        inscr.setForeground(LIGHT_PINK);
        this.add(inscr);

        this.add(result);
        result.setLocation(220, 420);
        result.setSize(550, 100);
        result.setFont(fontdown);

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

        super.paintComponent(g);
        g.drawRect(10, 10, 500, 200);
        g.drawImage(imgGame, 0, 0, null);
        if(b==0){
            drawHeart(g,860,20,40,45);
            drawHeart(g,915,20,40,45);
            drawHeart(g,970,20,40,45);
        }
        if(b==1){
            drawHeart(g,860,20,40,45);
            drawHeart(g,915,20,40,45);
        }
        if(b==2){
            drawHeart(g,860,20,40,45);
        }
        if(b==3){
            c+=1;
            timer.stop();
            inscr.setText("KONIEC GRY");
            result.setText("Twój wynik to "+a+"/9");
            this.remove(chance);
            this.remove(points);
            this.remove(WORD);
            this.remove(pictures);
            this.remove(jl_level);
        }
        if(c==1){
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\game-over.wav")));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }

        for (Shape shape : shapes) {
            shape.drawShape(g);
            repaint();
        }
    }

    public void drawHeart(Graphics g, int x, int y, int width, int height) {
        int[] triangleX = {x - 2*width/18, x + width + 2*width/18, (x - 2*width/18 + x + width + 2*width/18)/2};
        int[] triangleY = {y + height - 2*height/3, y + height - 2*height/3, y + height };
        g.setColor(color_hearts);
        g.fillOval(x - width/12, y, width/2 + width/6, height/2);
        g.fillOval(x + width/2 - width/12, y, width/2 + width/6, height/2);
        g.fillPolygon(triangleX, triangleY, triangleX.length);
    }

    public Dimension getPreferredSize() {
        return new Dimension(D_WIDTH, D_HEIGHT);
    }

    private List<Shape> createShapeList() {

        List<Shape> list = new ArrayList<>();
        Random random = new Random();
        level.removeAll(level);

        if ((word1)||(word4)||(word6)) {

            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));

            poziom1_letters_list.remove("O");
            poziom1_letters_list.remove("M");
            poziom1_letters_list.remove("H");
            poziom1_letters_list.remove("S");

            for (int i = 0; i < 3; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("O");
            for (int i = 4; i < 7; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("M");
            for (int i = 8; i < 11; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("H");

            amount_sphere = level.size();

            for (int i = 0; i < amount_sphere; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {color1, color2, color3, color4, color5, color6};
                int randszer = 75 * i + 55;
                int x = random.nextInt(kolor.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], level.get(i), i));
            }
        }
        if ((word2)||(word5)){

            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));

            poziom1_letters_list.remove("L");
            poziom1_letters_list.remove("S");
            poziom1_letters_list.remove("O");
            poziom1_letters_list.remove("M");

            for (int i = 0; i < 5; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("S");
            for (int i = 6; i < 11; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("L");

            amount_sphere = level.size();

            for (int i = 0; i < amount_sphere; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {color1, color2, color3, color4, color5, color6};
                int randszer =  75 * i + 55;
                int x = random.nextInt(kolor.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], level.get(i), i));
            }
        }
        if ((word3)||(word8)) {

            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));

            poziom1_letters_list.remove("O");
            poziom1_letters_list.remove("R");
            poziom1_letters_list.remove("S");
            poziom1_letters_list.remove("L");

            for (int i = 0; i < 5; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("O");
            for (int i = 6; i < 8; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("S");
            for (int i = 9; i < 12; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }

            amount_sphere = level.size();

            for (int i = 0; i < amount_sphere; i++) {

                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {color1, color2, color3, color4, color5, color6};
                int randszer = 75 * i + 55;
                int x = random.nextInt(kolor.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], level.get(i), i));
            }
        }

        if ((word7)||(word9)) {

            List<String> poziom1_letters_list = new ArrayList<String>(Arrays.asList(letters));

            poziom1_letters_list.remove("R");
            poziom1_letters_list.remove("A");
            poziom1_letters_list.remove("H");
            poziom1_letters_list.remove("O");

            for (int i = 0; i < 3; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("A");
            for (int i = 4; i < 6; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }
            level.add("R");
            for (int i = 7; i < 12; i++) {
                level.add(poziom1_letters_list.get(random.nextInt(poziom1_letters_list.size())));
            }

            amount_sphere = level.size();

            for (int i = 0; i < amount_sphere; i++) {
                int randomDelayedStart = random.nextInt(50);
                Color[] kolor = {color1, color2, color3, color4, color5, color6};
                int randszer = 75 * i + 55;
                int x = random.nextInt(kolor.length);
                list.add(new Shape(randszer, randomDelayedStart, kolor[x], level.get(i), i));
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
        int y = 45;
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
                g.setFont(new Font("Bauhaus 93", Font.LAYOUT_NO_LIMIT_CONTEXT, 40));
                g.drawString(letters, (int) (randszer + 25 - textWidth / 4), (y + 29 + fm.getMaxAscent() / 4));
            }
        }

        public void sprawdzenie() throws IOException {

            if (level1) {
                jl_level.setText("POZIOM 1");
            }
            if (level2) {
                jl_level.setText("POZIOM 2");
            }

            if (word1) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((level.get(i).equals("O"))) {

                        a += 1;
                        points.setText("PUNKTY " + a);
                        System.out.println("punkt "+a);

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
                        pictures.remove(picLabel1);
                        LocalDateTime then = LocalDateTime.now();
                        pictures.add(picLabel2);
                    }
                    if ((!level.get(i).equals("O"))) {
                        a -= 1;
                        b += 1;
                        System.out.println("suma przy odej " + a);
                        points.setText("PUNKTY " + a);
                        if(b!=3){
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
            }

            if (word2) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((level.get(i).equals("L"))) {

                            a += 1;
                        points.setText("PUNKTY " + a);

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
                        pictures.remove(picLabel2);
                        pictures.add(picLabel3);
                    }
                    if ((!level.get(i).equals("L"))&&(!level.get(i).equals("O"))) {

                        a -= 1;
                        b += 1;
                        points.setText("PUNKTY " + a);

                        if(b!=3){
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
            }

            if (word3) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((level.get(i).equals("S"))) {

                        a += 1;
                        points.setText("PUNKTY " + a);
                        WORD.setText("SKI");
                        level2 = true;
                        word4 = true;
                        word3 = false;
                        level1 = false;
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        pictures.remove(picLabel3);
                        pictures.add(picLabel4);
                        WORD.setText("_OU_E");
                    }
                    if ((!level.get(i).equals("S"))&&(!level.get(i).equals("L"))) {
                        a -= 1;
                        b += 1;
                        points.setText("PUNKTY " + a);
                        if(b!=3){
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
            }

            if (word4) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((level.get(i).equals("M"))) {
                        a += 1;
                        points.setText("PUNKTY " + a);
                        WORD.setText("MOU_E");
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        word5 = true;
                        word4=false;
                    }
                    if(!level.get(i).equals("M")&&(!level.get(i).equals("S"))){

                        a -= 1;
                        b += 1;
                        points.setText("PUNKTY " + a);

                        if(b!=3){
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
            }
            if (word5) {
                if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                    if ((level.get(i).equals("S"))) {
                        a += 1;
                        points.setText("PUNKTY " + a);
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                            clip.start();
                        } catch (Exception exc) {
                            exc.printStackTrace(System.out);
                        }
                        WORD.setText("MOUSE");
                        word6 = true;
                        word5=false;
                        WORD.setText("C_ER_Y");
                        pictures.remove(picLabel4);
                        pictures.add(picLabel5);
                    }
                    if(!level.get(i).equals("S")&&(!level.get(i).equals("M"))){

                        a -= 1;
                        b += 1;
                        points.setText("PUNKTY " + a);

                        if(b!=3){
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
            }

                if (word6) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((level.get(i).equals("H"))) {
                            a += 1;
                            points.setText("PUNKTY " + a);
                            try {
                                Clip clip = AudioSystem.getClip();
                                clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                                clip.start();
                            } catch (Exception exc) {
                                exc.printStackTrace(System.out);
                            }
                            WORD.setText("CHER_Y");
                            word6=false;
                            word7 = true;
                        }
                        if(!level.get(i).equals("H")&&(!level.get(i).equals("S"))){

                            a -= 1;
                            b += 1;
                            points.setText("PUNKTY " + a);

                            if(b!=3){
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
                }
                if (word7) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((level.get(i).equals("R"))) {
                            a += 1;
                            points.setText("PUNKTY " + a);
                            try {
                                Clip clip = AudioSystem.getClip();
                                clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                                clip.start();
                            } catch (Exception exc) {
                                exc.printStackTrace(System.out);
                            }
                            WORD.setText("CHERRY");
                            word7 = false;
                            word8 = true;
                            WORD.setText("C_LL_R");

                            pictures.remove(picLabel5);
                            pictures.add(picLabel6);
                        }
                        if(!level.get(i).equals("R")&&(!level.get(i).equals("H"))){

                            a -= 1;
                            b += 1;
                            points.setText("PUNKTY " + a);

                            if(b!=3){
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
                }

                if (word8) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((level.get(i).equals("O"))) {
                            a += 1;
                            points.setText("PUNKTY " + a);
                            try {
                                Clip clip = AudioSystem.getClip();
                                clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\pozytywny.wav")));
                                clip.start();
                            } catch (Exception exc) {
                                exc.printStackTrace(System.out);
                            }
                            WORD.setText("COLL_R");
                            word8 = false;
                            word9 = true;
                        }
                        if(!level.get(i).equals("O")&&(!level.get(i).equals("R"))){

                            a -= 1;
                            b += 1;
                            points.setText("PUNKTY " + a);

                            if(b!=3){
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
                }
                if (word9) {
                    if ((clickX >= randszer) && (clickX <= randszer + 60) && (clickY >= y) && (clickY <= y + 60)) {
                        if ((level.get(i).equals("A"))) {

                            a += 1;

                            points.setText("PUNKTY " + a);
                            WORD.setText("COLLAR");
                            word9 = false;
                            endgame = true;
                        }
                        if(!level.get(i).equals("A")&&(!level.get(i).equals("O"))){

                            a -= 1;
                            b += 1;
                            points.setText("PUNKTY " + a);

                            if(b!=3){
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
                }
            if(endgame){
                inscr.setText("KONIEC GRY");
                result.setText("Twój wynik to "+a+"/9");
                chance.setText("");
                points.setText("");
                WORD.setText("");
                jl_level.setText("");
                pictures.remove(picLabel6);
                pictures.add(picLabel7);
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\HP NoteBook\\IdeaProjects\\Falling Letters\\game-complete.wav")));
                    clip.start();
                } catch (Exception exc) {
                    exc.printStackTrace(System.out);
                }
            }
        }


        public void move() {
            if (draw) {
                y += INCREMENT;
                if(y>=600){
                    y = 45;
                    y += INCREMENT;
                    if(randszer == 55){
                        b += 1;
                    }
                }
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


