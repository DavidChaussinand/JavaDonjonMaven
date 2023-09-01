package ennemy;

import Weapons.ArmeWarrior.Mace;
import characters.Character;
import characters.Warrior;
import components.Case;

public class Ennemi extends Case {

    /**
     * Classe Ennemi qui est en enfant de Case , mais qui est parent de Dragon, Ennemi, Goblin, Sorcerer.
     */

    public void interaction(Character character){

        if (character instanceof Warrior) {
            if (this instanceof Ennemi){
                System.out.println("un ennemi arrive");;
            }
        }
    }

    public Ennemi(String name) {
        super(name);
            }

    @Override
    public String toString() {
        return "Ennemi{ "  +
                "contentCase = " + this.getName() +
                '}';
    }





}
