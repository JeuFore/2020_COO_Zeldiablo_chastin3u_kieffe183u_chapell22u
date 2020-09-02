package code.moteurJeu;

import java.awt.image.BufferedImage;

import code.moteurJeu.moteur.DessinAbstract;

import java.awt.*;

import code.moteurJeu.sprite.Sprites;
import code.jeu.*;

public class Graphique implements DessinAbstract {

    private Jeu jeu;

    public Graphique(Jeu j) {
        this.jeu = j;
    }

    public void dessiner(BufferedImage image) {

        Graphics2D graphics = image.createGraphics();

        int i = 0;
        while (i < this.jeu.getMap().size()) {
            Row r = this.jeu.getMap().get(i);
            for (int j = 0; j < r.getSize(); j++) {
                if (r.getTile(j) == 1)
                    Sprites.dessinerCentre(graphics, "tank_12_0", j * 30 + 15, i * 30 + 15);
            }
            i++;
        }

        code.characters.Character joueur = this.jeu.getCharacter();

        Sprites.dessinerCentre(graphics,
                joueur.getFacingProperty().getSpriteName() + "_" + joueur.getFacingProperty().getId() + "_"
                        + joueur.getFacingProperty().getView(),
                joueur.getPosition().getX() * 30 + 15, joueur.getPosition().getY() * 30 + 15);

        if(this.jeu.getActualBlock().getActif())
            Sprites.dessinerCentre(graphics, this.jeu.getActualBlock().getNom()+"_" + this.jeu.getActualBlock().getEtat() + "_0",
                    joueur.getPosition().getX() * 30 + 15, joueur.getPosition().getY() * 30 + 15);

        graphics.dispose();
    }
}