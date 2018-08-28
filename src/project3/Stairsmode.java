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

public class Stairsmode extends JPanel{

		public static Image image = null;
		public static Image bg = null;
		public static Image stairicon = null;
		public static Image stair2icon = null;
		
		
		public void paint(Graphics g) {

			paintComponent(g);
			g.drawImage(bg, 0, 0, (int) (1000*FBird_Main.scale), (int) (1000*FBird_Main.scale), null);
			g.drawImage(image, FBird_Main.stairsbirdx, FBird_Main.stairsbirdy, FBird_Main.birdwidth, FBird_Main.birdheight, null);
			
			for (Rectangle stair : FBird_Main.stairs) {
				paintStairs(g, stair);
			}
			for (Rectangle stair2 : FBird_Main.stairs2) {
	
				paintStairs2(g, stair2);
			}


			g.setColor(Color.RED);
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

		
		

		 public void stairschar(){
			 try {
				if (FBird_Main.character == 1) {
					image = new ImageIcon(this.getClass().getResource("/image/aa.gif")).getImage();
				} else if (FBird_Main.character == 2) {
					image = new ImageIcon(this.getClass().getResource("/image/bb.gif")).getImage();
				} else {
					image = new ImageIcon(this.getClass().getResource("/image/cc.gif")).getImage();
					
				}
					bg = ImageIO.read(this.getClass().getResource("/image/bg.png"));
					stairicon = ImageIO.read(this.getClass().getResource("/image/stair.jpg"));
					stair2icon = ImageIO.read(this.getClass().getResource("/image/stair2.jpg"));
			 }
				 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


		public void addStairs() {
			
			Random rand = new Random();

			FBird_Main.stairs.add(new Rectangle(rand.nextInt(585), 750 + FBird_Main.stairs.size() * 150 , 120, 40));

		}	
		public void addStairs2() {
			
			Random rand = new Random();

			FBird_Main.stairs2.add(new Rectangle(rand.nextInt(585), 850 + FBird_Main.stairs2.size() * 300 , 120, 40));

		}	
		
		

		public void paintStairs(Graphics g, Rectangle stair) {
			
				g.drawImage(stairicon, stair.x, stair.y, stair.width, stair.height, null);
			
		}
		public void paintStairs2(Graphics g, Rectangle stair2) {
			
			
			g.drawImage(stair2icon, stair2.x, stair2.y, stair2.width, stair2.height, null);
		
	}


	   

	

}
