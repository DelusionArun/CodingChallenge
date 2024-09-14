package com.codeitsuisse2023.javatemplate.service;

import com.codeitsuisse2023.javatemplate.model.EvaluationRequest;
import com.codeitsuisse2023.javatemplate.model.EvaluationScore;
import com.codeitsuisse2023.javatemplate.model.TeamSolution;
import com.codeitsuisse2023.javatemplate.model.TestCase;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
public class EvaluationService {
    // TODO: update token
    private final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb2RlaXRzdWlzc2UyMDIyQGdtYWlsLmNvbSIsImV4cCI6MTczMDMwNDAwMH0.trNElwseK8QUiYli1kqqs5vJj4Kits4aCrVeIyBxPFwwLqhnegejYJhYQeCrETtrzq_JpIE1dvCMfvrRI5sHTA";

    // TODO: update challenge path
    private final String CHALLENGE_PATH = "efficient-hunter-kazuma";
    private final long CONNECT_TIMEOUT_DURATION = 10L;
    private final long READ_TIMEOUT_DURATION = 5L;
    private final Integer[] TEST_CASE_SCORES = new Integer[] { 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5 }; // sum up to 100

    private final List<TestCase> TEST_CASES = createTestCases();

    private final RestTemplate restTemplate = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds(CONNECT_TIMEOUT_DURATION))
            .setReadTimeout(Duration.ofSeconds(READ_TIMEOUT_DURATION))
            .build();

    private List<TestCase> createTestCases() {
        List<TestCase> testCases = new ArrayList<>();
        TestCase testCase1 = new TestCase();
        TestCase testCase2 = new TestCase();
        TestCase testCase3 = new TestCase();
        TestCase testCase4 = new TestCase();
        TestCase testCase5 = new TestCase();
        TestCase testCase6 = new TestCase();
        TestCase testCase7 = new TestCase();
        TestCase testCase8 = new TestCase();
        TestCase testCase9 = new TestCase();
        TestCase testCase10 = new TestCase();
        TestCase testCase11 = new TestCase();
        TestCase testCase12 = new TestCase();
        TestCase testCase13 = new TestCase();
        TestCase testCase14 = new TestCase();
        TestCase testCase15 = new TestCase();
        TestCase testCase16 = new TestCase();
        TestCase testCase17 = new TestCase();
        TestCase testCase18 = new TestCase();
        TestCase testCase19 = new TestCase();
        TestCase testCase20 = new TestCase();
        testCase1.setMonsters(IntStream.range(0, 4).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase2.setMonsters(IntStream.range(0, 5).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase3.setMonsters(new int[] {1});
        testCase4.setMonsters(IntStream.range(0, 8).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase5.setMonsters(new int[] {143,144,145,1,899,900});
        testCase6.setMonsters(IntStream.range(0, 5).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase7.setMonsters(IntStream.range(0, 3).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase8.setMonsters(IntStream.range(0, 6).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase9.setMonsters(new int[] {9,4,2,1,45,21,43});
        testCase10.setMonsters(IntStream.range(0, 14).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase11.setMonsters(new int[] {239,248,294,294,499,28,589,923,394,295,58});
        testCase12.setMonsters(new int[] {143,144,145,1,899,900});
        testCase13.setMonsters(IntStream.range(0, 10).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase14.setMonsters(new int[] {5,4,3,2,1});
        testCase15.setMonsters(IntStream.range(0, 15).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase16.setMonsters(new int[] {500,1,4,10,201});
        testCase17.setMonsters(IntStream.range(0, 14).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase18.setMonsters(new int[] {500,600,1,4,10});
        testCase19.setMonsters(IntStream.range(0, 7).map(i -> (new Random()).nextInt(1001)).toArray());
        testCase20.setMonsters(new int[] {0,900,0,999,0,998});
        testCases.add(testCase1); 
        testCases.add(testCase2); 
        testCases.add(testCase3); 
        testCases.add(testCase4); 
        testCases.add(testCase5); 
        testCases.add(testCase6); 
        testCases.add(testCase7); 
        testCases.add(testCase8); 
        testCases.add(testCase9); 
        testCases.add(testCase10); 
        testCases.add(testCase11); 
        testCases.add(testCase12); 
        testCases.add(testCase13); 
        testCases.add(testCase14); 
        testCases.add(testCase15); 
        testCases.add(testCase16); 
        testCases.add(testCase17); 
        testCases.add(testCase18); 
        testCases.add(testCase19); 
        testCases.add(testCase20); 

        return testCases;
    }
    public void evaluate(EvaluationRequest evaluationRequest) {
        EvaluationScore evaluationScore;

        try {
            List<TeamSolution> teamSolutions = executeTeamSolution(TEST_CASES, evaluationRequest.getTeamUrl());

            if (teamSolutions.size() == TEST_CASES.size()) {
                evaluationScore = tabulateScore(
                    evaluationRequest.getRunId(),
                    TEST_CASES,
                    teamSolutions
                );
            } else {
                evaluationScore = new EvaluationScore(
                    "Number of returned solutions does not match number of test cases",
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
                );
            }

        } catch (HttpServerErrorException.ServiceUnavailable hse){
            String message = String.format("[%s] connection timeout when calling teamUrl [%s]", evaluationRequest.getRunId(), evaluationRequest.getTeamUrl());
            System.out.println(message);
            evaluationScore = new EvaluationScore(
                    message,
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
            );
        } catch (HttpServerErrorException hse) {
            String message = String.format("[%s] HttpServerErrorException when calling teamUrl [%s] with status code [%s]", evaluationRequest.getRunId(), evaluationRequest.getTeamUrl(), hse.getStatusCode());
            System.out.println(message);
            evaluationScore = new EvaluationScore(
                    message,
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
            );
        } catch (HttpClientErrorException hce) {
            String message = String.format("[%s] HttpClientErrorException when calling teamUrl [%s] with status code [%s]", evaluationRequest.getRunId(), evaluationRequest.getTeamUrl(), hce.getStatusCode());
            System.out.println(message);
            evaluationScore = new EvaluationScore(
                    message,
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
            );
        } catch (RuntimeException ex) {
            System.out.printf("[%s] RuntimeException: %s\n",  evaluationRequest.getRunId(), ex);
            evaluationScore = new EvaluationScore(
                    ex.getMessage(),
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
            );
        } catch (Throwable t) {
            System.out.printf("[%s] Error: %s\n",  evaluationRequest.getRunId(), t);
            evaluationScore = new EvaluationScore(
                    "Uncaught exception",
                    evaluationRequest.getRunId(),
                    BigDecimal.ZERO
            );
        }

        postResult(evaluationRequest.getCallbackUrl(), evaluationScore);
    }

    private void postResult(String callbackUrl, EvaluationScore evaluationScore) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(TOKEN);

        var entity = new HttpEntity<>(evaluationScore, headers);

        restTemplate.postForEntity(
            callbackUrl,
            entity,
            String.class
        );
    }

    private List<TeamSolution> executeTeamSolution(List<TestCase> testCases, String teamUrl) {
        String url = fromHttpUrl(teamUrl)
                .path(CHALLENGE_PATH)
                .toUriString();

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(testCases),
                new ParameterizedTypeReference<List<TeamSolution>>() {}
            ).getBody();

//        mock response from challenge server
//        return mockResponseFromTeamServer();
    }

    private EvaluationScore tabulateScore(String runId, List<TestCase> testCases, List<TeamSolution> teamSolutions) {
        List<String> results = new ArrayList<>();

        int finalScore = 0;
        for (int i=0; i<teamSolutions.size(); i++) {
            TeamSolution actual   = teamSolutions.get(i);
            TeamSolution expected = computeSolution(testCases.get(i));
            if (actual.equals(expected)) {
                finalScore += TEST_CASE_SCORES[i];
                results.add(String.format("Test %s: Passed", i+1));
            } else {
                results.add(String.format("Test %s: Failed", i+1));
            }
        }

        return new EvaluationScore(
            String.join(", ", results),
            runId,
            new BigDecimal(finalScore)
        );
    }

    // TODO: implement computing of solution based on test case
    private TeamSolution computeSolution(TestCase testCase) {
        int[] hunts = testCase.getMonsters();
        int numOfHunts = hunts.length;
        int numOfStates = 3;
        long[][] huntArray = new long[numOfHunts][numOfStates];

        huntArray[0][0] = -hunts[0];

        for (int i = 1; i < numOfHunts; i++) {
            huntArray[i][0] = Math.max(huntArray[i - 1][0], huntArray[i - 1][2] - hunts[i]);
            huntArray[i][1] = Math.max(huntArray[i - 1][1], huntArray[i - 1][0] + hunts[i]);
            huntArray[i][2] = huntArray[i - 1][1];
        };

        long efficientHuntCount = huntArray[numOfHunts-1][1];
        TeamSolution teamSolutions = new TeamSolution();
        teamSolutions.setEfficiency(efficientHuntCount);
        return teamSolutions;
    }

    private List<TeamSolution> mockResponseFromTeamServer() {
        List<TeamSolution> response = new ArrayList<>();
        response.add(new TeamSolution());
        response.add(new TeamSolution());
        response.add(new TeamSolution());
        response.add(new TeamSolution());
        response.add(new TeamSolution());
        return response;
    }
}
