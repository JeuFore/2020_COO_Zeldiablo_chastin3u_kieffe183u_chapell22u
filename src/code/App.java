package code;

import code.moteurJeu.moteur.MoteurGraphique;
import code.moteurJeu.sprite.Sprites;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Sprites.chargerFeuille("PlayableCharacter", "./documents/images/vf_actor1-5110ef5.png", 12, 8);

        Sprites.chargerFeuille("tank", "./documents/images/tank_tiles.png", 22, 12);

        Jeu jeu = new Jeu();

        Dessin d = new Dessin(jeu);
        JeuGraphique j = new JeuGraphique(jeu);
    
        MoteurGraphique m = new MoteurGraphique(j, d);
    
        m.lancerJeu(900, 900, 10);
    }
}