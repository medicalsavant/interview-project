package org.corrohealth.models;

import java.util.List;

public class Job {
  private String title;
  private List<String> requiredSkills;
  private int minExperience;

  public Job(String title, List<String> requiredSkills, int minExperience) {
    this.title = title;
    this.requiredSkills = requiredSkills;
    this.minExperience = minExperience;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getRequiredSkills() {
    return requiredSkills;
  }

  public int getMinExperience() {
    return minExperience;
  }

  @Override
  public String toString() {
    return "Job: " + title + ", Required Skills: " + requiredSkills + ", Min Experience: " + minExperience + " years";
  }
}
