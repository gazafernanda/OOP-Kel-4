import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public List<User> find(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection) {
        List<String[]> userData = connection.readData();
        users.clear();

        for (String[] row : userData) {
            User user = new User(Integer.parseInt(row[0]), row[1], row[2], row[3]);
            users.add(user);
        }

        List<User> result = new ArrayList<>();

        if (joinTable && joinTableName != null) {
            List<Team> teams = new TeamRepository().find(null, null, false, null, connection);

            for (User user : users) {
                for (Team team : teams) {
                    if (user.getTeamName().equals(team.getName())) {
                        result.add(user);
                    }
                }
            }
        } else {
            for (User user : users) {
                if (user.getName().equals(conditions[2])) {
                    result.add(user);
                }
            }
        }

        return result;
    }

    public User findOne(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection) {
        List<User> result = find(column, conditions, joinTable, joinTableName, connection);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public User insert(String[] data, Connection connection) {
        List<String[]> userData = connection.readData();
        int newId = userData.size() + 1; 
        User newUser = new User(newId, data[0], data[1], data[2]);
        users.add(newUser);
        userData.add(new String[]{String.valueOf(newId), data[0], data[1], data[2]});
        connection.writeData(userData);

        return newUser;
    }
}

