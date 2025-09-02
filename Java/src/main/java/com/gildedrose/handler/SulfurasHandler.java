package com.gildedrose.handler;

import com.gildedrose.Item;

public class SulfurasHandler implements ItemHandler {
    @Override
    public boolean handles(String itemName) {
        return "Sulfuras, Hand of Ragnaros".equals(itemName);
    }

    @Override
    public void updateItem(Item item) {
        // Legendary item, no changes to quality or sellIn
    }
}
