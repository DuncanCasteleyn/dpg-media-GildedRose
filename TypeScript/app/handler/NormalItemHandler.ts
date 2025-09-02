import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class NormalItemHandler implements ItemHandler {
  handles(item: Item): boolean {
    return false;
  }

  updateItemQuality(item: Item): void {
    if (item.quality > 0) {
      ItemUtils.decreaseQuality(item);
    }

    ItemUtils.decreaseSellIn(item);

    if (item.sellIn < 0 && item.quality > 0) {
      ItemUtils.decreaseQuality(item);
    }
  }
}
