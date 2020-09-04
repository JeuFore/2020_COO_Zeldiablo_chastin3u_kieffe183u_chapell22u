package code;

import code.moteurJeu.moteur.MoteurGraphique;
import code.moteurJeu.sprite.Sprites;
import code.moteurJeu.*;

import code.jeu.Jeu;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Sprites.chargerFeuille("PlayableCharacter", "./documents/images/vf_actor1-5110ef5.png", 12, 8);

        Sprites.chargerFeuille("NonPlayableCharacter", "./documents/images/monster.png", 12, 8);

        Sprites.chargerFeuille("tank", "./documents/images/tank_tiles.png", 22, 12);

        Sprites.chargerFeuille("beartrap", "./documents/images/beartrap.png", 1, 10);

        Sprites.chargerFeuille("fire", "./documents/images/fire.png", 1, 19);

        Sprites.chargerFeuille("heal", "./documents/images/heal.png", 1, 10);

        Sprites.chargerFeuille("victory", "./documents/images/victory.png", 1, 1);

        Jeu jeu = new Jeu();

        FrameListenerUpdater.addListener(jeu);

        Graphique graphique = new Graphique(jeu);
        JeuControleur jeuControleur = new JeuControleur(jeu);

        MoteurGraphique m = new MoteurGraphique(jeuControleur, graphique);

        Audio.play("src/audio/theme.wav");
        m.lancerJeu(900, 900, 6);
        
    }
}