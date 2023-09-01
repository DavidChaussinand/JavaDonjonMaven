package characters;

import Weapons.Weapon;
import characters.Character;


public class Warrior extends Character {


    private Weapon weapon;
    private String shield;

    /**
     * le constructeur reprend le constructeur de la classe parent avec "super()".
     */
    public Warrior(){
        super();
        this.weapon = new Weapon("main nue",2);
        this.shield = "bouclier";

    }

    public Warrior (String name , int levelOfLife, int attackForce){
        super(name,levelOfLife,attackForce);
        this.weapon = new Weapon("main nue",2);
        this.shield = "bouclier";
    }

    public Warrior (String name, int levelOfLife, int attackForce, String shield, String weapon){
        super(name,levelOfLife,attackForce);
        this.shield = shield;
        this.weapon = new Weapon(weapon,2);
    }

    @Override
    public String toString() {
        return "Le nom du guerrier est "+ this.getName() +
                " , vie = " + this.getLevelOfLife() +
                " , force = " + this.getAttackForce()+
                " , Son arme = "+ weapon.getWeaponName() +
                " , Son bouclier = "+ this.shield;
    }




    public String getShield() {
        return this.shield;
    }
    public void setShield(String shield) {
        this.shield = shield;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }






}