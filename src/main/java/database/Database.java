package database;
import exceptions.DatabaseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Mise en place du pattern Singleton afin de m'assurer qu'il n'y a qu'une seule instance
 * de mon objet pour la connexion à la base de donnée.
 * le contructeur est privé.
 * Et je dispose uniquement de la méthode getConnection() qui  retourne soit un objet Database, soit la connexion.
 */
public class Database {

    private static Connection connection;

        private Database() throws IOException, SQLException, ClassNotFoundException {
               InputStream env = new FileInputStream(".env");
               Properties properties = new Properties();
               properties.load(env);

               String URL = properties.getProperty("DB_URL");
               String USER = properties.getProperty("DB_USER");
               String PASSWORD = properties.getProperty("DB_PASSWORD");

               Class.forName("com.mysql.cj.jdbc.Driver");
               connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

    /**
     * getCnnection qui permet de créer un objet si la connexion est null ou fermé , sinon il retourne la connexion.
     * @return
     * @throws DatabaseException
     */
    public static Connection getConnection() throws DatabaseException {
        try {
            if (connection == null || connection.isClosed()){
                new Database();
            }
        } catch (Exception e) {
            throw new DatabaseException("impossible de se connecter" + e.getMessage());
        }
        return connection;
    }




}
