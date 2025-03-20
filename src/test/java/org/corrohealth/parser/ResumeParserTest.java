package org.corrohealth.parser;

import org.corrohealth.models.Candidate;
import org.corrohealth.parser.ResumeParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResumeParserTest {

  @Test
  public void testExtractTextFromTxt() {
    // Create a sample input file
    File inputFile = new File("src/test/resources/sample_input.txt");

    // Call the method to test
    List<Candidate> candidates = ResumeParser.extractTextFromTxt(inputFile);

    // Verify the results
    assertNotNull(candidates);
    assertEquals(3, candidates.size());

    Candidate candidate1 = candidates.get(0);
    assertEquals("Steve Smith", candidate1.getName());
    assertEquals("Java, Spring, Hibernate", String.join(", ", candidate1.getSkills()));
    assertEquals(5, candidate1.getExperience());

    Candidate candidate2 = candidates.get(1);
    assertEquals("John Doe", candidate2.getName());
    assertEquals("Python, Numpy, MangoDB", String.join(", ", candidate2.getSkills()));
    assertEquals(5, candidate2.getExperience());

    Candidate candidate3 = candidates.get(2);
    assertEquals("Sara Smith", candidate3.getName());
    assertEquals("AWS, Dockers, Kubernetes", String.join(", ", candidate3.getSkills()));
    assertEquals(5, candidate3.getExperience());
  }
}