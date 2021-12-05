/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import view.GamePlay;

/**
 *
 * @author Islam
 */
public class MyFrame extends JFrame{
private static MyFrame mf=new MyFrame();
public static MyFrame getInstence(){return mf;}
    public MyFrame() throws HeadlessException {
		GamePlay gamePlay = new GamePlay();
		this.setTitle("Brick Breaker");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamePlay);
                this.setBounds(10, 10, 700, 600);
    }
    
}
