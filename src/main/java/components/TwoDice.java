package components;

public class TwoDice implements DiceInterface{

    /**
     * class qui implément l'interface DiceInterface
     * @return resultat entre 2 et 12
     */

    public int rollTheDice(){
        Dice6 dice1 = new Dice6();
        Dice6 dice2 = new Dice6();
        return dice1.rollTheDice() + dice2.rollTheDice();

    }
}
