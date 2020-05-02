package mysql;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * lesson 196 https://www.youtube.com/watch?v=Pp6CzZYpTQI&list=PL786bPIlqEjRDXpAKYbzpdTaOYsWyjtCX&index=198
 * !!!! не прокидывай ексепшн отбрабатывай тут просто не это учим !!!!
 * result set постоянно требует соединение с базой
 * чтобы это не делать мы можем за раз все выгребти себе в CachedRowSet
 * через RowSetFactory она фабрика может выгребать по разному
 */

public class CacheForResultSet {
    static String url = "jdbc:postgresql://localhost:5432/sqlex";
    static String username = "postgres";
    static String password = "password";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id")); // name
            System.out.println(resultSet.getString(2)); // id column
        }


    }

    static ResultSet getData() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // ??????
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) { // look his open statement
            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id serial primary key, name varchar(90))");
            statement.executeUpdate("insert into Books (name) values ('Bible'), ('Algoritm'), ('Some Book')");
//================
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();


            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet output = st.executeQuery("select * from books");

            cachedRowSet.populate(output);
            return cachedRowSet;
        }
    }
}
