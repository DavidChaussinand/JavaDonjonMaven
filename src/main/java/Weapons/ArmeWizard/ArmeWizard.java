package Weapons.ArmeWizard;

import Weapons.Arme;



public class ArmeWizard extends Arme {

    public ArmeWizard(String name) {
        super(name);

    }




    @Override
    public String toString() {
        return "ArmeWizard{" +
                this.getName() +

                '}';
    }

}

