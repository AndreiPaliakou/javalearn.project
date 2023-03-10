package com.apaliakou.homework0802;

public interface TeamBuilder {

    TeamBuilder setTeamName(String newTeamName);

    TeamBuilder setTeamServiceOffer(double newTeamServiceOffer);

    TeamBuilder setTeamWorkersList(SkillsEnum[] newTeamWorkersList);

    Team build();
}
