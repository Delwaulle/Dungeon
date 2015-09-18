package dungeon.action;

public class DecorAction implements Action{	
	private String description;
	private String consequence;
	
	public DecorAction(String description,String consequence){
		this.setDescription(description);
		this.setConsequence(consequence);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConsequence() {
		return consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}

}
