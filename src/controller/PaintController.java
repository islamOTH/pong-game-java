/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import model.livedata.ScorePublisher;

/**
 *
 * @author Islam
 */
public class PaintController {
        public static int MAPX = 1;
	public static int MAPY = 5;
	public static int totalBricks = MAPX*MAPY;
        public static int delay = 2;
	public static int playerX = 310;
	public static int ballposX = 120;
	public static int ballposY = 350;
	public static int ballXdir = -1;
	public static int ballYdir = -2;
        private static PaintController paintController=new PaintController();
        public static PaintController getInstance(){return paintController;}
        public void paintBall(Graphics g,Color c){
      g.setColor(c);
      g.fillOval(ballposX, ballposY, 20, 20);
    }
        public void paintRectangle(Graphics g){
                g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8);
    }
        public void paintBackground(Graphics g){
                g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
     }
}
