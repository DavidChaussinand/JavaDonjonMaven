package components;

public class TwoDice implements DiceInterface{

    private final Dice6 dice1 = new Dice6();
    private final Dice6 dice2 = new Dice6();

    /**
     * class qui implément l'interface DiceInterface
     * @return resultat entre 2 et 12
     */

    public int rollTheDice(){
        return dice1.rollTheDice() + dice2.rollTheDice();

    }
}
