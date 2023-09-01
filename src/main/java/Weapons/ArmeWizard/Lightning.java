package Weapons.ArmeWizard;

import Weapons.ArmeWarrior.Mace;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class Lightning extends ArmeWizard{

    private int increaseAttack;



    public Lightning() {
        super("éclair");
        this.increaseAttack = 2;

    }

    public void interaction (Character character){

        if (character instanceof Wizard) {
            if (this instanceof Lightning){
                System.out.println("Magicien équipement pour toi : éclair +2 d'attaques");
                character.setAttackForce(character.getAttackForce()+2);
            }
        }
    }

    @Override
    public String toString() {
        return "Lightning{" +
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


