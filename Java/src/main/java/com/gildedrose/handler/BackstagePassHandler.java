package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.utility.ItemUtilities;

public class BackstagePassHandler implements ItemHandler {
    private static final int DOUBLE_QUALITY_INCREASE_MAX_EXCLCUSIVE = 11;
    private static final int TRIPLE_QUALITY_INCREASE_MAX_EXCLUSIVE = 6;

    @Override
    public boolean handles(String itemName) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(itemName);
    }

    @Override
    public void updateItem(Item item) {
        if (ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);

            if (ItemUtilities.isSellInLessThan(item, DOUBLE_QUALITY_INCREASE_MAX_EXCLCUSIVE) && ItemUtilities.canIncreaseQuality(item)) {
                ItemUtilities.increaseQuality(item);
            }

            if (ItemUtilities.isSellInLessThan(item, TRIPLE_QUALITY_INCREASE_MAX_EXCLUSIVE) && ItemUtilities.canIncreaseQuality(item)) {
                ItemUtilities.increaseQuality(item);
            }
        }

        ItemUtilities.decreaseSellIn(item);

        if (ItemUtilities.isExpired(item)) {
            ItemUtilities.resetQuality(item);
        }
    }
}
