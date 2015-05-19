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

	Thread spawnThread;
	
	public final int NUM_PER_WAVE = 10;
	
    private int roundNumber = 1;
    
    private boolean isRunning = false;
    
    private int numOnField = 0;
    
    private int numLeft = 0;
    
    public void registerKill(){
    	
    	if(numLeft > 1){
    		numLeft--;
    		numOnField--;
    		
    		System.out.println("Kill!" + numLeft);
    		
    	}else{
    	
    		stopRound();
    		
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
    	}
    	
    }
    
    public void stopRound(){
    	if(isRunning){
    		isRunning = false;
    		
    		spawnThread = null;
    		
    		System.out.println("End Round!");
    		
    		roundNumber++;
    		
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
