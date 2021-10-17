package com.task.planner;

public class Feature extends Task{

    private String featureSummary;
    private FeatureImpact impact;

    public Feature(String title, String creator, String assignee, TaskStatus status,
                   String type, String duedate, String featureSummary, FeatureImpact impact) {
        super(title, creator, assignee, status, type, duedate);
        this.featureSummary = featureSummary;
        this.impact = impact;
    }

    public enum FeatureImpact {
        LOW, MEDIUM, HIGH, UNKNOWN
    }
}
