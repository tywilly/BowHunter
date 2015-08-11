package apcs.entitys.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import net.client.protocol.packet.ActionPacket;
import net.client.protocol.packet.DisconnectPacket;
import net.client.protocol.packet.MovePacket;
import apcs.ClientDriver;
import apcs.LoginForm;
import apcs.entitys.world.World;
import apcs.scenes.GameScene;
import apcs.scenes.MenuScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.update.Updateable;

public class Player extends APlayer implements Updateable, Input {

	public Player(int x, int y) {
		super(x, y);
		this.playerName = LoginForm.username;
		this.setWorldX(x);
		this.setWorldY(y);
		this.setLayer(1);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(this.getTexture().getImage(), (int) xLoc, (int) yLoc,
				((int) xLoc) + this.width, ((int) yLoc) + this.height, 0, 0,
				this.getTexture().getImage().getWidth(), this.getTexture()
						.getImage().getHeight(), null);

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

			ClientDriver.client.sendPacket(new MovePacket(this.getUUID(), this
					.getWorldX() + " " + this.getWorldY()));

		} else if (down) {

			if (yLoc + height / 2 >= Engine.display.getHeight() / 2
					&& -GameScene.world.getYLocation() <= GameScene.world
							.getHeight() - Engine.display.getHeight()) {
				GameScene.world.moveWorld(0, -(int) (0.5 * mili));
			} else if (yLoc + height <= Engine.display.getHeight()) {
				yLoc += 0.5 * mili;
			}

			ClientDriver.client.sendPacket(new MovePacket(this.getUUID(), this
					.getWorldX() + " " + this.getWorldY()));

		}

		if (right) {

			if (xLoc + width / 2 >= Engine.display.getWidth() / 2
					&& -GameScene.world.getXLocation() <= GameScene.world
							.getWidth() - Engine.display.getWidth()) {
				GameScene.world.moveWorld((int) -(0.5 * mili), 0);
			} else if (xLoc + width <= Engine.display.getWidth()) {
				xLoc += 0.5 * mili;
			}

			ClientDriver.client.sendPacket(new MovePacket(this.getUUID(), this
					.getWorldX() + " " + this.getWorldY()));

		} else if (left) {

			if (xLoc + width / 2 <= Engine.display.getWidth() / 2
					&& GameScene.world.getXLocation() <= 0) {
				GameScene.world.moveWorld((int) (0.5 * mili), 0);
			} else if (xLoc >= 0) {
				xLoc -= 0.5 * mili;
			}

			ClientDriver.client.sendPacket(new MovePacket(this.getUUID(), this
					.getWorldX() + " " + this.getWorldY()));

		}

		healthText.setText("Health: " + this.getHealth());
		
	}

	@Override
	public void onInput(InputAction e) {
		// TODO Auto-generated method stub

		if (e.getAction() == ActionType.KEYBOARD_DOWN) {
			if (e.getKeyCode() == 'd') {
				this.setTexure(rightTexture);
				right = true;
			} else if (e.getKeyCode() == 'a') {
				this.setTexure(leftTexture);
				left = true;
			} else if (e.getKeyCode() == 'w') {
				up = true;
			} else if (e.getKeyCode() == 's') {
				down = true;
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
			}else if(e.getKeyNum() == KeyEvent.VK_ESCAPE){
				SceneManager.loadScene(new MenuScene(SceneManager.getCurrentScene()));
			}

		} else if (e.getAction() == ActionType.MOUSE_DOWN) {
			if (e.getKeyCode() == '1') {
				
				float xDir = e.getMouseX() - (this.xLoc + this.width / 2);
				float yDir = e.getMouseY() - (this.yLoc + this.height / 2);

                double angle = Math.atan2(yDir, xDir);
                float mag = 1.0f;

                yDir = (float) (mag * Math.sin(angle));
				

                xDir = (float) Math.sqrt(Math.pow(mag, 2)
                        - Math.pow(yDir, 2));

                if (e.getMouseX() < this.getX())
                {
                    xDir = -xDir;
                }
				
				ClientDriver.client.sendPacket(new ActionPacket(this.getUUID(), 1 + "", Math.toDegrees(angle) + " " + xDir + " " + yDir));
				
			} else {
				ClientDriver.client.sendPacket(new ActionPacket(getUUID(), e.getKeyCode() + "", 0 + ""));
			}
		}

	}

	@Override
	public void setWorldX(float x) {
		// TODO Auto-generated method stub
		this.xLoc = Engine.display.getWidth()/2;
		World.xLoc = -x;
	}

	@Override
	public void setWorldY(float y) {
		// TODO Auto-generated method stub
		this.yLoc = Engine.display.getHeight()/2;
		World.yLoc = -y;
	}

}
