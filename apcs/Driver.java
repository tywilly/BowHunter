/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package apcs;

import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.scene.SceneManager;


public class Driver
{
    
    public static void main(String[] args){
        
        Display.setTitle("BowHunter");
        Display.createDisplay(750, 500);
        
        
        
        SceneManager.loadScene(new GameScene());
        
    }
    
}
