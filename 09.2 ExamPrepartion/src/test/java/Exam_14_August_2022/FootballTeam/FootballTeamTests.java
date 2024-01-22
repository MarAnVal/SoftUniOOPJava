package test.java.Exam_14_August_2022.FootballTeam;

import main.java.Exam_14_August_2022.FootballTeam.FootballTeam;
import main.java.Exam_14_August_2022.FootballTeam.Footballer;
import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {
    @Test(expected = NullPointerException.class)
    public void testConstructorNullName() {
        //name spaces or null throw new NullPointerException("Invalid name.");
        new FootballTeam(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorSpacesName() {
        //name spaces or null throw new NullPointerException("Invalid name.");
        new FootballTeam("    ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeVacantPositions() {
        //vacantPositions less than 0 throw new IllegalArgumentException("Invalid vacant position.");
        new FootballTeam("SomeName", -1);
    }

    @Test
    public void testConstructorZeroVacantPositions() {
        //vacantPositions less than 0 throw new IllegalArgumentException("Invalid vacant position.");
        new FootballTeam("SomeName", 0);
    }

    @Test
    public void testConstructor() {
        String expectedName = "SomeName";
        int expectedVacantPositions = 1;
        FootballTeam footballTeam = new FootballTeam(expectedName, expectedVacantPositions);
        Assert.assertEquals(expectedName, footballTeam.getName());
        Assert.assertEquals(expectedVacantPositions, footballTeam.getVacantPositions());
        Assert.assertEquals(0 , footballTeam.getCount());
    }

    @Test
    public void testAddFootballer(){
        //no vacantPosition throw new IllegalArgumentException("Football team is full.");
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String footballerSecondName = "secondName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        Footballer secondFootballer = new Footballer(footballerSecondName);
        footballTeam.addFootballer(firstFootballer);
        footballTeam.addFootballer(secondFootballer);
        Assert.assertEquals(2, footballTeam.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerFullVacantPosition(){
        //no vacantPosition throw new IllegalArgumentException("Football team is full.");
        String footballTeamName = "SomeName";
        int footballTeamPositions = 1;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String footballerSecondName = "secondName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        Footballer secondFootballer = new Footballer(footballerSecondName);
        footballTeam.addFootballer(firstFootballer);
        footballTeam.addFootballer(secondFootballer);

        Assert.assertEquals(2, footballTeam.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerNotExisting(){
        //if no such name in team throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String footballerSecondName = "secondName";
        String notExistingName = "SomeName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        Footballer secondFootballer = new Footballer(footballerSecondName);
        footballTeam.addFootballer(firstFootballer);
        footballTeam.addFootballer(secondFootballer);

        footballTeam.removeFootballer(notExistingName);
    }
    @Test
    public void testRemoveFootballerExisting(){
        //if no such name in team throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String footballerSecondName = "secondName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        Footballer secondFootballer = new Footballer(footballerSecondName);
        footballTeam.addFootballer(firstFootballer);
        footballTeam.addFootballer(secondFootballer);

        footballTeam.removeFootballer(footballerSecondName);
        Assert.assertEquals(1, footballTeam.getCount());
    }
    @Test
    public void testFootballerForSaleExisting(){
        //if not existing name throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String footballerSecondName = "secondName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        Footballer secondFootballer = new Footballer(footballerSecondName);
        footballTeam.addFootballer(firstFootballer);
        footballTeam.addFootballer(secondFootballer);

        Footballer footballerForSale = footballTeam.footballerForSale(footballerFirstName);

        Assert.assertEquals(footballerFirstName, footballerForSale.getName());
        Assert.assertEquals(firstFootballer, footballerForSale);
        Assert.assertFalse(footballerForSale.isActive());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNotExisting(){
        //if not existing name throw new IllegalArgumentException(String.format("A footballer named %s is not on the soccer team.", name));
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String notExisting = "secondName";
        Footballer firstFootballer = new Footballer(footballerFirstName);
        footballTeam.addFootballer(firstFootballer);

        Footballer footballerForSale = footballTeam.footballerForSale(notExisting);

    }

    @Test
    public void testGetStatistics(){
        //"The footballer %s is in the team %s."
        String footballTeamName = "SomeName";
        int footballTeamPositions = 10;
        FootballTeam footballTeam = new FootballTeam(footballTeamName, footballTeamPositions);
        String footballerFirstName = "firstName";
        String expected = String.format("The footballer %s is in the team %s.", footballerFirstName, footballTeamName);
        Footballer firstFootballer = new Footballer(footballerFirstName);
        footballTeam.addFootballer(firstFootballer);

        Assert.assertEquals(expected, footballTeam.getStatistics());
    }
}
