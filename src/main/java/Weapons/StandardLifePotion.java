package Weapons;

import characters.Character;

public class StandardLifePotion extends Potion {
   private int increaseLIfe;



    public StandardLifePotion() {
        super("potion de base");
        this.increaseLIfe = 2;

    }

    public void interaction (Character character){


        if (this instanceof StandardLifePotion){
            System.out.println("équipement pour toi : potion +2 de vie");
            character.setLevelOfLife(character.getLevelOfLife()+2);
        }

    }

    @Override
    public String toString() {
        return "Potion Standard{" +
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

