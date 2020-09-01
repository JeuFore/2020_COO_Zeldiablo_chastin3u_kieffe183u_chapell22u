import org.junit.Test;

import static org.junit.Assert.*;

public class TestJoueur {

    @Test
    public void testConstructeurJoueur() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // test des données
        assertEquals("Le joueur doit être en X = 0", 0, j.getPositionX());
        assertEquals("Le joueur doit être en Y = 0", 0, j.getPositionY());
        assertEquals("Le joueur doit avoir 10 points de vie", 10, j.getVie());
        assertEquals("Le joueur doit avoir 0 de mana", 0, j.getMana());
        assertEquals("Le joueur doit avoir 0 d'xp", 0, j.getXp());
    }

    @Test
    public void testChangerVie() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerVie(7);
        j.changerVie(-2);

        // test des données
        assertEquals("Le joueur doit avoir 15 points de vie", 15, j.getVie());
    }

    @Test
    public void testChangerMana() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerMana(5);
        j.changerMana(-3);
        
        // test des données
        assertEquals("Le joueur doit avoir 2 points de mana", 2, j.getMana());
    }

    @Test
    public void testChangerXp() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerXp(12);
        j.changerXp(-11);

        // test des données
        assertEquals("Le joueur doit avoir 1 point d'xp", 1, j.getXp());
    }

    @Test
    public void testVieNegative() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerVie(7);
        j.changerVie(-20);

        // test des données
        assertEquals("Le joueur doit avoir 0 point de vie", 0, j.getVie());
    }

    @Test
    public void testManaNegative() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerMana(5);
        j.changerMana(-13);
        
        // test des données
        assertEquals("Le joueur doit avoir 0 point de mana", 0, j.getMana());
    }

    @Test
    public void testXpNegative() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerXp(12);
        j.changerXp(-15);

        // test des données
        assertEquals("Le joueur doit avoir 0 point d'xp", 0, j.getXp());
    }
}