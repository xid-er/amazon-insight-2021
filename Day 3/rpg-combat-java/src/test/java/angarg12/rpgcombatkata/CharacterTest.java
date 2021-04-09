package angarg12.rpgcombatkata;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {

    @Test
    public void createdHealth1000() {
        Character c = new Character();
        assertEquals(c.getHealth(), 1000);
    }

    @Test
    public void createdLevel1() {
        Character c = new Character();
        assertEquals(c.getLevel(), 1);
    }

    @Test
    public void createdIsAlive() {
        Character c = new Character();
        assertTrue(c.isAlive());
    }
    
    @Test
    public void damagedByAmount() {
        Character c = new Character();
        c.damage(500);
        assertEquals(c.getHealth(), 500);
    } 
    
    @Test
    public void damageDeaded() {
        Character c = new Character();
        c.damage(1500);
        assertFalse(c.isAlive());
    }
    
    @Test
    public void damageNotNegative() {
        Character c = new Character();
        c.damage(1500);
        assertEquals(c.getHealth(), 0);
    }
    
    @Test
    public void healedByAmount() {
        Character c = new Character();
        c.damage(500);
        c.heal(c, 250);
        assertEquals(c.getHealth(), 750);
    }
    
    @Test
    public void deadNotHealed() {
        Character c = new Character();
        c.damage(1000);
        c.heal(c, 250);
        assertEquals(c.getHealth(), 0);
    }
    
    @Test
    public void healNotAbove1000() {
        Character c = new Character();
        c.damage(500);
        c.heal(c, 750);
        assertEquals(c.getHealth(), 1000);
    }
    
    @Test
    public void createdNoFaction() {
        Character c = new Character();
        assertTrue(c.getFactions().isEmpty());
    }
    
    @Test
    public void joinedFaction() {
        Character c = new Character();
        c.joinFaction(Faction.GREENS);
        assertTrue(c.inFaction(Faction.GREENS));
    }
    
    @Test
    public void isAlly() {
        Character c = new Character();
        c.joinFaction(Faction.GREENS);
        Character p = new Character();
        p.joinFaction(Faction.YELLOWS);
        p.joinFaction(Faction.GREENS);
        assertTrue(Character.isAlly(c, p));
    }
    
    @Test
    public void noDamageByAlly() {
        Character c = new Character();
        c.joinFaction(Faction.GREENS);
        Character p = new Character();
        p.joinFaction(Faction.GREENS);
        c.damage(p, 420);
        assertEquals(c.getHealth(), 1000);
    }
    
    @Test
    public void healByAlly() {
        Character c = new Character();
        c.joinFaction(Faction.GREENS);
        Character p = new Character();
        p.joinFaction(Faction.GREENS);
        c.damage(500);
        c.heal(p, 400);
        assertEquals(c.getHealth(), 900);
    }
    
    @Test
    public void noHealByNonAlly() {
        Character c = new Character();
        c.joinFaction(Faction.GREENS);
        Character p = new Character();
        p.joinFaction(Faction.YELLOWS);
        c.damage(500);
        c.heal(p, 400);
        assertEquals(c.getHealth(), 500);
    }
}
