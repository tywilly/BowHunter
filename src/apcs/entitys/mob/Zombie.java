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

	public int PHYS_TICK = 0;

	boolean isDamageable = true;
	int damagableTimeOut = 0;

	public Zombie() {
		super(0, 0, 64, 64, TextureManager
				.createTexture("assets/characters/obama_sprite_left.png"));

		if (!this.getTexture().isLoaded()) {
			this.getTexture().loadIntoMemery();
		}

		World world = GameScene.world;

		Random rand = new Random();

		int xOne = rand.nextInt(Math.abs(world.getXLocation() + 1));
		int xTwo = rand.nextInt(world.getWidth() - Engine.display.getWidth())
				+ Engine.display.getWidth();

		int yOne = rand.nextInt(Math.abs(world.getYLocation() + 1));
		int yTwo = rand.nextInt(world.getHeight() - Engine.display.getHeight())
				+ Engine.display.getHeight();

		if (xOne <= 128) {
			this.setX(xTwo);
		} else if (xTwo >= world.getWidth() - 128) {
			this.setX(xOne);
		} else {
			if (rand.nextInt(2) == 1) {
				this.setX(xOne);
			} else {
				this.setX(xTwo);
			}
		}

		if (yOne <= 128) {
			this.setY(yTwo);
		} else if (yTwo >= world.getHeight() - 128) {
			this.setY(yOne);
		} else {
			if (rand.nextInt(2) == 1) {
				this.setY(yOne);
			} else {
				this.setY(yTwo);
			}
		}

	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub

		if (this.xLoc > GameScene.player.getX() - 2) {
			this.xLoc -= (.2) * mili;
		} else if (this.xLoc < GameScene.player.getX() + 2) {
			this.xLoc += (.2) * mili;
		}

		if (this.yLoc > GameScene.player.getY() - 2) {
			this.yLoc -= (.2) * mili;
		} else if (this.yLoc < GameScene.player.getY() + 2) {
			this.yLoc += (.2) * mili;
		}

		if (PHYS_TICK >= 4) {
			PHYS_TICK = -1;

			if (this.getX() >= GameScene.player.getX()
					&& this.getX() + this.getWidth() <= GameScene.player.getX()
					|| this.getX() + this.getWidth() >= GameScene.player.getX()
					&& this.getX() + this.getWidth() <= GameScene.player.getX()
							+ GameScene.player.getWidth()) {

				if (this.getY() >= GameScene.player.getY()
						&& this.getY() + this.getWidth() <= GameScene.player
								.getY()
						|| this.getY() + this.getHeight() >= GameScene.player
								.getY()
						&& this.getY() + this.getHeight() <= GameScene.player
								.getY() + GameScene.player.getHeight()) {

					if (isDamageable) {

						GameScene.player.onDamage(this, null);

						isDamageable = false;
						
					}else{
						if(damagableTimeOut >= 20){
							damagableTimeOut = -1;
							isDamageable = true;
						}
						
						damagableTimeOut++;
						
					}

				}

			}

		}

		PHYS_TICK++;

	}

	@Override
	public void onDamage(Damageable killer, Projectile projectile) {
		// TODO Auto-generated method stub

		this.setHealth(this.getHealth() - projectile.getDamage());

		GameScene.scoreManager.setScore(GameScene.scoreManager.getScore() + 10);

		if (this.getHealth() <= 0) {
			SceneManager.getCurrentScene().removeEntity(this);
			GameScene.roundManager.registerKill();
		}

	}

}
