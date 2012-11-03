import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Summoner {

	private int x, y, dy, speed, jumpstrength, gravity, health, mana, maxHealth, maxMana, manaRegen;
	private Image img;
	boolean left, right, jump;
	
	public Summoner(){
		x = 0; // initial x position
		y = 300; // initial y position
		dy = 0; // change in y position
		maxHealth = 100;
		maxMana = 100;
		manaRegen = 1;
		health = maxHealth; // starting health = maximum health
		mana = 0; // start with 0 mana
		jumpstrength = 20;
		gravity = 1; // pull of gravity
		speed = 10; // set movement speed
		
		// this needs to be changed to a more general path
		ImageIcon i = new ImageIcon("src/player.png");
		img = i.getImage();
		
	}
	
	// handle ActionEvents for character
	public void handleAction(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true;
			if( x + speed < 800){
				x += speed;
			}
			//System.out.println("left");
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = true;
			if( x - speed > 0){
				x -= speed;
			}
			//System.out.println("right");
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			jump = true;
			if(y >= 295){
				dy += jumpstrength;
			}
		}
	}
	
	public void cancelAction(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			jump = false;
		}
	}
	
	// note that this will be called many times a second.  mana and manaRegen should probably be changed to doubles
	public void update(){
		
		if(right == true){
			if( x + speed < 800){
				x += speed;
			}
			//System.out.println("left");
		}
		else if(left == true){
			if( x - speed > 0){
				x -= speed;
			}
			//System.out.println("right");
		}
		else if(jump == true){
			if(y >= 295){
				dy = jumpstrength;
			}
		}
		
		if(y < 300){
			y -= dy;
		}
		else if (y == 300 && dy > 0){
			y -= dy;
		}
		else{
			if(y > 300){
				y = 300;
			}
			
			dy = 0;
		}
		
		dy -= gravity;
		
		
		//x += speed;
		
		if(mana < maxMana){
			mana += manaRegen;
		}
		//System.out.println("update Hero");
		
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImage(){
		return img;
	}
}
