/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package apcs.entitys.text;

import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.update.Updateable;


public class ScoreText extends Text implements Updateable
{
    
    public ScoreText()
    {
        super(50,Engine.display.getHeight() - (Engine.display.getHeight()/5),20,"");
        
    }

    @Override
    public void update(long mili)
    {
        this.setText("Score: " + GameScene.scoreManager.getScore());
    }

    
    
}
