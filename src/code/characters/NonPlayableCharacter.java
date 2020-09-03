package code.characters;

import code.moteurJeu.FrameListener;
import code.moteurJeu.moteur.MoteurGraphique;

public abstract class NonPlayableCharacter extends Character implements FrameListener {
    public NonPlayableCharacter(String name, int life, int x, int y, FacingProperty facingProperty, int d) {
        super(name, life, x, y, facingProperty,d);
    }

    public void frameUpdate() {
        if (MoteurGraphique.getFrame() % 10 == 0) {
            final int rand = (int)Math.floor(Math.random() * 3) - 1;
            final boolean orientation = (int)Math.floor(Math.random() * 2) == 1;
            if (orientation) {
                this.move(rand, 0);
            } else {
                this.move(0, rand);
            }
        }
    }
}