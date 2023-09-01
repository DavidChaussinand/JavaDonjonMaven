package Weapons;

import Weapons.ArmeWarrior.Sword;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class BigPotion extends Potion{
    private String name;
    private int increaseLIfe;



    public BigPotion() {
        super("BIG POTION");
        this.increaseLIfe = 5;

    }

    public void interaction (Character character){

        if (character instanceof Warrior || character instanceof Wizard){
            if (this instanceof BigPotion){
                System.out.println("équipement pour toi : big potion +5 de vie");
                character.setLevelOfLife(character.getLevelOfLife()+5);
            }
        }


    }

    @Override
    public String toString() {
        return "BigPotion{" +
                this.getName() +
                ", increaseLife=" + this.increaseLIfe +
                '}';
    }

    public int getIncreaseAttack() {
        return this.increaseLIfe;
    }

    public void setIncreaseAttack(int increaseAttack) {
        this.increaseLIfe = increaseAttack;
    }
}


