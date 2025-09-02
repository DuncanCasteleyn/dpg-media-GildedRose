package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.utility.ItemUtilities;

public class AgedBrieHandler implements ItemHandler {
    @Override
    public boolean handles(String itemName) {
        return "Aged Brie".equals(itemName);
    }

    @Override
    public void updateItem(Item item) {
        if (ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);
        }

        ItemUtilities.decreaseSellIn(item);

        if (ItemUtilities.isExpired(item) && ItemUtilities.canIncreaseQuality(item)) {
            ItemUtilities.increaseQuality(item);
        }
    }
}
