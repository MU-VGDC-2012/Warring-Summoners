import java.awt.Image;

import javax.swing.ImageIcon;


public class Monster_1 implements Summon {

	private int x = 0;
	private int y = 300;
	private int summonSize = 50;
	private int hp;
	private int maxHP = 100;
	private int speed = 2;
	private boolean goRight;
	private int attackDamage = 5;
	private int attackDelay = 10;
	private int team;
	public static int manaCost = 10;
	
	private Image img;
	
	public Monster_1(){
		hp = maxHP;
		goRight = true;
		team = 1;

		ImageIcon i = new ImageIcon("src/player.png");
		img = i.getImage();
	}
	
	public Monster_1(int team){
		hp = maxHP;
		goRight = true;
		this.team = team;
		
		ImageIcon i = new ImageIcon("src/player.png");
		img = i.getImage();
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getHP() {
		return hp;
	}

	@Override
	public int getMaxHP() {
		return maxHP;
	}

	@Override
	public int getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getAttackDelay() {
		return attackDelay;
	}

	@Override
	public int getTeam() {
		return team;
	}

	@Override
	public Image getImage() {
		// return the unit's image
		return img;
	}

	@Override
	public void update() {
		// update movement

		if(x <= 0){
			goRight = true;
		}
		else if(x >= Map.rightBound - summonSize){
			goRight = false;
		}
		
		y = Map.lowerBound;
		
		if(goRight){
			x += speed; 
		}
		else{
			x -= speed;
		}
	}

	@Override
	public void death() {
		// TODO Handle unit death
		
	}

	@Override
	public void setTeam(int newTeam) {
		// TODO Auto-generated method stub
		team = newTeam;
	}

	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public void setY(int newY) {
		y = newY;
	}

	@Override
	public int getManaCost() {
		return manaCost;
	}

}
