package code.moteurJeu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import code.moteurJeu.moteur.DessinAbstract;

import java.awt.*;

import code.moteurJeu.sprite.Sprites;
import code.block.Block;
import code.jeu.*;

public class Graphique implements DessinAbstract {

    private Jeu jeu;

    public Graphique(Jeu j) {
        this.jeu = j;
    }

    public void dessiner(BufferedImage image) {

        Graphics2D graphics = image.createGraphics();

        code.characters.Character joueur = this.jeu.getCharacter();

        // Permet de dessiner le joueur
        Sprites.dessinerCentre(graphics,
                joueur.getFacingProperty().getSpriteName() + "_" + joueur.getFacingProperty().getId() + "_"
                        + (joueur.getFacingProperty().getView() + joueur.getFacingProperty().getIdYaxis()),
                joueur.getPosition().getX() * 30 + 15, joueur.getPosition().getY() * 30 + 15);

        //  Permet d'afficher tous les blocks du jeu
        for (int i = 0; i < this.jeu.getMap().getMap().size(); i++) {
            Row r = this.jeu.getMap().getMap().get(i);
            for (int j = 0; j < r.getTiles().size(); j++) {
                Block block = r.getTile(j);
                if (block.getVisible()) {
                    Sprites.dessinerCentre(graphics, block.getNom() + block.getyAxis(), j * 30 + 15,
                            i * 30 + 15);
                }
            }
        }

        // Permet de dessiner les characters autres que le joueur
        for (code.characters.Character character : this.jeu.getMap().getCharacters()) {
            Sprites.dessinerCentre(graphics,
                    character.getFacingProperty().getSpriteName() + "_" + character.getFacingProperty().getId() + "_"
                            + (character.getFacingProperty().getView() + character.getFacingProperty().getIdYaxis()),
                    character.getPosition().getX() * 30 + 15, character.getPosition().getY() * 30 + 15);
        }

        graphics.dispose();
    }
}