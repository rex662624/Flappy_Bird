package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BattleEnd extends JPanel {
	
	int winner;
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		Font f = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (72*FBird_Main.scale));
		g.setFont(f);
		g.drawString("Winner is", (int) (300*FBird_Main.scale), (int) (250*FBird_Main.scale));
		g.drawString("P" + winner, (int) (300*FBird_Main.scale), (int) (500*FBird_Main.scale));
		
		g.fillRoundRect((int) (300*FBird_Main.scale),(int) (600*FBird_Main.scale), (int) (400*FBird_Main.scale), (int) (100*FBird_Main.scale) ,5,(int) (5*FBird_Main.scale));
		g.setColor(Color.BLACK);
		Font f2 = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (50*FBird_Main.scale));
		g.setFont(f2);
		g.drawString("Return menu",(int) (350*FBird_Main.scale),(int) (675*FBird_Main.scale));
	}
	
	public void setWinner(int winner){
		this.winner = winner;
	}

}