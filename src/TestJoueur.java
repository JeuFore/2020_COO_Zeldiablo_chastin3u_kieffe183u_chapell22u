import org.junit.Test;

import static org.junit.Assert.*;

public class TestJoueur {

    @Test
    public void testConstructeurJoueur() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // test des données
        assertEquals("Le nom du joueur ne correspond pas", "Steve", j.getNom());
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

        // test des données
        assertEquals("Le joueur doit avoir 17 points de vie", 7, j.getVie());
    }

    @Test
    public void testChangerMana() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerVie(7);

        // test des données
        assertEquals("Le joueur doit avoir 7 points de vie", 7, j.getVie());
    }

    @Test
    public void testChangerXp() {
        // preparation des données
        Joueur j = new Joueur("Steve", 0, 0);

        // méthode testée
        j.changerVie(7);

        // test des données
        assertEquals("Le joueur doit avoir 7 points de vie", 7, j.getVie());
    }

    public void testVieNegative() {

    }

    @Test
    public void testManaNegative() {

    }

    @Test
    public void testXpNegative() {

    }
}