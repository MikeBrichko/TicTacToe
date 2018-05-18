package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanel2 extends JPanel implements ActionListener{
    private JButton[] button = new JButton[9];
    private String[] letters = new String[9];
    private String letter = "";
    private String win;

    private ImageIcon X = resizeIcon(new ImageIcon("X.png"), 66, 60);
    private ImageIcon O = resizeIcon(new ImageIcon("O.jpg"), 66, 60);
    private ImageIcon tempImg = new ImageIcon();

    //determine what players turn it is
    private static int turn = 0;

    //position of the square pressed in the BIG tic-tac-toe
    private static int position = 0;

    //position of the square pressed in the SMALL tic-tac-toe
    private int place;

    //says if the player has played his turn
    private boolean used;

    private ArrayList<Integer> buttonsUsed = new ArrayList<>();


    public JPanel2(){
        super();
        setSize(200,200);
        setBorder(BorderFactory.createBevelBorder(1));

        //tic tac toe layout
        setLayout(new GridLayout(3,3));
        for(int i=0; i<9; i++){
            button[i] = new JButton(""+ i);
            add(button[i]);
        }

        //add ActionListener
        for(int i=0; i<9; i++){
            button[i].addActionListener(this);
        }

        //initialize letters used for win verification
        for(int i=0; i<9; i++){
            letters[i] = "";
        }

        this.position = position++;
        this.used = false;
        this.win = "";
    }

    public void actionPerformed(ActionEvent e){
        turn++;

        //determine who's playing
        if(turn %2 == 1){
            letter = "O";
            tempImg = O;
        } else {
            letter = "X";
            tempImg = X;
        }

        //Display letters
        for(int i=0; i<9;i++){
            if(e.getSource() == button[i]){
                button[i].setIcon(tempImg);
                button[i].setDisabledIcon(tempImg);
                button[i].setEnabled(false);
                letters[i] = letter;

                buttonsUsed.add(i);
                place = i;
            }
        }

        //PanelState
        boolean victory = false;
        //check horizontal
        if(letters[0].equals(letters[1]) && letters[1].equals(letters[2]) && !letters[0].equals("")){
            victory = true;
        } else if(letters[3].equals(letters[4]) && letters[4].equals(letters[5]) && !letters[3].equals("")){
            victory = true;
        } else if(letters[6].equals(letters[7]) && letters[7].equals(letters[8]) && !letters[6].equals("")){
            victory = true;
        }

        //check vertical
        if(letters[0].equals(letters[3]) && letters[3].equals(letters[6]) && !letters[0].equals("")){
            victory = true;
        } else if(letters[1].equals(letters[4]) && letters[4].equals(letters[7]) && !letters[1].equals("")){
            victory = true;
        } else if(letters[2].equals(letters[5]) && letters[5].equals(letters[8]) && !letters[2].equals("")){
            victory = true;
        }

        //check diagonal
        if(letters[0].equals(letters[4]) && letters[4].equals(letters[8]) && !letters[0].equals("")){
            victory = true;
        } else if(letters[2].equals(letters[4]) && letters[4].equals(letters[6]) && !letters[2].equals("")){
            victory = true;
        }

        if(victory && win.equals("")){
            setWin(letter);
        }

        setUsed(true);
    }

    public String isWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public static int getPosition() {
        return position;
    }

    public static void setPosition(int position) {
        JPanel2.position = position;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getPlace() {
        return place;
    }

    public ArrayList<Integer> getButtonsUsed() {
        return buttonsUsed;
    }

    public ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
