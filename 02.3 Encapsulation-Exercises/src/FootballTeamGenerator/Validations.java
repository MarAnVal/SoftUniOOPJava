package FootballTeamGenerator;

class Validations {
    //A name cannot be null, empty, or white space.
    // If not, print: "A name should not be empty."
    static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
}
