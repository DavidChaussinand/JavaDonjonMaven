package Weapons.ArmeWarrior;


import Weapons.Arme;
import characters.Character;
import characters.Warrior;


public class ArmeWarrior extends Arme {




    public ArmeWarrior(String name){
        super(name);

    }



    @Override
    public String toString() {
        return "ArmeWarrior{" +
                "name='" + getName() + '\'' +
                '}';
    }



}
