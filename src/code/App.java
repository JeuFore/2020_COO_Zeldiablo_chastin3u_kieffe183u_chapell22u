package code;

import code.moteurJeu.moteur.MoteurGraphique;
import code.moteurJeu.sprite.Sprites;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Sprites.chargerImage("test", "./documents/images/megaman-solo.png");

        Sprites.chargerFeuille("character", "./documents/images/RPG.png", 12, 8);

        Sprites.chargerFeuille("tank", "./documents/images/tank_tiles.png", 22, 12);

        Jeu jeu = new Jeu();

        Dessin d = new Dessin(jeu);
        JeuGraphique j = new JeuGraphique(jeu);
    
        MoteurGraphique m = new MoteurGraphique(j, d);
    
        m.lancerJeu(900, 880, 10);
    }
}