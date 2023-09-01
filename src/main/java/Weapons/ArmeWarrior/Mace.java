package Weapons.ArmeWarrior;

import Weapons.ArmeWarrior.ArmeWarrior;
import characters.Character;
import characters.Warrior;

public class Mace extends ArmeWarrior {



    private int increaseAttack;



    public Mace() {
        super("massue");
        this.increaseAttack = 3;

    }

    public void interaction(Character character){

        if (character instanceof Warrior) {
            if (this instanceof Mace){
                System.out.println("Guerrier équipement pour toi : Massue +3 d'attaque");
                character.setAttackForce(character.getAttackForce()+3);
            }
        }
    }


    @Override
    public String toString() {
        return "Mace{" +
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
