package mysql;

import java.sql.*;

/**
 *
 */

public class TextMax {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/sqlex";
        String username = "postgres";
        String password = "password";
        Class.forName("org.postgresql.Driver"); // ??????
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id serial primary key, name varchar(90))");
            statement.executeUpdate("insert into Books (name) values ('Bible'), ('Mathematice')");

//            CallableStatement callableStatement = connection.prepareCall("{call }")


        }
    }
}
