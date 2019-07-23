package map;

import net.sf.json.JSONObject;

public class Cloud {
	private int x;
	private int y;
	public Cloud(JSONObject object) {
		this.x = object.getInt("x");
		this.y = object.getInt("y");
		System.out.printf("cloud x %d, y %d\n", this.x, this.y);
		
	}

}
