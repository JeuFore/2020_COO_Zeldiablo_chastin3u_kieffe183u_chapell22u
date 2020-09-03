package code.characters;

public class PlayableCharacter extends Character implements Playable {

    public PlayableCharacter(String name, int life, int x, int y, FacingProperty f, int d) {
        super(name, life, x, y, f,d);
    }

    private int xp;

    @Override
    public void setXP(int xp) {
        this.xp = xp;
    }

    @Override
    public void changerXP(int xp) {
        this.xp = Math.max(this.xp + xp, 0);
    }

    @Override
    public int getXP() {
        return this.xp;
    }

}