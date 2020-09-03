package code;

import code.moteurJeu.moteur.MoteurGraphique;
import code.moteurJeu.sprite.Sprites;
import code.moteurJeu.*;

import code.jeu.Jeu;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Sprites.chargerFeuille("PlayableCharacter", "./documents/images/vf_actor1-5110ef5.png", 12, 8);

        Sprites.chargerFeuille("tank", "./documents/images/tank_tiles.png", 22, 12);

        Sprites.chargerFeuille("trap", "./documents/images/beartrap.png", 5, 1);

        Jeu jeu = new Jeu();

        Graphique graphique = new Graphique(jeu);
        JeuControleur jeuControleur = new JeuControleur(jeu);

        MoteurGraphique m = new MoteurGraphique(jeuControleur, graphique);

        Audio.play("src/audio/theme.wav");
        m.lancerJeu(900, 900, 10);
    }
}