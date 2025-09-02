import { Item } from '../gilded-rose';

export class ItemUtils {
  static isAgedBrie(item: Item): boolean {
    return item.name === 'Aged Brie';
  }

  static isBackstagePass(item: Item): boolean {
    return item.name === 'Backstage passes to a TAFKAL80ETC concert';
  }

  static isSulfuras(item: Item): boolean {
    return item.name === 'Sulfuras, Hand of Ragnaros';
  }

  static increaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.min(50, item.quality + amount);
  }

  static decreaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.max(0, item.quality - amount);
  }

  static decreaseSellIn(item: Item): void {
    item.sellIn -= 1;
  }
}
