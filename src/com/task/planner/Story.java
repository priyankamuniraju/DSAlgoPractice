package com.task.planner;

import java.util.Objects;

public class Story extends Task {
    private String storySummary;
    private int storyPoints;


    public Story(String title, String creator, String assignee, TaskStatus status,
                 String type, String duedate, String storySummary, int storyPoints) {
        super(title, creator, assignee, status, type, duedate);
        this.storySummary = storySummary;
        this.storyPoints = storyPoints;
    }

    public String getStorySummary() {
        return storySummary;
    }

    public void setStorySummary(String storySummary) {
        this.storySummary = storySummary;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Story story = (Story) o;
        return storyPoints == story.storyPoints && Objects.equals(storySummary, story.storySummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storySummary, storyPoints);
    }
}
