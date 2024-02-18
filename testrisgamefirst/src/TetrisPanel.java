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
            {{{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}, {{1, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
            //LLLL
            {{{0, 0, 0, 0},{1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}, {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {1, 0, 0, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}}, {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}},
            //ZZZZ
            {{{1, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
            ///SSSS
            {{{0, 1, 0, 0}, {1, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}}, {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
            //OOOO
            {{{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}},
            //IIII
            {{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}}, {{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0}}}

    };

    String str0 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block1.jpg";
    String str1 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block2.jpg";
    String str2 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block3.jpg";
    String str3 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block4.jpg";
    String str4 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block5.jpg";
    String str5 = "C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\block6.jpg";
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

    static int speed = 170;

    int getXline = 0;
    int getYline = 0;

    Color a = Color.black;

    Image img0;
    BufferedImage image0;

    public static boolean checkPoint = false;
   static int chckPointX = 0;
    static int chckPointY = 0;

    TetrisPanel() {
        this.setBounds(55, 50, FRAME_WIGHT, FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(a);


        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\TetrisGamePanelBackPicture.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         img0 = image0.getScaledInstance(getWidth(), getHeight(), 4);

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
            speed = 170;

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

        g.drawImage(img0, 0, 0, this);

        new TetrisScorePanel(rand);

        checkisFillallXcoor();

        Random random = new Random();

        int fd1 = random.nextInt(0,255);
        int fd2 = random.nextInt(0,255);
        int fd3 = random.nextInt(0,255);

        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,0,400,7,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,543,400,543,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(0,0,7,543,true);
        g.setColor(new Color(fd1, fd2, fd3));
        g.fill3DRect(393,0,7,543,true);

       long a =  System.currentTimeMillis();

        if (rotateCheck) {
            rotateCheck = false;
        }
        if (rnd == 4) {
            rotate = 0;
        } else if (rnd == 5 && rotate >= 2) {
            rotate = 0;
        } else if (rnd == 3 && rotate >= 2) {
            rotate = 0;
        } else if (rnd == 2 && rotate >= 2) {
            rotate = 0;
        } else if (rnd == 0 && rotate ==4) {
            rotate = 0;
        }

        for (int i = 0; i < T[rnd].length; i++) {
            for (int j = 0; j < T[rnd][0][0].length; j++) {
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
            for (int c = 0; c < T[rnd].length; c++) {
                for (int z = 0; z < T[rnd][0][0].length; z++) {
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
                                getY -= 50;
                            }
                            if (rnd == 3 && rotate == 1) {
                                getY += 25;
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


        /*for (int i = -1; i <= col; i++) {
            for (int j = -1; j <= row; j++) {
                g.drawRect(i * UNIC, j * UNIC, UNIC, UNIC);
                g.setColor(Color.GRAY);
            }
        }*/


    }
    public void grap(Graphics g, int xs, int ys){
        g.setColor(Color.BLUE);
        g.fill3DRect(ys,xs,2, 5, true);
    }

    public void pauseLabel(Graphics g) {

        if (pause_cont && TetrisScorePanel.v != 0) {
            g.setColor(Color.RED);
            g.setFont(new Font("Bold", Font.ITALIC, 29));
            g.drawString("PAUSA", 150, 200);
        }

    }

    public void musicPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\blockJoinMusic.wav");
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
        for (int i = 0; i < T[rnd].length; i++) {
            for (int j = 0; j < T[rnd][0][0].length; j++) {
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
                            for (int f = 0; f < T[rnd].length; f++) {
                                for (int v = 0; v < T[rnd][0][0].length; v++) {
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
            for (int i = 0; i < T[rnd].length; i++) {
                for (int j = 0; j < T[rnd][0][0].length; j++) {
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

    public static boolean test(){

        for (int t = 0; t < 4; t++) {
            for (int j = 0; j < T[rnd][0][0].length; j++) {
                if (T[rnd][rotate][t][j] != 0) {

                    getX = t * UNIC + 6 * UNIC + x;
                    getY = j * UNIC + y;

                    for (ArrayList<Integer> tt : arrayList){
                        for (int i = 0; i < tt.size(); i++) {
                            if (i != 0 && i % 2 == 0 && tt.get(i) == getX && tt.get(i + 1) == getY+25){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean testLeft() {

        for (int t = 0; t < T[rnd].length; t++) {
            for (int j = 0; j < T[rnd][0][0].length; j++) {
                if (T[rnd][rotate][t][j] != 0) {

                    getX = t * UNIC + 6 * UNIC + x;
                    getY = j * UNIC + y;

                    for (ArrayList<Integer> tt : arrayList) {
                        for (int i = 0; i < tt.size(); i++) {
                            if (i != 0 && i % 2 == 0 && tt.get(i) == getX - 25 && tt.get(i + 1) == getY) {
                                return true;
                            }
                        }
                    }

                }
            }
        }

        return false;
    }

    public static boolean testRight() {

        for (int t = 0; t < T[rnd].length; t++) {
            for (int j = 0; j < T[rnd][0][0].length; j++) {
                if (T[rnd][rotate][t][j] != 0) {

                    getX = t * UNIC + 6 * UNIC + x;
                    getY = j * UNIC + y;

                    for (ArrayList<Integer> tt : arrayList) {
                        for (int i = 0; i < tt.size(); i++) {
                            if (i != 0 && i % 2 == 0 && tt.get(i) == getX + 25 && tt.get(i + 1) == getY) {
                                return true;
                            }
                        }
                    }
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
            imageOverGame = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\game-over (2).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image imgGameOv = imageOverGame.getScaledInstance(300, 180, 4);
        g.drawImage(imgGameOv, 40, 150, this);

    }

    public void musicGameOver() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\gameOverMusic.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void whantIsNewGame() {

        JLabel lEADtEXT = new JLabel();
        lEADtEXT.setText("Play again");
        lEADtEXT.setBounds(170, 240, 300, 100);
        lEADtEXT.setForeground(Color.orange);
        this.add(lEADtEXT);
        JLabel label = new JLabel();
        label.setBounds(50, 300, 300, 100);
        JButton button = new JButton();
        button.setBounds(75, 0, 40, 40);
        button.setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\afteGameOverYesButtonPicture.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(button.getWidth(), button.getHeight(), 4);
        button.setIcon(new ImageIcon(img));
        label.add(button);

        JButton buttonj = new JButton();
        buttonj.setBounds(185, 0, 40, 40);
        buttonj.setBackground(Color.WHITE);
        ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GamePictures\\afteGameOverNoButtonPicture.png");
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

                TetrisScorePanel.score = 0;
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

        for (Integer ycoor: chAllForYcoor){
            int xc = 0;
            int[] chcAllXcoor = {0, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400};
            for (ArrayList<Integer> arrrcoor: arrayList){
                for (int i=0; i<arrrcoor.size(); i++){
                    if (i!=1 && i % 2 == 1){
                        if (ycoor.equals(arrrcoor.get(i))){
                            for (int n=0; n<chcAllXcoor.length; n++){
                                if (arrrcoor.get(i-1)==chcAllXcoor[n]){
                                    xc++;
                                    chcAllXcoor[n] *= -1;
                                }
                            }
                        }
                    }
                }
            }

            if (xc==16){
                checkPoint = true;
                for (ArrayList<Integer> arrrcoor: arrayList){
                    for (int i=0; i<arrrcoor.size(); i++){
                        if (i!=1 && i % 2 == 1){
                            if (ycoor.equals(arrrcoor.get(i))){
                                arrrcoor.set(i,-25);
                                arrrcoor.set(i-1,-25);
                                chckPointY = arrrcoor.get(i);
                                chckPointX = arrrcoor.get(i-1);
                            }
                            if (ycoor-25 == arrrcoor.get(i)){
                                arrrcoor.set(i,-25);
                                arrrcoor.set(i-1,-25);
                            }
                            if (ycoor-50 == arrrcoor.get(i)){
                                arrrcoor.set(i,-25);
                                arrrcoor.set(i-1,-25);
                            }
                        }
                    }
                }
                switchAllBlockes(ycoor);
                TetrisScorePanel.score +=10;
                try {
                    musicForPoint();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }else{
                checkPoint = false;
            }
        }

    }

    public void switchAllBlockes(int u){

        for (ArrayList<Integer> arrrcoor: arrayList){
            for (int i=0; i<arrrcoor.size(); i++){
                if (i!=1 && i % 2 == 1){
                    if (u > arrrcoor.get(i)){
                        arrrcoor.set(i, arrrcoor.get(i)+75);
                    }
                }
            }
        }
    }
    public void musicForPoint() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\TETRIS\\GameMuiscs\\clearLinesMusic.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(6.0f);
        clip.start();

    }
}
