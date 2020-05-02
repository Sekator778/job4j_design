package mysql;

import java.sql.*;

/**
 *
 */

public class MethaData {
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

            //======================info about all tables from dataBase
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                System.out.println("info ###### " + resultSet.getCursorName());
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
            //======================info about current tables
            System.out.println("info about current tables");
            ResultSet resultSet1 = statement.executeQuery("select * from books");
            ResultSetMetaData resultSet1MetaData = resultSet1.getMetaData();

            for (int i = 1; i <= resultSet1MetaData.getColumnCount(); i++) {
                System.out.println(resultSet1MetaData.getColumnLabel(i));
                System.out.println(resultSet1MetaData.getColumnType(i));
            }
        }
    }
}
