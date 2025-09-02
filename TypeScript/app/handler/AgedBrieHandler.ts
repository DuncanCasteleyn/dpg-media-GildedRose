import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class AgedBrieHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name === 'Aged Brie';
  }

  updateItemQuality(item: Item): void {
    if (item.quality < 50) {
      ItemUtils.increaseQuality(item);
    }
    ItemUtils.decreaseSellIn(item);
    if (item.sellIn < 0 && item.quality < 50) {
      ItemUtils.increaseQuality(item);
    }
    item.quality = Math.min(50, item.quality);
  }
}
