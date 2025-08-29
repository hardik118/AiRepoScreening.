package com.example.AiRepoScrening.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackProducerResult {

    private Long submissionId;
    private Map<String, List<IssueItem>> errors;
    private Map<String, java.util.List<IssueItem>> improvements;
    private Map<String, java.util.List<IssueItem>> thingsDoneRight;
    private java.util.List<String> generalComments;
}


