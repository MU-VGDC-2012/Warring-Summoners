import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Map extends JPanel implements KeyListener, ActionListener {

	private Summoner hero;
	private static ArrayList<Summon> summons = new ArrayList<Summon>();
	private Image background;
	public static int rightBound, topBound, lowerBound, leftBound;
	
	//Timer time;
	//Thread draw;
	
	private int frameDelay = 20; // delay between repainting the window in milliseconds
	
	public Map() {
		
		hero = new Summoner();
		summons.add(new Monster_1());
		
		setFocusable(true);
		
		// set map bounds
		rightBound = 800;
		leftBound = 0;
		topBound = 0;
		lowerBound = 300;
		
		this.addKeyListener(this);
		
		// import background image
		// this needs to be changed to a more general path
		ImageIcon i = new ImageIcon("src/Blue background.png");
		background = i.getImage();
		
		
		//time = new Timer(5, this);
		//time.start();
		
		new Timer(frameDelay, periodicRepaint).start();
	}
	
	ActionListener periodicRepaint = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    repaint();
		  }
	};
	
	@Override
	public void keyPressed(KeyEvent e) {
		hero.handleAction(e);
		// TODO Auto-generated method stub
		//System.out.println("pressed");
		//repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		hero.cancelAction(e);
		System.out.println("released");
		//repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("typed");
		///repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("action");
		repaint();
	}
	
	public static void addSummon(Summon newSummon){
		summons.add(newSummon);
	}
	
	public void update(){
		// update all units
		hero.update();
		
		for(int i = 0; i < summons.size(); i++){
			summons.get(i).update();
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graphics = (Graphics2D) g;
		
		//draw = new Thread(this);
		//draw.start();
		
		update();
		
		// draw background
		graphics.drawImage(background, 0, 0, null);
		
		// draw summons
		for(int i = 0; i < summons.size(); i++){
			graphics.drawImage(summons.get(i).getImage(), summons.get(i).getX(), summons.get(i).getY(), null);
		}
		
		// draw player
		graphics.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
	}

	/*
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}*/

	
}
