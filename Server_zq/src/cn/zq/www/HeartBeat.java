package cn.zq.www;

public class HeartBeat {
	private static String idprefix = "#mj";
	private char[] id = null;
	private char state;
	private char doorstate;
	private char[] groupID = null;
	private static String suffix = "u";
	
	
	public HeartBeat(String id, char state, char doorstate, String groupID){
		this.id = id.toCharArray();
		this.state = state;
		this.doorstate = doorstate;
		this.groupID = groupID.toCharArray();
	}
	//message = "#mj2011102701,1,1,000000,u" 
	// strs = {""}
	public HeartBeat(String message){
		String[] strs = message.split(",");
		id = strs[0].substring(3).toCharArray();
		state = strs[1].charAt(0);
		doorstate = strs[2].charAt(0);
		groupID = strs[3].toCharArray();
	}
	
	public String toString(){
		String result = null;
		
		result = idprefix;
		result += String.valueOf(id);
		result += ",";
		result += String.valueOf(state);
		result += ",";
		result += String.valueOf(doorstate);
		result += ",";
		result += String.valueOf(groupID);
		result += ",";
		result += suffix;
		
		return result;
		
	}
	public char[] getId() {
		return id;
	}
	public void setId(char[] id) {
		this.id = id;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public char getDoorstate() {
		return doorstate;
	}
	public void setDoorstate(char doorstate) {
		this.doorstate = doorstate;
	}
	public char[] getGroupID() {
		return groupID;
	}
	public void setGroupID(char[] groupID) {
		this.groupID = groupID;
	}
}
