package team;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class Team {
    private String name;
    private int played;
    private int won;
    private int lost;
    private int tied;

    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addPlayer(Player player) {
        if(members.contains(player)){
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team opponent, int ourScore, int theirScore){
        if(ourScore > theirScore)
            won++;
        else if(ourScore == theirScore)
            tied++;
        else
            lost++;
        played++;
        if(opponent != null){
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }
}
