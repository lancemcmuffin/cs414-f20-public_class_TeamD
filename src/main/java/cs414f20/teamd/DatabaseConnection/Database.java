package cs414f20.teamd.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    // connection information when using port forwarding from local host
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:56247/publicclassteamd";
    private final static String DB_USER = "sdonepud";
    private final static String DB_PASSWORD = "831865987";
    // SQL SELECT query statement
    // private final static String COLUMN = "username";
    private final static String QUERY = "SELECT * FROM greatestAccounts;";

    private static void getAllUsers(){
        try (
             // connect to the database and query
             Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement query = conn.createStatement();
             ResultSet results = query.executeQuery(QUERY)
         ) {
            // iterate through query results and print out the column values
            int count = 0;
            while (results.next()) {
                System.out.printf("%6d %s", ++count, results.getString("personalID"));
                System.out.printf("\t%s", results.getString("username"));
                System.out.printf("\t%s\n", results.getString("password"));
            }
        } 
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void enterNewGame(int id, String whitePlayer, String blackPlayer){
        final String board = "newBoard";
        final String q = "INSERT INTO chessGames VALUES("+ id +",\"" + whitePlayer + "\",\""+ blackPlayer+"\",\""
                          + board + "\",\""+ whitePlayer +"\","+ 0 +");";
        try (
             Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement query = conn.createStatement();
         ) {
            query.executeUpdate(q);
        } 
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getAllUsers();
        enterNewGame(20, "me", "not me");
    }
}