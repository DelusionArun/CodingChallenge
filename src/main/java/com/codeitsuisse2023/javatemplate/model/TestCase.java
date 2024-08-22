package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.stream.IntStream;

// TODO: change this class based on expected JSON payload to send to participant teams
public class TestCase {
    @JsonProperty("monsters")
    private int[] monsters;

    public int[] getMonsters() {
        return monsters;
    }

    public void setMonsters(int[] monstersArray) {
        this.monsters = new int[monstersArray.length];
        IntStream.range(0, monsters.length).forEach(i -> monsters[i] = monstersArray[i]);
    }
}
