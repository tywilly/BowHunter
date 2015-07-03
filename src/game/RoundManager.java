/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package game;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.scene.SceneManager;

import apcs.entitys.mob.Zombie;
import apcs.entitys.text.RoundText;


public class RoundManager
{

	Thread spawnThread;
	public RoundText text = new RoundText();
	public Text zombiesLeftText = new Text((Engine.display.getWidth()/2) - 50, 25, 20, "Zombies Left: 0");
	
	public final int NUM_PER_WAVE = 10;
	
    private int roundNumber = 1;
    
    private boolean isRunning = false;
    
    private int numOnField = 0;
    
    private int numLeft = 0;
    
    public void registerKill(){
    	
    	if(numLeft > 1){
    		numLeft--;
    		numOnField--;
    		
    		zombiesLeftText.setText("Zombies Left: " + numLeft);
    		
    	}else{
    	
    		stopRound();
    		
    		zombiesLeftText.setText("Zombies Left: 0");
    		
    	}
    }
    
    public void startRound(){
    	
    	if(!isRunning){
    		System.out.println("New Round! " + roundNumber);
        	
        	isRunning =true;
        	
        	if(spawnThread == null){
        		spawnThread = new SpawnThread();
        	}
        	
        	numLeft = (int)1.5 * roundNumber + 5;
        	
        	System.out.println(numLeft);
        	
        	spawnThread.start();
        	
        	text.setText("Round: " + roundNumber + " - play");
        	zombiesLeftText.setText("Zombies Left: " + numLeft);
        	
    	}
    	
    }
    
    public void stopRound(){
    	if(isRunning){
    		isRunning = false;
    		
    		spawnThread = null;
    		
    		System.out.println("End Round!");
    		
    		roundNumber++;
    		
    		text.setText("Round: " + roundNumber + " - Inter");
    		
    	}
    }
    
    public void spawnZombies(int num){
    	
    	System.out.println("Spawning " + num + " zombies");
    	
        for(int i=0;i<num;i++){
            SceneManager.getCurrentScene().addEntity(new Zombie());
        }
    }
    
    public class SpawnThread extends Thread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(isRunning){
				
				if(numOnField < 5 && numLeft > NUM_PER_WAVE){
					spawnZombies(NUM_PER_WAVE);
					numOnField = NUM_PER_WAVE;
				}else if(numOnField < 5 && numLeft != numOnField){
					spawnZombies(numLeft);
					numOnField = numLeft;
				}
				
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

    }
    
}
