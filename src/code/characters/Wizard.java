package code.characters;

public class Wizard extends PlayableCharacter implements MagicPower {

    private int mana;

    public Wizard(String name, int life, int x, int y, int mana) {
        super(name, life, x, y, new FacingProperty("PlayableCharacter", 10, 4));
        this.mana = mana;
    }

    @Override
    public void changerMana(int mana) {
        if (this.mana + mana <= 0) this.mana = 0;
        else this.mana += mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer(super.toString());
        res.append(" Je possède des pouvoirs magiques (" + this.mana + ")");
        return res.toString();
    }

}