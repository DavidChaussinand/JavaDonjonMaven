import exceptions.DatabaseException;
import exceptions.HeroException;
import exceptions.PersonnageHorsPlateauException;
import menu.Menu;

import java.io.IOException;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws PersonnageHorsPlateauException, SQLException, IOException, ClassNotFoundException, HeroException, DatabaseException {

        Menu menu = new Menu();
        menu.menu();

    }







}






