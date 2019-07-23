package map;

import net.sf.json.JSONObject;

public class Wormhole {
	private int x;
	private int y;
	private String name;
	public Wormhole(JSONObject object) {
		this.x = object.getInt("x");
		this.y = object.getInt("y");
		this.name = object.getString("name");
		System.out.printf("wormhole x %d, y %d, name %s\n", this.x, this.y, this.name);
		
	}

}
