package org.corrohealth.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResumeParserTest {

  @Test
  public void testExtractPhoneNumber() {
    // Test with a valid phone number with +
    String input = "+1234567890";
    String expected = "1234567890";
    String actual = ResumeParser.extractPhoneNumber(input);
    assertEquals(expected, actual);

    // Test with a valid phone number without +
    input = "1234567890";
    expected = null; // Since the regex expects a + sign
    actual = ResumeParser.extractPhoneNumber(input);
    assertEquals(expected, actual);

    // Test with an invalid phone number
    input = "+abc123";
    expected = null;
    actual = ResumeParser.extractPhoneNumber(input);
    assertEquals(expected, actual);

    // Test with an empty string
    input = "";
    expected = null;
    actual = ResumeParser.extractPhoneNumber(input);
    assertEquals(expected, actual);

    // Test with a null input
    input = null;
    expected = null;
    actual = ResumeParser.extractPhoneNumber(input);
    assertEquals(expected, actual);
  }
}