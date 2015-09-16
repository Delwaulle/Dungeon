package game;

public class Monster {
	
	private String name;
	private int damages=2;
	private Item[] drop=new Item[]{new Potion("Health's potion",2)};
	
	public Monster(String name){
		this.name=name;
	}
	
	public Monster (String name,int damages){
		this.name=name;
		this.damages=damages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

	//add the drop table to the player inventory's
	public void getDrop() {
		for(int i=0;i<drop.length;i++){
			GameBoard.player.getInventory().addItem(drop[i]);
			System.out.println(drop[i].toString());
		}
		
	}
	

}
