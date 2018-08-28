package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {

	public Scanner filein = null;
	public String[] name = new String[10];
	public int[] score = new int[10];
	
	Image image = null;

	public ScoreBoard() {// constructor
		try {
			filein = new Scanner(new FileInputStream("Rank.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			name[i] = filein.nextLine();
			score[i] = filein.nextInt();
			filein.nextLine();// read"\n"(junk)

		}

	}

	public void paint(Graphics g) {
		try {
			filein = new Scanner(new FileInputStream("Rank.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			name[i] = filein.nextLine();
			score[i] = filein.nextInt();
			filein.nextLine();// read"\n"(junk)

		}
		
		try {
			image= ImageIO.read(this.getClass().getResource("/image/2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		paintComponent(g);

		g.setColor(Color.WHITE);
		Font f = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (30*FBird_Main.scale));
		g.setFont(f);

		int topx = 225, topy = 350, space = 60;

		for (int i = 0; i < 10; i++) {// �����
			g.drawRoundRect((int) ((topx - 50 + i)*FBird_Main.scale), (int) ((topy - 175 + i)*FBird_Main.scale),(int) (( 630 - 2 * i)*FBird_Main.scale), (int) ((770 - 2 * i)*FBird_Main.scale), (int) (20*FBird_Main.scale), (int) (20*FBird_Main.scale));

		}

		for (int i = 0; i < 9; i++) {// ��蝺�(璈�)
			for (int j = 0; j < 3; j++) {// ����
				g.drawLine((int) ((topx - 50)*FBird_Main.scale),(int) (( topy + 15 + j + i * space)*FBird_Main.scale),(int) (( topx - 50 + 630)*FBird_Main.scale),(int) (( topy + 15 + j + i * space)*FBird_Main.scale));
			}
			
			g.drawImage(image,  (int) (200*FBird_Main.scale), (int) (60*FBird_Main.scale), (int) (600*FBird_Main.scale), (int) (100*FBird_Main.scale), null);

		}

		for (int j = 0; j < 3; j++) {// j�靘�����

			g.drawLine((int) ((topx - 50)*FBird_Main.scale), (int) ((topy - space - 10 + j)*FBird_Main.scale), (int) ((topx - 50 + 630)*FBird_Main.scale), (int) ((topy - space - 10 + j)*FBird_Main.scale));

		}
		for (int j = 0; j < 3; j++) {// j�靘�����

			g.drawLine((int) ((topx + 125 + j)*FBird_Main.scale),(int) (( topy - 175)*FBird_Main.scale),(int) (( topx + 125 + j)*FBird_Main.scale),(int) (( topy - 175 + 770)*FBird_Main.scale));
			g.drawLine((int) ((topx + space * 7 + j)*FBird_Main.scale),(int) (( topy - 175)*FBird_Main.scale),(int) (( topx + space * 7 + j)*FBird_Main.scale),(int) (( topy - 175 + 770)*FBird_Main.scale));

		}

		g.drawString("Rank", (int) (topx*FBird_Main.scale), (int) ((topy - 100)*FBird_Main.scale));
		g.drawString("Name", (int) ((topx + space * 3)*FBird_Main.scale), (int) ((topy - 100)*FBird_Main.scale));
		g.drawString("Score", (int) ((topx + space * 7 + 30)*FBird_Main.scale), (int) ((topy - 100)*FBird_Main.scale));

		for (int i = 0; i < 10; i++) {
			g.drawString("No." + (i+1), (int) (topx*FBird_Main.scale), (int) ((topy + space * i)*FBird_Main.scale));
			g.drawString(name[i], (int) ((topx + space * 3)*FBird_Main.scale), (int) ((topy + space * i)*FBird_Main.scale));
			g.drawString(Integer.toString(score[i]), (int) ((topx + space * 8)*FBird_Main.scale), (int) ((topy + space * i)*FBird_Main.scale));

		}

		// -------------------return button
		g.fillRoundRect((int) (48*FBird_Main.scale), (int) (30*FBird_Main.scale), (int) (70*FBird_Main.scale), (int) (30*FBird_Main.scale), (int) (10*FBird_Main.scale), (int) (10*FBird_Main.scale));
		g.fillArc((int) (10*FBird_Main.scale), (int) (20*FBird_Main.scale), (int) (100*FBird_Main.scale), (int) (50*FBird_Main.scale), 90, 180);
		g.setColor(Color.BLACK);
		Font f2 = new Font("Arial Bold", Font.BOLD | Font.ITALIC, (int) (20*FBird_Main.scale));
		g.setFont(f2);
		g.drawString("Return", (int) (50*FBird_Main.scale), (int) (50*FBird_Main.scale));

	}

}