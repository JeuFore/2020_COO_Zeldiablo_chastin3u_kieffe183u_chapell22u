package code.block;

public class AnimateBlock extends Block {

    private int nbAnimation;
    private int animate;
    private int life;

    public AnimateBlock(String nom, int id, int nbAnimation, int life, boolean traversable) {
        super(nom, id, traversable);
        this.nbAnimation = nbAnimation - 1;
        this.animate = 0;
        this.life = life;
    }

    public void changeNbAnimation() {
        this.animate--;
    }

    public void activerAnimation() {
        this.animate = this.nbAnimation;
    }

    public int getAnimate() {
        return this.animate;
    }

    public int getLife() {
        return this.life;
    }

}