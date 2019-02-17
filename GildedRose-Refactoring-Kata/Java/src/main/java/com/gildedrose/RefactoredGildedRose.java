package com.gildedrose;

public class RefactoredGildedRose {
    Item[] items;

    public RefactoredGildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            int quality = items[i].quality;
            int sellin = items[i].sellIn;

            if (items[i].name.equals("Aged Brie")) {
                if (quality < 50  && sellin < 0) {
                    items[i].quality+=2;
                    items[i].sellIn-=1;
                } else if (sellin < 50) {
                    items[i].quality++;
                    items[i].sellIn --;
                }
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (quality == 50 && sellin >10)  {
                    items[i].sellIn -=1;
                }
                if (quality < 50 && sellin > 10) {
                    items[i].quality +=1;
                    items[i].sellIn -=1;
                }
                if ( quality == 50 & sellin <= 10 && sellin >= 5) {

                    items[i].sellIn -=1;
                }
                if ( quality < 50 & sellin < 10 && sellin >= 5) {
                    items[i].quality +=2;
                    items[i].sellIn -=1;
                }
                if ( quality == 50 & sellin < 5 && sellin >= 0) {

                    items[i].sellIn -=1;
                }
                if ( quality < 50 & sellin < 5 && sellin >= 0) {
                    items[i].quality +=3;
                    items[i].sellIn -=1;
                }
                if ( quality == 50 & sellin == 0) {
                    items[i].quality = 0;
                    items[i].sellIn  = -1;
                }
                if ( quality < 50 & sellin == 0) {
                    items[i].quality = 0;
                    items[i].sellIn  = -1;
                }
            } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

            }  else {
                if(quality > 1 && sellin < 0) {
                    items[i].quality -= 2;
                }
                items[i].sellIn -= 1;
            }

        }
    }
}