package apcs.entitys.player;

import net.client.protocol.packet.MovePacket;
import apcs.ClientDriver;
import apcs.entitys.Damageable;
import apcs.entitys.item.ActionItem;
import apcs.entitys.item.weapons.Weapon;
import apcs.entitys.mob.Zombie;
import apcs.entitys.projectile.Projectile;
import apcs.scenes.EndScene;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.update.Updateable;

public class Player extends APlayer implements Updateable, Input, Damageable {

	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub

		if (up) {

			if (yLoc + height / 2 <= Engine.display.getHeight() / 2
					&& GameScene.world.getYLocation() <= 0) {
				GameScene.world.moveWorld(0, (int) (0.5 * mili));
			} else if (yLoc >= 0) {
				yLoc -= 0.5 * mili;
			}

		} else if (down) {

			if (yLoc + height / 2 >= Engine.display.getHeight() / 2
					&& -GameScene.world.getYLocation() <= GameScene.world
							.getHeight() - Engine.display.getHeight()) {
				GameScene.world.moveWorld(0, -(int) (0.5 * mili));
			} else if (yLoc + height <= Engine.display.getHeight()) {
				yLoc += 0.5 * mili;
			}

		}

		if (right) {

			if (xLoc + width / 2 >= Engine.display.getWidth() / 2
					&& -GameScene.world.getXLocation() <= GameScene.world
							.getWidth() - Engine.display.getWidth()) {
				GameScene.world.moveWorld((int) -(0.5 * mili), 0);
			} else if (xLoc + width <= Engine.display.getWidth()) {
				xLoc += 0.5 * mili;
			}
		} else if (left) {

			if (xLoc + width / 2 <= Engine.display.getWidth() / 2
					&& GameScene.world.getXLocation() <= 0) {
				GameScene.world.moveWorld((int) (0.5 * mili), 0);
			} else if (xLoc >= 0) {
				xLoc -= 0.5 * mili;
			}
		}

	}

	@Override
	public void onInput(InputAction e) {
		// TODO Auto-generated method stub

		if (e.getAction() == ActionType.KEYBOARD_DOWN) {
			if (e.getKeyCode() == 'd') {
				this.setTexure(rightTexture);
				right = true;
				ClientDriver.client.getPacketManager()
						.addQueue(
								new MovePacket("", "" + this.getX() + " "
										+ this.getY()));
			} else if (e.getKeyCode() == 'a') {
				this.setTexure(leftTexture);
				left = true;
				ClientDriver.client.getPacketManager()
						.addQueue(
								new MovePacket("", "" + this.getX() + " "
										+ this.getY()));
			} else if (e.getKeyCode() == 'w') {
				up = true;
				ClientDriver.client.getPacketManager()
						.addQueue(
								new MovePacket("", "" + this.getX() + " "
										+ this.getY()));
			} else if (e.getKeyCode() == 's') {
				down = true;
				ClientDriver.client.getPacketManager()
						.addQueue(
								new MovePacket("", "" + this.getX() + " "
										+ this.getY()));
			} else if (e.getKeyCode() == ' ') {
				GameScene.roundManager.startRound();
			}
		} else if (e.getAction() == ActionType.KEYBOARD_UP) {

			if (e.getKeyCode() == 'd') {
				right = false;
			} else if (e.getKeyCode() == 'a') {
				left = false;
			} else if (e.getKeyCode() == 'w') {
				up = false;
			} else if (e.getKeyCode() == 's') {
				down = false;
			}

		} else if (e.getAction() == ActionType.MOUSE_DOWN) {
			if (e.getKeyCode() == '1') {

				if (inventory.getHandItem() instanceof Weapon) {

					float xDir = e.getMouseX() - (this.xLoc + this.width / 2);
					float yDir = e.getMouseY() - (this.yLoc + this.height / 2);

					double angle = Math.atan2(yDir, xDir);
					float mag = 1.0f;

					yDir = (float) (mag * Math.sin(angle));

					xDir = (float) Math.sqrt(Math.pow(mag, 2)
							- Math.pow(yDir, 2));

					if (e.getMouseX() < this.getX()) {
						xDir = -xDir;
					}

					((Weapon) inventory.getHandItem()).onAction(this, xDir,
							yDir, (int) Math.toDegrees(angle));
				} else if (inventory.getHandItem() instanceof ActionItem) {
					((ActionItem) inventory.getHandItem()).onAction(this);
				}

			} else if (e.getKeyCode() == '2') {

			}
		}

	}

	@Override
	public void onDamage(Damageable killer, Projectile projectile) {
		// TODO Auto-generated method stub

		if (killer instanceof Zombie) {
			this.health -= 10;

			healthText.setText("Health: " + health);

		}

		if (this.health <= 0) {
			SceneManager.loadScene(new EndScene());
		}

	}

}
