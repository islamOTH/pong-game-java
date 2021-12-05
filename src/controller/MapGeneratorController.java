package controller;

import static controller.PaintController.MAPX;
import static controller.PaintController.MAPY;
import static controller.PaintController.ballXdir;
import static controller.PaintController.ballYdir;
import static controller.PaintController.ballposX;
import static controller.PaintController.ballposY;
import static controller.PaintController.totalBricks;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.livedata.Score;

public class MapGeneratorController {
public static int brickWidth = 540/MAPX;
public static int brickHeight = 150/MAPY;
public static int  [][]map= new int [MAPY][MAPX];
private static MapGeneratorController mapGenerator=new MapGeneratorController();
public static MapGeneratorController getInstance(){return mapGenerator;}

public static void init(){ballposX = 120;ballposY = 350;ballXdir = -1;ballYdir = -2;PlayController.scorePublisher.notifyUpdate(new Score.Builder().Score(0).build()); ;
totalBricks = MAPX*MAPY;for(int i=0;i<map.length;i++)for(int j=0;j<map[0].length;j++)map[i][j]=1;} 
 
	
	public void draw(Graphics2D g) {
		for (int i = 0; i < map.length; i++) {
			for (int j=0; j< map[0].length;j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.black);
					g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.white);
					g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
				}
			}
			
		}
		
		}
		
	public void setBrickValue(int value, int i, int j) {map[i][j] = value;}

}
