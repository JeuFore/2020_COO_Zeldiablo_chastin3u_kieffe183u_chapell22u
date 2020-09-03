package code.block;

public class AnimateBlock extends Block {

    private int animation;
    private int tempNbAnimation;
    private int life;
    private boolean actif;

    public AnimateBlock(String nom, int id, int nbAnimation, int life, boolean traversable) {
        super(nom, 0, id, traversable);
        this.animation = 0;
        this.tempNbAnimation = nbAnimation- 1;
        this.actif = true;
        this.life = life;
        setVisible(false);
    }

    public void changeNbAnimation() {
        this.animation++;
        setyAxis(this.animation);
        if (this.animation == this.tempNbAnimation) {
            setVisible(false);
            this.actif = false;
        }
    }

    public void activerAnimation() {
        this.actif = false;
        this.setVisible(true);
    }

    public int getLife() {
        return this.life;
    }

    public boolean getActif() {
        return this.actif;
    }

}