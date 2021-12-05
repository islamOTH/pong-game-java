package view;

import controller.MapGeneratorController;
import controller.PaintController;
import static controller.PaintController.MAPX;
import static controller.PaintController.MAPY;
import static controller.PaintController.ballXdir;
import static controller.PaintController.ballYdir;
import static controller.PaintController.ballposX;
import static controller.PaintController.ballposY;
import static controller.PaintController.delay;
import static controller.PaintController.playerX;
import static controller.PaintController.totalBricks;
import controller.PlayController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
import model.MainPanel;
import model.livedata.Score;

public class GamePlay extends MainPanel{
	public static boolean play = false;
	private Timer timer;
	
	public GamePlay() {
                map.init();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
        @Override
	public void paint(Graphics g) {
		paintController.paintBackground(g);
		map.draw((Graphics2D)g);
		paintController.paintRectangle(g);
		paintController.paintBall(g,Color.green);
                
		g.setColor(Color.black);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + Score.getInstence().getScore(), 590, 30);

		if (totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You Won, Score: " + Score.getInstence().getScore(), 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart.", 230, 350);	
			
		}
		
		if(ballposY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Score: " + Score.getInstence().getScore(), 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart.", 230, 350);	
		} 
		
		
		
		g.dispose();
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		if(play) {
			// Ball - Pedal  interaction 
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = - ballYdir;
			}
			for( int i = 0; i<map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX = j*map.brickWidth + 80;
						int brickY = i*map.brickHeight + 50;
						int brickWidth= map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect) ) {
							map.setBrickValue(0, i, j);
							totalBricks--;
							PlayController.scorePublisher.notifyUpdate(new Score.Builder().Score(Score.getInstence().getScore()+5).build());
							
							if(ballposX + 19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width) 
								ballXdir = -ballXdir;
							 else {
								ballYdir = -ballYdir;
							}
						}
						
					}
					
				}
			}
			
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;  
			
			}
			
		}
		
		
		repaint();

	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
            if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
                                map.init();
				repaint();
			}
		}
            else
            playController.move(arg0);
		
	}	
        
	
		
	

	
}