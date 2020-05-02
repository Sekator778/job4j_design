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
            statement.executeUpdate("insert into Books (name) values ('Bible'), ('Algoritm'), ('Some Book')");

            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            PreparedStatement preparedStatement = connection.prepareStatement("sql", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement1.executeQuery("select * from books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("make manipulation with our row in table");
            resultSet.last();
            resultSet.updateString("name", "UpdateBook");
            resultSet.updateRow();
            // insert some record
            resultSet.moveToInsertRow();
            resultSet.updateString("name", "Insert some Row");
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
//переходим на какую строку и удаляем ее
            resultSet.absolute(2);
            resultSet.deleteRow();
            // на первую
            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }

//            CallableStatement callableStatement = connection.prepareCall("{call }")


        }
    }
}
