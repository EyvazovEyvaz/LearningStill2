import javax.swing.*;

public class Main {
    static TetrisFrame[] arrTetFrame1 = new TetrisFrame[1];
    public static void main(String[] args){

        createObjectFirstPage1();


    }
    public static void createObjectFirstPage1(){
        TetrisFirstPageFrame tetrisFirstPageFrame = new TetrisFirstPageFrame();
        TetrsiFirstPagePanel.clip.start();
        try {
            Thread.sleep(4000);
            tetrisFirstPageFrame.setVisible(false);
            TetrsiFirstPagePanel.clip.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createObjTetris1();

    }
    public static void createObjTetris1(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TetrisFrame[] arrTetFrame2 = new TetrisFrame[arrTetFrame1.length+1];

                for (int i=0; i< arrTetFrame1.length; i++){
                    arrTetFrame2[i] = arrTetFrame1[i];
                }

                arrTetFrame1 = arrTetFrame2;

                TetrisFrame tetrisFrame = new TetrisFrame();
                arrTetFrame1[arrTetFrame1.length-1] = tetrisFrame;

                for (int i=0; i< arrTetFrame1.length; i++){
                    if (i != arrTetFrame1.length-1 && arrTetFrame1[i] !=null){
                        arrTetFrame1[i].setVisible(false);
                    }
                }

            }
        });
    }
}