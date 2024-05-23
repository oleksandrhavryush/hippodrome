# Hippodrome Simulation with Testing and Logging

This repository contains a simulation of a horse race (hippodrome) implemented in Java. The project focuses on adding comprehensive testing and logging features to ensure reliability and maintainability. The simulation allows users to track horse movements and determine the winner of the race.

## Project Overview

The project includes several key features:

- **Simulation of Horse Races:** Simulates horse races with multiple horses, tracking their progress and determining the winner.
- **Comprehensive Testing:** Includes a variety of tests for constructors, methods, and overall functionality to ensure robustness.
- **Detailed Logging:** Implements logging for key events and error conditions to facilitate debugging and monitoring.

## Getting Started

To run the application, you need to set up a Java development environment. Follow these steps:

1. **Clone the Repository:** Clone the repository to your local machine.
2. **Open the Project:** Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. **Run the Simulation:** Execute the Main class to start the horse race simulation.

## Code Structure

### Horse Class

**Constructor:**
- Validates input parameters (name, speed, distance) and throws exceptions for invalid values.
- Logs errors and debug information for constructor calls.

**Methods:**
- `getName`: Returns the name of the horse.
- `getSpeed`: Returns the speed of the horse.
- `getDistance`: Returns the distance covered by the horse.
- `move`: Updates the distance based on a random factor and speed, with logging and testing for accuracy.

### Hippodrome Class

**Constructor:**
- Validates the list of horses and throws exceptions for null or empty lists.
- Logs errors and debug information for constructor calls.

**Methods:**
- `getHorses`: Returns the list of horses.
- `move`: Invokes the move method on all horses.
- `getWinner`: Determines the horse that has covered the maximum distance.

### Main Class

**Main Method:**
- Initializes the simulation and logs the start and end of the race.
- Displays the winner and logs relevant information.

## Testing

The project includes the following tests:

### Horse Class Tests

**Constructor:**
- Tests for null and invalid input parameters.
- Checks for appropriate exception messages.

**Get Methods:**
- Verifies correct values are returned by `getName`, `getSpeed`, and `getDistance`.

**Move Method:**
- Ensures the method updates distance correctly based on mocked random values.

### Hippodrome Class Tests

**Constructor:**
- Tests for null and empty list parameters.
- Checks for appropriate exception messages.

**GetHorses Method:**
- Ensures the method returns the correct list of horses.

**Move Method:**
- Verifies the method invokes move on all horses.

**GetWinner Method:**
- Confirms the method returns the horse with the greatest distance.

### Main Class Test

- Ensures the main method executes within a specified time limit (22 seconds).

## Logging

The logging configuration ensures that all significant events and errors are recorded. Logs are stored in `hippodrome.log` and rotated daily with old logs retained for seven days.

**Main Class:**
- Logs the start and end of the race, including the number of participants and the winner.

**Hippodrome Class:**
- Logs errors for null or empty horse lists.
- Logs debug information for constructor calls.

**Horse Class:**
- Logs errors for invalid input parameters.
- Logs debug information for constructor calls.

## Built With

- **Java:** The programming language used.
- **JUnit:** Used for unit testing.
- **Mockito:** Used for mocking dependencies in tests.
- **SLF4J & Logback:** Used for logging.
