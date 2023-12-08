import java.util.ArrayList;
import java.util.List;

public class TeamRepository implements Repository<Team> {
    private List<Team> teams;

    public TeamRepository() {
        this.teams = new ArrayList<>();
    }

    
    public List<Team> find(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection) {
        List<String[]> teamData = connection.readData();
        teams.clear(); 

        for (String[] row : teamData) {
            Team team = new Team(Integer.parseInt(row[0]), row[1]);
            teams.add(team);
        }

        List<Team> result = new ArrayList<>();
        if (conditions != null && conditions.length > 0 && conditions[2] != null) {
            for (Team team : teams) {
                if (team.getName().equals(conditions[2])) {
                    result.add(team);
                }
            }
        } else {
            result.addAll(teams);
        }

        return result;
    }

    public Team findOne(String column, String[] conditions, boolean joinTable, String joinTableName, Connection connection) {
        List<Team> result = find(column, conditions, joinTable, joinTableName, connection);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

  
    public Team insert(String[] data, Connection connection) {
        List<String[]> teamData = connection.readData();
        int newId = teamData.size() + 1; 
        Team newTeam = new Team(newId, data[0]);
        teams.add(newTeam);
        teamData.add(new String[]{String.valueOf(newId), data[0]});
        connection.writeData(teamData);

        return newTeam;
    }
}