/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static controller.PaintController.playerX;
import static controller.PlayController.playController;
import java.awt.event.KeyEvent;
import view.GamePlay;

/**
 *
 * @author Islam
 */
public class MoveRight implements MoveInterface{

    @Override
    public void move() {
        if(playerX >= 600) {playerX = 600;} else {GamePlay.play = true;playerX += 20;}

    }
    
}
