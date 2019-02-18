package com.gildedrose;

        import static org.junit.Assert.*;

        import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testItemName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
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
    public void testRegularQE1SLT0(){
        Item[] items = new Item[]{
                new Item("item1",-1,1)

        };

        // Create a new GildedRose instance
        GildedRose app = new GildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("item1", app.items[0].name);
        assertEquals(1, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("item1", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void testRegularQGT1SLT0(){
        Item[] items = new Item[]{
                new Item("item1",-1,2),
                new Item("item1",-1,3)

        };

        // Create a new GildedRose instance
        GildedRose app = new GildedRose(items);

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
    public void testRegularQGT0SGE0(){
        Item[] items = new Item[]{
                new Item("item1",0,1),
                new Item("item1",10,8)

        };

        // Create a new GildedRose instance
        GildedRose app = new GildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("item1", app.items[0].name);
        assertEquals(1, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        assertEquals("item1", app.items[1].name);
        assertEquals(8, app.items[1].quality);
        assertEquals(10, app.items[1].sellIn);

        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("item1", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        assertEquals("item1", app.items[1].name);
        assertEquals(7, app.items[1].quality);
        assertEquals(9, app.items[1].sellIn);

    }

    @Test
    public void testRegularQLTE0SGE0(){
        Item[] items = new Item[]{
                new Item("item1",0,0),
                new Item("item1",1,0),
                new Item("item1",0,-1),
                new Item("item1",1,-1)
        };

        // Create a new GildedRose instance
        GildedRose app = new GildedRose(items);

        // test that the quality and names are the same as in out list
        assertEquals("item1", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        assertEquals("item1", app.items[1].name);
        assertEquals(0, app.items[1].quality);
        assertEquals(1, app.items[1].sellIn);

        assertEquals("item1", app.items[2].name);
        assertEquals(-1, app.items[2].quality);
        assertEquals(0, app.items[0].sellIn);

        assertEquals("item1", app.items[3].name);
        assertEquals(-1, app.items[3].quality);
        assertEquals(1, app.items[3].sellIn);


        // call the update quality method of our GildedRose instance
        app.updateQuality();

        // test that the qualities have been updated
        assertEquals("item1", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        assertEquals("item1", app.items[1].name);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);

        assertEquals("item1", app.items[2].name);
        assertEquals(-1, app.items[2].quality);
        assertEquals(-1, app.items[0].sellIn);

        assertEquals("item1", app.items[3].name);
        assertEquals(-1, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);


    }


    @Test
    public void testSulfuras(){
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros",1,80)

        };

        // Create a new GildedRose instance
        GildedRose app = new GildedRose(items);

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
        GildedRose app = new GildedRose(items);

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
        GildedRose app = new GildedRose(items);

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
        GildedRose app = new GildedRose(items);
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
        GildedRose app = new GildedRose(items);
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
        GildedRose app = new GildedRose(items);
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
        GildedRose app = new GildedRose(items);
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

    @Test
    public void Conjured() {
        Item[] items = new Item[]{
                new Item("Conjured", 10, 10),
                new Item("Conjured", -1, 10),
                new Item("Conjured", 10, 0),
                new Item("Conjured", -1, 0),
                new Item("Conjured",-1,1),
                new Item("Conjured", -1, 3)
        };

        GildedRose app = new GildedRose(items);
        //initial state
        assertEquals("Conjured", app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);

        assertEquals("Conjured", app.items[1].name);
        assertEquals(10, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);

        assertEquals("Conjured", app.items[2].name);
        assertEquals(0, app.items[2].quality);
        assertEquals(10, app.items[2].sellIn);

        assertEquals("Conjured", app.items[3].name);
        assertEquals(0, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);

        assertEquals("Conjured", app.items[4].name);
        assertEquals(1, app.items[4].quality);
        assertEquals(-1, app.items[4].sellIn);

        assertEquals("Conjured", app.items[5].name);
        assertEquals(3, app.items[5].quality);
        assertEquals(-1, app.items[5].sellIn);

        app.updateQuality();

        //final state
        assertEquals("Conjured", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        assertEquals("Conjured", app.items[1].name);
        assertEquals(6, app.items[1].quality);
        assertEquals(-2, app.items[1].sellIn);

        assertEquals("Conjured", app.items[2].name);
        assertEquals(0, app.items[2].quality);
        assertEquals(9, app.items[2].sellIn);

        assertEquals("Conjured", app.items[3].name);
        assertEquals(0, app.items[3].quality);
        assertEquals(-2, app.items[3].sellIn);

        assertEquals("Conjured", app.items[4].name);
        assertEquals(0, app.items[4].quality);
        assertEquals(-2, app.items[4].sellIn);

        assertEquals("Conjured", app.items[5].name);
        assertEquals(0, app.items[5].quality);
        assertEquals(-2, app.items[5].sellIn);

    }
}


// sell in 10, q 10
// s -1, q 10
// s -1, q 1
// s 10, q, 0
// s -1, q 0