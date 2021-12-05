/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static controller.PaintController.playerX;
import static controller.PlayController.playController;
import view.GamePlay;

/**
 *
 * @author Islam
 */
public class MoveLeft implements MoveInterface{

    @Override
    public void move() {
if(playerX < 10) {playerX = 10;} else {GamePlay.play = true;playerX -= 20;}
    }
    
}
