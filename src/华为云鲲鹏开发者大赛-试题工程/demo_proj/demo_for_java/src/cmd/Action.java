package cmd;

import java.util.List;
import java.util.ArrayList;

public class Action
{
    private int team;
    private int player_id;
    private List<String> move = new ArrayList<String>();
    
    public Action(int team, int player, String move) {
    	this.team = team;
    	this.player_id = player;
    	this.move.add(move);
    }

    public int getTeam()
    {
        return team;
    }

    public void setTeam(int team)
    {
        this.team = team;
    }

    public int getPlayer_id()
    {
        return player_id;
    }

    public void setPlayer_id(int player_id)
    {
        this.player_id = player_id;
    }

    public List<String> getMove()
    {
        return move;
    }

    public void setMove(List<String> move)
    {
        this.move = move;
    }
}