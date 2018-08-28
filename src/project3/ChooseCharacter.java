package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChooseCharacter extends JPanel {
	private Image image = null;
	private Image image1 = null;
	private Image image2 = null;
	private Image image3 = null;
	private Image image4 = null;
	public void paint(Graphics g) {
		
		
		try {
			 image = ImageIO.read(this.getClass().getResource("/image/cha.png"));
			 image1 = ImageIO.read(this.getClass().getResource("/image/1-01.png"));
			 image2 = ImageIO.read(this.getClass().getResource("/image/2-01.png"));
			 image3 = ImageIO.read(this.getClass().getResource("/image/3-01.png"));
			 image4 = ImageIO.read(this.getClass().getResource("/image/4-01.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		paintComponent(g);
		
		g.setColor(Color.WHITE);
		for (int i = 0; i < 10; i++) {
			g.drawRoundRect((int) ((50 + i)*FBird_Main.scale), (int) ((350 + i)*FBird_Main.scale), (int) ((900 - 2 * i)*FBird_Main.scale), (int) ((600 - 2 * i)*FBird_Main.scale), 20, 20);
		}

		g.drawImage(image, (int) (50*FBird_Main.scale),(int) (50*FBird_Main.scale) ,(int) (900*FBird_Main.scale),(int) (250*FBird_Main.scale),null);
		g.drawImage(image1,(int) (100*FBird_Main.scale),(int) (400*FBird_Main.scale),(int) (200*FBird_Main.scale),(int) (200*FBird_Main.scale),null);
		g.drawImage(image2,(int) (400*FBird_Main.scale),(int) (400*FBird_Main.scale),(int) (200*FBird_Main.scale),(int) (200*FBird_Main.scale),null);
		g.drawImage(image3,(int) (700*FBird_Main.scale),(int) (400*FBird_Main.scale),(int) (200*FBird_Main.scale),(int) (200*FBird_Main.scale),null);
		g.drawImage(image4,(int) (400*FBird_Main.scale),(int) (700*FBird_Main.scale),(int) (200*FBird_Main.scale),(int) (200*FBird_Main.scale),null);		

	}

}
