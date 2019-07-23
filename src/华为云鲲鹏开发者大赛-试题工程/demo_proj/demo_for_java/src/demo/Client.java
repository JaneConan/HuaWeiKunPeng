package demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import map.*;

import java.util.ArrayList;
import java.util.List;
import demo.Team;
import cmd.Action;
import cmd.RoundAction;

public class Client {
	private int team_id = 0;
	private String team_name = "";
	private Team self = null;
	private Team enemy = null;
	private int roundId = 0;
	private String mode = null;
	private int moveIdx = 0;
	private List<String> moves = new ArrayList<String>();
	private List<Player> players = new ArrayList<Player>();

	public Client(int team_id, String team_name) {
		this.team_id = team_id;
		this.team_name = team_name;
		moves.add("up");
		moves.add("right");
		moves.add("down");
		moves.add("left");
	}

	public void legStart(JSONObject data) {
		System.out.println("leg start");

		JSONObject map = data.getJSONObject("map");

		int width = map.getInt("width");
		int height = map.getInt("height");
		int vision = map.getInt("vision");
		System.out.printf("map width:%d, map height %d, map vision %d\n", width, height, vision);

		try {
			JSONArray meteorArray  = map.getJSONArray("meteor");
			for (int i = 0; i < meteorArray.size(); i++) {
				JSONObject object = meteorArray.getJSONObject(i);
				Meteor meteor = new Meteor(object);
			}			
		}
		catch (Exception e) {
			System.out.printf("donot get meteor");
		}
		
		
		try {
		JSONArray cloudArray = map.getJSONArray("cloud");
		for (int i = 0; i < cloudArray.size(); i++) {
			JSONObject object = cloudArray.getJSONObject(i);
			Cloud cloud = new Cloud(object);
		}
		}
		catch (Exception e) {
			System.out.printf("donot get cloud");
		}
		
		try {		
			JSONArray tunnelArray = map.getJSONArray("tunnel");
			for (int i = 0; i < tunnelArray.size(); i++) {
				JSONObject object = tunnelArray.getJSONObject(i);
				Tunnel tunnel = new Tunnel(object);
			}
		}
		catch (Exception e) {
			System.out.printf("donot get tunnel");
		}
		
		try {		
			JSONArray wormholeArray = map.getJSONArray("wormhole");
			for (int i = 0; i < wormholeArray.size(); i++) {
				JSONObject object = wormholeArray.getJSONObject(i);
				Wormhole wormhole = new Wormhole(object);
			}
		}
		catch (Exception e) {
			System.out.printf("donot get wormhole");
		}

		try {		
			JSONArray teams = data.getJSONArray("teams");
	
			for (int i = 0; i < 2; i++) {
				JSONObject team = teams.getJSONObject(i);
				int team_id = team.getInt("id");
				if (this.team_id == team_id) {
					System.out.println("self team");
					this.self = new Team(team);
				} else {
					System.out.println("enemy team");
					this.enemy = new Team(team);
				}
			}
		}
		catch (Exception e) {
			System.out.printf("donot get teams");
		}
	}

	public void legEnd(JSONObject data) {
		System.out.println("leg end");

		try {
			JSONArray results = data.getJSONArray("teams");
			for (int i = 0; i < results.size(); i++) {
				Result result = new Result(results.getJSONObject(i));
			}
		}
		catch (Exception e) {
			System.out.printf("donot get legEnd teams");
		}
	}

	public void round(JSONObject data) {
		this.roundId = data.getInt("round_id");
		this.mode = data.getString("mode");
		System.out.printf("round %d, mode %s\n", this.roundId, this.mode);

		try {
			JSONArray powerArray = data.getJSONArray("power");
			for (int i = 0; i < powerArray.size(); i++) {
				JSONObject object = powerArray.getJSONObject(i);
				Power power = new Power(object);
			}
		}
		catch (Exception e) {
			System.out.printf("donot get round power");
		}

		try {
			this.players.clear();
			JSONArray players = data.getJSONArray("players");
			for (int i = 0; i < players.size(); i++) {
				JSONObject object = players.getJSONObject(i);
				Player player = new Player(object);
				if (player.getTeam() == this.team_id) {
					this.players.add(player);
				}
			}
		}
		catch (Exception e) {
			System.out.printf("donot get round players");
		}

		try {
			JSONArray scores = data.getJSONArray("teams");
			for (int i = 0; i < scores.size(); i++) {
				JSONObject object = scores.getJSONObject(i);
				Score score = new Score(object);
			}
		}
		catch (Exception e) {
			System.out.printf("donot get round teams");
		}
	}

	private int getIdx()
	{
		int idx = moveIdx % 4;
		moveIdx ++;
		
		return idx;
	}
	public RoundAction act() {
		List<Action> actions = new ArrayList<Action>();
		int idx = getIdx();
		for(Player player : this.players)
		{
			actions.add(new Action(player.getTeam(), player.getId(), moves.get(idx)));
		}
		
		RoundAction roundAction = new RoundAction(this.roundId, actions);
		return roundAction;
	}

}
