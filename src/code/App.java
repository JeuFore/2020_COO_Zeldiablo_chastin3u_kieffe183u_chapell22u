package code;

import code.moteurJeu.moteur.MoteurGraphique;
import code.moteurJeu.sprite.Sprites;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Sprites.chargerImage("test", "./documents/images/megaman-solo.png");

        Sprites.chargerFeuille("character", "./documents/images/RPG.png", 12, 8);

        Sprites.chargerFeuille("tank", "./documents/images/tank_tiles.png", 22, 12);

        Map map = new Map("./src/map/level_1.txt");

        Dessin d = new Dessin(map);
        JeuGraphique j = new JeuGraphique();
    
        MoteurGraphique m = new MoteurGraphique(j, d);
    
        m.lancerJeu(900, 880, 10);
    }
}