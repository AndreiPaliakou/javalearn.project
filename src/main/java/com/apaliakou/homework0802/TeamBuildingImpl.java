package com.apaliakou.homework0802;

public class TeamBuildingImpl implements TeamBuilder {

    Team team = new Team();

    @Override
    public TeamBuilder setTeamName(String newTeamName) {
        team.teamName = newTeamName;
        return this;
    }

    @Override
    public TeamBuilder setTeamServiceOffer(double newTeamServiceOffer) {
        team.teamServiceOffer = newTeamServiceOffer;
        return this;
    }

    @Override
    public TeamBuilder setTeamWorkersList(SkillsEnum[] newTeamWorkersList) {
        team.teamWorkersList = newTeamWorkersList;
        return this;
    }

    @Override
    public Team build() {
        return team;
    }
}
