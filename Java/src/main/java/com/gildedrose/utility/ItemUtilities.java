package com.gildedrose.utility;

import com.gildedrose.Item;

public final class ItemUtilities {

    private static final int MAX_ITEM_QUALITY = 50;
    private static final int MIN_ITEM_QUALITY = 0;
    private static final int EXPIRED_BELOW_SELL_IN = 0;

    private ItemUtilities() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean canIncreaseQuality(Item item) {
        return item.quality < MAX_ITEM_QUALITY;
    }

    public static boolean canDecreaseQuality(Item item) {
        return item.quality > MIN_ITEM_QUALITY;
    }

    public static boolean isExpired(Item item) {
        return item.sellIn < EXPIRED_BELOW_SELL_IN;
    }

    public static boolean isSellInLessThan(Item item, int days) {
        return item.sellIn < days;
    }

    public static void increaseQuality(Item item) {
        item.quality++;
    }

    public static void decreaseQuality(Item item) {
        item.quality--;
    }

    public static void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public static void resetQuality(Item item) {
        item.quality = MIN_ITEM_QUALITY;
    }
}
