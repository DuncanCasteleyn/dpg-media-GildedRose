package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case BACKSTAGE:
                    updateBackstagePass(item);
                    break;
                case SULFURAS:
                    // Legendary item, no update needed
                    break;
                default:
                    updateNormalItem(item);
            }
        }
    }

    private static void updateAgedBrie(Item item) {
        if (ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);
        }
        ItemUtilities.decreaseSellIn(item);
        if (ItemUtilities.isExpired(item) && ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);
        }
    }

    private static void updateBackstagePass(Item item) {
        if (ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);
            if (ItemUtilities.isSellInLessThan(item, 11) && ItemUtilities.canIncreaseQuality(item)) {
                ItemUtilities.increaseQuality(item);
            }
            if (ItemUtilities.isSellInLessThan(item, 6) && ItemUtilities.canIncreaseQuality(item)) {
                ItemUtilities.increaseQuality(item);
            }
        }
        ItemUtilities.decreaseSellIn(item);
        if (ItemUtilities.isExpired(item)) {
            ItemUtilities.resetQuality(item);
        }
    }

    private static void updateNormalItem(Item item) {
        if (ItemUtilities.canDecreaseQuality(item)) {
            ItemUtilities.decreaseQuality(item);
        }
        ItemUtilities.decreaseSellIn(item);
        if (ItemUtilities.isExpired(item) && ItemUtilities.canDecreaseQuality(item)) {
            ItemUtilities.decreaseQuality(item);
        }
    }

}
