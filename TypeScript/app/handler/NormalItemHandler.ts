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

    if (ItemUtils.shouldDegradeTwice(item)) {
      ItemUtils.decreaseQuality(item);
    }
  }
}
