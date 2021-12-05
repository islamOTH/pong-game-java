/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.MoveInterface;
import java.awt.event.KeyEvent;

/**
 *
 * @author Islam
 */
public abstract class AbstractFactore {
   public abstract MoveInterface getMove(KeyEvent arg0);
    
}
