package components;

import Weapons.ArmeWarrior.ArmeWarrior;
import Weapons.ArmeWarrior.Mace;
import Weapons.ArmeWarrior.Sword;
import Weapons.ArmeWizard.ArmeWizard;
import Weapons.Potion;
import characters.Character;
import characters.Warrior;
import characters.Wizard;
import ennemy.Ennemi;

import java.util.ArrayList;

/**
 *  classe abstraite Case , qui est Parent de CaseEmpty, Arme, ennemi , potion.
 *  represente les différentes cas du plateau.
 *  un seul attribut nom.
 */
public abstract class Case {



    private String name;
    private Object Case;

    public Case(String name) {
        this.name = name;
    }

    /**
     *
     * @param character
     * mise en place d'une méthode abstraite interaction qui est reprise dans différentes case
     * afin décrire la case en question et différentes modification que cela peut apporter ( ex: mace: équipement
     * pour un guerrier , +3 d'attaque, et mise à jour setAttackForce (+3).
     *
     */
    public abstract void interaction (Character character);





    @Override
    public String toString() {
        return "Case{" +
                "nameCase='" + this.name + '\'' +
                '}';
    }


    public String getName() {
        return this.name;
    }

    public void setName(String contentCase) {
        this.name = contentCase;
    }

}
