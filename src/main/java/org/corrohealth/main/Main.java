package org.corrohealth.main;

import org.corrohealth.matcher.JobMatcher;
import org.corrohealth.models.Candidate;
import org.corrohealth.models.Job;
import org.corrohealth.parser.ResumeParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    PrintStream fileOut = new PrintStream("src/main/resources/output.txt");
    String inputfilepath = "src/main/resources/input.txt";
    File file = new File(inputfilepath);

    List<Candidate> candidate = ResumeParser.parseResume(file);

    List<Job> jobs = Arrays.asList(
            new Job("Python Developer", Arrays.asList("Python", "Numpy", "MangoDB"), 5),
            new Job("Java Full Stack Developer", Arrays.asList("Java", "Spring", "Hibernate", "AWS", "SQL", "React.js", "Spring-Boot"), 5),
            new Job("Senior Cloud Architect", Arrays.asList("AWS", "Dockers", "Kubernetes"), 5)

    );

    fileOut.println("\nCandidate List:\n");
    candidate.forEach(fileOut::println);

    fileOut.println("---------------------------------------------------------------");

    fileOut.println("\n Checking Job Matches : \n");
    fileOut.println("---------------------------------------------------------------");
    JobMatcher.matchJobs(candidate, jobs);




  }
}


















