package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_NormalItems_ShouldHaveDecreasedBothSellInAndQualityByOne() {
        // Given
        Item[] items = new Item[]{
                new Item("Normal Item", 10, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void updateQuality_NormalItemWithSellInDatePassed_ShouldDecreaseTwiceAsFast() {
        // Given
        Item[] items = new Item[]{
                new Item("Normal Item", 0, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void updateQuality_NoramlItemWithZeroQuality_ShouldNotGoNegative() {
        // Given
        Item[] items = new Item[]{
                new Item("Normal Item", 10, 0)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void updateQuality_AgredBrie_ShouldIncreaseInQualityTheOlderItGets() {
        // Given
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 25)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(26, items[0].quality);
    }

    @Test
    void updateQuality_AgredBrieWithMaxQuality_ShouldNotExceedFifty() {
        // Given
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 50)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void updateQuality_Sulfuras_ShouldNeverDecreaseInQualityOrHaveToBeSold() {
        // Given
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void updateQuality_BackStagePasses_ShouldIncreaseBy2WhenTenDaysOrLess() {
        // Given
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void updateQuality_BackStagePasses_ShouldIncreaseBy3WhenFiveDaysOrLess() {
        // Given
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void updateQuality_BackStagePasses_AfterEventShouldDropToZeroQuality() {
        // Given
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void updateQuality_ConjuredItem_ShouldDegradeTwiceAsFast() {
        // Given
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 10, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(9, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void updateQuality_ConjuredItem_ShouldDegradeFourPerDayWhenSellInPassed() {
        // Given
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 0, 20)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(-1, items[0].sellIn);
        assertEquals(16, items[0].quality);
    }

    @Test
    void updateQuality_ConjuredItem_ShouldNotGoNegative() {
        // Given
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 5, 1)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}
