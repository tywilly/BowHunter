package apcs.entitys.projectile;

import apcs.entitys.Damageable;
import apcs.entitys.player.APlayer;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Projectile extends Sprite implements Updateable
{

    float xDir = 0;

    float yDir = 0;

    int physTick = 0;

    int damage = 0;

    Damageable shooter;

    public Projectile(float x, float y, int height, int width, float xDir,
            float yDir, Texture texture, int damage, Damageable shooter)
    {
        super(x, y, height, width, texture);
        // TODO Auto-generated constructor stub
        this.xDir = xDir;
        this.yDir = yDir;
        this.damage = damage;
        this.shooter = shooter;
    }

    @Override
    public void update(long mili)
    {
        // TODO Auto-generated method stub

        if (xLoc >= Engine.display.getWidth() || xLoc <= 0)
        {
            SceneManager.getCurrentScene().removeEntity(this);
        }

        xLoc += xDir * mili;
        yLoc += yDir * mili;

        if (physTick >= 4)
        {

            physTick = -1;

            for (int i = 0; i < SceneManager.getCurrentScene().ents.size(); i++)
            {

                Entity ent = SceneManager.getCurrentScene().ents.get(i);

                if (ent instanceof Damageable || ent instanceof APlayer)
                {
                    if ((Damageable) ent != shooter)
                    {
                        if (this.getX() + this.width/2 >= ent.getX() && this.getX() + this.width/2 <= ent.getX() + ent.getWidth())
                        {
                            if (this.getY() + this.height/2 >= ent.getY() && this.getY() + height/2 <= ent.getY() + ent.getHeight())
                            {
                                SceneManager.getCurrentScene().removeEntity(
                                        this);
                                ((Damageable) ent).onDamage(shooter, this);
                            }
                        }
                    }
                }

            }

        }

        physTick++;

    }

    public int getDamage()
    {
        return damage;
    }

}
