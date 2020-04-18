import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class SQLStorage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/car_storage";
        String username = "postgres";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

            //update ============
//            PreparedStatement st = conn.prepareStatement("update car set name = ? where car_id = ?");
//            st.setString(1, "update name car");
//            st.setInt(2, 7);
//            st.executeUpdate();

            // insert===========
//            PreparedStatement st = conn.prepareStatement("insert into car (name, body_car_id, motor_car_id, transmission_car_id) values (?, ?, ?, ?)");
//
//            st.setString(1, "new Java");
//            st.setInt(2, 1);
//            st.setInt(3, 2);
//            st.setInt(4, 2);
//            st.executeUpdate();

            //select==========
//            PreparedStatement st = conn.prepareStatement("SELECT * FROM car as c where c.car_id in (?, ?)");
//                st.setInt(1, 4);
//                st.setInt(2, 3);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                System.out.printf("%s %s" + "\n", rs.getString("name"), rs.getString("body_car_id"));
//            }
//            rs.close();
//            st.close();

            //delete ===================
//            PreparedStatement st = conn.prepareStatement("delete from car where car_id = ?");
//            st.setInt(1, 7);
//            st.executeUpdate();

            //insert + result =====
            PreparedStatement st = conn.prepareStatement("insert into car (name, body_car_id, motor_car_id, transmission_car_id) values (?, ?, ?, ?)");

            st.setString(1, "best Java car222");
            st.setInt(2, 1);
            st.setInt(3, 1);
            st.setInt(4, 1);
            st.executeUpdate();
            ResultSet resultSet = st.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("any");
                System.out.println(resultSet.getInt(1));
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}