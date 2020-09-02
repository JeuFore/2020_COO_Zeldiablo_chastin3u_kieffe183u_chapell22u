package tests;

import org.junit.Test;

import code.Jeu;
import code.Joueur;

import static org.junit.Assert.*;

import java.io.File;

public class TestCaseDenclencheur {

    @Test
    public void testCaseDenclencheurNegative(){
        Jeu jeu = new Jeu(getFile("tests/map/level_4.txt"));
        jeu.getJoueur().move(1, 0);
        assertEquals("Le joueur devrait avoir bouge", 1, jeu.getJoueur().getPositionX());
        assertEquals("Le joueur doit avoir perdu des points de vie", 8, jeu.getJoueur().getVie());
    }

    @Test
    public void testCaseDenclencheurPositive(){
        Jeu jeu = new Jeu(getFile("tests/map/level_4.txt"));
        jeu.getJoueur().move(0, -1);
        assertEquals("Le joueur devrait avoir bouge", -1, jeu.getJoueur().getPositionY());
        assertEquals("Le joueur doit avoir gagne des points de vie", 12, jeu.getJoueur().getVie());
    }

}