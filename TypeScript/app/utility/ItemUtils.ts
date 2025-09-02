import { Item } from '../gilded-rose';

export class ItemUtils {
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
