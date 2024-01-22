package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int spint,
                  int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(spint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        Validations.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        validateStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStat(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStat(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStat(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStat(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / (double) 5;
    }

    //· Stats should be in the range [0..100].
    // If not, print: "{Stat name} should be between 0 and 100."
    private static void validateStat(int stat, String nameOfStat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(nameOfStat + " should be between 0 and 100.");
        }
    }
}
