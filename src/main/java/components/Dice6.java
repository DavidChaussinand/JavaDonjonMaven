package components;

public class Dice6 implements DiceInterface{

    /**
     * class qui implément l'interface DiceInterface
     * @return un resultat en 1 et 6.
     */
    public int rollTheDice(){
        return (int)(Math.random() * 6) +1 ;
    }



}
