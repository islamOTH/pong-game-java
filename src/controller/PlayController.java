
package controller;

import model.AbstractFactore;
import model.MoveInterface;
import static controller.PaintController.playerX;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.MoveLeft;
import model.MoveRight;
import model.livedata.ScorePublisher;
import view.GamePlay;
import static view.GamePlay.play;


public class PlayController extends AbstractFactore  {
    public static ScorePublisher scorePublisher =new ScorePublisher();
    public static PlayController playController=new PlayController();
    public static PlayController getInstence(){return playController;}
      public void moveRight() {}
      public void moveLeft() {}
      public void move(KeyEvent arg0){getMove(arg0).move();}

    @Override
    public MoveInterface getMove(KeyEvent arg0) {
       if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {return new MoveRight();}
       if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {return new MoveLeft();}
       return new MoveInterface() {@Override public void move() { } };  }
    
}
