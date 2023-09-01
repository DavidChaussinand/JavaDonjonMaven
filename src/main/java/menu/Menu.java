package menu;

import Weapons.Spell;
import Weapons.Weapon;
import characters.Character;
import characters.Warrior;
import characters.Wizard;
import database.Database;
import exceptions.DatabaseException;
import exceptions.PersonnageHorsPlateauException;
import exceptions.HeroException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.lang.reflect.*;

/**
 * Classe Menu qui sert à lancer le jeu en récupérant les personnages qui sont disponible dans la base de donnée
 *      * avec la méthode getHeroes().
 *      * ensuite le menu permet de lancer la partie en utilisant l'objet Game.
 *      * le menu dispose de 2 actions possible : soit lancer la partie , soit quittez.
 */
public class Menu {

    /**
     *
     * @throws PersonnageHorsPlateauException
     * @throws DatabaseException Si la base de données n’est pas accessible ou si login/pwd n’est pas correct.
     * @throws HeroException si impossible d'obtenir les info des personnages.
     */
    public void menu() throws PersonnageHorsPlateauException, DatabaseException, HeroException {

        Scanner user_input = new Scanner(System.in);
        List<Character> charactersList = getHeroes();

        boolean keepGoing = true;

        while (keepGoing) {
            showMenu();
            switch (user_input.next()) {

                case "1":
                    if (!charactersList.isEmpty()) {
                        System.out.println("Choisissez un personnage : ");
                        for (int i = 0; i < charactersList.size(); i++) {
                            System.out.println((i + 1) + ". " + charactersList.get(i).toString());
                        }
                        int choice = user_input.nextInt();
                        Character selectedCharacter = charactersList.get(choice - 1); // -1 car l'index commence à 0
                        Game jouer = new Game();
                        jouer.play(selectedCharacter);
                    } else {
                        System.out.println("Créez d'abord un personnage !");
                    }
                    break;

                case "2":
                    System.out.println("merci d'avoir quitté");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("choose from 1 to 2");
                    break;
            }
        }
    }

    /**
     * méthode qui recupere la connexion à la base de donnée, d'exécuter la requete sql pour récuperer les donnée des personnages.
     * @return la liste de personnages.
     * @throws DatabaseException If Database is not reachable or login/pwd ar not correct.
     */
    public List<Character> getHeroes() throws DatabaseException, HeroException {

        List<Character> charactersList = new ArrayList<Character>();
        try {

            String sql = "SELECT * FROM Hero";
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            // exécution de la requête
            ResultSet resultat = statement.executeQuery(sql);

            // Récupération des données
            while (resultat.next()) {
                int id = resultat.getInt("Id");
                String type = resultat.getString("Type");
                String nom = resultat.getString("Nom");
                int niveauVie = resultat.getInt("NiveauVie");
                int niveauForce = resultat.getInt("NiveauForce");
                String armeSort = resultat.getString("ArmeSort");
                String bouclier = resultat.getString("Bouclier");

                // Reflection in Java
                Class<?> clazz = Class.forName("characters."+type);
                Character character = (Character) clazz.getDeclaredConstructor(String.class, int.class, int.class, String.class, String.class).newInstance(nom, niveauVie, niveauForce, armeSort, bouclier);
                charactersList.add(character);
            }

        } catch (SQLException e){
            throw new DatabaseException("impossible de se connecter" + e.getMessage());
        } catch (Exception e) {
            throw new HeroException("impossible d'obtenir les info des personnages : " + e.getMessage());
        }

        return charactersList;
    }

    private void showMenu(){
        System.out.println("voici le menu :  choix ");
        System.out.println("tapez 1  : pour démarrer le jeu");
        System.out.println("tapez 2 : pour quitter");
    }

    /**
     * menu qui permet de lancer le dé ou de quitter.
     * Si on lance le dé , on applique la méthode move.
     * @return le résultat du dé.
     */
    public int rollTheDice (){
        Game dice = new Game();
        Scanner user_input = new Scanner(System.in);
        System.out.println("tapez 1 : pour lancer le dé" +
                "\ntapez 2 : quitter" );
        String choix = user_input.next();

        switch (choix) {
            case "1":
                dice.move();
                break;
            case "2":
                System.out.println("merci d'avoir quitter");
                System.exit(0);
            default:
                System.out.println("choose from 1 to 2");
                rollTheDice();
        }
        return dice.move();

    }

    // ici les méthodes createWarrior , createWizard  et updateCharacter ne sont plus utilisé,
    // car le projet a changé.  On devait initialement mettre dans le menu la possibilité de créer un personnage
    // avant le lancement de la partie et de pouvoir le modifier.

//    public Warrior createWarrior() {
//        Scanner user_input = new Scanner(System.in);
//        Warrior warrior = new Warrior();
//
//        System.out.print("Saisir votre nom de guerrier : ");
//        warrior.setName(user_input.nextLine());
//
//        System.out.print("Saisir votre niveau de vie entre 5 et 10: ");
//        warrior.setLevelOfLife(user_input.nextInt());
//        user_input.nextLine();
//
//        System.out.print("Saisir votre niveau de force entre 5 et 10 : ");
//        warrior.setAttackForce(user_input.nextInt());
//        user_input.nextLine();
//
//        updateCharacter(warrior);
//        charactersList.add(warrior);
//        return warrior;
//    }
//
//    public Wizard createWizard() {
//        Scanner user_input = new Scanner(System.in);
//        Wizard wizard = new Wizard();
//
//        System.out.print("Saisir votre nom de magicien : ");
//        wizard.setName(user_input.nextLine());
//
//        System.out.print("Saisir votre niveau de vie entre 3 et 6: ");
//        wizard.setLevelOfLife(user_input.nextInt());
//        user_input.nextLine();
//
//        System.out.print("Saisir votre niveau de force entre 8 et 15 : ");
//        wizard.setAttackForce(user_input.nextInt());
//        user_input.nextLine();
//
//        updateCharacter(wizard);
//        charactersList.add(wizard);
//        return wizard;
//    }

//    public void updateCharacter(Character character) {
//        Scanner user_input = new Scanner(System.in);
//
//        System.out.println("tapez 1 : pour afficher les infos du perso en cours de création" +
//                "\ntapez 2 : pour modifier ses infos" +
//                "\ntapez 3 : quitter");
//
//        String choix = user_input.next();
//
//        if (Objects.equals(choix, "1")) {
//            System.out.println("Nom: " + character.getName());
//            System.out.println("Points de vie: " + character.getLevelOfLife());
//            System.out.println("Force d'attaque: " + character.getAttackForce());
//        } else if (Objects.equals(choix, "2")) {
//            user_input.nextLine();
//            System.out.print("Nouveau nom : ");
//            String newName = user_input.nextLine();
//            System.out.print("Nouvelle valeur des points de vie : ");
//            int newLevelOfLife = user_input.nextInt();
//            System.out.print("Nouvelle valeur de la force d'attaque : ");
//            int newAttackForce = user_input.nextInt();
//
//            character.setName(newName);
//            character.setLevelOfLife(newLevelOfLife);
//            character.setAttackForce(newAttackForce);
//
//        } else if (Objects.equals(choix, "3")) {
//            return;
//        }
//
//        updateCharacter(character);
//    }


}







