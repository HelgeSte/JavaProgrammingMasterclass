package team;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("L.A Galaxy");
        soccerPlayerTeam.addPlayer(beckham);

        /*Team<String> brokenTeam = new Team("this won't work");
        brokenTeam.addPlayer("NoOne"); // Should not be able to add a String */

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorne = new Team<>("Hawthorne");
        Team<FootballPlayer> freemantle = new Team("Freemantle");

        hawthorne.matchResult(freemantle, 1,1);
        hawthorne.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(freemantle, 2, 1);
        adelaideCrows.matchResult(hawthorne, 5, 5);
        melbourne.matchResult(adelaideCrows, 2, 0);

        ArrayList<Team<FootballPlayer>> footballTeams = new ArrayList<>();
        footballTeams.add(melbourne);
        footballTeams.add(freemantle);
        footballTeams.add(hawthorne);
        System.out.println("\nStandings:");
        footballTeams.stream()
                .sorted()
                .forEach(t -> System.out.println(t.getName() + ": " + t.ranking()));
    }
}