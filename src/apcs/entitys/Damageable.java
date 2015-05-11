package apcs.entitys;

import apcs.entitys.projectile.Projectile;

public interface Damageable {

	public void onDamage(Damageable killer, Projectile projectile);
	
}
