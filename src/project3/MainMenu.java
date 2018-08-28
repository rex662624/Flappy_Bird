package project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	public void paint(Graphics g) {

		
		paintComponent(g);
		
		Image back = null;
		try {
			back= ImageIO.read(this.getClass().getResource("/image/bg-01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(back, 0,0, (int) (1000*FBird_Main.scale), (int) (1000*FBird_Main.scale), null);
		
		g.setColor(Color.black);
		g.fillRect((int) (550 * FBird_Main.scale), (int) (450 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		g.fillRect((int) (550 * FBird_Main.scale), (int) (530 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		g.fillRect((int) (550 * FBird_Main.scale), (int) (610 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		g.fillRect((int) (550 * FBird_Main.scale), (int) (690 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		g.fillRect((int) (550 * FBird_Main.scale), (int) (770 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		g.fillRect((int) (550 * FBird_Main.scale), (int) (850 * FBird_Main.scale), (int) (300 * FBird_Main.scale),
				(int) (60 * FBird_Main.scale));
		
		
		
		g.setColor(Color.white);
		
		Font f = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (30*FBird_Main.scale));
		g.setFont(f);
		
		String NowMode="";
		if(FBird_Main.Mode==2)NowMode="EASY";
		else if(FBird_Main.Mode==1)NowMode="NORMAL";
		else if(FBird_Main.Mode==3)NowMode="DIFFICULT";
		
		g.drawString("Play", (int) (570*FBird_Main.scale),(int) (490*FBird_Main.scale));
		g.drawString("Battle", (int) (570*FBird_Main.scale),(int) (570*FBird_Main.scale));
		g.drawString("Stairs Mode", (int) (570*FBird_Main.scale),(int) (650*FBird_Main.scale));
		g.drawString("Mode"+"("+NowMode+")", (int) (570*FBird_Main.scale),(int) (730*FBird_Main.scale));
		g.drawString("Score Board", (int) (570*FBird_Main.scale),(int) (810*FBird_Main.scale));
		g.drawString("Close", (int) (570*FBird_Main.scale),(int) (890*FBird_Main.scale));
	}

}
