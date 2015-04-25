package apcs.entitys;

import java.awt.Color;
import java.awt.Graphics;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.update.Updateable;

public class Arrow extends Entity implements Updateable{

	
	
	public Arrow(int x, int y) {
		super(x, y, 128, 128);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g){
		
		g.setColor(Color.CYAN);
		
		g.fillRect(xLoc, yLoc, 128, 128);
		
	}
	
	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		if(xLoc >= Engine.display.getWidth()){
			xLoc = 0;
		}
		
		xLoc += (int) (1 * mili);
		
	}
	
}
