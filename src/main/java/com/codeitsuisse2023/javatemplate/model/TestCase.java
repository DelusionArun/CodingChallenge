package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.stream.IntStream;

// TODO: change this class based on expected JSON payload to send to participant teams
public class TestCase {
    @JsonProperty("hunts")
    private int[] hunts;

    public int[] getHunts() {
        return hunts;
    }

    public void setHunts(int[] huntArray) {
        this.hunts = new int[huntArray.length];
        IntStream.range(0, hunts.length).forEach(i -> hunts[i] = huntArray[i]);
    }
}
