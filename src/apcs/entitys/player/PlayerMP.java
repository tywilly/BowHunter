package apcs.entitys.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import apcs.entitys.world.World;

public class PlayerMP extends APlayer{
	
	public PlayerMP(int x, int y, String username) {
		super(x,y);
		this.playerName = username;
		this.setWorldX(200);
		this.setWorldY(200);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(playerName, (int)(this.getX() + World.xLoc) - 2, (int)(this.getY() + World.yLoc) - 10);
		
	}
}
