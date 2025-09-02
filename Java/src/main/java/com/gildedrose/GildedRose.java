package com.gildedrose;

import com.gildedrose.handler.ItemHandler;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static void updateAgedBrie(Item item) {

    }

    private static void updateBackstagePass(Item item) {

    }

    private static void updateNormalItem(Item item) {

    }

    public void updateQuality() {


        for (Item item : items) {
            ItemHandler.HANDLERS.stream()
                                .filter(itemHandler -> itemHandler.handles(item.name))
                                .findFirst()
                                .ifPresentOrElse(itemHandler -> itemHandler.updateItem(item),
                                                 () -> ItemHandler.DEFAULT_HANDLER.updateItem(item)
                                );
        }
    }

}
