package Weapons;

public class Spell {




    private String spellName;

    private int spellAttackLevel;

    public Spell(String spellName, int spellAttackLevel) {
        this.spellName = spellName;
        this.spellAttackLevel = spellAttackLevel;
    }

    public String getSpellName() {
        return this.spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellAttackLevel() {
        return this.spellAttackLevel;
    }

    public void setSpellAttackLevel(int spellAttackLevel) {
        this.spellAttackLevel = spellAttackLevel;
    }

}
