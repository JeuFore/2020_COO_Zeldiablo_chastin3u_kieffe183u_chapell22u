import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeplacement {

    
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
        Jeu jeu = new Jeu();
        jeu.gererCollision(jeu.getJoueur().getPositionX()+1, jeu.getJoueur().getPositionY());
        jeu.getJoueur().move(-1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPositionX());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().getCollision());
    }

    @Test
    public void testDeplacementCollisionSurUnMur(){
        Jeu jeu = new Jeu();
        jeu.gererCollision(jeu.getJoueur().getPositionX()+1, jeu.getJoueur().getPositionY());
        jeu.getJoueur().move(1, 0);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPositionX());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().getCollision());
    }

    @Test
    public void testDeplacementDansLeVide(){
        Jeu jeu = new Jeu();
        jeu.gererCollision(jeu.getJoueur().getPositionX()+1, jeu.getJoueur().getPositionY());
        jeu.getJoueur().move(0, -1);
        assertEquals("Le joueur devrait ne pas avoir bouge", 0, jeu.getJoueur().getPositionY());
        assertEquals("La collision devrait etre active", true, jeu.getJoueur().getCollision());
    }
}