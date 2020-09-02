package tests;

import org.junit.Test;

import code.jeu.Jeu;
import code.characters.Advanturer;

import static org.junit.Assert.*;

import java.io.File;

public class TestCaseDeclencheur {

    /**
     * Methode qui retourne le fichier correspondant au path donnees (probleme de path avec les tests)
     * @param path
     * @return le Fichier correspondant
     */
    private File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return file;
    }

    @Test
    public void testCaseDenclencheurNegative(){
    	File file = getFile("tests/map/level_4.txt");
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.getCharacter().move(1, 0);
        jeu.gererDeclencheur(jeu.getCharacter().getPosition().getX(), jeu.getCharacter().getPosition().getY(), jeu.getCharacter());
        assertEquals("Le joueur devrait avoir bouge", 1, jeu.getCharacter().getPosition().getX());
        assertEquals("Le joueur doit avoir perdu des points de vie", 8, jeu.getCharacter().getVie());
    }

    @Test
    public void testCaseDenclencheurPositive(){
    	File file = getFile("tests/map/level_4.txt");
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.getCharacter().move(0, 1);
        jeu.gererDeclencheur(jeu.getCharacter().getPosition().getX(), jeu.getCharacter().getPosition().getY(), jeu.getCharacter());
        assertEquals("Le joueur devrait avoir bouge", 1, jeu.getCharacter().getPosition().getY());
        assertEquals("Le joueur doit avoir gagne des points de vie", 12, jeu.getCharacter().getVie());
    }

}