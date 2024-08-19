package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EvaluationScore {

    @JsonProperty("message")
    private String message;
    @JsonProperty("runId")
    private String runId;
    @JsonProperty("score")
    private BigDecimal score;

    public EvaluationScore(String message, String runId, BigDecimal score) {
        this.message = message;
        this.runId = runId;
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "EvaluationScore{" +
                "message='" + message + '\'' +
                ", runId='" + runId + '\'' +
                ", score=" + score +
                '}';
    }
}
