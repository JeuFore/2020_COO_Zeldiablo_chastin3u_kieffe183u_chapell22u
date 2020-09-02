package tests;

import org.junit.Test;

import code.Jeu;
import code.characters.Advanturer;

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
        Joueur j = new Joueur("Bob", 1, 1);
        j.move(1, 0);
        assertEquals("Le joueur j devrait etre a 2 1", 2, j.getPositionX());
        assertEquals("Le joueur j devrait etre a 2 1", 1, j.getPositionY());
    }

    @Test
    public void testDeplacementSurY(){
        Joueur j = new Joueur("Bob", 1, 1);
        j.move(0, 1);
        assertEquals("Le joueur j devrait etre a 1 2", 1, j.getPositionX());
        assertEquals("Le joueur j devrait etre a 1 2", 2, j.getPositionY());
    }

    @Test
    public void testDeplacementCollision(){
        Joueur j = new Joueur("Bob", 1, 1);
        j.bloquer(true);
        j.move(0, 1);
        assertEquals("Le joueur devrait ne pas avoir bouge", 1, j.getPositionX());
        assertEquals("Le joueur devrait ne pas avoir bouge", 1, j.getPositionY());
    }

    @Test
    public void testDeplacementCollisionOutOFBounds(){
    	File file = getFile("tests/map/level_3.txt");
        Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getJoueur().getPosition().getX()+1, jeu.getJoueur().getPosition().getY());
        jeu.getJoueur().move(-1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPosition().getX());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().isCollision());
    }

    @Test
    public void testDeplacementCollisionSurUnMur(){
    	File file = getFile("tests/map/level_3.txt");
    	System.out.println(file);
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getJoueur().getPosition().getX()+1, jeu.getJoueur().getPosition().getY());
        jeu.getJoueur().move(1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPosition().getX());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().isCollision());
    }

    @Test
    public void testDeplacementDansLeVide(){
    	File file = getFile("tests/map/level_3.txt");
    	Jeu jeu = new Jeu(file, new Advanturer("Bruno",10,0,0));
        jeu.gererCollision(jeu.getJoueur().getPosition().getX()+1, jeu.getJoueur().getPosition().getY());
        jeu.getJoueur().move(0, -1);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPosition().getY());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().isCollision());
    }
}