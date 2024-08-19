package com.codeitsuisse2023.javatemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EvaluationRequest {
    @JsonProperty("callbackUrl")
    private String callbackUrl;

    @JsonProperty("runId")
    private String runId;

    @JsonProperty("teamUrl")
    private String teamUrl;

    public EvaluationRequest(String callbackUrl, String runId, String teamUrl) {
        this.callbackUrl = callbackUrl;
        this.runId = runId;
        this.teamUrl = teamUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getTeamUrl() {
        return teamUrl;
    }

    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    @Override
    public String toString() {
        return "EvaluationRequest{" +
                "callbackUrl='" + callbackUrl + '\'' +
                ", runId='" + runId + '\'' +
                ", teamUrl='" + teamUrl + '\'' +
                '}';
    }
}
