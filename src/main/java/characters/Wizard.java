package characters;

import Weapons.Spell;
import characters.Character;

public class Wizard extends Character {

    /**
     * classe Wizard qui hérite de la classe Character
     * rajout des attributs spell(objet Spell) et potion
     */

    private Spell spell;
    private String potion;


    /**
     * le constructeur reprend le constructeur de la classe parent avec "super()".
     */
    public Wizard(){
        super();
        this.spell = new Spell("eclair",2);
        this.potion = "potion de vie";

    }


    public Wizard (String name , int levelOfLife, int attackForce){
        super(name,levelOfLife,attackForce);
        this.spell = new Spell("eclair",2);
        this.potion = "potion de vie";
    }



    public Wizard (String name, int levelOfLife, int attackForce , String potion , String spell){
        super(name,levelOfLife,attackForce);
        this.potion = potion;
        this.spell = new Spell(spell,2);


    }




    @Override
    public String toString() {
        return "le nom du magicien est "+ this.getName() +
                " , vie = " + this.getLevelOfLife() +
                " , force = " + this.getAttackForce()+
                " , Son arme ="+ spell.getSpellName() ;

    }



    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }











}












