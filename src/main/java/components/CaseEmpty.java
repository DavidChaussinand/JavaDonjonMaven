package components;

import Weapons.ArmeWarrior.Mace;
import characters.Character;
import characters.Warrior;

public class CaseEmpty extends Case{


    public void interaction (Character character){

        if (character instanceof Warrior) {
            if (this instanceof CaseEmpty){
                System.out.println("case sans interaction");
            }
        }
    }


    public CaseEmpty() {
        super("caseEmpty");

    }


    @Override
    public String toString() {
        return "CaseEmpty{" +
                "nameCase = " + this.getName() +
                '}';
    }






}
