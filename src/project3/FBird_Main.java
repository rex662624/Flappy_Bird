package project3;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class FBird_Main extends JFrame implements ActionListener, MouseListener, KeyListener {
	public static double scale = 0.75;
	public static int State = 0;
	// menu:state = 0; start:1; gameover:2; choosecharacter:3
	// ; Scoreboard:4; chooseMode:5; battle:6; battleend:7; battlecharacter:8
	public static int score = 0;
	public static int birdx = 50, birdy = 50, birdwidth = 50, birdheight = 50;
	public static int stairsbirdx = 350, stairsbirdy = 100;
	public static int bird2x = 650, bird2y = 50;
	public static int character = 0;
	public static int character2 = 0;// 角色有 1 2 3 三種
	public static int Mode = 1;// Mode有 1 2 3 三種 1:normal 2:easy 3:difficult
	public static int judge_recordwindow = 0;

	public Rectangle judgebird = new Rectangle(birdx, birdy, birdwidth, birdheight);
	public Rectangle judgebird2 = new Rectangle(750 - birdx, 750 - birdy, birdwidth, birdheight);
	public Rectangle judgebird3 = new Rectangle(stairsbirdx, stairsbirdy, birdwidth, birdheight);

	public static JFrame frame = new JFrame();

	public int yMotion = 5;
	public int yMotion2 = 5;

	public static ArrayList<Rectangle> columns = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> columns2 = new ArrayList<Rectangle>();

	public static ArrayList<Rectangle> ball = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> ball2 = new ArrayList<Rectangle>();

	// ---------------------------------
	public static Random rand = new Random();
	
	public static ArrayList<Rectangle> enemys = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> stairs = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> stairs2 = new ArrayList<Rectangle>();

	// ---------------------------------------
	public static void main(String[] args) {

		FBird_Main FBird = new FBird_Main();

	}

	MainMenu mainmenu = new MainMenu();
	Startgame startgame = new Startgame();
	GameOver gameover = new GameOver();
	ChooseCharacter choosechar = new ChooseCharacter();
	ChooseMode choosemode = new ChooseMode();
	ScoreBoard scoreboard = new ScoreBoard();
	Battle battle = new Battle();
	BattleEnd battleend = new BattleEnd();
	BattleCharacter battlecharacter = new BattleCharacter();
	Stairsmode stairsmode=new Stairsmode();

	public FBird_Main() {

		frame.setTitle("Flappy Pokemon");
		frame.setSize((int) (1000 * scale), (int) (1000 * scale));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.addMouseListener(this);
		frame.addKeyListener(this);
		// -------------------------------------
		Timer timer = new Timer(35, this);
		timer.start();
		// -------------------------------------
		mainmenu.setLocation(0, 0);
		mainmenu.setSize((int) (1000 * scale), (int) (1000 * scale));
		mainmenu.setBackground(Color.cyan);

		startgame.setLocation(0, 0);
		startgame.setSize((int) (1000 * scale), (int) (1000 * scale));
		startgame.setBackground(Color.black);
		
		stairsmode.setLocation(0, 0);
		stairsmode.setSize((int) (1000 * scale), (int) (1000 * scale));
		stairsmode.setBackground(Color.white);

		gameover.setLocation(0, 0);
		gameover.setSize((int) (1000 * scale), (int) (1000 * scale));

		choosechar.setLocation(0, 0);
		choosechar.setSize((int) (1000 * scale), (int) (1000 * scale));
		choosechar.setBackground(Color.ORANGE);

		choosemode.setLocation(0, 0);
		choosemode.setSize((int) (1000 * scale), (int) (1000 * scale));
		choosemode.setBackground(Color.darkGray);

		scoreboard.setLocation(0, 0);
		scoreboard.setSize((int) (1000 * scale), (int) (1000 * scale));
		scoreboard.setBackground(Color.darkGray);

		battle.setLocation(0, 0);
		battle.setSize((int) (1000 * scale), (int) (1000 * scale));

		battleend.setLocation(0, 0);
		battleend.setSize((int) (1000 * scale), (int) (1000 * scale));

		battlecharacter.setLocation(0, 0);
		battlecharacter.setSize((int) (1000 * scale), (int) (1000 * scale));
		battlecharacter.setBackground(Color.ORANGE);

		// ------------------------------------
		for (int i = 1; i <= 5000; i++)
			startgame.addColumn();
		// ----------add
		for (int i = 1; i <= 5000; i++)
			startgame.addenemy();
		for (int i = 1; i <= 5000; i++)
			stairsmode.addStairs();
		for (int i = 1; i <= 5000; i++)
			stairsmode.addStairs2();
		// ----------
		System.out.println(columns.size());
		// --------------------------------------
		frame.add(mainmenu);
		frame.add(startgame);
		frame.add(gameover);
		frame.add(choosechar);
		frame.add(choosemode);
		frame.add(scoreboard);
		frame.add(battle);
		frame.add(battleend);
		frame.add(battlecharacter);
		frame.add(stairsmode);
		frame.setResizable(true);
		frame.setLayout(null);

		frame.setVisible(true);

		PlaySound();

	}

	
	public void actionPerformed(ActionEvent e) {

		if (State == 0) {// nemu
			mainmenu.repaint();
		} else if (State == 3)// 選角畫面
		{
			choosechar.repaint();
		} else if (State == 1) {// gametime

			judgebird.x = birdx;
			judgebird.y = birdy;
			int speed, enemyspeed;

			if (Mode == 2) {
				speed = 5;
				enemyspeed = 7;
			} else if (Mode == 3) {
				speed = 10;
				enemyspeed = 25;
			} else {
				speed = 7;
				enemyspeed = 15;

			}

			// ------------------------------------------------
			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);

				column.x -= speed;
			}
			// ---------------------------------------------------enemy
			for (int i = 0; i < enemys.size(); i++) {
				Rectangle enemy = enemys.get(i);

				enemy.x -= enemyspeed;
			}

			// System.out.println(score);
			// ---------------------------------------------------

			for (Rectangle column : columns) {
				if (column.y == 0 && column.x < birdx + 4 && column.x > birdx - 4)

				{
					score++;
				}

				if (column.intersects(judgebird) || judgebird.y >= 1050 * FBird_Main.scale || judgebird.y <= -50) {//

					State = 2;

					if (judgebird.y >= 1050 || judgebird.y <= -50)
						;

					else if (birdx <= column.x) {
						birdx = column.x - birdwidth;

					} else {
						if (column.y != 0) {
							birdy = column.y - birdheight;
						} else if (birdy < column.height) {
							birdy = column.height;
						}
					}
				}
			}
			// ---------------------------------------

			for (Rectangle enemy : enemys) {

				if (enemy.x < 10) {
					enemys.remove(enemys.indexOf(enemy));
					return;
				}
				if (enemy.intersects(judgebird)) {
					State = 2;
				}
			}

			for (Rectangle theball : ball) {
				for (Rectangle enemy : enemys) {
					if (enemy.intersects(theball)) {
						ball.remove(ball.indexOf(theball));
						enemys.remove(enemys.indexOf(enemy));
						return;
					}

				}
				// 球的射速

				if (character == 1) {
					theball.x += 40;
				} else if (character == 2) {
					theball.x += 15;
				} else if (character == 3) {
					theball.x += 8;
				}
			}
			if (yMotion <= 10) {
				yMotion += 1;
			}
			// ---------------------------------
			birdy += yMotion;

			startgame.repaint();

		} else if (State == 2) {// gameover

			while (judge_recordwindow == 0 && score > scoreboard.score[9]) {
				judge_recordwindow = 1;// 產生一個window就好
				WriteRecord writerecordWindow = new WriteRecord(scoreboard.name, scoreboard.score);

				writerecordWindow.setVisible(true);

			}
			startgame.repaint();
			// gameover.repaint();
		} else if (State == 5)// chooseMode
		{
			choosemode.repaint();
		} else if (State == 4)// Scoreboard
		{
			scoreboard.repaint();
		} else if (State == 6) {

			judgebird.x = birdx;
			judgebird.y = birdy;

			judgebird2.x = bird2x;
			judgebird2.y = bird2y;

			int speed = 3;

			for (Rectangle column : columns) {

				if (column.intersects(judgebird) || judgebird.y >= 1000 * FBird_Main.scale || judgebird.y <= -50) {//
					if (State == 6)
						battleend.setWinner(2);
					State = 7;
					if (judgebird.y >= 1000 || judgebird.y <= 0)
						;
					else if (birdx <= column.x) {
						birdx = column.x - birdwidth;
					} else {
						if (column.y != 0) {
							birdy = column.y - birdheight;
						} else if (birdy < column.height) {
							birdy = column.height;
						}
					}
				} else {

					column.x -= speed;

				}

			}

			for (Rectangle column : columns2) {

				if (column.intersects(judgebird2) || judgebird2.y >= 1000 * FBird_Main.scale || judgebird2.y <= -50) {//
					if (State == 6)
						battleend.setWinner(1);
					State = 7;

					if (judgebird2.y >= 1000 || judgebird2.y <= 0)
						;
					else if (bird2x + birdwidth >= column.x + column.width) {
						bird2x = column.x + column.width;
					} else {
						if (column.y != 0) {
							bird2y = column.y - birdheight;
						} else if (birdy < column.height) {
							bird2y = column.height;
						}
					}
				} else {

					column.x += speed;
				}
			}

			if (yMotion <= 10) {
				yMotion += 1;
			}
			if (yMotion2 <= 10) {
				yMotion2 += 1;
			}
			birdy += yMotion;
			bird2y += yMotion2;

			for (Rectangle theball : ball) {
				if (judgebird2.intersects(theball)) {
					if (State == 6)
						battleend.setWinner(1);
					State = 7;

				}
				for (Rectangle theball2 : ball2) {
					if (theball.intersects(theball2)) {
						ball.remove(ball.indexOf(theball));
						ball2.remove(ball2.indexOf(theball2));

					}
				}
				if (character == 1) {
					theball.x += 40;
				} else if (character == 2) {
					theball.x += 15;
				} else if (character == 3) {
					theball.x += 8;
				}
			}
			for (Rectangle theball : ball2) {
				if (judgebird.intersects(theball)) {
					if (State == 6)
						battleend.setWinner(2);
					State = 7;
				}
				if (character == 1) {
					theball.x -= 40;
				} else if (character == 2) {
					theball.x -= 15;
				} else if (character == 3) {
					theball.x -= 8;
				}

			}

			battle.repaint();

		} else if (State == 7) {
			battleend.repaint();
		} else if (State == 8) {
			battlecharacter.repaint();
		}
		else if(State==9){
			choosechar.repaint();
		}
		else if (State == 10){
			
			judgebird3.x = stairsbirdx;
			judgebird3.y = stairsbirdy;
			stairsbirdy+=yMotion;
		    int stairsspeed=6;

			for (int i = 0; i < stairs.size(); i++) {
				Rectangle stair = stairs.get(i);

				stair.y -= stairsspeed;
			}
			for (int i = 0; i < stairs2.size(); i++) {
				Rectangle stair2 = stairs2.get(i);

				stair2.y -= stairsspeed;
			}
			
			

			for (Rectangle stair : stairs) {
				

				if (stair.intersects(judgebird3)) {

					yMotion=-6;
				}
			

			    if (stair.y <=0 ){
			    	score++;
			    	stairs.remove(stairs.indexOf(stair));
			    	return;
			    }
			  
						
			}
			for (Rectangle stair2 : stairs2) {
				

				if (stair2.intersects(judgebird3)) {
					State = 2;
					
				}
			

			    if (stair2.y+60 < 0 ){
			    	stairs2.remove(stairs2.indexOf(stair2));
			    	return;
			    }
						
			}

			
			if (judgebird3.y<0 || judgebird3.y>740) {
				    State = 2;
					}
			
			
			stairsmode.repaint();

			
		}
	}

	
	public void mouseClicked(MouseEvent arg0) {

		if ((arg0.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
			// TODO Auto-generated method stub
			int x = arg0.getX();
			int y = arg0.getY();
			System.out.println("\nX:" + x + " Y:" + y + " State" + State);
			if (State == 0) {
				if (x > 420 && x < 650 && y > 375 && y < 420) {
					State = 3;
				} else if (x > 420 && x < 650 && y > 435 && y < 480) {
					character = 0;
					character2 = 0;
					State = 8;
				} else if (x > 420 && x < 650 && y > 495 && y < 540) {
					State=9;
				} else if (x > 420 && x < 650 && y > 555 && y < 600) {
					State = 5;
				}
				else if (x > 420 && x < 650 && y > 615 && y < 660) {
					State = 4;
				}
				else if (x > 420 && x < 650 && y > 675 && y < 720) {
					System.exit(0);
				}
			} 
			else if (State == 1) {// game
				if (yMotion <= -10)
					yMotion -= 5;
				else
					yMotion -= 23;
			} else if (State == 2) {// gameover
				if (x > 300 * FBird_Main.scale && x < 700 * FBird_Main.scale && y > 600 * FBird_Main.scale
						&& y < 700 * FBird_Main.scale) {

					State = 0;
					score = 0;
					birdx = 50;
					birdy = 50;
					birdwidth = 50;
					birdheight = 50;
					yMotion = 5;
					judge_recordwindow = 0;

					enemys.removeAll(enemys);
					columns.removeAll(columns);
					ball.removeAll(ball);

					for (int i = 1; i <= 5000; i++) {
						startgame.addColumn();
					}
					for (int i = 1; i <= 5000; i++) {
						startgame.addenemy();
					}

					mainmenu.repaint();

				}

			} else if (State == 3) {// choose character

				if (x > 100 * FBird_Main.scale && x < 300 * FBird_Main.scale && y > 400 * FBird_Main.scale
						&& y < 600 * FBird_Main.scale) {
					character = 1;
					startgame.update();
					State = 1;
				} else if (x > 400 * FBird_Main.scale && x < 600 * FBird_Main.scale && y > 400 * FBird_Main.scale
						&& y < 600 * FBird_Main.scale) {
					character = 2;
					startgame.update();
					State = 1;
				} else if (x > 700 * FBird_Main.scale && x < 900 * FBird_Main.scale && y > 400 * FBird_Main.scale
						&& y < 600 * FBird_Main.scale) {
					character = 3;
					startgame.update();
					State = 1;
				} else if (x > 400 * FBird_Main.scale && x < 600 * FBird_Main.scale && y > 700 * FBird_Main.scale
						&& y < 900 * FBird_Main.scale) {
					Random rand = new Random();
					character = 1 + rand.nextInt(3);
					startgame.update();
					State = 1;
				}

			} else if (State == 5) {// choose mode
				if (x > 250 * FBird_Main.scale && x < 750 * FBird_Main.scale && y > 350 * FBird_Main.scale
						&& y < 430 * FBird_Main.scale) {
					Mode = 2;
					State = 0;
				} else if (x > 250 * FBird_Main.scale && x < 750 * FBird_Main.scale && y > 550 * FBird_Main.scale
						&& y < 630 * FBird_Main.scale) {
					Mode = 1;
					State = 0;
				} else if (x > 250 * FBird_Main.scale && x < 750 * FBird_Main.scale && y > 750 * FBird_Main.scale
						&& y < 830 * FBird_Main.scale) {
					Mode = 3;
					State = 0;
				}

			} else if (State == 4) {

				if (x > 10 * FBird_Main.scale && x < 118 * FBird_Main.scale && y > 50 * FBird_Main.scale
						&& y < 85 * FBird_Main.scale) {
					State = 0;
				}

			}else if (State == 7) {
				if (x > 300 * FBird_Main.scale && x < 700 * FBird_Main.scale && y > 600 * FBird_Main.scale
						&& y < 700 * FBird_Main.scale) {

					State = 0;
					birdx = 50;
					birdy = 50;
					bird2x = 650;
					bird2y = 50;
					yMotion = 5;
					yMotion2 = 5;

					columns.removeAll(columns);
					columns2.removeAll(columns2);
					ball.removeAll(ball);
					ball2.removeAll(ball2);

					for (int i = 1; i <= 5000; i++) {
						startgame.addColumn();
					}

					mainmenu.repaint();

				}
			}else if (State == 8){
				
				if(x > (int) (350 * FBird_Main.scale) && x < (int) (650 * FBird_Main.scale) && y > (int) (450 * FBird_Main.scale)
						&& y <(int) (550 * FBird_Main.scale)){
					if(FBird_Main.character != 0 && FBird_Main.character2 != 0){ 
						State =6;
						battle.update();
					}
				}
				else if(x > (int) (100 * FBird_Main.scale) && x < (int) (300 * FBird_Main.scale) && y > (int) (100 * FBird_Main.scale)
						&& y <(int) (300 * FBird_Main.scale)){
					character = 1;
				}
				else if(x > (int) (400 * FBird_Main.scale) && x < (int) (600 * FBird_Main.scale) && y > (int) (100 * FBird_Main.scale)
						&& y <(int) (300 * FBird_Main.scale)){
					character = 2;
				}
				else if(x > (int) (700 * FBird_Main.scale) && x < (int) (900 * FBird_Main.scale) && y > (int) (100 * FBird_Main.scale)
						&& y <(int) (300 * FBird_Main.scale)){
					character = 3;
				}
				else if(x > (int) (100 * FBird_Main.scale) && x < (int) (300 * FBird_Main.scale) && y > (int) (650 * FBird_Main.scale)
						&& y <(int) (850 * FBird_Main.scale)){
					character2 = 1;
				}
				else if(x > (int) (400 * FBird_Main.scale) && x < (int) (600 * FBird_Main.scale) && y > (int) (650 * FBird_Main.scale)
						&& y <(int) (850 * FBird_Main.scale)){
					character2 = 2;
				}
				else if(x > (int) (700 * FBird_Main.scale) && x < (int) (900 * FBird_Main.scale) && y > (int) (650 * FBird_Main.scale)
						&& y <(int) (850 * FBird_Main.scale)){
					character2 = 3;
				}
					
				battlecharacter.repaint();
				
			}
			else if (State == 9)
			if (x > 100 * FBird_Main.scale && x < 300 * FBird_Main.scale && y > 400 * FBird_Main.scale
					&& y < 600 * FBird_Main.scale) {
				character = 1;
				stairsmode.stairschar();
				State = 10;
			} else if (x > 400 * FBird_Main.scale && x < 600 * FBird_Main.scale && y > 400 * FBird_Main.scale
					&& y < 600 * FBird_Main.scale) {
				character = 2;
				stairsmode.stairschar();
				State = 10;
			} else if (x > 700 * FBird_Main.scale && x < 900 * FBird_Main.scale && y > 400 * FBird_Main.scale
					&& y < 600 * FBird_Main.scale) {
				character = 3;
				stairsmode.stairschar();
				State = 10;
			} else if (x > 400 * FBird_Main.scale && x < 600 * FBird_Main.scale && y > 700 * FBird_Main.scale
					&& y < 900 * FBird_Main.scale) {
				Random rand = new Random();
				character = 1 + rand.nextInt(3);
				stairsmode.stairschar();
				State = 10;
			}
				
				

		}

	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void keyPressed(KeyEvent arg0) {
		 if (State == 10) {
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				stairsbirdx+=20;
				stairsbirdy-=10;
				yMotion=5;
				
			}
		    if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
		    	stairsbirdx-=20;
		    	stairsbirdy-=10;
		    	yMotion=5;
		    	
			}
		   
		    
		}

	}

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (State == 1) {
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {

			if (character == 1)
				ball.add(new Rectangle(birdx + 50, birdy + 20, 10, 10));
			else if (character == 2)
				ball.add(new Rectangle(birdx + 50, birdy + 20, 25, 25));
			else if (character == 3)
				ball.add(new Rectangle(birdx + 50, birdy + 20, 50, 50));

			ShootSound();

		}
		}

		else if (State == 6) {
			if (arg0.getKeyCode() == KeyEvent.VK_Q) {

				if (yMotion <= -10)
					yMotion -= 5;
				else
					yMotion -= 23;

			}
			if (arg0.getKeyCode() == KeyEvent.VK_O) {

				if (yMotion2 <= -10)
					yMotion2 -= 5;
				else
					yMotion2 -= 23;

			}

			if (arg0.getKeyCode() == KeyEvent.VK_W) {

				if (character == 1)
					ball.add(new Rectangle(birdx + 50, birdy + 20, 10, 10));
				else if (character == 2)
					ball.add(new Rectangle(birdx + 50, birdy + 20, 25, 25));
				else if (character == 3)
					ball.add(new Rectangle(birdx + 50, birdy + 20, 50, 50));

				ShootSound();

			}
			if (arg0.getKeyCode() == KeyEvent.VK_P) {

				if (character2 == 1)
					ball2.add(new Rectangle(bird2x, bird2y + 20, 10, 10));
				else if (character2 == 2)
					ball2.add(new Rectangle(bird2x, bird2y + 20, 25, 25));
				else if (character2 == 3)
					ball2.add(new Rectangle(bird2x, bird2y + 20, 50, 50));

				ShootSound();

			}

		}
		

	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void PlaySound() {
		try {
			File file = new File("BGM" + ".wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void ShootSound() {
		try {
			File file = new File("shoot" + ".wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
