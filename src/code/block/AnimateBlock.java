package code.block;

public class AnimateBlock extends Block {

    private int nbAnimation;
    private int animate;

    public AnimateBlock(String nom, int id, int nbAnimation) {
        super(nom, id);
        this.nbAnimation = nbAnimation - 1;
        this.animate = 0;
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

}
