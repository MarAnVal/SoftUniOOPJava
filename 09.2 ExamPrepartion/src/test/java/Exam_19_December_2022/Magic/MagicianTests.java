package test.java.Exam_19_December_2022.Magic;

import main.java.Exam_19_December_2022.Magic.Magic;
import main.java.Exam_19_December_2022.Magic.Magician;
import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {
    //public Magician(String username, int health) {
    //        this.setUsername(username);
    //        this.setHealth(health);
    //        this.magics = new ArrayList<>();
    //    }
    //
    //    public String getUsername() {
    //        return this.username;
    //    }
    //
    //    private void setUsername(String username) {
    //        if (username == null || username.trim().length() < 1) {
    //            throw new NullPointerException("Cannot be null!");
    //        }
    //        this.username = username;
    //    }
    //
    //    public int getHealth() {
    //        return this.health;
    //    }
    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        Magician magician = new Magician(null, 1332);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameSpaces() {
        Magician magician = new Magician("  ", 1332);
    }

    //    private void setHealth(int health) {
    //        if (health < 0) {
    //            throw new IllegalArgumentException("Health cannot be bellow zero!");
    //        }
    //        this.health = health;
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthNegative() {
        Magician magician = new Magician("SomeName", -324);
    }

    @Test
    public void testGetUsername() {
        String name = "SomeName";
        Magician magician = new Magician(name, 324);
        Assert.assertEquals(name, magician.getUsername());
    }

    @Test
    public void testGetHealth() {
        int health = 324;
        Magician magician = new Magician("SomeName", health);
        Assert.assertEquals(health, magician.getHealth());
    }

    //    public List<Magic> getMagics() {
    //        return Collections.unmodifiableList(this.magics);
    //    }
    @Test
    public void testGetMagicsEmpty() {
        int health = 324;
        Magician magician = new Magician("SomeName", health);
        Assert.assertEquals(0, magician.getMagics().size());
    }

    //    public void takeDamage(int damage) {
    //        if (this.health <= 0) {
    //            throw new IllegalStateException("Magician is dead!");
    //        }
    //
    //        if (this.health - damage < 0) {
    //            this.health = 0;
    //        } else {
    //            this.health -= damage;
    //        }
    //    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageDead() {
        Magician magician = new Magician("SomeName", 0);
        magician.takeDamage(24);
    }

    @Test
    public void testTakeDamageResultLessThanZero() {
        Magician magician = new Magician("SomeName", 10);
        magician.takeDamage(24);
        Assert.assertEquals(0, magician.getHealth());
    }

    @Test
    public void testTakeDamage() {
        int health = 100;
        int damage = 24;
        Magician magician = new Magician("SomeName", health);
        magician.takeDamage(damage);
        Assert.assertEquals(health - damage, magician.getHealth());
    }
    //    public void addMagic(Magic magic) {
    //        if (magic == null) {
    //            throw new NullPointerException("Magic cannot be null!");
    //        }
    //
    //        this.magics.add(magic);
    //    }
    @Test(expected = NullPointerException.class)
    public void testAddMagicNull(){
        Magician magician = new Magician("SomeName", 10);
        magician.addMagic(null);
    }
    @Test
    public void testAddMagic(){
        Magician magician = new Magician("SomeName", 10);
        Magic magic = new Magic("MagicName", 3432);
        magician.addMagic(magic);
        magician.addMagic(magic);
    }
    //    public boolean removeMagic(Magic magic) {
    //        return this.magics.remove(magic);
    //    }
    @Test
    public void testRemoveMagic(){
        Magician magician = new Magician("SomeName", 10);
        Magic magic = new Magic("MagicName", 3432);
        magician.addMagic(magic);
        magician.addMagic(magic);
        Assert.assertTrue(magician.removeMagic(magic));
        Assert.assertEquals(1, magician.getMagics().size());
    }
    //    public Magic getMagic(String name) {
    //        Magic magic = this.magics.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    //        return magic;
    //    }
    @Test
    public void testGetMagic(){
        Magician magician = new Magician("SomeName", 10);
        Magic magic1 = new Magic("MagicName1", 3432);
        Magic magic2 = new Magic("MagicName2", 43632);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        Assert.assertEquals(magic1, magician.getMagic("MagicName1"));
    }
}
