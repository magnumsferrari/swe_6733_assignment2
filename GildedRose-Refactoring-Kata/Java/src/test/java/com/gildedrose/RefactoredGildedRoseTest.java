package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RefactoredGildedRoseTest {

    @Test
    public void testItemName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        //app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
        /*
        testRegular
            (Q>0, Q<=0)x(S<0, S>=0)

        testSulfuras
            (Q>0, Q<=0)x(S<0, S>=0)

        testAgedBrie...
            ( Q<=50, S>=0, S<0)

        testConcertQualityGTE50SellinGT0
        testConcertQualityLT50SellinGT11
        testConcertQualityLT50SellinLT11GT6
        testConcertQualityLT50SellinLT6GT0
        testConcertQualityLT50SellinLT0
     */


    @Test
    public void testRegularQGT1SLT0(){
        Item[] items = new Item[]{
                new Item("item1",-1,2),
                new Item("item1",-1,3)

        };

        // Create a new GildedRose instance
        RefactoredGildedRose app = new RefactoredGildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("item1", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        // test that the quality and names are the same as in out list
        assertEquals("item1", app.items[1].name);
        assertEquals(3, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the quality is updated
        assertEquals("item1", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);

        // test that the quality is updated
        assertEquals("item1", app.items[1].name);
        assertEquals(1, app.items[1].quality);
        assertEquals(-2, app.items[1].sellIn);

    }


    @Test
    public void testSulfuras(){
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros",1,80)

        };

        // Create a new GildedRose instance
        RefactoredGildedRose app = new RefactoredGildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }


    @Test
    public void testAgedBrieQLT50SE0(){
        Item[] items = new Item[]{
                new Item("Aged Brie",-1,45),

        };

        // Create a new GildedRose instance
        RefactoredGildedRose app = new RefactoredGildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(45, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(47, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);

    }
    @Test
    public void testAgedBrie(){
        Item[] items = new Item[]{
                new Item("Aged Brie",20,45),


        };

        // Create a new GildedRose instance
        RefactoredGildedRose app = new RefactoredGildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(45, app.items[0].quality);
        assertEquals(20, app.items[0].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(46, app.items[0].quality);
        assertEquals(19, app.items[0].sellIn);

    }


    @Test
    public void ConcertSGT10(){
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert",12,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",12,45)

        };
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        // test that the quality and names are the same as in out list
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(12, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(45, app.items[1].quality);
        assertEquals(12, app.items[1].sellIn);


        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(46, app.items[1].quality);
        assertEquals(11, app.items[1].sellIn);
    }
    @Test
    public void ConcertSGTb5to10(){
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert",7,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",7,45)

        };
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        // test that the quality and names are the same as in out list
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(45, app.items[1].quality);
        assertEquals(7, app.items[1].sellIn);


        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(6, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(47, app.items[1].quality);
        assertEquals(6, app.items[1].sellIn);
    }

    @Test
    public void ConcertSGTb0to5(){
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert",4,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",2,45)

        };
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        // test that the quality and names are the same as in out list
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(45, app.items[1].quality);
        assertEquals(2, app.items[1].sellIn);


        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(48, app.items[1].quality);
        assertEquals(1, app.items[1].sellIn);
    }

    @Test
    public void ConcertSE0(){
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert",0,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",0,45)

        };
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        // test that the quality and names are the same as in out list
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(45, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);


        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(0, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }


}
