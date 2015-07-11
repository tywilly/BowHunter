package apcs.entitys.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import net.client.protocol.packet.MovePacket;
import apcs.ClientDriver;
import apcs.entitys.Damageable;
import apcs.entitys.item.ActionItem;
import apcs.entitys.item.weapons.Bow;
import apcs.entitys.item.weapons.Weapon;
import apcs.entitys.mob.Zombie;
import apcs.entitys.player.skills.AttackSkill;
import apcs.entitys.player.skills.DefenseSkill;
import apcs.entitys.projectile.Projectile;
import apcs.scenes.EndScene;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;
import com.tywilly.WillyEngine.update.Updateable;

public abstract class APlayer extends Sprite
{

    public String playerName = "Player 1";

    Texture rightTexture;

    Texture leftTexture = TextureManager.createTexture("assets/characters/sarge_left.png");

    boolean right = false;

    boolean left = false;

    boolean up = false;

    boolean down = false;

    int health = 100;
    
    public Text healthText = new Text(Engine.display.getWidth() - Engine.display.getWidth()/10, 25, 20, "Health: " + health);

    Inventory inventory = new Inventory();

    /*
     * Skills
     */

    AttackSkill atackSkill = new AttackSkill();

    DefenseSkill defenseSkill = new DefenseSkill();

    public APlayer(int x, int y)
    {
        super(x, y, 64, 64, TextureManager.createTexture(
                "assets/characters/sarge_right.png"));
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
        g.drawString(playerName, (int)xLoc - 2, (int)yLoc - 10);
        
    }

    public Inventory getInventory()
    {
        return inventory;
    }

}
