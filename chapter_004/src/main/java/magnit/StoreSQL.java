//package magnit;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//public class StoreSQL implements AutoCloseable {
//    private final Config config;
//    private Connection connect;
//
//    public StoreSQL(Config config) {
//        this.config = config;
//    }
//
//    /**
//     *    метод generate(int size) - генерирует в базе данных n записей.
//     *    описывается схемой
//     *    create table entry {
//     *          field integer;
//     *    }
//     * @param size - size
//     */
//    public void generate(int size) {
//
//
//    }
//
//    public List<Map.Entry> load() {
//        List<Map.Entry> entries = new ArrayList<>();
//        try (Statement statement = connect.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("select entry");
//            while (resultSet.next()) {
//                Map.Entry entry = new Map.Entry(resultSet.getInt("field"));
//                entries.add(entry);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Collections.EMPTY_LIST;
//    }
//
//    @Override
//    public void close() throws Exception {
//        if (connect != null) {
//            connect.close();
//        }
//    }
//}