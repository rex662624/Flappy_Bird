package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BattleCharacter extends JPanel {
	private Image image1 = null;
	private Image image2 = null;
	private Image image3 = null;
	private Image image12 = null;
	private Image image22 = null;
	private Image image32 = null;
	private Image cha1 = null;
	private Image cha2 = null;

	public void paint(Graphics g) {

		try {
			image1 = ImageIO.read(this.getClass().getResource("/image/1-01.png"));
			image2 = ImageIO.read(this.getClass().getResource("/image/2-01.png"));
			image3 = ImageIO.read(this.getClass().getResource("/image/3-01.png"));
			image12 = ImageIO.read(this.getClass().getResource("/image/12.png"));
			image22 = ImageIO.read(this.getClass().getResource("/image/22.png"));
			image32 = ImageIO.read(this.getClass().getResource("/image/32.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		paintComponent(g);
		
		g.setColor(Color.BLACK);
		Font f2 = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (50 * FBird_Main.scale));
		g.setFont(f2);
		g.drawString("P1", (int) (100 * FBird_Main.scale), (int) (350 * FBird_Main.scale));
		g.drawString("P2", (int) (850 * FBird_Main.scale), (int) (650 * FBird_Main.scale));

		g.drawImage(image1, (int) (100 * FBird_Main.scale), (int) (100 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
		g.drawImage(image2, (int) (400 * FBird_Main.scale), (int) (100 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
		g.drawImage(image3, (int) (700 * FBird_Main.scale), (int) (100 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);

		g.drawImage(image1, (int) (100 * FBird_Main.scale), (int) (650 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
		g.drawImage(image2, (int) (400 * FBird_Main.scale), (int) (650 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
		g.drawImage(image3, (int) (700 * FBird_Main.scale), (int) (650 * FBird_Main.scale),
				(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);

		if (FBird_Main.character != 0) {
			if (FBird_Main.character == 1) {
				g.drawImage(image12, (int) (100 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);

			} else if (FBird_Main.character == 2) {
				g.drawImage(image22, (int) (100 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);

			} else if (FBird_Main.character == 3) {
				g.drawImage(image32, (int) (100 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);

			}

		}
		if (FBird_Main.character2 != 0) {
			if (FBird_Main.character2 == 1) {
				g.drawImage(image12, (int) (700 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
			} else if (FBird_Main.character2 == 2) {
				g.drawImage(image22, (int) (700 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
			} else if (FBird_Main.character2 == 3) {
				g.drawImage(image32, (int) (700 * FBird_Main.scale), (int) (400 * FBird_Main.scale),
						(int) (200 * FBird_Main.scale), (int) (200 * FBird_Main.scale), null);
			}

		}
		if (FBird_Main.character != 0 && FBird_Main.character2 != 0) {
			g.setColor(Color.WHITE);
			g.fillRoundRect((int) (350 * FBird_Main.scale), (int) (450 * FBird_Main.scale),
					(int) (300 * FBird_Main.scale), (int) (100 * FBird_Main.scale), 5, (int) (5 * FBird_Main.scale));
			g.setColor(Color.BLACK);
			g.drawString("START", (int) (420 * FBird_Main.scale), (int) (520 * FBird_Main.scale));
		}
	}
}
