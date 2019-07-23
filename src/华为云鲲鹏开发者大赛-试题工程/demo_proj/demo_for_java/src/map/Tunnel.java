package map;

import net.sf.json.JSONObject;

public class Tunnel {
	private int x;
	private int y;
	private String direction;
	public Tunnel(JSONObject object) {
		this.x = object.getInt("x");
		this.y = object.getInt("y");
		this.direction = object.getString("direction");
		System.out.printf("tunnel x %d, y %d, direction %s\n", this.x, this.y, this.direction);
		
	}

}
