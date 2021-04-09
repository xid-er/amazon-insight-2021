package angarg12.rpgcombatkata;

public class Game {
	
	public static void main(String[] args) {
		Character player = new Character();
		do {
			// Actions
			
			// Armour storage
			
			if (player.getMana() < 20) {
				player.increaseMana(1);
			}
			
		} while (player.isAlive());
	}
}
