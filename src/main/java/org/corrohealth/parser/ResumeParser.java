package org.corrohealth.parser;


import org.corrohealth.models.Candidate;
import org.corrohealth.models.PersonalDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResumeParser {

  public static List<Candidate> parseResume(File resumeFile) {
    System.out.println("Parsing resume: " + resumeFile.getName());

    // Read resume text from a .txt file
    return extractTextFromTxt(resumeFile);


  }

  // Extract text from a TXT file
  public static List<Candidate> extractTextFromTxt(File file) {
    //  StringBuilder text = new StringBuilder();
    List<Candidate> candidateList = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        //   text.append(scanner.nextLine()).append("\n");
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

            if (words.length == 7) {
              PersonalDetails personalDetails = new PersonalDetails();
              personalDetails.setEmail(words[4].trim());
              personalDetails.setPhone(extractPhoneNumber(words[5].trim()));
              personalDetails.setLocation(words[6].trim());
              candidate.setPersonalDetails(personalDetails);
            }
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

  public static String extractPhoneNumber(String input) {
    // Define the regex pattern to match the phone number

    try {
      String regex = "\\+([0-9]+)";

      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      // Find and extract the phone number without the +
      if (matcher.find()) {
        return matcher.group(1);
      } else {
        return null; // or handle the case where no match is found
      }
    } catch (Exception e) {
      System.out.println("Error: Unable to extract phone number.");

    }
    return null;
  }


}
