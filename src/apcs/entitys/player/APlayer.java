package apcs.entitys.player;

import apcs.entitys.WorldEntity;
import apcs.entitys.player.skills.AttackSkill;
import apcs.entitys.player.skills.DefenseSkill;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;

public abstract class APlayer extends WorldEntity
{
	
    public String playerName = "";

    Texture rightTexture;

    Texture leftTexture = TextureManager.createTexture("assets/characters/sarge_left.png");

    boolean right = false;

    boolean left = false;

    boolean up = false;

    boolean down = false;

    private int health = 100;
    
    public Text healthText = new Text(Engine.display.getWidth() - Engine.display.getWidth()/10, 25, 1, 20, "Health: " + health);

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

    }

    public Inventory getInventory()
    {
        return inventory;
    }
    
    public void setHealth(int health){
    	this.health = health;
    }
    
    public int getHealth(){
    	return health;
    }
}
