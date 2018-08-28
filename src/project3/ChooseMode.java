package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChooseMode extends JPanel {

	public void paint(Graphics g) {
		Image image = null;
		Image image1 = null;
		Image image2 = null;
		Image image3 = null;
		
		try{
		image = ImageIO.read(this.getClass().getResource("/image/1.png"));
		image1 = ImageIO.read(this.getClass().getResource("/image/a-01.png"));
		image2 = ImageIO.read(this.getClass().getResource("/image/b-01.png"));
		image3 = ImageIO.read(this.getClass().getResource("/image/c-01.png"));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		paintComponent(g);
		g.setColor(Color.WHITE);
		for (int i = 0; i < 10; i++) {
			g.drawRoundRect((int) ((150 + i)*FBird_Main.scale), (int) ((250 + i)*FBird_Main.scale), (int) ((680 - 2 * i)*FBird_Main.scale),(int) (( 700 - 2 * i)*FBird_Main.scale),(int) (20*FBird_Main.scale), (int) (20*FBird_Main.scale));

		}
		

		g.drawImage(image,  (int) (200*FBird_Main.scale), (int) (60*FBird_Main.scale), (int) (600*FBird_Main.scale), (int) (100*FBird_Main.scale), null);
		g.drawImage(image1, (int) (250*FBird_Main.scale), (int) (350*FBird_Main.scale), (int) (500*FBird_Main.scale), (int) (80*FBird_Main.scale), null);
		g.drawImage(image2, (int) (250*FBird_Main.scale), (int) (550*FBird_Main.scale), (int) (500*FBird_Main.scale), (int) (80*FBird_Main.scale), null);
		g.drawImage(image3, (int) (250*FBird_Main.scale), (int) (750*FBird_Main.scale), (int) (500*FBird_Main.scale), (int) (80*FBird_Main.scale), null);
		
	}

}

