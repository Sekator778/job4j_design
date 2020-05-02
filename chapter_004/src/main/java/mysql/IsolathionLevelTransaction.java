package mysql;

import java.sql.*;

/**
 * Уровень изоляции транзакций 1 не поддерживается
 */

public class IsolathionLevelTransaction {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/sqlex";
        String username = "postgres";
        String password = "password";
        Class.forName("org.postgresql.Driver"); // ??????

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false); // commit need
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            statement.execute("truncate table books restart identity ");
            statement.execute("update books set name = 'IsolathionBookLevel' where id = 1");
            new OtherTransaction().start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connection.rollback();

        }
    }


    static class OtherTransaction extends Thread {
        @Override
        public void run() {
            String url = "jdbc:postgresql://localhost:5432/sqlex";
            String username = "postgres";
            String password = "password";
            Connection connection = null;
            try (Connection con = DriverManager.getConnection(url, username, password);
                 Statement statement = con.createStatement()) {
                con.setAutoCommit(false); // commit need
                con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // this variant may dirty read
                ResultSet resultSet = statement.executeQuery("select * from books");
                while (resultSet.next()) {
                    System.out.println("2 thread read");
                    System.out.println(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
