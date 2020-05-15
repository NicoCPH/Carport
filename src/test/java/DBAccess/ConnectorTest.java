package DBAccess;

import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorTest {
//Test
    private static Connection testDBConnection;
    private static String USERNAME = "carport";
    private static String USERPASSWORD = "carport";
    private static String DBNAME = "carportdb?serverTimezone=CET";
    private static String HOST = "127.0.0.1";


    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void setConnection() {
    }

    @org.junit.Before
    public void setUp() {
            try {

                if ( testDBConnection == null ) {
                    String URL = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                    Class.forName( "com.mysql.cj.jdbc.Driver" );

                    testDBConnection = DriverManager.getConnection( URL, USERNAME, USERPASSWORD );

                    Connector.setConnection( testDBConnection );
                }



            } catch ( ClassNotFoundException | SQLException ex ) {
                testDBConnection = null;
                System.out.println( "Could not open connection to database: " + ex.getMessage() );
            }
        }




    @org.junit.Test
    public void setDBCredentials() {
    }
}