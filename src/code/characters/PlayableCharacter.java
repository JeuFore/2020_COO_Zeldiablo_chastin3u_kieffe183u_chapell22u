package code.characters;

public class PlayableCharacter extends Character implements Playable {

    public PlayableCharacter(String name, int life, int x, int y) {
        super(name, life, x, y);
    }

    private int xp;

    @Override
    public void setXP(int xp) {
        this.xp = xp;
    }

    @Override
    public void changerXP(int xp) {
        this.xp += xp;

    }

    @Override
    public int getXP() {
        return this.xp;
    }
    
}