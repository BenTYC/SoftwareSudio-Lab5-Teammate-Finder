package netdb.courses.softwarestudio.lab.rpg.player;

public class Player {
	// TODO: fill the Player class with proper fields and methods
	private int id;
	private String login;
	private String name;
	private String profession;
	private int level;
	
	public void setId(int id) {
        this.id = id;
    }
	
	public int getId() {
        return id;
    }
	
	public void setLogin(String login) {
		this.login = login;
    }
	
	public String getLogin() {
        return login;
    }
	
	public void setLevel(int level) {
		this.level = level;
    }
	
	public int getLevel() {
        return level;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
	
    public String getName() {
        return name;
    }
    
    public void setProfession(String profession) {
    	this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }
    
    public String getComplementaryProfession() {
    	if( profession.equals("Mage") )
			return "Warrior";
		if( profession.equals("Archer") )
			return "Thief";
		if( profession.equals("Warrior") )
			return "Mage";
		if( profession.equals("Thief") )
			return "Archer";		
		return null;
    }    
    
	@Override
	public String toString() {		
		// TODO: return the string of the player with the format
		// ${id}/${login}/${profession}/${level}/${name}
		// For example:
		// 12/103062512/Archer/20/CoolBrandon
		return id +"/"+ login +"/"+ profession +"/"+ level +"/"+ name;
	}
}
