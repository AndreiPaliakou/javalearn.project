package com.apaliakou.homework0802;

import java.util.Arrays;

import static com.apaliakou.homework0802.FinalTeamsComparison.teamList;

public class Team {

    public static final double SERVICE_COST = 3000;
    String teamName;
    double teamServiceOffer;
    SkillsEnum[] teamWorkersList;

    public Team(String teamName, double teamServiceOffer, SkillsEnum[] teamWorkersList) {
        this.teamName = teamName;
        this.teamServiceOffer = teamServiceOffer;
        this.teamWorkersList = teamWorkersList;
    }

    public Team() {
    }

    public double getTeamServiceOffer() {
        return teamServiceOffer;
    }

    void getTeamInfo() {
        System.out.println("Team name is " + teamName + "\nTeam service offer is " + teamServiceOffer + "\nTeam workers list: " + Arrays.toString(teamWorkersList));
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamServiceOffer=" + teamServiceOffer +
                ", teamWorkersList=" + Arrays.toString(teamWorkersList) +
                '}';
    }

    public static SkillsEnum[] teamRequirementsChecking(Team team) {
        int counter = 0;
        for (int i = 4; i < SkillsEnum.values().length; i++) {
            for (int j = 0; j < team.teamWorkersList.length; j++) {
                boolean temp = SkillsEnum.values()[i].equals(team.teamWorkersList[j]);
                if (temp) {
                    counter++;
                }
            }
        }
        if (counter == 10) {
            System.out.println("This team corresponds to the skills and workers quantity requirements!");
            if (team.teamServiceOffer <= SERVICE_COST) {
                System.out.println("This team corresponds to the service cost requirements!");
                teamList.add(team);
                return team.teamWorkersList;
            } else {
                System.out.println("This team does not correspond to the service cost requirements! Remove from the tender!");
                return null;
            }
        } else {
            System.out.println("This team does not correspond to the skills and workers quantity requirements! Remove from the tender!");
            return null;
        }
    }

    public static Team teamFinalChecking() {
        if (teamList != null) {
            double minTeamServiceOffer = 50000;
            Team minCostTeam = null;
            for (Team team : teamList) {
                if (team.getTeamServiceOffer() < minTeamServiceOffer) {
                    minTeamServiceOffer = team.getTeamServiceOffer();
                    minCostTeam = team;
                }
            }
            return minCostTeam;
        } else {
            System.out.println("The tender is closed");
            return null;
        }
    }
}
