
public class Team extends Model {
	    private String name;

	    public Team(int id, String name) {
	        super(id);
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
	}

