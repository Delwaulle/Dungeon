package dungeon.actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ActionFactory {
	
	private Map<String,Action> decors;
	
	public ActionFactory(){
		this.decors = new HashMap<>();
		this.decors.put("Carpet", new CarpetAction());
	}
	
	
	public void executeAction(String key){
		if ( this.decors.containsKey(key) ) {
			this.decors.get(key).apply();
		}
	}
	
	/**
	 * set the decor of a room
	 * @param name
	 * @param action
	 */
	public void addDecor(String name,Action action){
		this.decors.put(name,action);
	}

	public Map<String, Action> getDecors() {
		return decors;
	}

	public void setDecors(Map<String, Action> decors) {
		this.decors = decors;
	}
	
	
	/**
	 * @return all the actions
	 */
	public String toString(){
		String allActionsString="Elements of the room / action : ";
		Set<String> listKeys=this.decors.keySet();  // key list of the map
		Iterator<String> iterateur=listKeys.iterator(); 
		while(iterateur.hasNext())
		{
			String nextName=iterateur.next();
			allActionsString+="\n"+nextName+" / "+this.decors.get(nextName).toString();
		}
		
		return allActionsString;
	}

}
