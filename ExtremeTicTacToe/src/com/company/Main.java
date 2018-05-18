package com.company;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Extreme Tic Tac Toe");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setResizable(false);
        myFrame.setLayout(new GridLayout(3,3));


        JPanel2[] bigTTT= new JPanel2[9];
        for(int i=0; i<bigTTT.length; i++){
            bigTTT[i] = new JPanel2();
            myFrame.add(bigTTT[i]);
        }

        myFrame.setVisible(true);

        //loop to always look if the game is finished
        boolean gameOver = false;
        int location = 4;
        int count = 0;
        while(!gameOver){
            //check what square has been clicked and determines where the next player should play
            for(int i=0; i<bigTTT.length; i++){
                if(bigTTT[i].isUsed() == true){
                    location = bigTTT[i].getPlace();
                    bigTTT[i].setUsed(false);
                    break;
                }
            }

            //enable and disables the big tic tac toe squares
            for(int i=0; i<bigTTT.length; i++){
                if(location != i){
                    for(Component c : bigTTT[i].getComponents()){
                            c.setEnabled(false);
                    }
                } else {
                    for(Component c : bigTTT[i].getComponents()){
                        if(!bigTTT[i].getButtonsUsed().contains(count))
                            c.setEnabled(true);
                        location = i;
                        count++;
                    }
                    count = 0;
                }
            }

            //horizontal
            if(bigTTT[0].isWin().equals(bigTTT[1].isWin()) && bigTTT[1].isWin().equals(bigTTT[2].isWin()) && !bigTTT[0].isWin().equals("")){
                System.out.println("Player " + bigTTT[0].isWin() + " won the game!!");
            } else if(bigTTT[3].isWin().equals(bigTTT[4].isWin()) && bigTTT[4].isWin().equals(bigTTT[5].isWin()) && !bigTTT[3].isWin().equals("")){
                System.out.println("Player " + bigTTT[3].isWin() + " won the game!!");
            } else if(bigTTT[6].isWin().equals(bigTTT[7].isWin()) && bigTTT[7].isWin().equals(bigTTT[8].isWin()) && !bigTTT[6].isWin().equals("")){
                System.out.println("Player " + bigTTT[6].isWin() + " won the game!!");
            }

            //vertical
            if(bigTTT[0].isWin().equals(bigTTT[3].isWin()) && bigTTT[3].isWin().equals(bigTTT[6].isWin()) && !bigTTT[0].isWin().equals("")){
                System.out.println("Player " + bigTTT[0].isWin() + " won the game!!");
            } else if(bigTTT[1].isWin().equals(bigTTT[4].isWin()) && bigTTT[4].isWin().equals(bigTTT[7].isWin()) && !bigTTT[1].isWin().equals("")){
                System.out.println("Player " + bigTTT[1].isWin() + " won the game!!");
            } else if(bigTTT[2].isWin().equals(bigTTT[5].isWin()) && bigTTT[5].isWin().equals(bigTTT[8].isWin()) && !bigTTT[2].isWin().equals("")){
                System.out.println("Player " + bigTTT[2].isWin() + " won the game!!");
            }

            //diagonal
            if(bigTTT[0].isWin().equals(bigTTT[4].isWin()) && bigTTT[4].isWin().equals(bigTTT[8].isWin()) && !bigTTT[0].isWin().equals("")){
                System.out.println("Player " + bigTTT[0].isWin() + " won the game!!");
            } else if(bigTTT[2].isWin().equals(bigTTT[4].isWin()) && bigTTT[4].isWin().equals(bigTTT[6].isWin()) && !bigTTT[2].isWin().equals("")){
                System.out.println("Player " + bigTTT[2].isWin() + " won the game!!");
            }
        }
    }
}

