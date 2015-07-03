/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package apcs;

import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.scene.SceneManager;


public class Driver
{
    
	Engine engine;
	
    public static void main(String[] args){
        
    	Driver driver = new Driver();
    	
    }
    
    public Driver(){
    	
    	engine = new Engine(Display.createDisplay(1280, 720));
    	Engine.display.setTitle("Bow Hunter");
    	engine.start();
    	
    	
    	GameScene gs = new GameScene();
    	
    	SceneManager.loadScene(gs);

    	
    	
    }
    
}
