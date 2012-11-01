import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Map extends JPanel implements KeyListener, ActionListener {

	private Summoner hero;
	private Image background;
	public int rightBound, topBound, lowerBound, leftBound;
	
	//Timer time;
	//Thread draw;
	
	private int frameDelay = 20; // delay between repainting the window in milliseconds
	
	public Map() {
		
		hero = new Summoner();
		setFocusable(true);
		
		// set map bounds
		rightBound = 800;
		leftBound = 0;
		topBound = 350;
		lowerBound = 0;
		
		this.addKeyListener(this);
		
		// import background image
		// this needs to be changed to a more general path
		ImageIcon i = new ImageIcon("C:\\Users\\Stratos\\VGDC\\Warring Summoners\\img\\Blue background.png");
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
		System.out.println("pressed");
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
		repaint();
		// do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		repaint();
		// do nothing
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("action");
		repaint();
	}
	
	public void update(){
		// update all units
		hero.update();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graphics = (Graphics2D) g;
		
		//draw = new Thread(this);
		//draw.start();
		
		update();
		
		// draw background
		graphics.drawImage(background, 0, 0, null);
		graphics.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
		
	}

	/*
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}*/

	
}
