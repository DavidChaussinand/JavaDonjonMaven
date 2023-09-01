package Weapons;

import components.Case;

public class Weapon {


    private String weaponName;
    private int weaponAttackLevel;

    public Weapon(String weaponName, int weaponAttackLevel){
        this.weaponName = weaponName;
        this.weaponAttackLevel = weaponAttackLevel;
    }

    public String getWeaponName() {
        return this.weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponAttackLevel() {
        return this.weaponAttackLevel;
    }

    public void setWeaponAttackLevel(int weaponAttackLevel) {
        this.weaponAttackLevel = weaponAttackLevel;
    }

}
