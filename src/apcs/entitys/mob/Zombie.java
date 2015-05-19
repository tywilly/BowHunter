package apcs.entitys.mob;

import java.util.Random;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.TextureManager;

import apcs.entitys.Damageable;
import apcs.entitys.projectile.Projectile;
import apcs.entitys.world.World;
import apcs.scenes.GameScene;

public class Zombie extends Mob {

    public boolean isMoving = false;
    
	public Zombie() {
		super(0, 0, 64, 64, TextureManager
				.createTexture("assets/characters/obama_sprite_left.png"));

		if (!this.getTexture().isLoaded()) {
			this.getTexture().loadIntoMemery();
		}

		World world = GameScene.world;

		Random rand = new Random();
		
		int xOne = rand.nextInt(world.getXLocation() + 1);
		int xTwo = rand.nextInt(world.getWidth()
				- Engine.display.getWidth())
				+ Engine.display.getWidth();

		int yOne = rand.nextInt(world.getYLocation() + 1);
		int yTwo = rand.nextInt(world.getHeight()
				- Engine.display.getHeight())
				+ Engine.display.getHeight();

		if(xOne <= 128){
			this.setX(xTwo);
		}else if(xTwo >= world.getWidth() - 128){
		    this.setX(xOne);
		}else{
			if(rand.nextInt(2) == 1){
				this.setX(xOne);
			}else{
				this.setX(xTwo);
			}
		}
		
		if(yOne <= 128){
			this.setY(yTwo);
		}else if(yTwo >= world.getHeight() - 128){
		    this.setY(yOne);
		}else{
			if(rand.nextInt(2) == 1){
				this.setY(yOne);
			}else{
				this.setY(yTwo);
			}
		}
		
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
	    if(this.xLoc > GameScene.player.getX()){
	        this.xLoc -= (.1) * mili;
	    }else{
	        this.xLoc += (.1) * mili;
	    }
	    
	    if(this.yLoc > GameScene.player.getY()){
            this.yLoc -= (.1) * mili;
        }else{
            this.yLoc += (.1) * mili;
        }
		
	}

	@Override
	public void onDamage(Damageable killer, Projectile projectile) {
		// TODO Auto-generated method stub
		
		this.setHealth(this.getHealth() - projectile.getDamage());
		
		if (this.getHealth() <= 0){
			SceneManager.getCurrentScene().removeEntity(this);
		}
		
	}

}
