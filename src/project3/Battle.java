package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battle extends JPanel {

	public static Image image = null;
	public static Image image2 = null;
	public static Image ballimage = null;
	public static Image ballimage2 = null;
	public static Image enemyimage = null;
	public static Image bg = null;
	public static Image pipe = null;

	public void update() {

		try {
			if (FBird_Main.character == 1) {
				image = new ImageIcon(this.getClass().getResource("/image/aa.gif")).getImage();
				ballimage = ImageIO.read(this.getClass().getResource("/image/11-01.png"));
			} else if (FBird_Main.character == 2) {
				image = new ImageIcon(this.getClass().getResource("/image/bb.gif")).getImage();
				ballimage = ImageIO.read(this.getClass().getResource("/image/21-01.png"));
			} else {
				image = new ImageIcon(this.getClass().getResource("/image/cc.gif")).getImage();
				ballimage = ImageIO.read(this.getClass().getResource("/image/31-01.png"));
			}
			if (FBird_Main.character2 == 1) {
				image2 = new ImageIcon(this.getClass().getResource("/image/aaa.gif")).getImage();
				ballimage2 = ImageIO.read(this.getClass().getResource("/image/11-01.png"));
			} else if (FBird_Main.character2 == 2) {
				image2 = new ImageIcon(this.getClass().getResource("/image/bbb.gif")).getImage();
				ballimage2 = ImageIO.read(this.getClass().getResource("/image/21-01.png"));
			} else {
				image2 = new ImageIcon(this.getClass().getResource("/image/ccc.gif")).getImage();
				ballimage2 = ImageIO.read(this.getClass().getResource("/image/31-01.png"));
			}
			enemyimage = ImageIO.read(this.getClass().getResource("/image/enemy.png"));
			pipe = ImageIO.read(this.getClass().getResource("/image/00.png"));
			bg = ImageIO.read(this.getClass().getResource("/image/bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void paint(Graphics g) {
		
		paintComponent(g);
		g.drawImage(bg, 0, 0, (int) (1000 * FBird_Main.scale), (int) (1000 * FBird_Main.scale), null);
		g.drawImage(image, FBird_Main.birdx, FBird_Main.birdy, FBird_Main.birdwidth, FBird_Main.birdheight, null);
		g.drawImage(image2, FBird_Main.bird2x, FBird_Main.bird2y, FBird_Main.birdwidth, FBird_Main.birdheight, null);
		for (Rectangle column : FBird_Main.columns) {
			paintColumn(1, g, column);
		}
		for (Rectangle column : FBird_Main.columns2) {
			paintColumn(2, g, column);
		}
		for (Rectangle ball : FBird_Main.ball) {
			paintball(1, g,ball);
		}
		for (Rectangle ball : FBird_Main.ball2) {
			paintball(2, g,ball);
		}

	}

	public void paintColumn(int a, Graphics g, Rectangle column) {

		if (a == 1 && column.x <= 500*0.75) {
			
			if(column.y == 0)
				g.drawImage(pipe, column.x, -(750-column.height), column.width, (int) (1000*FBird_Main.scale), null);
			else
				g.drawImage(pipe, column.x, column.y , column.width, 750, null);

		}
		if (a == 2 && column.x >= 500*0.75) {
			
			if(column.y == 0)
				g.drawImage(pipe, column.x, (int) -((1000*FBird_Main.scale)-column.height), column.width, (int) (1000*FBird_Main.scale), null);
			else
				g.drawImage(pipe, column.x, column.y , column.width, (int) (1000*FBird_Main.scale), null);
			
		}

	}
	
	public void paintball(int a, Graphics g, Rectangle ball) {
		if(a==1)
		g.drawImage(ballimage, ball.x,ball.y, ball.width, ball.height, null);

		else
		g.drawImage(ballimage2, ball.x,ball.y, ball.width, ball.height, null);
	
	}

};
