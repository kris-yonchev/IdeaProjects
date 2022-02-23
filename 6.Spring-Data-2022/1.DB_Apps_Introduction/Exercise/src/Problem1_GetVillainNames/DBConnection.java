package Problem1_GetVillainNames;

public final class DBConnection {
    public static final String URL_DB;

    private static final String JDBC = "jdbc";
    private static final String DRIVER = "mysql";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "minions_db";
    private static final String USER = "root";
    private static final String PASS = "peshomisho123";


    static {
        URL_DB = String.format("%s:%s://%s:%s/%s?user=%s&password=%s", JDBC, DRIVER, HOST, PORT, DATABASE, USER, PASS);
    }

    private DBConnection(){

    }
}
