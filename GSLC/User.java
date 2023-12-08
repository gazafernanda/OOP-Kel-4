
public class User extends Model {
	    private String nim;
	    private String name;
	    private String teamName;

	    public User(int id, String nim, String name, String teamName) {
	        super(id);
	        this.nim = nim;
	        this.name = name;
	        this.teamName = teamName;
	    }

	    public String getNim() {
	        return nim;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getTeamName() {
	        return teamName;
	    }
	}


