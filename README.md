## Overview

The Job Matcher project is designed to match candidates with suitable job positions based on their skills and experience. The project parses candidate resumes, compares their qualifications with job requirements, and outputs the matching results.

## Features

- Parse candidate resumes from an input file.
- Match candidates with job positions based on skills and experience.
- Output the matching results to a file.

## Task for the project

### Beginning of the interview

**Instructions:**
1. Clone the repository, read the README, read the code, and understand the project structure.
2. Clone the repository using the command: `git clone [inserturl]`.
3. Create your own development branch from the master branch.
4. Do NOT commit.

**Tasks:**
1. Find a bugs and fix it.
2. Write the `PersonalDetails` class.
3. Write a test method for the `testExtractTextFromTxt` method.

## Project Structure

- `src/main/java/org/corrohealth/models/`: Contains the model classes for `Candidate`, `Job`, and `PersonalDetails`.
- `src/main/java/org/corrohealth/parser/`: Contains the `ResumeParser` class for parsing resumes.
- `src/main/java/org/corrohealth/matcher/`: Contains the `JobMatcher` class for matching jobs with candidates.
- `src/main/java/org/corrohealth/main/`: Contains the `Main` class to run the application.
- `src/main/resources/`: Contains the input and output files.

## Getting Started

### Prerequisites

- Java 11 or higher
- Gradle

### Building the Project

To build the project, run the following command:

```sh
gradle build
```