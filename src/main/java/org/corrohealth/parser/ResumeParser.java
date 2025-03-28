package org.corrohealth.parser;


import org.corrohealth.models.Candidate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ResumeParser {

  public static List<Candidate> parseResume(File resumeFile) {
    System.out.println("Parsing resume: " + resumeFile.getName());

    // Read resume text from a .txt file
    return extractTextFromTxt(resumeFile);

  }

  // Extract text from a TXT file
  public static List<Candidate> extractTextFromTxt(File file) {
    List<Candidate> candidateList = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        try {
          String[] words = line.split(",");
          if (words.length >= 4) {
            Candidate candidate = new Candidate();
            candidate.setName(words[0].trim());
            candidate.setTitle(words[1].trim());
            candidate.setExperience(Integer.parseInt(words[2].trim()));
            String skillListCommaSeparated = words[3].trim();
            String[] skills = skillListCommaSeparated.split("\\s");
            List<String> skillList = new ArrayList<>();
            skillList.addAll(Arrays.asList(skills));
            candidate.setSkills(skillList);
            candidateList.add(candidate);

          }
        } catch (Exception e) {
          System.out.println("Wrong format - " + line);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: Resume file not found.");
    }
    return candidateList;
  }

}
