package Weapons.ArmeWarrior;

import Weapons.ArmeWarrior.ArmeWarrior;
import characters.Character;
import characters.Warrior;

public class Sword extends ArmeWarrior {
        private int increaseAttack;



    public Sword() {
        super("épée");
        this.increaseAttack = 5;

    }

    public void interaction(Character character){

        if (character instanceof Warrior) {
            if (this instanceof Sword){
                System.out.println("Guerrier équipement pour toi : épée +5 d'attaques");
                character.setAttackForce(character.getAttackForce()+5);
            }
        }
    }

    @Override
    public String toString() {
        return "Sword{" +
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
