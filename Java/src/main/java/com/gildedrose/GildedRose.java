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

    private void updateAgedBrie(Item item) {
        if (canIncreaseQuality(item)) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (isExpired(item) && canIncreaseQuality(item)) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePass(Item item) {
        if (canIncreaseQuality(item)) {
            increaseQuality(item);
            if (isSellInLessThan(item, 11) && canIncreaseQuality(item)) {
                increaseQuality(item);
            }
            if (isSellInLessThan(item, 6) && canIncreaseQuality(item)) {
                increaseQuality(item);
            }
        }
        decreaseSellIn(item);
        if (isExpired(item)) {
            resetQuality(item);
        }
    }

    private void updateNormalItem(Item item) {
        if (canDecreaseQuality(item)) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
        if (isExpired(item) && canDecreaseQuality(item)) {
            decreaseQuality(item);
        }
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }

    private boolean canDecreaseQuality(Item item) {
        return item.quality > 0;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private boolean isSellInLessThan(Item item, int days) {
        return item.sellIn < days;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }
}
