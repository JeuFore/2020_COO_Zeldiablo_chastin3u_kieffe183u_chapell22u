package code.characters;

import code.moteurJeu.FrameListener;
import code.moteurJeu.moteur.MoteurGraphique;

public abstract class NonPlayableCharacter extends Character implements FrameListener {
    public NonPlayableCharacter(String name, int life, int x, int y, FacingProperty facingProperty, int d) {
        super(name, life, x, y, facingProperty,d);
    }

    public void frameUpdate() {
        if (MoteurGraphique.getFrame() % 10 == 0) {
            this.move((int)Math.floor(Math.random() * 3) - 1, (int)Math.floor(Math.random() * 3) - 1);
        }
    }
}