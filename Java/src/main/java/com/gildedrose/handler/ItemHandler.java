package com.gildedrose.handler;

import java.util.List;

public interface ItemHandler {
    ItemHandler DEFAULT_HANDLER = new NormalItemHandler();

    List<ItemHandler> HANDLERS = List.of(
        new AgedBrieHandler(),
        new BackstagePassHandler(),
        new SulfurasHandler()
    );

    boolean handles(String itemName);

    void updateItem(com.gildedrose.Item item);
}
