package apcs.entitys.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import apcs.entitys.Arrow;
import apcs.entitys.item.ActionItem;
import apcs.entitys.item.weapons.Bow;
import apcs.entitys.item.weapons.Weapon;
import apcs.entitys.player.skills.AttackSkill;
import apcs.entitys.player.skills.DefenseSkill;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Player extends Sprite implements Updateable, Input
{

    String playerName = "Player 1";

    Texture rightTexture;

    Texture leftTexture = new Texture("assets/characters/obama_sprite_left.png");

    boolean right = false;

    boolean left = false;

    boolean up = false;

    boolean down = false;

    Inventory inventory = new Inventory();

    /*
     * Skills
     */

    AttackSkill atackSkill = new AttackSkill();

    DefenseSkill defenseSkill = new DefenseSkill();

    public Player(int x, int y)
    {
        super(x, y, 64, 64, new Texture(
                "assets/characters/obama_sprite_right.png"));
        this.getTexture().loadIntoMemery();
        rightTexture = this.getTexture();
        leftTexture.loadIntoMemery();

        inventory.setHandItem(new Bow());

    }

    @Override
    public void paint(Graphics g)
    {
        // TODO Auto-generated method stub
        super.paint(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(playerName, xLoc - 2, yLoc - 10);

    }

    @Override
    public void update(long mili)
    {
        // TODO Auto-generated method stub

        if (up)
        {

            if (yLoc + height / 2 <= Engine.display.getHeight() / 2
                    && GameScene.world.getYLocation() <= 0)
            {
                GameScene.world.moveWorld(0, (int) (0.5 * mili));
            } else if (yLoc >= 0)
            {
                yLoc -= 0.5 * mili;
            }

        } else if (down)
        {

            if (yLoc + height / 2 >= Engine.display.getHeight() / 2
                    && -GameScene.world.getYLocation() <= GameScene.world
                            .getHeight() - Engine.display.getHeight())
            {
                GameScene.world.moveWorld(0, -(int) (0.5 * mili));
            } else if (yLoc + height <= Engine.display.getHeight())
            {
                yLoc += 0.5 * mili;
            }

        }

        if (right)
        {

            if (xLoc + width / 2 >= Engine.display.getWidth() / 2
                    && -GameScene.world.getXLocation() <= GameScene.world
                            .getWidth() - Engine.display.getWidth())
            {
                GameScene.world.moveWorld((int) -(0.5 * mili), 0);
            } else if (xLoc + width <= Engine.display.getWidth())
            {
                xLoc += 0.5 * mili;
            }
        } else if (left)
        {

            if (xLoc + width / 2 <= Engine.display.getWidth() / 2
                    && GameScene.world.getXLocation() <= 0)
            {
                GameScene.world.moveWorld((int) (0.5 * mili), 0);
            } else if (xLoc >= 0)
            {
                xLoc -= 0.5 * mili;
            }
        }

    }

    @Override
    public void onInput(InputAction e)
    {
        // TODO Auto-generated method stub

        if (e.getAction() == ActionType.KEYBOARD_DOWN)
        {
            if (e.getKeyCode() == 'd')
            {
                this.setTexure(rightTexture);
                right = true;
            } else if (e.getKeyCode() == 'a')
            {
                this.setTexure(leftTexture);
                left = true;
            } else if (e.getKeyCode() == 'w')
            {
                up = true;
            } else if (e.getKeyCode() == 's')
            {
                down = true;
            } else if (e.getKeyCode() == ' ')
            {
                // shootProjectile(1, 0);
            }
        } else if (e.getAction() == ActionType.KEYBOARD_UP)
        {

            if (e.getKeyCode() == 'd')
            {
                right = false;
            } else if (e.getKeyCode() == 'a')
            {
                left = false;
            } else if (e.getKeyCode() == 'w')
            {
                up = false;
            } else if (e.getKeyCode() == 's')
            {
                down = false;
            }

        } else if (e.getAction() == ActionType.MOUSE_DOWN)
        {
            if (e.getKeyCode() == '1')
            {

                // int xDir = (this.xLoc + (this.width/2)) - e.getMouseX();
                // int yDir = (this.yLoc + (this.height/2)) - e.getMouseY();

                float xDir = e.getMouseX() - this.xLoc;
                float yDir = e.getMouseY() - this.yLoc;

                System.out.println("Mouse:" + xDir + " " + yDir);

                double angle = Math.atan2(yDir, xDir);

                if(e.getMouseX() > this.getX()){
                    xDir = 1;
                }else if(e.getMouseX() < this.getX()){
                    xDir = -1;
                }
                
                yDir = ((float) (xDir * Math.atan(angle)));

                System.out.println("Arrow:" + xDir + " " + yDir + " Angle: "
                        + Math.toDegrees(angle));

                if (inventory.getHandItem() instanceof Weapon)
                {
                    ((Weapon) inventory.getHandItem()).onAction(this, xDir,
                            yDir);
                } else if (inventory.getHandItem() instanceof ActionItem)
                {
                    ((ActionItem) inventory.getHandItem()).onAction(this);
                }

            } else if (e.getKeyCode() == '2')
            {

            }
        }

    }

    public Inventory getInventory()
    {
        return inventory;
    }

}
