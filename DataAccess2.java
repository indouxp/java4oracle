///////////////////////////////////////////////////////////////////////////////
//
// Oracle Server 12.2.0への接続
//
///////////////////////////////////////////////////////////////////////////////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess2 {

  public static void main(String[] args) {
    DataAccess2 dataAccess = new DataAccess2();

    try {
      dataAccess.selectOracle();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void selectOracle() throws Exception {

    // ユーザ名
    String user = "indou";
    // パスワード
    String pass = "indou";
    // サーバ名
    String servername = "172.17.0.2";
    // service name
    String sevice = "orclpdb1";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    try {
      // JDBCドライバクラスのロード
      Class.forName("oracle.jdbc.driver.OracleDriver");

      // ServiceへのConnectionの作成
      String url = "jdbc:oracle:thin:" + "@//" + servername + ":1521/" + sevice;
      conn = DriverManager.getConnection(url, user, pass);

      // Statementの作成
      stmt = conn.createStatement();

      // Resultsetの作成
      rset = stmt.executeQuery("SELECT TABLE_NAME, STATUS FROM USER_TABLES ORDER BY TABLE_NAME");

      // 取得したデータを出力する
      while (rset.next()) {
        System.out.println(rset.getString("TABLE_NAME") + "," + rset.getString("STATUS"));
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
