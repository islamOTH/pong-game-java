/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MapGeneratorController;
import controller.PaintController;
import controller.PlayController;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Islam
 */
public  abstract class MainPanel extends JPanel implements KeyListener, ActionListener{
        public PaintController paintController=PaintController.getInstance();
        public PlayController playController=PlayController.getInstence();
	public MapGeneratorController map =  MapGeneratorController.getInstance();
        
        @Override
	public void keyReleased(KeyEvent arg0) {}

        @Override
	public void keyTyped(KeyEvent arg0) {
        }
	
    
}
