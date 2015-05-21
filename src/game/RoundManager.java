/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package game;

import com.tywilly.WillyEngine.scene.SceneManager;

import apcs.entitys.mob.Zombie;


public class RoundManager
{

    public int roundNumber = 1;
    
    public void spawnZombies(int num){
        for(int i=0;i<num;i++){
            SceneManager.getCurrentScene().addEntity(new Zombie(100, 0));
        }
    }
    
}
