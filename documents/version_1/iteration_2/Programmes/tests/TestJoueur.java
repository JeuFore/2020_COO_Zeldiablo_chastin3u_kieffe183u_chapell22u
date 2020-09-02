package tests;

import org.junit.Test;

import code.characters.Advanturer;
import code.characters.Wizard;

import static org.junit.Assert.*;

public class TestJoueur {

    @Test
    public void testConstructeurJoueur() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        // test des données
        assertEquals("Le joueur doit être en X = 0", 0, j.getPosition().getX());
        assertEquals("Le joueur doit être en Y = 0", 0, j.getPosition().getY());
        assertEquals("Le joueur doit avoir 10 points de vie", 10, j.getVie());
        assertEquals("Le joueur doit avoir 0 d'xp", 0, j.getXP());
    }

    @Test
    public void testChangerVie() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        // méthode testée
        j.changerVie(7);
        j.changerVie(-2);

        // test des données
        assertEquals("Le joueur doit avoir 15 points de vie", 15, j.getVie());
    }

    @Test
    public void testChangerMana() {
        // preparation des données
        Wizard j = new Wizard("Steve", 10, 0, 0, 0);

        // méthode testée
        j.changerMana(5);
        j.changerMana(-3);
        
        // test des données
        assertEquals("Le joueur doit avoir 2 points de mana", 2, j.getMana());
    }

    @Test
    public void testChangerXp() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        // méthode testée
        j.changerXP(12);
        j.changerXP(-11);

        // test des données
        assertEquals("Le joueur doit avoir 1 point d'xp", 1, j.getXP());
    }

    @Test
    public void testVieNegative() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        // méthode testée
        j.changerVie(7);
        j.changerVie(-20);

        // test des données
        assertEquals("Le joueur doit avoir 0 point de vie", 0, j.getVie());
    }

    @Test
    public void testManaNegative() {
        // preparation des données
        Wizard j = new Wizard("Steve", 10, 0, 0, 4);

        // méthode testée
        j.changerMana(5);
        j.changerMana(-13);
        
        // test des données
        assertEquals("Le joueur doit avoir 0 point de mana", 0, j.getMana());
    }

    @Test
    public void testXpNegative() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        // méthode testée
        j.changerXP(12);
        j.changerXP(-15);

        // test des données
        assertEquals("Le joueur doit avoir 0 point d'xp", 0, j.getXP());
    }

    @Test
    public void test_move() {
        // preparation des données
        Advanturer j = new Advanturer("Steve", 10, 0, 0);

        j.move(-1, 0);
        assertEquals("Le joueur avoir bougé", -1, j.getPosition().getX());
        j.move(2, 0);
        assertEquals("Le joueur avoir bougé", 1, j.getPosition().getX());
        j.move(0, -1);
        assertEquals("Le joueur avoir bougé", -1, j.getPosition().getY());
        j.move(0, 2);
        assertEquals("Le joueur avoir bougé", 1, j.getPosition().getY());
    }
}