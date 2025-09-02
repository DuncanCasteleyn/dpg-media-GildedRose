import { Item, GildedRose } from '@/gilded-rose';

describe('Gilded Rose', () => {
  describe('Normal items', () => {
    it('should degrade quality twice as fast after sell by date', () => {
      const gildedRose = new GildedRose([new Item('foo', 0, 10)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(8);
    });

    it('should never have negative quality', () => {
      const gildedRose = new GildedRose([new Item('foo', 0, 0)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBeGreaterThanOrEqual(0);
    });
  });

  describe('Aged Brie', () => {
    it('should increase quality of Aged Brie as it gets older', () => {
      const gildedRose = new GildedRose([new Item('Aged Brie', 2, 0)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(1);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(2);
    });

    it('should never have quality more than 50', () => {
      const gildedRose = new GildedRose([new Item('Aged Brie', 2, 50)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBeLessThanOrEqual(50);
    });
  });

  describe('Sulfuras', () => {
    it('never has to be sold or decreases in quality', () => {
      const gildedRose = new GildedRose([new Item('Sulfuras, Hand of Ragnaros', 0, 80)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].sellIn).toBe(0);
      expect(gildedRose.items[0].quality).toBe(80);
    });
  });

  describe('Backstage passes', () => {
    it('increase in quality by 1 when sellIn > 10', () => {
      const gildedRose = new GildedRose([
        new Item('Backstage passes to a TAFKAL80ETC concert', 15, 20)
      ]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(21); // +1
    });

    it('increase in quality by 2 when sellIn <= 10 and > 5', () => {
      const gildedRose = new GildedRose([
        new Item('Backstage passes to a TAFKAL80ETC concert', 10, 20)
      ]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(22); // +2
    });

    it('increase in quality by 3 when sellIn <= 5 and > 0', () => {
      const gildedRose = new GildedRose([
        new Item('Backstage passes to a TAFKAL80ETC concert', 5, 20)
      ]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(23); // +3
    });

    it('drops quality to 0 after concert', () => {
      const gildedRose = new GildedRose([
        new Item('Backstage passes to a TAFKAL80ETC concert', 0, 20)
      ]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(0);  // drops to 0
    });
  });

  describe('Conjured items', () => {
    it('should degrade in quality twice as fast as normal items before sell by date', () => {
      const gildedRose = new GildedRose([new Item('Conjured Mana Cake', 5, 10)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(8); // -2
    });

    it('should degrade in quality twice as fast as normal items after sell by date', () => {
      const gildedRose = new GildedRose([new Item('Conjured Mana Cake', 0, 10)]);
      gildedRose.updateQuality();
      expect(gildedRose.items[0].quality).toBe(6); // -4
    });

    it('should never have negative quality', () => {
      const gildedRose = new GildedRose([new Item('Conjured Mana Cake', 0, 0)]);

      gildedRose.updateQuality();

      expect(gildedRose.items[0].quality).toBeGreaterThanOrEqual(0);
    });
  });
});
