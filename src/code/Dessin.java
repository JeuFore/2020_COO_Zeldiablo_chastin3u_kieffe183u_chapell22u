package code;

import java.awt.image.BufferedImage;

import code.moteurJeu.moteur.DessinAbstract;

import java.awt.*;

import code.moteurJeu.sprite.*;

public class Dessin implements DessinAbstract {

    private Jeu jeu;

    public Dessin(Jeu j) {
        this.jeu = j;
    }

    public void dessiner(BufferedImage image) {

        Graphics2D graphics = image.createGraphics();

        int i = 0;
        while (i < this.jeu.getMap().size()) {
            Row r = this.jeu.getMap().get(i);
            for (int j = 0; j < r.getSize(); j++) {
                if (r.getTile(j) == 1)
                    Sprites.dessinerCentre(graphics, "tank_12_0", j * 30 +15, i * 30+15);
            }
            i++;
        }

        Sprites.dessinerCentre(graphics, "character_4_" + this.jeu.getJoueur().getFacing(),
                this.jeu.getJoueur().getPositionX() * 30+15, this.jeu.getJoueur().getPositionY() * 30+15);

        graphics.dispose();
    }
}