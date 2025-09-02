import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class AgedBrieHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name === 'Aged Brie';
  }

  updateItemQuality(item: Item): void {
    if (ItemUtils.canIncreaseQuality(item)) {
      ItemUtils.increaseQuality(item);
    }

    ItemUtils.decreaseSellIn(item);

    if (ItemUtils.isExpired(item) && ItemUtils.canIncreaseQuality(item)) {
      ItemUtils.increaseQuality(item);
    }
  }
}
