package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteRecord extends JFrame implements ActionListener {

	JTextField input = new JTextField(50);

	private String[] newname = new String[10];
	private int[] newscore = new int[10];

	public WriteRecord(String[] boardname, int[] boardscore) {
		
		for (int i = 0; i < 10; i++) {
			newname[i] = boardname[i];
			newscore[i] = boardscore[i];
		}
		

		setSize(800, 600);

		JLabel Label = new JLabel("congratulations! You break the record");
		JLabel Label2 = new JLabel("Your Score: " + FBird_Main.score);

		Label.setFont(new Font("Arial Bold", Font.BOLD | Font.ITALIC, 32));
		Label.setLocation(100, 0);
		Label.setSize(600, 100);
		Label2.setFont(new Font("Arial Bold", Font.BOLD | Font.ITALIC, 32));
		Label2.setLocation(250, 50);
		Label2.setSize(600, 100);

		JButton button = new JButton("Submit");
		button.addActionListener(this);
		button.setLocation(250, 300);
		button.setSize(250, 50);

		setLayout(null);

		input.setLocation(100, 200);
		input.setSize(input.getPreferredSize());
		input.setText("<Input your name here>");
		this.add(input);
		this.add(button);
		this.add(Label);
		this.add(Label2);
	}

	public void actionPerformed(ActionEvent e) {
		String recordname = input.getText();

		int recordscore = FBird_Main.score;
		SortAndStore(recordname, recordscore);

		this.setVisible(false);
	}

	public void SortAndStore(String r_name, int r_score) {

		// ---------------------------------------------sort
		int index = 0;// index:�蝝����閰脫���
		
		for (index = 0; index < 10; index++) {
			if (r_score > newscore[index]) {// ��蝝���府����
				System.out.println(index);
				for (int i = 8; i >= index; i--)// index敺����銝hift銝�雿�洵10��◤����隞亙�洵9���(index=8)���hift
				{
					newname[i + 1] = newname[i];
					newscore[i + 1] = newscore[i];
				}
				break;
			}
		}
		newname[index] = r_name;
		newscore[index] = r_score;
		
			
			
			
		
		// ------------------------------------------store
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream("Rank.txt"));
			for (int i = 0; i < 10; i++) {
				writer.println(newname[i]);
				writer.println(newscore[i]);
			}
			writer.flush();
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
