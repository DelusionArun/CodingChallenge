package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: change this class based on expected JSON payload received from participant teams
public class TeamSolution {
    @JsonProperty("efficiency")
    private long efficiency;

    public long getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(long efficiency) {
        this.efficiency = efficiency;
    }

    // TODO: update this accordingly
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TeamSolution)) {
            return false;
        } else {
            return this.efficiency == ((TeamSolution) obj).efficiency;
        }
    }
}
