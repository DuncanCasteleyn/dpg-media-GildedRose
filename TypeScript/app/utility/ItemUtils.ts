import { Item } from '../gilded-rose';

export class ItemUtils {
  static increaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.min(50, item.quality + amount);

    ItemUtils.enforceQualityBounds(item);
  }

  static decreaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.max(0, item.quality - amount);
    ItemUtils.enforceQualityBounds(item);
  }

  static decreaseSellIn(item: Item): void {
    item.sellIn -= 1;
  }

  static enforceQualityBounds(item: Item): void {
    item.quality = Math.max(0, Math.min(50, item.quality));
  }
}
