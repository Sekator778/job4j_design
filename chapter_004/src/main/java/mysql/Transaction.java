package mysql;

import java.sql.*;

/**
 * ставим автокомит фолс
 * делаем что то с базой
 * если дошли до конца то комитим
 * если ексепшн то ролбечим 
 */

public class Transaction {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/sqlex";
        String username = "postgres";
        String password = "password";
        Class.forName("org.postgresql.Driver"); // ??????
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            connection.setAutoCommit(false); // commit need

            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id serial primary key, name varchar(90))");
            statement.executeUpdate("insert into Books (name) values ('Java')");
            statement.executeUpdate("insert into Books (name) values ('Algoritm')");
//            Savepoint s1 = connection.setSavepoint();  // name savepoint = s1
            statement.executeUpdate("insert into Books (name) values  ('Some Book')");

//            connection.rollback(s1);
            connection.commit();
//                connection.releaseSavepoint(s1);

        } catch (SQLException e) {
            connection.rollback();
        }
    }
}
