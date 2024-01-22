package test.java.Exam_15_August_2021.ShopAndGoodsc;


import main.java.Exam_15_August_2021.ShopAndGoods.Goods;
import main.java.Exam_15_August_2021.ShopAndGoods.Shop;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    //private Map<String, Goods> shelves;
    //
    //    public Shop() {
    //        this.shelves = new LinkedHashMap<>();
    //        this.shelves.put("Shelves1", null);
    //        this.shelves.put("Shelves2", null);
    //        this.shelves.put("Shelves3", null);
    //        this.shelves.put("Shelves4", null);
    //        this.shelves.put("Shelves5", null);
    //        this.shelves.put("Shelves6", null);
    //        this.shelves.put("Shelves7", null);
    //        this.shelves.put("Shelves8", null);
    //        this.shelves.put("Shelves9", null);
    //        this.shelves.put("Shelves10", null);
    //        this.shelves.put("Shelves11", null);
    //        this.shelves.put("Shelves12", null);
    //    }
    @Test
    public void TestGoodsGetName(){
        Goods goods = new Goods("someName", "someCode");
        Assert.assertEquals("someName", goods.getName());
    }
    @Test
    public void testShopConstructor() {
    Shop shop = new Shop();
        Assert.assertEquals(12, shop.getShelves().size());
    }
    //    public String addGoods(String shelf, Goods goods) throws OperationNotSupportedException, IllegalArgumentException{
    //        if (!this.shelves.containsKey(shelf)) {
    //            throw new IllegalArgumentException("The shelf doesn't exist!");
    //        }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsNotExistingShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName", "someCode");
        shop.addGoods("Shelves", goods);
    }
    //        if (this.shelves.get(shelf) != null) {
    //            throw new IllegalArgumentException("The shelf is already taken!");
    //        }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsNotFreeShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("someName1", "someCode1");
        Goods goods2 = new Goods("someName2", "someCode2");
        shop.addGoods("Shelves1", goods1);
        shop.addGoods("Shelves1", goods2);
    }
    //        boolean itemExist = getShelves().containsValue(goods);
    //
    //        if (itemExist) {
    //            throw new OperationNotSupportedException("Goods is already in shelf!");
    //        }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsGoodsExist() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName", "someCode");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves3", goods);
    }
    //        this.shelves.put(shelf, goods);
    //        return String.format("Goods: %s is placed successfully!", goods.getGoodsCode());
    //    }
    @Test
    public void testAddGoods() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName", "someCode");
        shop.addGoods("Shelves1", goods);
        Assert.assertTrue(shop.getShelves().containsValue(goods));
    }
    @Test
    public void testAddGoodsResult() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName", "someCode");
        String expectedText =String.format("Goods: %s is placed successfully!", goods.getGoodsCode());
        Assert.assertEquals(expectedText, shop.addGoods("Shelves1", goods));
    }
    //    public String removeGoods (String shelf, Goods goods) {
    //        if (!this.shelves.containsKey(shelf)) {
    //            throw new IllegalArgumentException("The shelf doesn't exist!");
    //        }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsNotExistingShelf(){
        Shop shop = new Shop();
        Goods goods = new Goods("someName", "someCode");
        shop.removeGoods("Shelves", goods);
    }
    //        if (this.shelves.get(shelf) != goods) {
    //            throw new IllegalArgumentException("Goods in that shelf doesn't exists!");
    //        }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsDifferentGoodsInShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("someName1", "someCode1");
        Goods goods2 = new Goods("someName2", "someCode2");
        shop.addGoods("Shelves1", goods1);
        shop.removeGoods("Shelves1", goods2);
    }
    //        this.shelves.put(shelf, null);
    //
    //        return String.format("Goods: %s is removed successfully!", goods.getGoodsCode());
    //    }
    @Test
    public void testRemoveGoods() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName1", "someCode1");
        shop.addGoods("Shelves1", goods);
        Assert.assertTrue(shop.getShelves().containsValue(goods));
        shop.removeGoods("Shelves1", goods);
        Assert.assertFalse(shop.getShelves().containsValue(goods));
    }
    @Test
    public void testRemoveGoodsResult() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("someName1", "someCode1");
        shop.addGoods("Shelves1", goods);
        Assert.assertTrue(shop.getShelves().containsValue(goods));
        String expectedText = String.format("Goods: %s is removed successfully!", goods.getGoodsCode());
        Assert.assertEquals(expectedText, shop.removeGoods("Shelves1", goods));
    }
}