package test.java.Exam_9_April_2022.Gifts;

import main.java.Exam_9_April_2022.Gifts.Gift;
import main.java.Exam_9_April_2022.Gifts.GiftFactory;
import org.junit.Assert;
import org.junit.Test;

public class GiftFactoryTests {
    @Test
    public void testGiftFactory() {
        GiftFactory giftFactory = new GiftFactory();
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGift() {
        GiftFactory giftFactory = new GiftFactory();
        String giftName = "giftName";
        double giftMagic = 932.32;
        Gift gift = new Gift(giftName, giftMagic);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }
    @Test
    public void testRemoveGift(){
        GiftFactory giftFactory = new GiftFactory();
        String giftName = "giftName";
        double giftMagic = 932.32;
        Gift gift = new Gift(giftName, giftMagic);
        giftFactory.createGift(gift);
        Assert.assertTrue(giftFactory.removeGift(giftName));
        giftFactory.createGift(gift);
        Assert.assertFalse(giftFactory.removeGift("NotExisting"));
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGiftNull(){
        GiftFactory giftFactory = new GiftFactory();
        String giftName = "giftName";
        double giftMagic = 932.32;
        Gift gift = new Gift(giftName, giftMagic);
        giftFactory.createGift(gift);
        Assert.assertTrue(giftFactory.removeGift(null));
    }
    @Test
    public void testGetPresentWithLeastMagicEmptyList(){
        GiftFactory giftFactory = new GiftFactory();
        Assert.assertEquals(null, giftFactory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresentWithLeastMagic(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Name1", 29423.21);
        Gift gift2 = new Gift("Name2", 294.2321);
        Gift gift3 = new Gift("Name3", 2.942321);
        Gift gift4 = new Gift("Name4", 2942.321);
        Gift gift5 = new Gift("Name5", 29.42321);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.createGift(gift4);
        giftFactory.createGift(gift5);
        Assert.assertEquals(gift3, giftFactory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresentEmptyList(){
        GiftFactory giftFactory = new GiftFactory();
        Assert.assertEquals(null, giftFactory.getPresent("Name3"));
    }
    @Test
    public void testGetPresent(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Name1", 29423.21);
        Gift gift2 = new Gift("Name2", 294.2321);
        Gift gift3 = new Gift("Name3", 2.942321);
        Gift gift4 = new Gift("Name4", 2942.321);
        Gift gift5 = new Gift("Name5", 29.42321);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.createGift(gift4);
        giftFactory.createGift(gift5);
        Assert.assertEquals(gift3, giftFactory.getPresent("Name3"));
    }
    @Test
    public void testGetPresents(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Name1", 29423.21);
        Gift gift2 = new Gift("Name2", 294.2321);
        Gift gift3 = new Gift("Name3", 2.942321);
        Gift gift4 = new Gift("Name4", 2942.321);
        Gift gift5 = new Gift("Name5", 29.42321);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.createGift(gift4);
        giftFactory.createGift(gift5);
        Assert.assertEquals(5, giftFactory.getPresents().size());
    }
}
