package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.utility.ItemUtilities;

public class ConjuredItemHandler implements ItemHandler {
    @Override
    public boolean handles(String itemName) {
        return itemName != null && itemName.toLowerCase().contains("conjured");
    }

    @Override
    public void updateItem(Item item) {
        for (int i = 0; i < 2; i++) {
            if (ItemUtilities.canDecreaseQuality(item)) {
                ItemUtilities.decreaseQuality(item);
            }
        }

        ItemUtilities.decreaseSellIn(item);

        if (ItemUtilities.isExpired(item)) {
            for (int i = 0; i < 2; i++) {
                if (ItemUtilities.canDecreaseQuality(item)) {
                    ItemUtilities.decreaseQuality(item);
                }
            }
        }
    }
}
