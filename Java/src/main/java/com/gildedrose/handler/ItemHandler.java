package com.gildedrose.handler;

public interface ItemHandler {

    boolean handles(String itemName);

    void updateItem(com.gildedrose.Item item);
}
