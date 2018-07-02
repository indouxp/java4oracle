import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("  usage: <url> <username> <password>`\n  java Access jdbc:oracle:thin:@172.17.0.2:1521/orclpdb1 system oracle");
            System.exit(0);
        }

        String url = args[0];
        String username = args[1];
        String password = args[2];

        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Successfully connected!");
            }
        } catch (Exception ex) {
            System.out.println("Failed to connect: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


    }
}
