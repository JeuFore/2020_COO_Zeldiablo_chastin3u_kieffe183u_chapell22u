package code;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import code.moteurJeu.moteur.DessinAbstract;

import java.awt.*;

import code.moteurJeu.sprite.*;

public class Dessin implements DessinAbstract {

    private Map map;

    public Dessin(Map m) {
        this.map = m;
    }

    public void dessiner(BufferedImage image) {

        Graphics2D graphics = image.createGraphics();

        int i = 0;
        while (i < this.map.getMap().size()) {
            Row r = this.map.getMap().get(i);
            for (int j = 0; j < r.getSize(); j++) {
                if (r.getTile(j) == 1)
                    Sprites.dessinerCentre(graphics, "tank_12_0", j * 30, i * 30);
            }
            i++;
        }

        Sprites.dessinerCentre(graphics, "character_1_0", 20, 20);

        graphics.dispose();
    }
}