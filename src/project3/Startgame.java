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

public class Startgame extends JPanel {

	public static Image image = null;
	public static Image ballimage = null;
	public static Image enemyimage = null;
	public static Image bg = null;
	public static Image pipe = null;

	public void update(){
		
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
			enemyimage = ImageIO.read(this.getClass().getResource("/image/enemy.png"));
			pipe = ImageIO.read(this.getClass().getResource("/image/00.png"));
			bg = ImageIO.read(this.getClass().getResource("/image/bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	

	public void addColumn() {
		Random rand = new Random();

		int initialx = (int) (600*FBird_Main.scale);
		int space = (int) (300*FBird_Main.scale);
		int width = (int) (120*FBird_Main.scale);
		int height = (int) ((100 + rand.nextInt(550))*FBird_Main.scale);
		int space2 = (int) (250*FBird_Main.scale);

		FBird_Main.columns.add(new Rectangle(initialx + FBird_Main.columns.size() * space, 0, width, height));
		FBird_Main.columns.add(new Rectangle(initialx + (FBird_Main.columns.size() - 1) * space, 0 + height + space2,
				width, 1000 - (0 + height + space2)));
		
		//Battle use
		
		int initialx2 = (int) (1000*FBird_Main.scale-initialx);
		height = (int) ((100 + rand.nextInt(550))*FBird_Main.scale);
		
		FBird_Main.columns2.add(new Rectangle(initialx2 - FBird_Main.columns2.size() * space, 0, width, height));
		FBird_Main.columns2.add(new Rectangle(initialx2 - (FBird_Main.columns2.size() - 1) * space, 0 + height + space2,
				width, 1000 - (0 + height + space2)));
		
	}

	public void addenemy() {
		Random rand = new Random();

		int initialx = (int) (1400*FBird_Main.scale);
		int space = (int) (300*FBird_Main.scale);


		FBird_Main.enemys.add(new Rectangle(initialx + FBird_Main.enemys.size() * space + 300, rand.nextInt(1000), 60, 60));
	}	
	
	public void paint(Graphics g) {

		paintComponent(g);
		g.drawImage(bg, 0, 0, (int) (1000*FBird_Main.scale), (int) (1000*FBird_Main.scale), null);
		g.drawImage(image, FBird_Main.birdx, FBird_Main.birdy, FBird_Main.birdwidth, FBird_Main.birdheight, null);

		for (Rectangle column : FBird_Main.columns) {
			paintColumn(g, column);
		}

		for (Rectangle ball : FBird_Main.ball) {

			paintball(g, ball);
		}

		for (Rectangle enemy : FBird_Main.enemys) {
			paintenemy(g, enemy);
		}

		g.setColor(Color.BLACK);
		Font f = new Font("Arial Bold", Font.BOLD | Font.ITALIC, 30);
		g.setFont(f);
		g.drawString("Score:" + FBird_Main.score, 30, 30);

		if (FBird_Main.State == 2) {// 因為gameover沒有用到 paintcomponent 為了使文字不閃爍加上

			g.setColor(Color.WHITE);
			Font f1 = new Font("Arial Bold", Font.BOLD | Font.ITALIC, 72);
			g.setFont(f1);
			g.drawString("Game Over !", (int) (300*FBird_Main.scale), (int) (250*FBird_Main.scale));// Gameover

			g.drawString("Score:" + FBird_Main.score, (int) (300*FBird_Main.scale), (int) (500*FBird_Main.scale));// 顯示分數

			g.fillRoundRect((int) (300*FBird_Main.scale), (int) (600*FBird_Main.scale), (int) (400*FBird_Main.scale), (int) (100*FBird_Main.scale), 5, 5);// Return按鈕的按鈕
			g.setColor(Color.BLACK);
			Font f2 = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (50*FBird_Main.scale));
			g.setFont(f2);
			g.drawString("Return menu", (int) (350*FBird_Main.scale), (int) (675*FBird_Main.scale));// Return按鈕的文字
		}

	}

	public void paintColumn(Graphics g, Rectangle column) {
		if(column.y == 0)
			g.drawImage(pipe, column.x, (int) -((1000*FBird_Main.scale)-column.height), column.width, (int) (1000*FBird_Main.scale), null);
		else
			g.drawImage(pipe, column.x, column.y , column.width, (int) (1000*FBird_Main.scale), null);
	}

	public void paintball(Graphics g, Rectangle ball) {
		
		g.drawImage(ballimage, ball.x,ball.y, ball.width, ball.height, null);

	}

	public void paintenemy(Graphics g, Rectangle enemy) {
		g.drawImage(enemyimage,enemy.x, enemy.y, enemy.width, enemy.height, null);

	}
    

}
