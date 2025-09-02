import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class NormalItemHandler implements ItemHandler {
  handles(item: Item): boolean {
    return !ItemUtils.isAgedBrie(item) && !ItemUtils.isBackstagePass(item) && !ItemUtils.isSulfuras(item);
  }

  updateItemQuality(item: Item): void {
    if (item.quality > 0) {
      ItemUtils.decreaseQuality(item);
    }
    ItemUtils.decreaseSellIn(item);
    if (item.sellIn < 0 && item.quality > 0) {
      ItemUtils.decreaseQuality(item);
    }
    item.quality = Math.max(0, item.quality);
  }
}
