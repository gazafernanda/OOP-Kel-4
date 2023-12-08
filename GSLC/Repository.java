import java.util.List;

interface Repository<T> {
    List<T> find(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection);

    T findOne(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection);

    T insert(String[] data, Connection connection);
}