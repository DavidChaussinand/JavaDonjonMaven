package ennemy;

import Weapons.ArmeWarrior.Sword;
import characters.Character;
import characters.Warrior;

public class Dragon extends Ennemi{

    /**
     * classe Dragon qui hérite d'ennemi
     * constructer qui dispose de super() (récupere constructeur du parent) pour le nom
     *                et dispose de 2 attributs en dure : niveau de vie et force attaque
     */
    private int attackForce;
    private int levelOfLife;

    public Dragon() {
        super("dragon");
        this.levelOfLife = 15;
        this.attackForce = 4;

    }

    public void interaction(Character character){

            if (this instanceof Dragon){
                System.out.println("Un dragon arrive");
                //character.setAttackForce(character.getAttackForce()+5);
            }

    }


    @Override
    public String toString() {
        return "Dragon{" +
                this.getName() +
                ",  attackForce = " + this.attackForce +
                ", levelOfLife = " + this.levelOfLife +
                '}';
    }

    public int getAttackForce() {
        return this.attackForce;
    }

    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }

    public int getLevelOfLife() {
        return this.levelOfLife;
    }

    public void setLevelOfLife(int levelOfLife) {
        this.levelOfLife = levelOfLife;
    }





}
