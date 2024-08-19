package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: change this class based on expected JSON payload received from participant teams
public class TeamSolution {
    @JsonProperty("value")
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // TODO: update this accordingly
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TeamSolution)) {
            return false;
        } else {
            return this.value == ((TeamSolution) obj).value;
        }
    }
}
