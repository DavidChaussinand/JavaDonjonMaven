package Weapons;

import Weapons.ArmeWarrior.Mace;
import characters.Character;
import characters.Warrior;
import components.Case;

public class Arme extends Case {


    public void interaction(Character character){

        if (character instanceof Warrior) {
            if (this instanceof Arme){
                System.out.println("bonus arrive");
            }
        }
    }





    public Arme(String contentCase) {
        super(contentCase);

    }

    @Override
    public String toString() {
        return "Arme{" +
                "contentCase = " + this.getName() +
               '}';
    }




}
