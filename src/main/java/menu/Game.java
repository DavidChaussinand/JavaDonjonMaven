package menu;

import Weapons.*;
import Weapons.ArmeWarrior.Mace;
import Weapons.ArmeWarrior.Sword;
import Weapons.ArmeWizard.FireBall;
import Weapons.ArmeWizard.Lightning;
import characters.Character;
import ennemy.Dragon;
import components.*;
import ennemy.Goblin;
import ennemy.Sorcerer;
import exceptions.PersonnageHorsPlateauException;
import menu.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {


    private int positionPlayer;
    private int tour;


    private ArrayList<Case> board;

    /**
     *  constructeur qui initialise le plateau de 64 case, et mélange le plateau avec la méthode shuffle.
     */
    public Game() {
        this.board = initializationBoard();
        this.board = initializationBoardRandom(this.board);

    }

    /**
     * création en dure d'un plateau de 64 case.
     * @return un plateau
     */
    public ArrayList<Case> initializationBoard(){

        this.board= new ArrayList<>();

        for (int i = 1;  i < 65 ; i++){

            if(i == 45 || i == 52 || i == 56 || i == 62){
                this.board.add(new Dragon());
            }
            else if(i == 10 || i == 20 || i == 25 || i == 32 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47){
                this.board.add(new Sorcerer());
            }
            else if(i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30){
                this.board.add(new Goblin());
            }
            else if(i == 2 || i == 11 || i == 5 || i == 22 || i == 38){
                this.board.add(new Mace());
            }

            else if(i == 19 || i == 26 || i == 42 || i == 53){
                this.board.add(new Sword());
            }
            else if(i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                this.board.add(new Lightning());
            }

            else if(i == 48 || i == 49 ) {
                this.board.add(new FireBall());
            }
            else if(i == 7 || i == 13 || i == 31 || i == 33 || i == 39 || i == 43) {
                this.board.add(new StandardLifePotion());
            }

            else if(i == 28 || i == 41 ) {
                this.board.add(new BigPotion());
            }
            else{
                this.board.add(new CaseEmpty());
            }

        }
        return this.board;
    }

    /**
     * méthode qui prend en parametre un board et qui le mélange pour avoir un plateau aléatoire à chaque partie.
     * @param originalBoard
     * @return le plateau mélangé
     */
    public ArrayList<Case> initializationBoardRandom(ArrayList<Case> originalBoard) {
        ArrayList<Case> shuffledBoard = new ArrayList<>(originalBoard);
        Collections.shuffle(shuffledBoard);
        return shuffledBoard;
    }


    /**
     *
     * @param perso
     * @throws PersonnageHorsPlateauException
     */
    public void play(Character perso) throws PersonnageHorsPlateauException  {
        Menu dice = new Menu();
        System.out.println(perso);

        while (this.positionPlayer <= this.board.size()){
            int move = dice.rollTheDice();
            this.positionPlayer = this.positionPlayer + move;
            if (this.positionPlayer > this.board.size()){
                throw new PersonnageHorsPlateauException(" Tu es sorti du plateau : BRAVO");
            }
            Case currentCase = board.get(this.positionPlayer);
            System.out.println(this.board.get(this.positionPlayer-1));    // tableau commence index 0, la position du joueur est à 1 : donc positionJoueur -1 .
            currentCase.interaction(perso);
            System.out.println(perso);
            this.tour ++ ;
            System.out.println("tour " + tour + ":  le joueur est sur la case " + this.positionPlayer);
        }
        System.out.println("Fin de partie ,vous avez gagné");

        if (this.positionPlayer >= this.board.size()){
            Scanner user_input = new Scanner(System.in);
            System.out.println("tapez 1 : rejouer" +
                    "\ntapez 2 : quitter");

            switch (user_input.next()) {
                case "1":
                    this.positionPlayer = 0;
                    this.tour=0;
                    play(perso) ;
                    break;
                case "2":
                    System.out.println("merci d'avoir jouer , au revoir");
                    return;

                default:
                    System.out.println("choose from 1 to 2");
            }
        }
    }

    /**
     * utilisation de l'interface pour récuperer l'un des dé qui utilise la méthode de l'interface rollTheDice.
     * @return le résultat du dé lancé
     */
    public int move(){
        DiceInterface dice = new TwoDice();
        return dice.rollTheDice();
    }





    public int getPositionPlayer() {
        return this.positionPlayer;
    }

    public void setPositionPlayer(int positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    public int getTour() {
        return this.tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }






}