package my.projects.Games.Gui.TicTacToe;

import javax.swing.*;
import java.awt.GridLayout;

public class TicTacToe extends JFrame{
    JPanel p=new JPanel();
    XOButton buttons[]=new XOButton[9];

    public static void main(String args[]){
        new TicTacToe();
    }

    public TicTacToe(){
        super("TicTacToe");
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        p.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++){
            buttons[i]=new XOButton();
            p.add(buttons[i]);
        }
        add(p);

        setVisible(true);
    }
}