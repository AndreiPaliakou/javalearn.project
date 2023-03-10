package com.apaliakou.homework0802;

public enum SkillsEnum {

    WORKER_concrete_bricklayer("CONCRETE_BRICKLAYER"),
    WORKER_welder_fitter("WELDER_FITTER"),
    WORKER_plasterer_painter("PLASTERER_PAINTER"),
    WORKER_loader_laborer("LOADER_LABORER"),
    WORKER_concrete("CONCRETE"),
    WORKER_bricklayer("BRICKLAYER"),
    WORKER_welder("WELDER"),
    WORKER_fitter("FITTER"),
    WORKER_plasterer("PLASTERER"),
    WORKER_painter("PAINTER"),
    WORKER_plumber("PLUMBER"),
    WORKER_electrician("ELECTRICIAN"),
    WORKER_loader("LOADER"),
    WORKER_laborer("LABORER");

    final String skills;

    SkillsEnum(String skills) {
        this.skills = skills;
    }
}
