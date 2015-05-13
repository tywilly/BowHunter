package apcs.entitys.player.skills;

public abstract class Skill {

	int skillLevel = 0;
	int exp = 0;
	
	public int getExp(){
		return exp;
	}
	
	public int getLevel(){
		return skillLevel;
	}
	
}
