package team;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class Team<T extends Player> { // How do we limit it to subclasses?
// public class Team<T extends Player & Coach & Manager> { = This is how you would use multiple bounds. The last two
// would have to be interfaces.
    private String name;
    private int played;
    private int won;
    private int lost;
    private int tied;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addPlayer(T player) {
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

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){ // Generic to avoid matches between different sports
        String message;
        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        }
        else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        }
        else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);   // null => avoid infinite loop
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }
}
