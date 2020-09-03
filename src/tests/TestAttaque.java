package tests;

import org.junit.Test;

import code.characters.*;
import code.characters.Character;
import code.jeu.*;

import static org.junit.Assert.*;

public class TestAttaque {
	
	
	@Test
	public void testAttaqueAdventurer() {
		Map m = new Map("tests/map/level_5.txt");
		Character j = new Advanturer("Bruno", 10, 3, 2);
		Character grr = new Monster("Pastique", 10, 3, 3);
		m.ajouterCharacter(j);
		m.ajouterCharacter(grr);
		m.gererAttaque(j.getPosition().getX(), j.getPosition().getY(), j);
		assertEquals("Le monstre devrait avoir perdu de la vie", 6,grr.getVie());
	}
	
	@Test
	public void testAttaqueMage() {
		Map m = new Map("tests/map/level_5.txt");
		Wizard j = new Wizard("Paul", 10, 3, 2, 10);
		Monster grr = new Monster("TANK", 10,3, 4);
		m.ajouterCharacter(j);
		m.ajouterCharacter(grr);
		m.gererAttaque(j.getPosition().getX(), j.getPosition().getY(), j);
		assertEquals("Le monstre devrait avoir perdu des points de vies",6 ,grr.getVie());
		assertEquals("Le mage doit avoir perdu du mana", 9,j.getMana());
	}
	
	
}
