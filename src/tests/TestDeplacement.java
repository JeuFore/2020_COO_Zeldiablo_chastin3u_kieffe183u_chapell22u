package tests;

import org.junit.Test;

import code.jeu.Jeu;
import code.characters.Advanturer;
import code.characters.Character;

import static org.junit.Assert.*;

import java.io.*;

public class TestDeplacement {

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
    public void testDeplacementSurX(){
        Character j = new Advanturer("Bob",10, 1, 1);
        j.move(1, 0);
        assertEquals("Le joueur j devrait etre a 2 1", 2, j.getPosition().getX());
        assertEquals("Le joueur j devrait etre a 2 1", 1, j.getPosition().getY());
    }

    @Test
    public void testDeplacementSurY(){
    	Character j = new Advanturer("Bob",10, 1, 1);
        j.move(0, 1);
        assertEquals("Le joueur j devrait etre a 1 2", 1, j.getPosition().getX());
        assertEquals("Le joueur j devrait etre a 1 2", 2, j.getPosition().getY());
    }

    @Test
    public void testDeplacementCollision(){
    	Character j = new Advanturer("Bob",10, 1, 1);
        j.bloquer(true);
        j.move(0, 1);
        assertEquals("Le joueur devrait ne pas avoir bouge", 1, j.getPosition().getX());
        assertEquals("Le joueur devrait ne pas avoir bouge", 1, j.getPosition().getY());
    }

    @Test
    public void testDeplacementCollisionOutOFBounds(){
    	File file = getFile("tests/map/level_3.txt");
        Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getCharacter().getPosition().getX()+1, jeu.getCharacter().getPosition().getY());
        jeu.getCharacter().move(-1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getCharacter().getPosition().getX());
        assertEquals("La collision devrait etre active", true, jeu.getCharacter().isCollision());
    }

    @Test
    public void testDeplacementCollisionSurUnMur(){
    	File file = getFile("tests/map/level_3.txt");
    	System.out.println(file);
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getCharacter().getPosition().getX()+1, jeu.getCharacter().getPosition().getY());
        jeu.getCharacter().move(1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getCharacter().getPosition().getX());
        assertEquals("La collision devrait etre active", true, jeu.getCharacter().isCollision());
    }

    @Test
    public void testDeplacementDansLeVide(){
    	File file = getFile("tests/map/level_3.txt");
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getCharacter().getPosition().getX()+1, jeu.getCharacter().getPosition().getY());
        jeu.getCharacter().move(0, -1);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getCharacter().getPosition().getY());
        assertEquals("La collision devrait etre active", true, jeu.getCharacter().isCollision());
    }
}