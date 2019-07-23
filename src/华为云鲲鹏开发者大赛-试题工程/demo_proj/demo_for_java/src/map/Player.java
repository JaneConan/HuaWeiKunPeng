package map;

import net.sf.json.JSONObject;

public class Player {
	private int id;
	private int team;
	private int x;
	private int y;
	private int score;
	private int sleep;
	
	public Player(JSONObject object) {
		this.id = object.getInt("id");
		this.team = object.getInt("team");
		this.x = object.getInt("x");
		this.y = object.getInt("y");
		this.score = object.getInt("score");
		this.sleep = object.getInt("sleep");
		System.out.printf("player id %d team %d x %d, y %d, score %d, sleep %d\n",
				this.id, this.team, this.x, this.y, this.score, this.sleep);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int getTeam()
	{
		return this.team;
	}
}
