package angarg12.rpgcombatkata;

import java.util.HashSet;
import java.util.Set;

public class Character {
    private int health = 1000;
    private int mana = 20;
    private int level = 1;
    private boolean alive = true;
    private Set<Faction> factions = new HashSet<Faction>();
    private Armour equippedArmour;

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public void decreaseMana(int amount) {
		// TODO hardcoded test for min = 0
		this.mana -= amount;
	}
	
	public void increaseMana(int amount) {
		// TODO hardcoded test for max = 20
		this.mana += amount;
	}

	public int getLevel() {
		return level;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public boolean inFaction(Faction faction) {
		return this.factions.contains(faction);
	}
	
	public Set<Faction> getFactions(){
		return this.factions;
	}
	
	public void damage(int amount) {
		if (this.equippedArmour != null) {
			
		}
		this.health -= amount;
		if (this.health <= 0) {
			this.alive = false;
			this.health = 0;
		}
	}
	
	public void damage(Character c, int amount) {
		if (!Character.isAlly(this, c)) {
			this.damage(amount);
		}
	}
	
	private void heal(int amount) {
		if (this.alive == true) {
			if(this.health + amount > 1000) {
				this.health = 1000;
			} else {
				this.health += amount;
			}
		}
	}
	
	public void heal(Character c, int amount) {
		// TODO extend to transfer mana player to player
		int healMana = 10;
		if (Character.isAlly(this, c) && c.getMana() >= healMana) {
			this.heal(amount);
			c.decreaseMana(healMana);
		}
	}
	
	public void joinFaction(Faction faction) {
		this.factions.add(faction);
	}
	
	public void leaveFaction(Faction faction) {
		this.factions.remove(faction);
	}
	
	public static boolean isAlly(Character c, Character p) {
		for (Faction faction : c.factions) {
			if (p.inFaction(faction)) {
				return true;
			}
		}
		return false;
	}
	
	public void equipArmour(Armour a) {
		if (this.level >= a.getLevelRequired()) {
			this.equippedArmour = a;
		}
	}
	
	public void unequipArmour() {
		this.equippedArmour = null;
	}
}
