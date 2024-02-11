import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TetrisScorePanel extends JPanel {
    public static final int FRAME_SCORE_WIGHT = 250;
    public static final int FRAME_SCORE_HEIGHT = 550;
    public static final int UNICS = 25;
    public static final int colS = FRAME_SCORE_WIGHT / 25;
    public static final int rowS = 4;
    public static final int allbuttonsSize = 50;

    public static final int UNIC = 25;
    static int p = 0;
    static int v = 0;
    public static int rnd = 0;
    public int x = 10;
    static int ch = 0;
    static int strt = 0;

    static Clip clip;

    static boolean checkReset = false;
    static int checkSpeed = 0;

   static JButton buttonRight, buttonLeft,buttonDown, buttonReset, buttonRotate, buttonResume;

   static int clrs1;
   static int clrs2;
   static int clrs3;

   int checkButtonType = 0;
    int checkButtonType2 = 0;

    int xForLabel = 0;

    JLabel next = new JLabel("NEXT");

    int clr1 = 255;
    int clr2 = 0;
    int clr3 = 0;

    static int scr = 0;

    int checkLoopForNextLael = 0;
    Random randomColors = new Random();

    static int score = 0;
    public static final int[][][][] T = {//TTTT
            {{{1, 0, 0}, {1, 1, 0}, {1, 0, 0}}, {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{0, 0, 1}, {0, 1, 1}, {0, 0, 1}}, {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}},},
            //LLLL
            {{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}}, {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}}, {{0, 0, 0}, {1, 0, 0}, {1, 1, 1}}, {{0, 1, 1}, {0, 0, 1}, {0, 0, 1}},},
            //ZZZZ
            {{{1, 0, 0}, {1, 1, 0}, {0, 1, 0}}, {{0, 0, 0}, {0, 1, 1}, {1, 1, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            ///SSSS
            {{{0, 1, 0}, {1, 1, 0}, {1, 0, 0}}, {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            //OOOO
            {{{1, 1, 0}, {1, 1, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            //IIII
            {{{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}, {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},

    };

    BufferedImage image0;
    Image img0;
    JLabel scoreL = new JLabel();

    TetrisScorePanel(int random) {
        this.setBounds(475, 50, FRAME_SCORE_WIGHT, FRAME_SCORE_HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        //scoreLabel();
        score();
        commandbuttonsStartResume();
        this.setFocusable(true);
        this.setVisible(true);
        rnd = random;

        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\ScorePanelBackPicture.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        img0 = image0.getScaledInstance(getWidth(), getHeight(), 4);
    }

    public void scoreLabel(int clForNextLbl1, int clForNextLbl2, int clForNextLbl3) {

        JLabel jLabelScore = new JLabel("SCORE");
        jLabelScore.setBounds(20, 0, 200, 50);
        jLabelScore.setFont(new Font("BOLD", Font.BOLD, 20));
        jLabelScore.setForeground(Color.white);
        this.add(jLabelScore);
        this.setLayout(null);

        next.setBounds(xForLabel, 70, 100, 50);
        next.setFont(new Font("BOLD", Font.BOLD, 20));
        next.setForeground(new Color(clForNextLbl1, clForNextLbl2, clForNextLbl3));
        this.add(next);
        this.setLayout(null);

    }

    public void score() {

        scoreL.setText(String.valueOf(score));
        scoreL.setBounds(160, -10, 100, 100);
        scoreL.setFont(new Font("BOLD", Font.BOLD, 60));
        scoreL.setForeground(Color.white);
        this.add(scoreL);
        this.setLayout(null);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

       // Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        g.drawImage(img0, 0, 0, this);

        scoreL.setText(String.valueOf(score));

        /*for(int i=-1; i<=colS; i++){
            for(int j=-1; j<=rowS; j++){
                g.drawRect(i*UNICS, j*UNICS+100, UNICS,UNICS);
                g.setColor(Color.white);
            }
        }*/
        String str0 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block1.jpg";
        String str1 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block2.jpg";
        String str2 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block3.jpg";
        String str3 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block4.jpg";
        String str4 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block5.jpg";
        String str5 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block6.jpg";

        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][0][i][j] != 0) {
                    BufferedImage imagef = null;
                    switch (rnd) {
                        case 0 -> {
                            try {
                                imagef = ImageIO.read(new File(str0));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 1 -> {
                            try {
                                imagef = ImageIO.read(new File(str1));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 2 -> {
                            try {
                                imagef = ImageIO.read(new File(str2));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 3 -> {
                            try {
                                imagef = ImageIO.read(new File(str3));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 4 -> {
                            try {
                                imagef = ImageIO.read(new File(str4));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 5 -> {
                            try {
                                imagef = ImageIO.read(new File(str5));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    g.drawImage(imagef, i * UNIC + 4 * UNIC + x, j * UNIC + 125, UNIC, UNIC, this);
                }
            }
        }

        if (!TetrisPanel.pause_cont) {
            if (xForLabel==200){
                xForLabel = -60;
            }
            xForLabel += 20;
            x -= 23;
        }
        if (x < -170) {
            x = 100;
        }
        checkIsGameOver(g);
        pauseLabel(g);

        repaint();

        this.remove(next);
        checkLoopForNextLael ++;
        if (checkLoopForNextLael==3){
            clr1 = randomColors.nextInt(0, 255);
            clr2 = randomColors.nextInt(0, 255);
            clr3 = randomColors.nextInt(0, 255);
            checkLoopForNextLael = 0;
        }

        scoreLabel(clr1,clr2,clr3);
    }

    public void commandbuttonsRights() {
        buttonRight = new JButton();
        buttonRight.setBounds(150, 300, allbuttonsSize, allbuttonsSize);
        buttonRight.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\forRightButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRight.getWidth(), buttonRight.getHeight(), 5);
        buttonRight.setIcon(new ImageIcon(img));
        this.add(buttonRight);

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    musicForStone();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                    throw new RuntimeException(ex);
                }

                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {
                    int m1 = 175;
                    if (TetrisPanel.rnd == 1 || TetrisPanel.rnd == 4 || TetrisPanel.rotate == 1) {
                        m1 += 25;
                    }
                    if (TetrisPanel.rnd == 5 && TetrisPanel.rotate == 0) {
                        m1 += 50;
                    }
                    if (TetrisPanel.rnd == 5 && TetrisPanel.rotate == 1) {
                        m1 -= 50;
                    }
                    if (TetrisPanel.rnd == 2 && TetrisPanel.rotate == 1) {
                        m1 -= 25;
                    }
                    if (TetrisPanel.x < m1 && !TetrisPanel.testRight())
                        TetrisPanel.x += 25;
                }

            }
        });

        checkButtonType = 2;
        ft(buttonRight,checkButtonType);

    }

    public void commandbuttonsLefts() {
        buttonLeft = new JButton();
        buttonLeft.setBounds(30, 300, allbuttonsSize, allbuttonsSize);
        buttonLeft.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\forLeftButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonLeft.getWidth(), buttonLeft.getHeight(), 5);
        buttonLeft.setIcon(new ImageIcon(img));
        this.add(buttonLeft);

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    musicForStone();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {

                    int n1 = -150;
                    if (TetrisPanel.rnd == 2 || TetrisPanel.rnd == 0 && TetrisPanel.rotate == 1) {
                        n1 -= 25;
                    }
                    if (TetrisPanel.rnd == 1 && TetrisPanel.rotate == 2) {
                        n1 -= 25;
                    }/*if (TetrisPanel.rnd==5 && TetrisPanel.rotate==1){
                        n1 -=50;*/
                    if (TetrisPanel.rnd == 2 && TetrisPanel.rotate == 0) {
                        n1 += 25;
                    }
                    if (TetrisPanel.x > n1 && !TetrisPanel.testLeft())
                        TetrisPanel.x -= 25;

                }

            }
        });

        checkButtonType = 1;
        ft(buttonLeft,checkButtonType);

    }

    public void commandbuttonsDown() {
        buttonDown = new JButton();
        buttonDown.setBounds(90, 360, allbuttonsSize, allbuttonsSize);
        buttonDown.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\forDownButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonDown.getWidth(), buttonDown.getHeight(), 5);
        buttonDown.setIcon(new ImageIcon(img));
        this.add(buttonDown);

        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*if (checkSpeed==0){
                    checkSpeed = 1;
                    TetrisPanel.speed = 0;
                } else if (checkSpeed==1) {
                    checkSpeed = 0;
                    TetrisPanel.speed = 80;
                }*/
                TetrisPanel.speed = 0;

            }
        });

        checkButtonType = 3;
        ft(buttonDown,checkButtonType);
    }

    public void commandbuttonsReset() {
        buttonReset = new JButton();
        buttonReset.setBounds(150, 420, allbuttonsSize, allbuttonsSize);
        buttonReset.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\forResetButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonReset.getWidth(), buttonReset.getHeight(), 5);
        buttonReset.setIcon(new ImageIcon(img));
        this.add(buttonReset);

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    musicForReset();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0){
                    TetrisPanel.arrayList = new ArrayList<>();
                    TetrisPanel.rnd = TetrisPanel.randommm();
                    TetrisPanel.y = -25;
                    checkReset = true;
                    //clip.stop();
                }
            }
        });

        checkButtonType = 4;

        ft(buttonReset,checkButtonType);

    }

    public void commandbuttonsStartResume() {
        buttonResume = new JButton();
        buttonResume.setBounds(30, 420, allbuttonsSize, allbuttonsSize);
        buttonResume.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\forStartResumeButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonResume.getWidth(), buttonResume.getHeight(), 5);
        buttonResume.setIcon(new ImageIcon(img));

        buttonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v = 1;
                buttonsAdd();
                if (p == 0) {
                    TetrisScorePanel.p++;
                    TetrisPanel.pause_cont = false;
                    buttonResume.setBackground(Color.black);
                    try {
                        music();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (p == 1) {
                    TetrisScorePanel.p--;
                    buttonResume.setBackground(Color.blue);
                    TetrisPanel.pause_cont = true;
                    clip.stop();
                }

            }
        });

        this.add(buttonResume);
    }

    public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\backGroundMusic.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(-16.6f);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public static void musicForReset() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if (!TetrisPanel.pause_cont){
            File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\resetMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(6.0f);
            clip.start();
        }

    }

    public static void musicForStone() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        if (!TetrisPanel.pause_cont){
            File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\rotateRightLeftMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(6.0f);
            clip.start();
        }
    }

    public void commandButtonsRotate() {
        buttonRotate = new JButton();
        buttonRotate.setBounds(30, 240, allbuttonsSize, allbuttonsSize);
        buttonRotate.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\rotateButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRotate.getWidth(), buttonRotate.getHeight(), 5);
        buttonRotate.setIcon(new ImageIcon(img));

        buttonRotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {
                    TetrisPanel.rotateCheck = true;
                    TetrisPanel.rotate++;
                    if (TetrisPanel.rnd != 4 ){
                        try {
                            musicForStone();
                        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        this.add(buttonRotate);

        checkButtonType = 5;
        ft(buttonRotate,checkButtonType);

    }

    public void buttonsAdd (){

            commandbuttonsRights();
            commandbuttonsLefts();
            commandbuttonsDown();
            commandbuttonsReset();
            commandButtonsRotate();
    }

    public void checkIsGameOver(Graphics g){

        if (TetrisPanel.gameOver()){

            buttonResume.setEnabled(false);


            this.remove(buttonRight);
            this.remove(buttonLeft);
            this.remove(buttonDown);
            this.remove(buttonReset);
            this.remove(buttonRotate);

        }
            clrs1 = randomColors.nextInt(0, 255);
            clrs2 = randomColors.nextInt(0, 255);
            clrs3 = randomColors.nextInt(0, 255);

        drawRectPermanent(g);
    }
    public void drawRectPermanent(Graphics g){


            g.drawRect(150, 300, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 300, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(90, 360, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(150, 420, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 420, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 240, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));

    }

    public void pauseLabel(Graphics g){

        switch (checkButtonType2) {
            case 1 ->
                styleButtonNames(g, 0, 255, 255, "Bold", 1, 15, "LEFT", buttonLeft.getX(), buttonLeft.getY());
            case 2 ->
                styleButtonNames(g, 31, 82, 5, "Bold", 1, 15, "RIGHT", buttonRight.getX(), buttonRight.getY());
            case 3 ->
                styleButtonNames(g, 255, 255, 255, "Bold", 1, 15, "DOWN", buttonDown.getX(), buttonDown.getY());
            case 4 ->
                styleButtonNames(g,255, 255, 0, "Bold", 1, 15, "RESET", buttonReset.getX(), buttonReset.getY());
            case 5 ->
                styleButtonNames(g,70, 189, 198,"Bold", 1, 15,"ROTATE", buttonRotate.getX(), buttonRotate.getY() - 79);
        }

    }
    public void styleButtonNames(Graphics g, int clr1, int clr2, int clr3,String fNm, int fStl, int fSize, String btNa, int x, int y){
        g.setColor(new Color(clr1, clr2, clr3));
        g.setFont(new Font(fNm, fStl, fSize));
        g.drawString(btNa, x, y + 70);
    }
    public void ft(JButton b, int n){
        b.addMouseListener(new MouseListener() {
             int cg = n;
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                switch (cg) {
                    case 1 -> {
                        b.setBackground(new Color(0, 0, 255));
                        checkButtonType2 = 1;
                    }
                    case 2 -> {
                        b.setBackground(new Color(0, 255, 0));
                        checkButtonType2 = 2;
                    }
                    case 3 -> {
                        b.setBackground(new Color(255, 255, 255));
                        checkButtonType2 = 3;
                    }
                    case 4 -> {
                        b.setBackground(new Color(255, 255, 0));
                        checkButtonType2 = 4;
                    }
                    case 5 -> {
                        b.setBackground(new Color(70, 189, 198));
                        checkButtonType2 = 5;
                    }
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(Color.black);
                checkButtonType2 = 0;
            }
        });
    }
}
