package com.apaliakou.homework0802;

import static com.apaliakou.homework0802.Team.teamFinalChecking;
import static com.apaliakou.homework0802.Team.teamRequirementsChecking;

public class Main {
    public static void main(String[] args) {

        SkillsEnum[] firstTeamSkills = {SkillsEnum.WORKER_concrete, SkillsEnum.WORKER_bricklayer, SkillsEnum.WORKER_welder, SkillsEnum.WORKER_fitter, SkillsEnum.WORKER_plasterer, SkillsEnum.WORKER_painter, SkillsEnum.WORKER_plumber, SkillsEnum.WORKER_electrician, SkillsEnum.WORKER_loader, SkillsEnum.WORKER_laborer};
        SkillsEnum[] secondTeamSkills = {SkillsEnum.WORKER_concrete, SkillsEnum.WORKER_bricklayer, SkillsEnum.WORKER_welder_fitter, SkillsEnum.WORKER_fitter, SkillsEnum.WORKER_plasterer_painter, SkillsEnum.WORKER_painter, SkillsEnum.WORKER_plumber, SkillsEnum.WORKER_electrician, SkillsEnum.WORKER_loader_laborer, SkillsEnum.WORKER_laborer};
        SkillsEnum[] thirdTeamSkills = {SkillsEnum.WORKER_concrete, SkillsEnum.WORKER_bricklayer, SkillsEnum.WORKER_welder, SkillsEnum.WORKER_fitter, SkillsEnum.WORKER_plasterer, SkillsEnum.WORKER_painter, SkillsEnum.WORKER_plumber, SkillsEnum.WORKER_electrician, SkillsEnum.WORKER_loader, SkillsEnum.WORKER_laborer};

        Team firstTeam = new TeamBuildingImpl()
                .setTeamName("BELARUS BUILDER LTD.CO")
                .setTeamServiceOffer(2000.00)
                .setTeamWorkersList(firstTeamSkills)
                .build();
        firstTeam.getTeamInfo();
        teamRequirementsChecking(firstTeam);
        System.out.println();

        Team secondTeam = new TeamBuildingImpl()
                .setTeamName("GERMANY BUILDER LTD.CO")
                .setTeamServiceOffer(3000.00)
                .setTeamWorkersList(secondTeamSkills)
                .build();
        secondTeam.getTeamInfo();
        teamRequirementsChecking(secondTeam);
        System.out.println();

        Team thirdTeam = new TeamBuildingImpl()
                .setTeamName("USA BUILDER LTD.CO")
                .setTeamServiceOffer(2500.00)
                .setTeamWorkersList(thirdTeamSkills)
                .build();
        thirdTeam.getTeamInfo();
        teamRequirementsChecking(thirdTeam);
        System.out.println();

        System.out.println("The tender winner: \n" + teamFinalChecking());
    }
}