package dungeon.action;

public class DecorAction implements Action{	
	private String description;
	private String consequence;
	
	/**
	 * create a decor and its consequence in a room
	 * @param description
	 * @param consequence
	 */
	public DecorAction(String description,String consequence){
		this.setDescription(description);
		this.setConsequence(consequence);
	}

	/**
	 * @return the description of the decor
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * set the description of the decor
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getConsequence() {
		return consequence;
	}

	/**
	 * set the consequence of the decor
	 * @param consequence
	 */
	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}

}
