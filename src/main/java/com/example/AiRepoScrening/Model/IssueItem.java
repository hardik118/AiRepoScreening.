package com.example.AiRepoScrening.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueItem {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum IssueSeverity {
        LOW, MEDIUM, HIGH, CRITICAL, ERROR
    }

    private String description;
    private String filePath;
    private Integer lineNumber;
    private String codeContext;
    private IssueSeverity severity = IssueSeverity.MEDIUM;

    public IssueItem(String description, String filePath, Integer lineNumber, String codeContext) {
        this.description = description;
        this.filePath = filePath;
        this.lineNumber = lineNumber;
        this.codeContext = codeContext;
    }
}
