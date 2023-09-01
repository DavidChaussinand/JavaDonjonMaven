package ennemy;

import characters.Character;

public class Sorcerer extends Ennemi{

    /**
     * classe Dragon qui hérite d'ennemi
     * constructer qui dispose de super() (récupere constructeur du parent) pour le nom
     *                et dispose de 2 attributs en dure : niveau de vie et force attaque
     */
    private int attackForce;
    private int levelOfLife;

    public Sorcerer() {
        super("sorcerer");
        this.levelOfLife = 9;
        this.attackForce = 2;

    }

    public void interaction(Character character){

        if (this instanceof Sorcerer){
            System.out.println("Un Sorcier arrive");
            //character.setAttackForce(character.getAttackForce()+5);
        }

    }


    @Override
    public String toString() {
        return "Sorcier{" +
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
