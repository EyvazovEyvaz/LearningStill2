import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class TetrisPanel extends JPanel {
    public static final int FRAME_WIGHT = 400;
    public static final int FRAME_HEIGHT = 550;
    public static final int UNIC = 25;
    public static final int col = FRAME_WIGHT / UNIC;
    public static final int row = FRAME_HEIGHT / UNIC;

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
  /*  String str0 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_5).png";
    String str1 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_2).png";
    String str2 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_3).png";
    String str3 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_6).png";
    String str4 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_4).png";
    String str5 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_!).png";*/

    String str0 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_0).png";
    String str1 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_1).png";
    String str2 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_2).png";
    String str3 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_3).png";
    String str4 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_4).png";
    String str5 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_5).png";
    static int y = -25;
    static int x = 0;
    public static boolean rotateCheck = false;
    public static int rotate = 0;
    static int rnd = 0;
    static boolean check = false;
    static boolean pause_cont = true;
    static boolean pause_cont2 = false;
    static int getX = 0;
    static int getY = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    ArrayList<Integer> arrayListChild;
    static int rand;

    static int speed = 100;

    int getXline = 0;
    int getYline = 0;

    Color a = Color.white;

    Image img0;
    BufferedImage image0;

    static int fh = 0;

    TetrisPanel() {
        this.setBounds(55, 50, FRAME_WIGHT, FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(a);


        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\4e.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);

    }

    public static void thrEad() {
        try {
            Thread.sleep(speed);
            Y();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Y() {
        if (pause_cont) return;
        if (y == FRAME_HEIGHT-50 || test()) {
            pause_cont2 = true;
            y = -25;
            rotate = 0;
            rnd = rand;
            x = 0;
            speed = 100;
        }else {
            if (y == -25) {
                randommm();
            }
            pause_cont2 = false;
            check = true;
            y += 25;
        }
    }

    public static int randommm() {
        Random random = new Random();
        rand = random.nextInt(0, 6);
        return rand;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.drawImage(image0, 0, 0, this);s

        new TetrisScorePanel(rand);

       long a =  System.currentTimeMillis();

        if (rotateCheck) {
            rotateCheck = false;
        }
        if (rnd == 4) {
            rotate = 0;
        } else if (rnd == 5 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 3 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 2 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 0 && rotate == 4) {
            rotate = 0;
        } else if (rnd == 5 && rotate == 3) {
            rotate = 0;
        }

        if (rotate == 4 || rotate == 5 || rotate == 6 || rotate == 7) {
            rotate = 0;
        }

        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][rotate][i][j] != 0) {
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
                    getX = i * UNIC + 6 * UNIC + x;
                    getY = j * UNIC + y;
                    test();
                    g.drawImage(imagef, getX, getY, UNIC, UNIC, this);
                }
            }
        }

        if (y == FRAME_HEIGHT-50 || test()) {
            arrayListChild = new ArrayList<>();
            arrayListChild.add(rnd);
            arrayListChild.add(rotate);
            speed = 100;
        }

        if (test() || y == FRAME_HEIGHT-50) {
            for (int c = 0; c < T[4].length - 1; c++) {
                for (int z = 0; z < T[4][0][0].length; z++) {
                    if (T[rnd][rotate][c][z] != 0) {

                        getX = c * UNIC + 6 * UNIC + x;
                        getY = z * UNIC + y;

                        if (y==FRAME_HEIGHT-50){
                            if (rnd == 1 && rotate == 0 || rotate == 1 || rotate == 2 || rotate == 3) {
                                getY -= 25;
                            }
                            if (rnd == 5 && rotate == 1) {
                                getY += 50;
                            }
                            if (rnd == 5 && rotate == 0) {
                                getY -= 25;
                            }
                            if (rnd == 0 && rotate == 3) {
                                getY -= 25;
                            }
                            if (rnd == 2 && rotate == 0) {
                                getY -=25;
                            }
                            if (rnd == 3 && rotate == 1) {
                                getY += 25;
                            }
                            if (rnd == 2 && rotate == 1) {
                                getY -=25;
                            }
                            if (rnd == 3 && rotate == 1) {
                                getY -= 25;
                            }
                        }

                        arrayListChild.add(getX);
                        arrayListChild.add(getY);
                    }
                }
            }
        }

        if (y == FRAME_HEIGHT-50 || test()) {
            arrayList.add(arrayListChild);
            System.out.println(arrayListChild);
        }

        try {
            musicPanel();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        if (!gameOver()) {
            paint2(g);
            thrEad();
            pauseLabel(g);
            repaint();
        } else {
            paint2(g);
            paintGameOver(g);
            try {
                musicGameOver();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            whantIsNewGame();
            Y();
        }

        long b =  System.currentTimeMillis();


        for (int i = -1; i <= col; i++) {
            for (int j = -1; j <= row; j++) {
                g.drawRect(i * UNIC, j * UNIC, UNIC, UNIC);
                g.setColor(Color.white);
            }
        }

        Random random = new Random();

        int fd1 = random.nextInt(0,255);
        int fd2 = random.nextInt(0,255);
        int fd3 = random.nextInt(0,255);

        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,0,400,10,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,540,400,540,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,0,10,540,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(390,0,10,540,true);

    }

    public void pauseLabel(Graphics g) {

        if (pause_cont && TetrisScorePanel.v != 0) {
            g.setColor(Color.RED);
            g.setFont(new Font("Bold", Font.ITALIC, 29));
            g.drawString("PAUSA", 150, 200);
        }

    }

    public void musicPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\f68c40b3-1185-46a3-82ff-4dc4ffb04942.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        if (y == FRAME_HEIGHT-50 || test() && !gameOver()) {
            floatControl.setValue(6.0f);
            clip.start();
        } else {
            clip.stop();
        }

    }

    public void paintLine(Graphics g) {
        getXline = 0;
        getYline = 0;
        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][rotate][i][j] != 0) {
                    switch (rnd) {
                        case 0 -> g.setColor(Color.white);
                        case 1 -> g.setColor(Color.white);
                        case 2 -> g.setColor(Color.white);
                        case 3 -> g.setColor(Color.white);
                        case 4 -> g.setColor(Color.white);
                        case 5 -> g.setColor(Color.white);
                    }

                    getXline = i * UNIC + 6 * UNIC + x;
                    getYline = j * UNIC + 500;

                    if (getYline == j * UNIC + 500) {
                        if (rnd == 1 && rotate == 0 || rotate == 1 || rotate == 2 || rotate == 3) {
                            getYline -= 25;
                        }
                        if (rnd == 5 && rotate == 1) {
                            getYline += 50;
                        }
                        if (rnd == 5 && rotate == 0) {
                            getYline -= 25;
                        }
                        if (rnd == 0 && rotate == 3) {
                            getYline -= 25;
                        }
                        if (rnd == 2 && rotate == 0) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getYline += 25;
                        }
                        if (rnd == 2 && rotate == 1) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getYline -= 25;

                        }

                        //g.drawRect(getXline, getYline, UNIC, UNIC);
                    }

                    /*for(int s=0; s<arrayList.size(); s++){
                        int x = 0;
                        int y = 0;
                        for (int n=s+1; n<arrayList.size(); n++){
                            for (int d=0; d<10; d++){
                                if (d !=0 && d%2==0 && Objects.equals(arrayList.get(s).get(d), arrayList.get(n).get(d))){
                                    if (arrayList.get(s).get(d+1)>arrayList.get(n).get(d+1)){
                                        y = arrayList.get(s).get(d+1);
                                        x = arrayList.get(s).get(d);
                                    } else if (arrayList.get(s).get(d+1)<arrayList.get(n).get(d+1)) {
                                        y = arrayList.get(n).get(d+1);
                                        x = arrayList.get(n).get(d);
                                    }
                                    if (x == getXline - 25) {
                                        for (int f = 0; f < T[4].length - 1; f++) {
                                            for (int v = 0; v < T[4][0][0].length; v++) {
                                                if (T[rnd][rotate][f][v] != 0) {
                                                    getYline = y-50;
                                                    g.fillRect(getXline, getYline, UNIC, UNIC);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }*/
                }
                for (ArrayList<Integer> tt : arrayList) {
                    for (int c = 0; c < tt.size(); c++) {
                        if (c % 2 == 0 && tt.get(c) == getXline - 25) {
                            for (int f = 0; f < T[4].length - 1; f++) {
                                for (int v = 0; v < T[4][0][0].length; v++) {
                                    if (T[rnd][rotate][f][v] != 0) {
                                        getYline = tt.get(c + 1) - 75;
                                    }
                                }
                            }
                        }
                    }
                }
                g.drawRect(getXline, getYline, UNIC, UNIC);
            }
        }
    }

    public void paint2(Graphics g) {
        for (ArrayList<Integer> rr : arrayList) {
            BufferedImage imagef = null;
            int tX = 0;
            int tY = 0;
            for (int i = 0; i < T[4].length - 1; i++) {
                for (int j = 0; j < T[4][0][0].length; j++) {
                    if (T[rr.get(0)][rr.get(1)][i][j] != 0) {
                        switch (rr.get(0)) {
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
                        tX += 2;
                        tY += 2;

                    }
                    g.drawImage(imagef, rr.get(tX), rr.get(tY + 1), UNIC, UNIC, this);
                }
            }
        }
    }

    public static boolean test() {
        boolean vv = false;
       main: for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i != 0 && i % 2 == 0 && tt.get(i) == getX && tt.get(i + 1) == getY + 25) {
                    System.out.println("hh");
                    vv = true;
                    break main;
                }else {
                    vv = false;
                }
            }
        }
        if (vv){
            return true;
        }else{
            return false;
        }
    }

    public static boolean testLeft() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i != 0 && i % 2 == 0 && tt.get(i) == getX - 25 && tt.get(i + 1) == getY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean testRight() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i != 0 && i % 2 == 0 && tt.get(i) == getX + 25 && tt.get(i + 1) == getY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean gameOver() {

        if (test()) {
            if (getY == 25 || getY == -25 || getY == 0) {
                TetrisScorePanel.clip.stop();
                TetrisPanel.pause_cont = true;
                return true;
            }
        }
        return false;
    }

    public void paintGameOver(Graphics g) {

        BufferedImage imageOverGame;

        try {
            imageOverGame = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\gameOver - Copy.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image imgGameOv = imageOverGame.getScaledInstance(380, 160, 4);
        g.drawImage(imgGameOv, 10, 150, this);

    }

    public void musicGameOver() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\928daa61-6297-4a75-8e12-bfac5aff4ef7.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void whantIsNewGame() {

        JLabel lEADtEXT = new JLabel();
        lEADtEXT.setText("Yenidən oyna");
        lEADtEXT.setBounds(170, 240, 300, 100);
        lEADtEXT.setForeground(Color.orange);
        this.add(lEADtEXT);
        JLabel label = new JLabel();
        label.setBounds(50, 300, 300, 100);
        JButton button = new JButton();
        button.setBounds(75, 0, 40, 40);
        button.setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\yes1.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(button.getWidth(), button.getHeight(), 4);
        button.setIcon(new ImageIcon(img));
        label.add(button);

        JButton buttonj = new JButton();
        buttonj.setBounds(185, 0, 40, 40);
        buttonj.setBackground(Color.WHITE);
        ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\yes.png");
        Image image1 = imageIcon1.getImage().getScaledInstance(buttonj.getWidth(), buttonj.getHeight(), 4);
        buttonj.setIcon(new ImageIcon(image1));
        label.add(buttonj);
        this.add(label);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Main.createObjectFirstPage1();
                Main.createObjTetris1();
                arrayList = new ArrayList<>();
                pause_cont = false;
                pause_cont2 = true;

                TetrisScorePanel.scr = 0;
            }
        });
        buttonj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

    }

    public void checkisFillallXcoor() {

        int[] chAllForYcoor = {0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400,
                               425, 450, 475, 500, 525};

        int sum = 0;
        for (int k : chAllForYcoor) {
            int[] chcAllXcoor = new int[]{0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400};
            sum =0;
            for (ArrayList<Integer> arr : arrayList) {
                for (int j = 0; j < arr.size(); j++) {
                    for (int xc = 0; xc < chcAllXcoor.length; xc++) {
                        if (j != 0 && j % 2 == 0 && k == arr.get(j + 1) && chcAllXcoor[xc] == arr.get(j) && chcAllXcoor[xc] >= 0) {
                            chcAllXcoor[xc] += -1000;
                            sum++;
                            if (sum==16){
                                TetrisScorePanel.scr++;
                                sum =0;
                            }
                        }
                    }
                }
            }

        }

        System.out.println(sum);
    }
}
