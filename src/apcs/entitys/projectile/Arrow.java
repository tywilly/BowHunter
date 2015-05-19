package apcs.entitys.projectile;

import apcs.entitys.Damageable;

import com.tywilly.WillyEngine.texture.Texture;

public class Arrow extends Projectile
{

    static Texture rightTexture = new Texture(
            "assets/weapons/bullets/new/arrow_right.png");

    public Arrow(float x, float y, float xdir, float ydir, int angle, Damageable shooter)
    {
        super(x, y, 64, 64, xdir, ydir, null, 10, shooter);
        // TODO Auto-generated constructor stub
        
        if (!rightTexture.isLoaded())
        {
            rightTexture.loadIntoMemery();
        }

//        if (this.dir == 2)
//        {
//            this.setTexure(rightTexture);
//        } else if (this.dir == 4)
//        {
//            this.setTexure(leftTexture);
//        }

        this.setTexure(rightTexture);
        this.setRotation(angle);
        
    }

}
