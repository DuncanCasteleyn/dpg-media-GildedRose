package com.gildedrose;

public final class ItemUtilities {

    private ItemUtilities() {
        throw new IllegalStateException("Utility class" );
    }


    public static boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }

    static boolean canDecreaseQuality(Item item) {
        return item.quality > 0;
    }

    static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    static boolean isSellInLessThan(Item item, int days) {
        return item.sellIn < days;
    }

    static void increaseQuality(Item item) {
        item.quality++;
    }

    static void decreaseQuality(Item item) {
        item.quality--;
    }

    static void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    static void resetQuality(Item item) {
        item.quality = 0;
    }
}
