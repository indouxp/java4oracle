import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

  public static void main(String[] args) {
    DataAccess dataAccess = new DataAccess();

    try {
      dataAccess.selectOracle();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void selectOracle() throws Exception {

    // ユーザ名
    String user = "system";
    // パスワード
    String pass = "oracle";
    // サーバ名
    String servername = "172.17.0.2";
    // service name
    String sid = "ORCLCDB";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    try {
      // JBBCドライバクラスのロード
      Class.forName("oracle.jdbc.driver.OracleDriver");

      // Connectionの作成
      String url = "jdbc:oracle:thin:" + "@" + servername + ":1521:" + sid;
      conn = DriverManager.getConnection(url, user, pass);

      // Statementの作成
      stmt = conn.createStatement();

      // Resultsetの作成
      rset = stmt.executeQuery("select USERNAME, ACCOUNT_STATUS from DBA_USERS order by USERNAME");

      // 取得したデータを出力する
      while (rset.next()) {
        System.out.println(rset.getString("USERNAME") + "," + rset.getString("ACCOUNT_STATUS"));
      }

    } catch (ClassNotFoundException e) {
      throw e;
    } catch (SQLException e) {
      throw e;
    } catch (Throwable e) {
      throw e;
    } finally {
      try {
        /* クローズ処理 */
        if (rset != null) {
          rset.close();
          rset = null;
        }

        if (stmt != null) {
          stmt.close();
          stmt = null;
        }

        if (conn != null) {
          conn.close();
          conn = null;
        }
      } catch (Throwable e) {
          // nop
      }
    }
  }
}
