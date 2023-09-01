package Weapons.ArmeWizard;

import Weapons.ArmeWarrior.Mace;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class FireBall extends ArmeWizard{

    private int increaseAttack;


    public FireBall() {
        super("boule de feu");
        this.increaseAttack = 7;
    }

    public void interaction(Character character){

        if (character instanceof Wizard) {
            if (this instanceof FireBall){
                System.out.println("Magicien équipement pour toi : Boule de feu +7 d'attaques");
                character.setAttackForce(character.getAttackForce()+7);
            }
        }
    }



    @Override
    public String toString() {
        return "FireBall{" +
                this.getName() +
                ", increaseAttack=" + this.increaseAttack +
                '}';
    }



    public int getIncreaseAttack() {
        return this.increaseAttack;
    }

    public void setIncreaseAttack(int increaseAttack) {
        this.increaseAttack = increaseAttack;
    }
}
