package components;


public class Dice8 implements DiceInterface {

    /**
     * class qui implément l'interface DiceInterface
     * @return un resultat en 1 et 8.
     */
    public int rollTheDice(){
        return (int)(Math.random() * 8) +1 ;

    }
}
