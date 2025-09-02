package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.utility.ItemUtilities;

public class NormalItemHandler implements ItemHandler {
    @Override
    public boolean handles(String itemName) {
        return true;
    }

    @Override
    public void updateItem(Item item) {
        if (ItemUtilities.canDecreaseQuality(item)) {
            ItemUtilities.decreaseQuality(item);
        }

        ItemUtilities.decreaseSellIn(item);

        if (ItemUtilities.isExpired(item) && ItemUtilities.canDecreaseQuality(item)) {
            ItemUtilities.decreaseQuality(item);
        }
    }
}
