package org.corrohealth.matcher;


import org.corrohealth.models.Candidate;
import org.corrohealth.models.Job;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class JobMatcher {

  public static void matchJobs(List<Candidate> candidateList, List<Job> jobList) {
    boolean anyMatch = false;

    try (PrintStream fileOut = new PrintStream(new FileOutputStream("src/main/resources/output.txt", true))) {
      for (Candidate candidate : candidateList) {
        fileOut.println("Candidate Name: "+candidate.getName());
        for (Job job : jobList) {
          List<String> missingSkills = getMissingSkills(candidate, job);
          boolean experienceMismatch = candidate.getExperience() < job.getMinExperience();

          if (missingSkills.isEmpty() && !experienceMismatch) {
            fileOut.println("\n Matched Successfully for : " + job.getTitle());
          } else {

            fileOut.println("\n No Match for : " + job.getTitle());
            if (!missingSkills.isEmpty()) {

              fileOut.println("\n Missing Skills: " + missingSkills);
            }
            if (experienceMismatch) {
              fileOut.println("\n Requires at least " + job.getMinExperience() + " years experience, but candidate has " + candidate.getExperience() + " years experience"); // Line 24
            }
          }

          if (missingSkills.isEmpty() && !experienceMismatch) {
            anyMatch = true;
          }
        }
        fileOut.println("\n---------------------------------------------------------------");
      }

      if (!anyMatch) {
        fileOut.println("\n No suitable jobs found."); // Line 38
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: Unable to create output file.");
    }
  }

  private static List<String> getMissingSkills(Candidate candidate, Job job) {
    List<String> missingSkills = new ArrayList<>();
    for (String requiredSkill : job.getRequiredSkills()) {
      if (!candidate.getSkills().contains(requiredSkill)) {
        missingSkills.add(requiredSkill);
      }
    }
    return missingSkills;
  }
}