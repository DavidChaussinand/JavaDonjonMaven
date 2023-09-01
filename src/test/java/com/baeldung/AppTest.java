package com.baeldung;

import static org.junit.Assert.assertTrue;
import characters.Character;
import components.Dice6;
import components.FakeDice;
import database.Database;
import menu.Menu;
import org.junit.Test;
import java.sql.Connection;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldConnectDatabase()
    {
        try {
            Connection connection = Database.getConnection();
            assertTrue("Connection must exist !",  connection != null );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Database may connect !", false);
        }

    }

    @Test
    public void shouldGetHeroes()
    {
        Menu menu = new Menu();
        try {
            List<Character> characters = menu.getHeroes();
            assertTrue("Character list must have 3 entries, here is: "+ characters.size(),  characters.size() == 3 );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Character list must be filled !", false);
        }
    }

    @Test
    public void shouldResulRollTheDice(){
        Dice6 dice = new Dice6();
        int result = dice.rollTheDice();
        assertTrue("le resultat obtenu est " + result +" nous devons avoir entre 1 et 6  ",result >= 1 && result <= 6);
    }

    @Test
    public void shouldResulRollTheDice3(){
        FakeDice dice = new FakeDice();
        int result = dice.rollTheDice();
        assertTrue("le resultat obtenu est " + result +" nous devons avoir 1 ",result == 1 );
    }





}
