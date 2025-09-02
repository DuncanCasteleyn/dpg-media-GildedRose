import { Item } from '../gilded-rose';

export class ItemUtils {
  static readonly MAX_QUALITY = 50;
  static readonly MIN_QUALITY = 0;

  static increaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.min(ItemUtils.MAX_QUALITY, item.quality + amount);
  }

  static decreaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.max(ItemUtils.MIN_QUALITY, item.quality - amount);
  }

  static decreaseSellIn(item: Item): void {
    item.sellIn -= 1;
  }

  static enforceQualityBounds(item: Item): void {
    item.quality = Math.max(ItemUtils.MIN_QUALITY, Math.min(ItemUtils.MAX_QUALITY, item.quality));
  }

  static resetQuality(item: Item): void {
    item.quality = ItemUtils.MIN_QUALITY;
  }

  static isExpired(item: Item): boolean {
    return item.sellIn < 0;
  }

  static canIncreaseQuality(item: Item): boolean {
    return item.quality < ItemUtils.MAX_QUALITY;
  }

  static shouldDegradeTwice(item: Item): boolean {
    return item.sellIn < 0 && item.quality > ItemUtils.MIN_QUALITY;
  }
}
