package apcs.entitys.text;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.update.Updateable;

public class RoundText extends Text implements Updateable{

	public RoundText() {
		super(Engine.display.getWidth() - (Engine.display.getWidth()/8), Engine.display.getHeight() - (Engine.display.getHeight()/10), 20, "Round: 1 - Inter");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		this.setX(Engine.display.getWidth() - (Engine.display.getWidth()/8));
		this.setY(Engine.display.getHeight() - (Engine.display.getHeight()/10));
		
	}
}
